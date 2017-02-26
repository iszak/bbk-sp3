package bc

import org.scalatest.FunSuite
import vm._

class IIncByteCodeSuite extends FunSuite with ByteCodeValues {
  test("pops top integer increments it and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](3,4))

    vm = vm.execute(Vector[ByteCode](
      new IIncByteCode
    ))

    assert(vm.state == Vector(3,5))
  }
}
