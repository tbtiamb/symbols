package expressions;

import com.Parser;
import lombok.Getter;
import lombok.Setter;
import sun.net.ftp.FtpClient;

@Getter
@Setter
public class Number implements Expression {


    private Double value;

    public Number(Double value) {
        this.value = value;
    }

    public Number(Expression expression) {
        this.value = ((Number)expression).value;
    }

    @Override
    public Expression add(Expression right) {
//        return this.add(Parser.getExpression(other));
        if (right instanceof Symbol) {
            return this.add(new Symbol(right));
        }
        if (right instanceof Number) {
            return this.add(new Number(right));
        }
        if (right instanceof FractionalExpression) {
            return this.add(new FractionalExpression(right));
        }
        if (right instanceof SummedExpression) {
            return this.add(new SummedExpression(right));
        }
        return null;
    }

    @Override
    public Expression add(Number other) {
        return new Number(this.value + other.value);
    }

    @Override
    public Expression add(Symbol other) {
        SummedExpression summedExpression = new SummedExpression();
        summedExpression.addExpression(new Number(this.value));
        summedExpression.addExpression(other);
        return summedExpression;
    }

    @Override
    public Expression add(SummedExpression other) {
        SummedExpression summedExpression = new SummedExpression();
        for (Expression expr : other.getExpressionList()) {
            if (expr instanceof Number) {
                ((Number) expr).value += this.value;
                return other;
            }
        }
//        other.addExpression(new Number(this.value));
//        summedExpression.setExpressionList(other.getExpressionList());
//        return summedExpression;
        other.getExpressionList().add(new Number(this.value));
        return other;
    }

    @Override
    public Expression add(FractionalExpression other) {
        for (Expression expr : other.getNumerator()) {
            if (expr instanceof Number) {
//                Number numberTemp = new Number();
//                ((Number) expr).value *= this.value; 123
                expr.multiply(new Number(this.value));
                return other;
            }
        }
        other.getNumerator().add(new Number(this.value));
        return other;
    }

    @Override
    public Expression multiply(Number other) {
        return new Number(this.value * other.value);

    }

    @Override
    public Expression multiply(Symbol other) {
        FractionalExpression fractionalExpression = new FractionalExpression();
        fractionalExpression.addExprToNumerator(new Number(this.value));
        fractionalExpression.addExprToNumerator(other);
        return fractionalExpression;
    }


    @Override
    public Expression multiply(SummedExpression other) {
        SummedExpression summedExpression = new SummedExpression();
        Number number = new Number(this.value);
        for (Expression expr : other.getExpressionList()) {
//            FractionalExpression fractionalExpression = new FractionalExpression();
//            if (expr instanceof Number){
//                ((Number) expr).value *= this.value;
//            }
//            if (expr instanceof Symbol){
//                ((Symbol) expr).multiply(new Number(this.value));
//            }
            summedExpression.addExpression(expr.multiply(number));
        }
        return summedExpression;
    }

    @Override
    public Expression multiply(FractionalExpression other) {
        Number number = new Number(this.value);
        for (Expression expr : other.getNumerator()) {
            if (expr instanceof Number) {
                expr.multiply(number);
                return other;
            }
        }
        other.getNumerator().add(number);
        return other;
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
    public Expression subtract(SummedExpression other) {
        return null;
    }

    @Override
    public Expression subtract(FractionalExpression other) {
        return null;
    }

    @Override
    public Expression subtract(Number other) {
        return new Number(this.value - other.value);
    }

    @Override
    public Expression subtract(Symbol other) {
        return null;
    }

    @Override
    public Expression divide(Number other) {
        return new Number(this.value / other.value); //123
    }

    @Override
    public Expression divide(Symbol other) {
        FractionalExpression fractionalExpression = new FractionalExpression();
        fractionalExpression.addExprToNumerator(new Number(this.value));
        fractionalExpression.addExprToDenominator(other);
        return fractionalExpression;
    }

    @Override
    public Expression divide(SummedExpression other) {
        FractionalExpression fractionalExpression = new FractionalExpression();
        fractionalExpression.addExprToNumerator(new Number(this.value));
        fractionalExpression.addExprToDenominator(other);
        return fractionalExpression;
    }

    @Override
    public Expression divide(FractionalExpression other) { //123
        FractionalExpression fractionalExpression = new FractionalExpression();
        fractionalExpression.addExprToNumerator(new Number(this.value));
        for (Expression expr : other.getDenominator()) {
            fractionalExpression.addExprToNumerator(expr);
        }
        return fractionalExpression;
    }

}
