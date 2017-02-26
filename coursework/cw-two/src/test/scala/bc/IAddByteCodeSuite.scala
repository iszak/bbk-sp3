package bc

import org.scalatest.FunSuite
import vm._

class IAddByteCodeSuite extends FunSuite with ByteCodeValues {
  test("adds top 2 integer and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](1, 2))

    vm = vm.execute(Vector[ByteCode](
      new IAddByteCode
    ))

    assert(vm.state == Vector(3))
  }
}
