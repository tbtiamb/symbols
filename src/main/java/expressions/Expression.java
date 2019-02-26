package expressions;

public interface Expression {

    Expression addition(Expression other);
    Expression addition(IntegerExpression other);
    Expression addition(DoubleExpression other);

    Expression multiplication(Expression other);
    Expression multiplication(IntegerExpression other);
    Expression multiplication(DoubleExpression other);

    Expression division(Expression other);
    Expression division(IntegerExpression other);
    Expression division(DoubleExpression other);

    Expression subtraction(Expression other);
    Expression subtraction(IntegerExpression other);
    Expression subtraction(DoubleExpression other);
}
