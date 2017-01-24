import org.junit.Test
import org.junit.Assert.assertEquals

class SmokeSensorTest {
  @Test def testThatIsTriggeredReturnsFalse() {
    val sensor: SmokeSensor = new SmokeSensor(new ProbabilityTrigger(0))
    val isTriggered: Boolean = sensor.isTriggered
    assertEquals(false, isTriggered)
  }

  @Test def testThatGetLocationReturnsNull() {
    val sensor: SmokeSensor = new SmokeSensor(new ProbabilityTrigger(0))
    val location: String = sensor.getLocation
    assertEquals(null, location)
  }

  @Test def testThatGetSensorTypeReturnsNull() {
    val sensor: SmokeSensor = new SmokeSensor(new ProbabilityTrigger(0))
    val sensorType: String = sensor.getSensorType
    assertEquals(null, sensorType)
  }

  @Test def testThatGetBatteryPercentageReturnsNegativeOne() {
    val sensor: SmokeSensor = new SmokeSensor(new ProbabilityTrigger(0))
    val batteryPercentage: Double = sensor.getBatteryPercentage
    assertEquals(-1.0, batteryPercentage, 0.01)
  }
}