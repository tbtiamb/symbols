package symb;

import java.util.Scanner;


public class ExpressionTreeTest
{
    public static void main(String[] args)
    {

        ExpressionTree et = new ExpressionTree();

        et.buildTree(GFG.infixToPrefix("100+1"));

//        System.out.print("\nPrefix  : ");
//        et.prefix();
//        System.out.print("\n\nInfix   : ");
//        et.infix();
//        System.out.print("\n\nPostfix : ");
//        et.postfix();
        Symbol symbol1 = new Symbol("abc");
        Symbol symbol2 = new Symbol("caba");

        System.out.println(symbol1.add(symbol2));


//        System.out.println(Symbol.isTwinChars("abx", "xab"));
//        System.out.println("\n\nEvaluated Result : "+ et.evaluate());
    }
}