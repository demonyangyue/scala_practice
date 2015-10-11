package org.strirwaybook.expr
import org.strirwaybook.expr._
/**
 * @author yy
 */
object Express extends App {
  val f = new ExprFormatter 
  val e1 = BinOp("*", BinOp("/", Number(1), Number(2)),
                      BinOp("+", Var("x"), Number(1)))
  println(f.format(e1) + "\n\n")

}
