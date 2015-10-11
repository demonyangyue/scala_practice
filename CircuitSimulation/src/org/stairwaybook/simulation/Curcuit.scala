package org.stairwaybook.simulation

/**
 * @author yy
 */

class Curcuit extends Simulator {
    def InverterDelay: Int = 1
    def AndGateDelay: Int = 3
    def OrGateDelay: Int = 5

    def inverter(input: Wire, output: Wire) = {
      def invertAction() {
        val inputSig = input.getSignal
        afterDelay(InverterDelay) {
          output setSignal !inputSig 
        }
      }
      input addAction invertAction
    }

    def andGate(a1: Wire, a2: Wire, output: Wire) = {
      def andAction() = {
        val a1Sig = a1.getSignal
        val a2Sig = a2.getSignal
        afterDelay(AndGateDelay) {
          output setSignal (a1Sig & a2Sig) 
        }
      }
      a1 addAction andAction
      a2 addAction andAction
    }

    def orGate(o1: Wire, o2: Wire, output: Wire) {
      def orAction() {
        val o1Sig = o1.getSignal
        val o2Sig = o2.getSignal
        afterDelay(OrGateDelay) {
          output setSignal (o1Sig | o2Sig)
        }
      }
      o1 addAction orAction
      o2 addAction orAction
    }

    def probe(name: String, wire: Wire) {
      def probeAction() {
        println(name +" "+ currentTime +
            " new-value = "+ wire.getSignal)
      }
      wire addAction probeAction
    }

    
    def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire) {
      val d, e = new Wire
      orGate(a, b, d)
      andGate(a, b, c)
      inverter(c, e)
      andGate(d, e, s)
    }

    def fullAdder(a: Wire, b: Wire, cin: Wire,
        sum: Wire, cout: Wire) {
    
      val s, c1, c2 = new Wire
      halfAdder(a, cin, s, c1)
      halfAdder(b, s, sum, c2)
      orGate(c1, c2, cout)
    }
}

object Curcuit  {
  def main(args: Array[String]) = {
     
    val input1, input2, sum, carry = new Wire
  
    val cc = new Curcuit()

    cc.probe("sum", sum)
    cc.probe("carry", carry)
    cc.halfAdder(input1, input2, sum, carry)

    input1 setSignal true
    cc.run()

    input2 setSignal true
    cc.run()
  }
   
}
