/**
 * @author yy
 */
package org.strirwaybook.layout
import Element.elem
import org.strirwaybook.layout._

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = contents(0).length

  override def toString  = contents mkString "\n"

  def above(that: Element) :Element  = {
    val this1 = this widen that.width  
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element) :Element  = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((str1, str2) <- this1.contents zip that1.contents )
        yield str1 + str2
      )
    
  }
   
  def widen(w: Int) :Element  = {
    
    if (w <= width) {
      this
    } else {
      val left = elem(' ', (w-width)/2, height)
      val right = elem(' ', w-width-left.width, height)
      left beside this beside right
    }
  }

  def heighten(h: Int) :Element  = {
    
    if (h <= height) {
      this
    } else {
      
      val top = elem(' ', width, (h - height)/2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  }
}

object Element {
   
  def elem(contents: Array[String]) :Element  = {
    new ArrayElement(contents) 
  }

  def elem(chr: Char, width: Int, height: Int) :Element  = {
    new UniformElement(chr, width, height) 
  }

  def elem(line: String) :Element  = {
    new LineElement(line)
  }
}
