package expressions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringExpression implements Expression {

    private String value;

    public StringExpression(String value) {
        this.value = value;
    }

    @Override
    public Expression addition(Expression other) {
        return null;
    }

    @Override
    public StringExpression addition(IntegerExpression other) {
        this.value += "+" + other;
        return new StringExpression(this.value);
    }

    @Override
    public Expression addition(DoubleExpression other) {
        this.value += "+" + other;
        return new StringExpression(this.value);
    }

    @Override
    public Expression multiplication(Expression other) {
        return null;
    }

    @Override
    public Expression multiplication(IntegerExpression other) {
        this.value += "*" + other;
        return new StringExpression(this.value);
    }

    @Override
    public Expression multiplication(DoubleExpression other) {
        this.value += "*" + other;
        return new StringExpression(this.value);
    }

    @Override
    public Expression division(Expression other) {
        return null;
    }

    @Override
    public Expression division(IntegerExpression other) {
        return null;
    }

    @Override
    public Expression division(DoubleExpression other) {
        return null;
    }

    @Override
    public Expression subtraction(Expression other) {
        return null;
    }

    @Override
    public Expression subtraction(IntegerExpression other) {
        return null;
    }

    @Override
    public Expression subtraction(DoubleExpression other) {
        return null;
    }
}
