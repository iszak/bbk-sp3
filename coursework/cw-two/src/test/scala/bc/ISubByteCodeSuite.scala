package bc

import org.scalatest.FunSuite
import vm._

class ISubByteCodeSuite extends FunSuite with ByteCodeValues {
  test("subtracts top 2 integer and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](2,3))

    vm = vm.execute(Vector[ByteCode](
      new ISubByteCode
    ))

    assert(vm.state == Vector(1))
  }
}
