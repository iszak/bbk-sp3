import org.scalatest.FunSuite
import org.scalactic.TripleEquals
import org.scalactic.Tolerance

class SmokeSensorSuite extends FunSuite with TripleEquals with Tolerance {
  test("that is triggered returns false") {
    val sensor: SmokeSensor = new SmokeSensor(new ProbabilityTrigger(0))
    val isTriggered: Boolean = sensor.isTriggered
    assert(!isTriggered)
  }

  test("that get location returns null") {
    val sensor: SmokeSensor = new SmokeSensor(new ProbabilityTrigger(0))
    val location: String = sensor.getLocation
    assert(location == null)
  }

  test("that get sensor type returns null") {
    val sensor: SmokeSensor = new SmokeSensor(new ProbabilityTrigger(0))
    val sensorType: String = sensor.getSensorType
    assert(sensorType == null)
  }

  test("that get battery percentage returns negative one") {
    val sensor: SmokeSensor = new SmokeSensor(new ProbabilityTrigger(0))
    val batteryPercentage: Double = sensor.getBatteryPercentage
    assert(batteryPercentage === -1.0 +- 0.01)
  }
}
