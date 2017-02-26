package bc

import org.scalatest.FunSuite
import vm._

class IMulByteCodeSuite extends FunSuite with ByteCodeValues {
  test("multiply top 2 integer and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](2,3))

    vm = vm.execute(Vector[ByteCode](
      new IMulByteCode
    ))

    assert(vm.state == Vector(6))
  }
}
