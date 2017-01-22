import org.junit.Test
import org.junit.Assert.assertEquals

class SmokeSensorTest {
  @Test def testThatIsTriggeredReturnsFalse() {
    val sensor: SmokeSensor = new SmokeSensor
    val isTriggered: Boolean = sensor.isTriggered
    assertEquals(false, isTriggered)
  }

  @Test def testThatGetLocationReturnsNull() {
    val sensor: SmokeSensor = new SmokeSensor
    val location: String = sensor.getLocation
    assertEquals(null, location)
  }

  @Test def testThatGetSensorTypeReturnsNull() {
    val sensor: SmokeSensor = new SmokeSensor
    val sensorType: String = sensor.getSensorType
    assertEquals(null, sensorType)
  }

  @Test def testThatGetBatteryPercentageReturnsNegativeOne() {
    val sensor: SmokeSensor = new SmokeSensor
    val batteryPercentage: Double = sensor.getBatteryPercentage
    assertEquals(-1.0, batteryPercentage, 0.01)
  }
}