import java.util.Calendar

// TODO: Should Array[Sensor] be Array[SecuritySensor] or Array[MotionSensor]
class SecurityControlUnit(sensors: Array[Sensor], calendar: Calendar) extends ControlUnit(sensors) {
  override def pollSensors(): Unit = {
    val hour = calendar.get(Calendar.HOUR_OF_DAY)

    // TODO: Ideally make these configurable
    if (hour >= 21 || hour <= 6) {
      super.pollSensors()
    }
  }
}
