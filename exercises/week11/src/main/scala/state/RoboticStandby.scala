package state

case class RoboticStandby(r: Robot) extends RoboticState {
  def walk(): Unit = {
    r.state = RoboticOn(r)
    r.state.walk()
  }
  def cook(): Unit = {
    r.state = RoboticCook(r)
    r.state.cook()
  }
  def off(): Unit = {
    r.state = RoboticOff(r)
    r.state.off()
  }
}
