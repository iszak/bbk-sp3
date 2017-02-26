package bc

import org.scalatest.FunSuite
import vm._

class PrintByteCodeSuite extends FunSuite with ByteCodeValues {
  test("pops top integer and prints it to the console") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](3,4))

    vm = vm.execute(Vector[ByteCode](
      new PrintByteCode
    ))

    assert(vm.state == Vector(3))
  }
}
