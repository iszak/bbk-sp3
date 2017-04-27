package mediator

trait Colleague {
  protected var mediator:MachineMediator = _

  def setMediator(mediator: MachineMediator): Unit = this.mediator = mediator
}