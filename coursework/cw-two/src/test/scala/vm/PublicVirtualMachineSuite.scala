package vm
import bc._
import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicVirtualMachineSuite extends FunSuite {
  val vmp = VirtualMachineFactory.virtualMachineParser
  val bcp = VirtualMachineFactory.byteCodeParser
  val vm  = VirtualMachineFactory.virtualMachine

  test("state returns current stack") {
    var newVm1 = new PublicVirtualMachine(Vector[Int]())
    assert(newVm1.state.isEmpty)

    val vec = Vector[Int](1, 5, 10)
    newVm1 = new PublicVirtualMachine(vec)
    assert(newVm1.state.length == 3)
    assert(newVm1.state == vec)
  }

  test("push adds int to stack") {
    val newVm1: VirtualMachine = new PublicVirtualMachine(Vector[Int]())
    val newVm2 = newVm1.push(1).push(2).push(3)

    assert(newVm1.state.isEmpty)
    assert(newVm2.state.length == 3)
    assert(newVm2.state == Vector(1,2,3))
  }


  test("pop remove int from stack") {
    val newVm1: VirtualMachine = new PublicVirtualMachine(Vector[Int]())
    val newVm2: VirtualMachine = newVm1.push(1).push(2)
    val tuple = newVm2.push(3).pop()

    assert(newVm1.state.isEmpty)
    assert(tuple._1 == 3)
    assert(tuple._2.state == newVm2.state)
  }

  test("executeOne executes bytecode and retuns new VM") {
    val bcVector:Vector[ByteCode] = Vector(new IConstByteCode(1), new IConstByteCode(2))
    val newVm:VirtualMachine = new PublicVirtualMachine(Vector[Int]())
    val tuple = newVm.executeOne(bcVector)

    assert(Vector[ByteCode](bcVector(1)) == tuple._1)
    assert(tuple._2.state == Vector(1))
  }

  test("execute executes all bytecode") {
    val bcVector:Vector[ByteCode] = Vector(new IConstByteCode(1), new IConstByteCode(2))
    val newVm1:VirtualMachine = new PublicVirtualMachine(Vector[Int]())

    val newVm2 = newVm1.execute(bcVector)
    assert(newVm2.state == Vector(1, 2))
  }

  test("[10] a virtual machine should execute a program") {
    val bc  = vmp.parse("programs/p05.vm")
    val vm2 = vm.execute(bc)
  }

  test("[2] iconst should work correctly") {
    val bc  = vmp.parseString("iconst 1")
    val (bc2, vm2) = vm.executeOne(bc)
    assert(vm2.state.head == 1)
  }

  test("[2] iadd should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niadd")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 3)
  }

  test("[2] isub should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\nisub")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("[2] iswap should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niswap")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state(0) == 1)
    assert(next._2.state(1) == 2)
  }
}
