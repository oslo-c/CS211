// CS 211 HW 8
// Ethan Hamilton
//   
// TreeEvaluator can evaluate the expression tree.
// It can also print the tree in "vertical format" for you to inspect.

public class TreeEvaluator {
    private TreeNode root;
    public TreeEvaluator(TreeNode root) {
        this.root = root;
    }

    public double evaluatie() {
        return evaluateHelper(root);
    }
    
    // evaluateHelper is a recursive function that evaluates the expression tree. Because of the way the tree is constructed, 
    // the right child is always the first to be evaluated. Otherwise, the operations will be applied in the wrong order.
    private double evaluateHelper(TreeNode node) {
        if (node.isOperator()) {
            return calculate(node.getOperator(), evaluateHelper(node.getRightChild()), evaluateHelper(node.getLeftChild()));
        } else if (node.isNumber()) {
            return node.getNumber();
        } else {
            throw new IllegalStateException();
        }
    }
 
    // calculate prerforms the arithmetic operation on the two given operands.
    private double calculate(String operator, double op1, double op2) {
        if (operator.equals("+")) {
            return op1 + op2;
        } else if (operator.equals("-")) {
            return op1 - op2;
        } else if (operator.equals("*")) {
            return op1 * op2;
        } else if (operator.equals("/")) {
            return op1 / op2;
        } else {
            throw new IllegalStateException();
        }
    }
    
    public void print() {
        if(root != null) {
            printWithLevel(root, 0);            
        }
    }
    
    private void printWithLevel(TreeNode node, int level) {
        String content = " ";
        for(int i = 0; i < level; i++) {
            content += "      ";
        }
        content += node.getData();
        
        if (node.isOperator()) {
            printWithLevel(node.getRightChild(), level + 1);
            System.out.println(content);            
            printWithLevel(node.getLeftChild(), level + 1);
        } else if (node.isNumber()) {
            System.out.println(content);
        }
    }    
}