package bc

import org.scalatest.FunSuite
import vm._

class IConstByteCodeSuite extends FunSuite with ByteCodeValues {
  test("pushes integer onto vm stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int]())

    vm = vm.execute(Vector[ByteCode](
      new IConstByteCode(1),
      new IConstByteCode(2),
      new IConstByteCode(3)
    ))

    assert(vm.state == Vector(1, 2, 3))
  }
}
