import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpressionTreeTest {
    public static void main(String[] args) {

        ExpressionTree et = new ExpressionTree();
//"(?=[+|\\-|*|/|^|(|)])|(?<=[+|\\-|*|/|^|(|)])"
        et.buildTree(GFG.infixToPrefix("1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1"));
//        System.out.println(GFG.infixToPrefix("(a+b+c)*a/c"));
        String [] strs = "2a+c".split("(?=[+|\\\\-|*|^|(|)])|(?<=[+|\\\\-|*|^|(|)])");
        System.out.println();
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, strs);
        stringList.add(10,"*");
//        System.out.print("\nPrefix  : ");
//        et.prefix();
//        System.out.print("\n\nInfix   : ");
//        et.infix();
//        System.out.print("\n\nPostfix : ");
//        et.postfix();
        Symbol symbol1 = new Symbol("abc");
        Symbol symbol2 = new Symbol("caba");

//        System.out.println(symbol1.add(symbol2));


//        System.out.println(Symbol.isTwinChars("abx", "xab"));
        System.out.println("\n\nEvaluated Result : " + et.evaluate());
    }
}