import org.scalatest.FunSuite

class ProbabilityTriggerSuite extends FunSuite {
  test("that is triggered returns true") {
    val trigger: ProbabilityTrigger = new ProbabilityTrigger(100)

    for (_ <- 1 to 100) assert(trigger.trigger)
  }

  test("that is triggered returns false") {
    val trigger: ProbabilityTrigger = new ProbabilityTrigger(0)

    for (_ <- 1 to 100) assert(!trigger.trigger)
  }
}
