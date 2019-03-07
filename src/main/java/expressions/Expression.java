package expressions;

public interface Expression {

    Expression add(Expression other);
    Expression add(SummedExpression other);
    Expression add(FractionalExpression other);
    Expression add(Number other);
    Expression add(Symbol other);

    Expression multiply(Expression other);
    Expression multiply(SummedExpression other);
    Expression multiply(FractionalExpression other);
    Expression multiply(Number other);
    Expression multiply(Symbol other);

    Expression divide(Expression other);
    Expression divide(SummedExpression other);
    Expression divide(FractionalExpression other);
    Expression divide(Number other);
    Expression divide(Symbol other);

    Expression subtract(Expression other);
    Expression subtract(SummedExpression other);
    Expression subtract(FractionalExpression other);
    Expression subtract(Number other);
    Expression subtract(Symbol other);
}
