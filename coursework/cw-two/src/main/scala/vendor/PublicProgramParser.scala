package vendor

import scala.io.Source

class PublicProgramParser extends ProgramParser {
  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String): InstructionList = Source.fromFile(file).getLines().map(parseInstruction).toVector

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String): InstructionList = string.split("\n").map(parseInstruction).toVector


  /**
    * parses a VM instruction from a string format to an Instruction type
    *
    * @param line a string in the format "opCode [operand1 ... operandN]"
    * @return
    */
  private def parseInstruction(line: String): Instruction = {
    val instruction = line.split(" ").toList
    val name = instruction.head
    val args = instruction.tail.map(arg => arg.toInt).toVector
    // TODO: Throw InvalidInstructionFormatException

    new Instruction(name, args)
  }
}
