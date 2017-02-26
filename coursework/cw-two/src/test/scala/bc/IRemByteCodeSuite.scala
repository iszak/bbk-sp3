package bc

import org.scalatest.FunSuite
import vm._

class IRemByteCodeSuite extends FunSuite with ByteCodeValues {
  test("remainder of revision of the top 2 integer and pushes onto stack") {
    var vm: VirtualMachine = new PublicVirtualMachine(Vector[Int](3,4))

    vm = vm.execute(Vector[ByteCode](
      new IRemByteCode
    ))

    assert(vm.state == Vector(1))
  }
}
