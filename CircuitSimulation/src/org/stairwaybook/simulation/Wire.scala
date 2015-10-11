package org.stairwaybook.simulation

import Simulator.Action
/**
 * @author yy
 */
class Wire {
  private var sinalVal = false  
  private var actions: List[Action] = List() 

  def getSignal = sinalVal 

  def setSignal(value: Boolean)  = {
    if (value != sinalVal)    
      sinalVal = value
      actions foreach (_())
  }

  def addAction(a: Action) = {
    actions = a::actions 
    a()
  }
}

