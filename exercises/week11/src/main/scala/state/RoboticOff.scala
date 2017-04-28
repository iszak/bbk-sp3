package state

case class RoboticOff(r: Robot) extends RoboticState {
  // And finally, when in off state it will automatically turn on and walk when the user commands
  // it to walk
  def walk(): Unit = {
    r.state = RoboticOn(r)
    r.state.walk()
  }
  def cook(): Unit = println("Cannot cook at Off state.")
  def off(): Unit = println("Robot is switched off")
}
