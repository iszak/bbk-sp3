package mediator

class Machine extends Colleague {
  def start(): Unit = {
    mediator.open()
    println("Filling water...")
    mediator.closed()

    mediator.on()
    mediator.off()

    this.wash()
  }

  def wash(): Unit = mediator.wash()
}