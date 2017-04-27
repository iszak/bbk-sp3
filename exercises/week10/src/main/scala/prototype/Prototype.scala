package prototype

trait Prototype extends Cloneable {
  override def clone(): AccessControl = throw new CloneNotSupportedException
}