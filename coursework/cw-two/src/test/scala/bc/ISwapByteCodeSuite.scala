package bc

import org.scalatest.FunSuite
import vm._

class ISwapByteCodeSuite extends FunSuite with ByteCodeValues {
  test("swap top 2 integer and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](2,3))

    vm = vm.execute(Vector[ByteCode](
      new ISwapByteCode
    ))

    assert(vm.state == Vector(3,2))
  }
}
