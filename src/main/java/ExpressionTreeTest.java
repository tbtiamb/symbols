import java.util.Scanner;


public class ExpressionTreeTest
{
    public static void main(String[] args)
    {

        ExpressionTree et = new ExpressionTree();

        et.buildTree(GFG.infixToPrefix("4+4*2^2"));

//        System.out.print("\nPrefix  : ");
//        et.prefix();
//        System.out.print("\n\nInfix   : ");
//        et.infix();
//        System.out.print("\n\nPostfix : ");
//        et.postfix();
        Symbol symbol1 = new Symbol("abc", null, null);
        Symbol symbol2 = new Symbol("cab", null, null);


        System.out.println(Symbol.isTwinChars("abx", "xab"));
//        System.out.println("\n\nEvaluated Result : "+ et.evaluate());
    }
}