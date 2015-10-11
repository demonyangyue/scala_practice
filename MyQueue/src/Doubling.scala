

/**
 * @author yy
 */
trait Doubling extends IntQueue{
  abstract override def put(item: Int) = super.put(item * 2)
}
