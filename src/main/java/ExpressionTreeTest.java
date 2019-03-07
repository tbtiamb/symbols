import expressions.Expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExpressionTreeTest {
    public static void main(String[] args) {

        ExpressionTree et = new ExpressionTree();
//"(?=[+|\\-|*|/|^|(|)])|(?<=[+|\\-|*|/|^|(|)])"
//        String input = "5+2+a+3";
        String input = "a+a+a+a+a+a+a+a+a+a+a+a+a";
//        String[] strings = input.split("(?=[+|\\\\-|*|/|^|(|)])|(?<=[+|\\\\-|*|/|^|(|)])");
//        List<String> stringList = Arrays.asList(strings);
//        String tst = GFG.infixToPrefix(strings);
        et.buildTree(GFG.infixToPrefix(input));
//        System.out.println(GFG.infixToPrefix("(a+b+c)*a/c"));
//        String [] strs = "2a+c".split("(?=[+|\\\\-|*|^|(|)])|(?<=[+|\\\\-|*|^|(|)])");
////        System.out.println();
//        List<String> stringList = new ArrayList<>();
//        Collections.addAll(stringList, strs);
//        stringList.add(10,"*");
//        System.out.print("\nPrefix  : ");
//        et.prefix();
//        System.out.print("\n\nInfix   : ");
//        et.infix();
//        System.out.print("\n\nPostfix : ");
//        et.postfix();

        Expression expression = et.evaluate();

//        System.out.println(Symbol.isTwinChars("abx", "xab"));
        System.out.println("\n\nEvaluated Result : " + et.evaluate());
    }
}