package mediator

class Motor {
  def startMotor(): Unit = println("Starting motor...")

  def rotateDrum(rpm: Int): Unit = println(s"Rotating drum at $rpm rpm.")
}