package state

case class RoboticCook(r: Robot) extends RoboticState {
  // Similarly, when in cook state it can walk or cook
  def walk(): Unit = println("Walking...")
  def cook(): Unit = println("Cooking...")

  // but cannot be switched off
  def off(): Unit = println("Cannot cook at Off state.")
}
