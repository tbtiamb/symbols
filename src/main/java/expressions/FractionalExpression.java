package expressions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FractionalExpression implements Expression {

    private Double coefficient;
    private List<Expression> numerator;
    private List<Expression> denominator;

    public FractionalExpression() {
        this.coefficient = 1.0;
        this.numerator = new ArrayList<>();
        this.denominator = new ArrayList<>();
    }

    public FractionalExpression(Expression expression) {
        this.numerator = ((FractionalExpression) expression).numerator;
        this.denominator = ((FractionalExpression) expression).denominator;
        this.coefficient = ((FractionalExpression) expression).coefficient;
    }

    public void addExprToNumerator(Expression expr) {
        this.numerator.add(expr);
    }

    public void addExprToDenominator(Expression expr) {
        this.denominator.add(expr);
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
    public Expression add(Number other) {
        SummedExpression summedExpression = new SummedExpression();
        summedExpression.addExpression(this);
        summedExpression.addExpression(other);
        return summedExpression;
    }

    @Override
    public Expression add(Symbol other) {
        if (this.numerator.size() == 1 && ((Symbol) this.numerator.get(0)).getValue().equals(other.getValue())) {
            this.coefficient++;
            return this;
        }
        SummedExpression summedExpression = new SummedExpression();
        summedExpression.addExpression(this);
        summedExpression.addExpression(other);
        return summedExpression;
    }

    @Override
    public Expression multiply(Expression other) { 
        return null;    
    }

    @Override
    public Expression multiply(SummedExpression other) {
        return null; 
    }

    @Override
    public Expression multiply(FractionalExpression other) {
        return null;
    }

    @Override
    public Expression multiply(Number other) {
        return null;
    }

    @Override
    public Expression multiply(Symbol other) {
        return null;
    }

    @Override
    public Expression divide(Expression other) {
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
    public Expression subtract(Expression other) {
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
