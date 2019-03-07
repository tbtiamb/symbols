package expressions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol implements Expression {

    private String value;

    public Symbol(String value) {
        this.value = value;
    }


    @Override
    public Expression multiply(Expression other) {
        return null;
    }

    @Override
    public Expression divide(Expression other) {
        return null;
    }

    @Override
    public Expression subtract(Expression other) {
        return null;
    }

    @Override
    public Expression add(Expression other) {
        if (other instanceof Symbol) {
            return this.add(new Symbol(other));
        }
        if (other instanceof Number) {
            return this.add(new Number(other));
        }
        if (other instanceof FractionalExpression) {
            return this.add(new FractionalExpression(other));
        }
        if (other instanceof SummedExpression) {
            return this.add(new SummedExpression(other));
        }
        return null;
    }

    public Symbol(Expression expression) {
        this.value = ((Symbol) expression).value;
    }

    @Override
    public Expression add(Number other) {
        SummedExpression summedExpression = new SummedExpression();
        summedExpression.addExpression(this);
        summedExpression.addExpression(other);
        return summedExpression;
    }

    @Override
    public Expression add(SummedExpression other) {
        other.addExpression(this);
        return other;
    }

    @Override
    public Expression add(FractionalExpression other) {
        SummedExpression summedExpression = new SummedExpression();
        summedExpression.addExpression(this);
        summedExpression.addExpression(other);
        return summedExpression;
    }

    @Override
    public Expression add(Symbol other) {
        if (this.value.equals(other.value)) {
            FractionalExpression fractionalExpression = new FractionalExpression();
            Double coefficient = fractionalExpression.getCoefficient();
            fractionalExpression.setCoefficient(++coefficient);
            fractionalExpression.addExprToNumerator(other);
            return fractionalExpression;
        }
        SummedExpression summedExpression = new SummedExpression();
        summedExpression.addExpression(this);
        summedExpression.addExpression(other);
        return summedExpression;
    }

    @Override
    public Expression multiply(Number other) {
        this.value += "*" + other;
        return new Symbol(this.value);
    }

    @Override
    public Expression multiply(SummedExpression other) {
        this.value += "*" + other;
        return new Symbol(this.value);
    }

    @Override
    public Expression multiply(FractionalExpression other) {
        return null;
    }

    @Override
    public Expression multiply(Symbol other) {
        return null;
    }

    @Override
    public Expression divide(SummedExpression other) {
        return null;
    }

    @Override
    public Expression divide(FractionalExpression other) {
        return null;
    }

    @Override
    public Expression divide(Number other) {
        return null;
    }

    @Override
    public Expression divide(Symbol other) {
        return null;
    }

    @Override
    public Expression subtract(SummedExpression other) {
        return null;
    }

    @Override
    public Expression subtract(FractionalExpression other) {
        return null;
    }

    @Override
    public Expression subtract(Number other) {
        return null;
    }

    @Override
    public Expression subtract(Symbol other) {
        return null;
    }
}
