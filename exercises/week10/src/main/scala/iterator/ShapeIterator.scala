package iterator

import java.util.Iterator

class ShapeIterator(var shapes: Array[Shape]) extends Iterator[Shape] {
  private var index:Integer = 0

  override def hasNext(): Boolean = index < shapes.length

  override def next(): Shape = {
    val shape = shapes(index)
    index = index + 1
    shape
  }

  override def remove(): Unit = {
    shapes = shapes.take(index) ++ shapes.drop(index + 1)
  }
}