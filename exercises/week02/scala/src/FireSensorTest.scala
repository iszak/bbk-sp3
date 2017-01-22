import org.junit.Test
import org.junit.Assert.assertEquals

class FireSensorTest {
  @Test def testThatIsTriggeredReturnsFalse() {
    val sensor: FireSensor = new FireSensor
    val isTriggered: Boolean = sensor.isTriggered
    assertEquals(false, isTriggered)
  }

  @Test def testThatGetLocationReturnsNull() {
    val sensor: FireSensor = new FireSensor
    val location: String = sensor.getLocation
    assertEquals(null, location)
  }

  @Test def testThatGetSensorTypeReturnsNull() {
    val sensor: FireSensor = new FireSensor
    val sensorType: String = sensor.getSensorType
    assertEquals(null, sensorType)
  }

  @Test def testThatGetBatteryPercentageReturnsNegativeOne() {
    val sensor: FireSensor = new FireSensor
    val batteryPercentage: Double = sensor.getBatteryPercentage
    assertEquals(-1.0, batteryPercentage, 0.01)
  }
}