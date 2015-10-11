package org.example

object Msortsample extends App {
  def msort[T](less: (T,T)=> Boolean)(xs: List[T]): List[T]  = {
     
    def merge(ys: List[T], zs: List[T]): List[T]  = {
      (ys, zs)  match {
          case (Nil, _) => zs
          case (_, Nil) => ys
          case (y1 :: ys1, z1 :: zs1) => {
            if (less(y1,z1)) {
              y1 :: merge(ys1,zs)
             } else {
              z1 :: merge(ys,zs1) 
             }
          }
      }
    }

    val mid = xs.length / 2
    if (mid == 0) {
      xs
    } else {
      val (ys, zs) = xs splitAt mid
      println("merge at " + mid)
      merge(msort(less)(ys), msort(less)(zs))

    }
  }

  println("Hello, msortSample")
  val li = List(4,5,3,1,8)
  val res = msort[Int](_<_)(li)
  println(res)
}
