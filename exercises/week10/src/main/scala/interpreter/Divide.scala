package interpreter

class Divide(private val leftExpression: Expression,
             private val rightExpression: Expression)
    extends Expression {

  override def interpret(): Int =
    leftExpression.interpret() / rightExpression.interpret()

}
