class SmokeSensor(trigger: Trigger) extends Sensor with BatteryPoweredSensor {
  override def isTriggered: Boolean = trigger.trigger

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}
