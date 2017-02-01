import java.util.Calendar

// TODO: Test
class CalendarTimeCheck(calendar: Calendar) extends TimeCheck {
  override def check(): Boolean = {
    val hour = calendar.get(Calendar.HOUR_OF_DAY)

    // TODO: Ideally make these configurable
    hour >= 21 || hour <= 6
  }
}
