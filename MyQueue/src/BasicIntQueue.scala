import scala.collection.mutable.ArrayBuffer

/**
 * @author yy
 */
class BasicIntQueue extends IntQueue {
  private val items = new ArrayBuffer[Int]
  def put(item: Int){
    items += item
  } 
  def get(): Int = items.remove(0)
}
