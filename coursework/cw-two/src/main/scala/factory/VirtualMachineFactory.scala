package factory

import bc.{ByteCodeFactory, PublicByteCodeFactory, PublicByteCodeParser}
import vendor.{ProgramParser, PublicProgramParser}
import vm.{PublicVirtualMachine, PublicVirtualMachineParser, VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  def byteCodeFactory: ByteCodeFactory = new PublicByteCodeFactory

  def vendorParser: ProgramParser = new PublicProgramParser

  def byteCodeParser: PublicByteCodeParser = new PublicByteCodeParser(byteCodeFactory)

  def virtualMachineParser: VirtualMachineParser = new PublicVirtualMachineParser(byteCodeParser,vendorParser)

  def virtualMachine: VirtualMachine = new PublicVirtualMachine(Vector[Int]())

}
