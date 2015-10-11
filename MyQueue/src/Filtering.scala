

/**
 * @author yy
 */
trait Filtering extends IntQueue {
  abstract override def put(item: Int) = if(item >= 0) super.put(item) 
}
