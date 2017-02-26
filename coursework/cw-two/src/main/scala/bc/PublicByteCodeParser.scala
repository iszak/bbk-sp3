package bc

class PublicByteCodeParser(bcf:ByteCodeFactory) extends ByteCodeParser with ByteCodeValues {
  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * You should use [[ByteCodeValues.bytecode]] to help translate
    * the individual `Byte`s into a correponding [[ByteCode]].
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    var byteCodes = Vector[ByteCode]()

    var index:Int = 0
    while (index < bc.length) {
      val byteCodeCode = bc(index)
      // TODO: Dynamically determine instructions and operands
      if (byteCodeCode == 1) {
        byteCodes = byteCodes :+ bcf.make(byteCodeCode, bc(index + 1).toInt)
        index += 2
      } else {
        byteCodes = byteCodes :+ bcf.make(byteCodeCode)
        index += 1
      }
    }

    byteCodes
  }
}
