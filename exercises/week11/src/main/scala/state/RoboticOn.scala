package state

case class RoboticOn(r: Robot) extends RoboticState {
  // If a robot is in an on state you can command it to walk
  def walk(): Unit = println("Walking...")

  // If asked to cook, the state would change to cook
  def cook(): Unit = r.state = RoboticCook(r)

  // or if set to off, it will be switched off
  def off(): Unit = {
    r.state = RoboticOff(r)
    r.state.off()
  }
}
