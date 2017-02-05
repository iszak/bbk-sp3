package sml

case class OutInstruction(label: String, opcode: String, register: Int) extends Instruction(label, opcode) {
  override def execute(m: Machine) =
    println(m.regs(register))

  override def toString(): String = {
    super.toString + " printing register " + register
  }
}

object OutInstruction {
  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)
}