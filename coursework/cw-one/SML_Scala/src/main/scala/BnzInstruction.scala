package sml

case class BnzInstruction(label: String, opcode: String, register: Int, value: String) extends Instruction(label, opcode) {

  override def execute(m: Machine) = {
    if (m.regs(register) != 0) {
      m.pc = m.labels.indexOf(value) match {
        case -1 => throw new IllegalArgumentException("Label not found " + value)
        case x => x
      }
    }

    Unit
  }

  override def toString(): String = {
    super.toString + " if register " + register + " is not zero go to label " + value
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, value: String) =
    new BnzInstruction(label, "bnz", register, value)
}