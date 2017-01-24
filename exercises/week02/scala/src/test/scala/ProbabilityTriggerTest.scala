import org.junit.Test
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse

class ProbabilityTriggerTest {
  @Test def testThatIsTriggeredReturnsTrue() {
    val trigger: ProbabilityTrigger = new ProbabilityTrigger(100)

    for (_ <- 1 to 100) assertTrue(trigger.trigger)
  }

  @Test def testThatIsTriggeredReturnsFalse() {
    val trigger: ProbabilityTrigger = new ProbabilityTrigger(0)

    for (_ <- 1 to 100) assertFalse(trigger.trigger)
  }
}