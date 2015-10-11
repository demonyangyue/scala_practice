

/**
 * @author yy
 */
class NQueens {
  
  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] = {
      if (k == 0) List(List())
      else {
         for ( queens <- placeQueens(k-1);
             column <- 1 to n;
             queen = (k, column)
             if isSafe(queens, queen))
         yield queen :: queens
      }
    }

    placeQueens(n)
  
  }
  
  def isSafe(queens: List[(Int, Int)], queen: (Int, Int)): Boolean = {
    queens forall ( q => !inCheck(queen, q)) 
    
  }
  def inCheck(q1: (Int, Int), q: (Int, Int)): Boolean = {
           q1._1 == q._1 ||  q1._2 == q._2 || (q1._1 - q._1).abs == (q1._2 - q._2).abs
  }
      
}

object NQueens extends App {
  val nqueens = new NQueens
  nqueens.queens(8) foreach (println(_))
}
