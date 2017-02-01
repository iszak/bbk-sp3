import java.io.IOException
import java.util.Scanner

object App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  @throws[IOException]
  def main(args: Array[String]) {
    val sensors = Array[Sensor](
      new FireSensor(new ProbabilityTrigger(5)),
      new SmokeSensor(new ProbabilityTrigger(10))
    )
    val controlUnit: ControlUnit = new ControlUnit(sensors)
    val scanner: Scanner = new Scanner(System.in)
    var input: String = ""

    while (input != EXIT) {
      println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
      input = scanner.nextLine
      if (input == POLL) {
        controlUnit.pollSensors()
      }
    }
  }
}
