import com.Parser;
import expressions.*;
import expressions.Number;
import sun.security.krb5.internal.PAData;

/**
 * Class ExpressionTree
 **/
public class ExpressionTree {
    /**
     * class TreeNode
     **/
    public class TreeNode {
        Expression data;
        TreeNode left, right;

        /**
         * constructor
         **/
//        public TreeNode(char data)
//        {
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
        public TreeNode(Expression data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    /**
     * class StackNode
     **/
    public class StackNode {
        TreeNode treeNode;
        StackNode next;

        /**
         * constructor
         **/
        StackNode(TreeNode treeNode) {
            this.treeNode = treeNode;
            next = null;
        }
    }

    private static StackNode top;

    /**
     * constructor
     **/
    public ExpressionTree() {
        top = null;
    }

    /**
     * function to clear tree
     **/
    public void clear() {
        top = null;
    }

    /**
     * function to push a node
     **/
    private void push(TreeNode ptr) {
        if (top == null)
            top = new StackNode(ptr);
        else {
            StackNode nptr = new StackNode(ptr);
            nptr.next = top;
            top = nptr;
        }
    }

    /**
     * function to pop a node
     **/
    private TreeNode pop() {
        if (top == null)
            throw new RuntimeException("Underflow");
        else {
            TreeNode ptr = top.treeNode;
            top = top.next;
            return ptr;
        }
    }

    /**
     * function to get top node
     **/
    private TreeNode peek() {
        return top.treeNode;
    }

    /**
     * function to insert character
     **/
    private void insert(char val) {
        try {
            if (Parser.isNumber(val)) {
                TreeNode nptr = new TreeNode(new Number(Double.parseDouble(val+"")));
                push(nptr);

            }
            if (Parser.isOperator(val)) {
                TreeNode nptr = new TreeNode(new Symbol(val+""));
                nptr.left = pop();
                nptr.right = pop();
                push(nptr);
            }
            if (Parser.isSymbol(val)) {
                TreeNode nptr = new TreeNode(new Symbol(val+""));
                push(nptr);
            }
//            else {
//                TreeNode nptr = new TreeNode(val);
//                push(nptr);
//            }
        } catch (Exception e) {
            System.out.println("Invalid Expression");
        }
    }


    /**
     * function to convert character to digit
     **/
    private int toDigit(char ch) {
        return ch - '0';
    }

    /**
     * function to build tree from input
     */
    public void buildTree(String eqn) {
        for (int i = eqn.length() - 1; i >= 0; i--)
            insert(eqn.charAt(i));
    }

    /**
     * function to evaluate tree
     */
    public Expression evaluate() {
        return evaluate(peek());
    }

    /**
     * function to evaluate tree
     */
    public Expression evaluate(TreeNode ptr) {
        if (ptr.left == null && ptr.right == null)
            return ptr.data;
//            return ptr.data;
        else {
            Expression result = null;
            Expression left = evaluate(ptr.left);
            Expression operator = ptr.data;
            Expression right = evaluate(ptr.right);

            switch (((Symbol)operator).getValue()) {
                case "+":
                    result = left.add(right);
                    break;
                case "-":
                    result = left.subtract(right);
                    break;
                case "*":
                    result = left.multiply(right);
                    break;
                case "/":
                    result = left.divide(right);
                    break;
                default:
                    result = left.add(right);
                    break;
            }
            return result;
        }
    }

    /**
     * function to get postfix expression
     */
    public void postfix() {
        postOrder(peek());
    }

    /**
     * post order traversal
     */
    private void postOrder(TreeNode ptr) {
        if (ptr != null) {
            postOrder(ptr.left);
            postOrder(ptr.right);
            System.out.print(ptr.data);
        }
    }

    /**
     * function to get infix expression
     */
    public void infix() {
        inOrder(peek());
    }

    /**
     * in order traversal
     */
    private void inOrder(TreeNode ptr) {
        if (ptr != null) {
            inOrder(ptr.left);
            System.out.print(ptr.data);
            inOrder(ptr.right);
        }
    }

    /**
     * function to get prefix expression
     */
    public void prefix() {
        preOrder(peek());
    }

    /**
     * pre order traversal
     */
    private void preOrder(TreeNode ptr) {
        if (ptr != null) {
            System.out.print(ptr.data);
            preOrder(ptr.left);
            preOrder(ptr.right);
        }
    }
}

