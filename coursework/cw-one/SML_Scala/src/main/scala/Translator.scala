package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        val label = fields(0)
        val instruction = fields(1)

        val packageName = this.getClass.getPackage.getName
        val className = instruction.capitalize + "Instruction"
        val klass = Class.forName(packageName + "." + className)

        // NOTE: This is not ideal if there is more than one constructor
        val constructor = klass.getConstructors()(0)
        val parameters = constructor.getParameterTypes

        val args:Array[AnyRef] = fields.zipWithIndex.map(
          (element) => {
            val value = element._1
            val klass = parameters(element._2)

            if (klass.isPrimitive) {
              if (klass.toString == "int") {
                value.toInt.asInstanceOf[AnyRef]
              } else {
                throw new IllegalArgumentException("Unsupported primitive type")
              }
            } else {
              klass.cast(value).asInstanceOf[AnyRef]
            }
          }
        )

        program = program :+ constructor.newInstance(args:_*).asInstanceOf[Instruction]

        labels.add(label)
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
