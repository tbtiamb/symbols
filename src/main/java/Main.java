import com.Parser;
import expressions.Expression;
import expressions.Number;
import expressions.Symbol;

public class Main {
    public static void main(String[] args) {
        Number number1 = new Number(2.0);
        Number number2 = new Number(3.2);
        Symbol symbol1 = new Symbol("a");

//        Expression expression = number1.add(symbol1);
        Expression expression = Parser.getExpression(number1);
        Expression expr = number2.add(expression);
        System.out.println();
    }
}
