package expressions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoubleExpression implements Expression {

    private String value;

    @Override
    public Expression addition(Expression other) {
        return null;
    }

    @Override
    public Expression multiplication(Expression other) {
        return null;
    }

    @Override
    public Expression division(Expression other) {
        return null;
    }

    @Override
    public Expression subtraction(Expression other) {
        return null;
    }
}
