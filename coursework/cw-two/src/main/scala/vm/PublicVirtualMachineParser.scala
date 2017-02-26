package vm
import bc.{ByteCode, ByteCodeParser, ByteCodeValues, InvalidBytecodeException}
import vendor.{Instruction, ProgramParser}

class PublicVirtualMachineParser(byteCodeParser:ByteCodeParser, vendorParser:ProgramParser)
  extends VirtualMachineParser with ByteCodeValues {
  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String): Vector[ByteCode] = parseInstructions(vendorParser.parse(file))

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  override def parseString(str: String): Vector[ByteCode] = parseInstructions(vendorParser.parseString(str))


  /**
    * @todo add comment
    * @param instructions
    * @return
    */
  private def parseInstructions(instructions: Vector[Instruction]) = {
    val vectorOfBytes = instructions.flatMap(instruction => {
      val key = instruction.name

      if (!bytecode.contains(key)) {
        throw new InvalidBytecodeException("Could not find instruction " + key)
      }

      val opcode = bytecode(key)
      val operands = instruction.args.map(_.toByte)

      Vector[Byte](opcode) ++ operands
    })

    byteCodeParser.parse(vectorOfBytes)
  }
}
