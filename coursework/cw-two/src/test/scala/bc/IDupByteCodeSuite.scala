package bc

import org.scalatest.FunSuite
import vm._

class IDupByteCodeSuite extends FunSuite with ByteCodeValues {
  test("pops top integer duplicates it and pushes both onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](3,4))

    vm = vm.execute(Vector[ByteCode](
      new IDupByteCode
    ))

    assert(vm.state == Vector(3,4,4))
  }
}
