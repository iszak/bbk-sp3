package bc

import org.scalatest.FunSuite
import vm._

class INegByteCodeSuite extends FunSuite with ByteCodeValues {
  test("pops top integer negates it and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](3,4))

    vm = vm.execute(Vector[ByteCode](
      new INegByteCode
    ))

    assert(vm.state == Vector(3,-4))
  }
}
