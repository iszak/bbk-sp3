import scala.collection.mutable.ListBuffer

object ControlUnit

class ControlUnit {
  def pollSensors() {
    val sensors = new ListBuffer[Sensor]()
    sensors += new FireSensor(new ProbabilityTrigger(5))
    sensors += new SmokeSensor(new ProbabilityTrigger(10))
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
}
