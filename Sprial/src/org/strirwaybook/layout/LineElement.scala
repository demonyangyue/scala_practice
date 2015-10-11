
/**
 * @author yy
 */

package org.strirwaybook.layout

class LineElement(line: String) extends Element {
  val contents = Array(line)
  override def width = line.length
  override def height = 1
}
