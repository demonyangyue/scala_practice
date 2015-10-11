

/**
 * @author yy
 */

class MyQueue extends BasicIntQueue with Filtering with Doubling
  

object MyQueue extends App {

  val myQueue = new MyQueue
  myQueue.put(-1)
  myQueue.put(0)
  myQueue.put(1)
  println(myQueue.get)
  println(myQueue.get)
  
}
