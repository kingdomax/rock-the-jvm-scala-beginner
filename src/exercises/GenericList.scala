package exercises

// EXERCISE 1 : Expand MyList to be generic

/*
  EXERCISES 2
  1.  Generic trait MyPredicate[-T] with a little method test(T) => Boolean
  2.  Generic trait MyTransaformer[-A, B] with a method transform(A) => B
  3.  MyList:
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to myList[B]) => MyList[B]

      class EveentPrdicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransforermet[String, Int]

      classEvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String, Int]

      [1,2,3].map(n * 2) = [2,4,6]
      [1,2,3,4].filter(n % 2) = [2,4]
      [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
 */

abstract class GenericList[+A]
{
  def head: A
  def tail: GenericList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GenericList[B] // use bound type to solve problem
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  // for exercise2
  def map[B](transformer: MyTransformer[A, B]): GenericList[B]
  def flatMap[B](transformer: MyTransformer[A, GenericList[B]]): GenericList[B]
  def filter(predicate: MyPredicate[A]): GenericList[A]

  // concatenation
  def ++[B >: A](list: GenericList[B]): GenericList[B]
}

case object Empty2 extends GenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: GenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): GenericList[B] = new Cons2(element, Empty2)
  def printElements: String = ""

  // for exercise2
  def map[B](transformer: MyTransformer[Nothing, B]): GenericList[B] = Empty2
  def flatMap[B](transformer: MyTransformer[Nothing, GenericList[B]]): GenericList[B] = Empty2
  def filter(predicate: MyPredicate[Nothing]): GenericList[Nothing] = Empty2

  def ++[B >: Nothing](list: GenericList[B]): GenericList[B] = list
}

case class Cons2[+A](h: A, t: GenericList[A]) extends GenericList[A] {
  def head: A = h
  def tail: GenericList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): GenericList[B] = new Cons2(element, this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  /*
    [1,2,3].filter(n % 2 == 0) =
      [2,3].filter(n % 2 == 0) =
      = new Cons2(2, [3].filter(n % 2 == 0))
      = new Cons2(2, Empty.filter(n % 2 == 0))
      = new Cons(2, Empty)
   */
  def filter(predicate: MyPredicate[A]): GenericList[A] = {
    if (predicate.test(h)) new Cons2(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /*
    [1,2,3].map(n*2)
      = new Cons2(2, [2,3].map(n * 2))
      = new Cons2(2, new Cons(4, [3].map(n * 2))
      = new Cons2(2, new Cons(4, new Cons(6, Empty.map(n*2)))
      = new Cons2(2, new Cons(4, new Cons(6, Empty))
   */
  def map[B](transformer: MyTransformer[A, B]): GenericList[B] =
    new Cons2(transformer.transform(h), t.map(transformer))


  /*
  [1,2].flatMap(n => [n, n+1])
  = [1,2] ++ [2].flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty
  = [1,2,2,3]
 */
  def flatMap[B](transformer: MyTransformer[A, GenericList[B]]): GenericList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  /*
    [1,2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5))
   */
  def ++[B >: A](list: GenericList[B]): GenericList[B] = new Cons2(h, t ++ list)
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}

object GenericList extends App {
  val listOfInteger: GenericList[Int] = new Cons2(1, new Cons2(2, new Cons2(3, Empty2)))
  val cloneListOfInteger: GenericList[Int] = new Cons2(1, new Cons2(2, new Cons2(3, Empty2)))
  val anotherListOfInteger: GenericList[Int] = new Cons2(4, new Cons2(5, Empty2))
  val listOfString: GenericList[String] = new Cons2("Hello", new Cons2("scala", Empty2))

  println(listOfInteger.toString)
  println(listOfString.toString)

  println(listOfInteger.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOfInteger.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element %2 == 0
  }).toString)

  println((listOfInteger ++ anotherListOfInteger).toString)

  println(listOfInteger.flatMap(new MyTransformer[Int, GenericList[Int]] {
    override def transform(elem: Int): GenericList[Int] = new Cons2(elem, new Cons2(elem+1, Empty2))
  }).toString)

  println(listOfInteger == cloneListOfInteger)
}
