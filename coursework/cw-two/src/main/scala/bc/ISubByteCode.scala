package bc

import vm.VirtualMachine

class ISubByteCode extends ByteCode {
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[ByteCodeValues]]
    */
  override val code: Byte = 3

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val tuple1 = vm.pop()
    val tuple2 = tuple1._2.pop()

    tuple2._2.push(tuple1._1 - tuple2._1)
  }
}
