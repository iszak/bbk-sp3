class FireSensor(trigger: Trigger) extends Sensor {
  override def isTriggered: Boolean = trigger.trigger

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}
