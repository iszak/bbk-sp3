// TODO: Should Array[Sensor] be Array[SecuritySensor] or Array[MotionSensor]
class SecurityControlUnit(sensors: Array[Sensor], timeCheck: TimeCheck) extends ControlUnit(sensors) {
  override def pollSensors(): Unit = {
    if (timeCheck.check()) {
      super.pollSensors()
    }
  }
}
