package bc

import org.scalatest.FunSuite
import vm._

class IDivByteCodeSuite extends FunSuite with ByteCodeValues {
  test("divide top 2 integer and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](3,6))

    vm = vm.execute(Vector[ByteCode](
      new IDivByteCode
    ))

    assert(vm.state == Vector(2))
  }
}
