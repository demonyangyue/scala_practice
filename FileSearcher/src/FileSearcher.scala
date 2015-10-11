class FileSearcher {
  
  private def fileList = (new java.io.File(".")).listFiles

  private def matchPattern(matcher: String => Boolean)  = {
    for (file <- fileList 
         if matcher(file.getName))
          yield file
  }


  def matchEnd(pattern: String)  = {
    matchPattern(_.endsWith(pattern))
  }
}

/**
 * @author yy
 */
object FileSearcher extends App {
  val fileSearcher = new FileSearcher()
  fileSearcher.matchEnd(".settings").foreach(file => println(file.getName))
}
