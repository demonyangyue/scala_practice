package org.stairwaybook.simulation

/**
 * @author yy
 */

import Simulator.Action

case class WorkItem(time: Int, action: Action)

class Simulator {
  private var curtime = 0  
  def currentTime: Int = curtime

  private var agenda: List[WorkItem] = List()

  private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem]  = {
    if (ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(ag.tail, item)
  }

  def afterDelay(delay: Int)(block: =>Unit) = {
    val item = WorkItem(currentTime + delay, () => block) 
    agenda = insert(agenda, item)
  }

  private def executeNext() = {
    (agenda: @unchecked) match {
      case item :: rest => 
        agenda = rest
        curtime = item.time
        item.action()
    }
  }

  def run() = {
    afterDelay(0) {
      println("*** simulation started, time = " + currentTime + " ***")
    } 
    while (!agenda.isEmpty) executeNext()
  }
}

object Simulator {
  type Action = () => Unit
}
