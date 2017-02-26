package bc

class PublicByteCodeFactory extends ByteCodeFactory {
  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = {
    // TODO: Dynamically load byte code classes
    // TODO: Dynmaically pass in args?
    byte match {
      case 1 => new IConstByteCode(args(0))
      case 2 => new IAddByteCode
      case 3 => new ISubByteCode
      case 4 => new IMulByteCode
      case 5 => new IDivByteCode
      case 6 => new IRemByteCode
      case 7 => new INegByteCode
      case 8 => new IIncByteCode
      case 9 => new IDecByteCode
      case 10 => new ISwapByteCode
      case 11 => new IDupByteCode
      case 12 => new PrintByteCode
      case _ => throw new InvalidBytecodeException("Byte " + byte + " not found")
    }
  }
}
