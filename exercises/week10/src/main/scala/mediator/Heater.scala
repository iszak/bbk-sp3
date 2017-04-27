package mediator

class Heater extends Colleague {
  def on(temp: Int): Unit = {
    println("Heater is on...")
    if (mediator.checkTemperature(temp)) {
      println(s"Temperature reached $temp C")
      println(s"Temperature is set to $temp C")
    }
  }

  def off(): Unit = println("Heater is off...")
}