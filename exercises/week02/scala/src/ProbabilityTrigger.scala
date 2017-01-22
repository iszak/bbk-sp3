import scala.util.Random
class ProbabilityTrigger(probability: Double) extends Trigger {
  // nextInt includes 0 so 0 to 100 = 101 integers
  // +1 is to support the probability of 0 (never)
  override def trigger: Boolean = Random.nextInt(99) + 1 <= probability
}
