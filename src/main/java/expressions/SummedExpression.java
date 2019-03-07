package expressions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SummedExpression implements Expression {

    private List<Expression> expressionList;

    public SummedExpression() {
        this.expressionList = new ArrayList<>();
    }

    public SummedExpression(Expression expression) {
        this.expressionList = ((SummedExpression)expression).expressionList;
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

    public void addExpression(Expression newExpression) {
        this.expressionList.add(newExpression);
    }

    @Override
    public Expression add(SummedExpression other) {
       SummedExpression summedExpression = new SummedExpression();
       for (Expression expression : other.getExpressionList()){
           summedExpression.addExpression(expression);
       }
        for (Expression expression : this.getExpressionList()){
            summedExpression.addExpression(expression);
        }
        return summedExpression;
    }

    @Override
    public Expression add(FractionalExpression other) {
        this.addExpression(other);
        return this;
    }

    @Override
    public Expression add(Number other) {
        for (Expression expression : this.expressionList){
            if (expression instanceof Number){
                Expression newExpression = expression.add(other);
                expressionList.remove(expression);
                expressionList.add(newExpression);
                return this;
            }
        }
        this.addExpression(other);
        return this;
    }

    @Override
    public Expression add(Symbol other) {
        this.addExpression(other);
        return this;
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
}
