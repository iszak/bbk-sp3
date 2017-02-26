package bc

import org.scalatest.FunSuite
import vm._

class IDecByteCodeSuite extends FunSuite with ByteCodeValues {
  test("pops top integer decrements it and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](3,4))

    vm = vm.execute(Vector[ByteCode](
      new IDecByteCode
    ))

    assert(vm.state == Vector(3,3))
  }
}
