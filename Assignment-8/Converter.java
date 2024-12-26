// CS 211 HW 8
// Ethan Hamilton


//   Converter can convert from infix notation into exprssion tree
//
//   for exmaple, the infix is:
//   3 + 2
//
//   the expression tree is like:
//      2
//   +
//      3


import java.io.*;
import java.util.*;

public class Converter {

    public static void main(String[] args) throws FileNotFoundException {        
        // TODO: change path to match where your input file is located
        File f = new File("expressions.txt");
        Scanner s = new Scanner(f);
        
        while(s.hasNextLine()) {
            Converter c = new Converter(s.nextLine());
            System.out.println("infix:       " + c.getInfix());           
            System.out.println("postfix:     " + c.getPostfix());
            
            Evaluator e1 = new Evaluator(c.getPostfix());
            System.out.println("result:      " + e1.evaluate());
            
            TreeNode root = c.getExpressionTree();
            
            TreeEvaluator e2 = new TreeEvaluator(root); 
            System.out.println("tree:");
            e2.print();
            
            System.out.println("tree result: " + e2.evaluatie());
            
            System.out.println("\n---\n");
        }
    }
    
    private String infix;
    private String operators = "+-*/";

    public Converter(String infix) {
        this.infix = infix;
    }
    
    public String getInfix() {
        return infix;
    }
    
    // This is a sample implementation for "postfix"
    public String getPostfix() {
        Tokenizer tokenizer = new Tokenizer(infix);
        Stack<String> ops = new Stack<>();
        
        String result = "";
        while(tokenizer.hasNextToken()) {
            String t = tokenizer.nextToken();
            if(t.equals("(")) {
                //nothing
            } else if (t.equals(")")) {
                result += ops.pop() + " ";
            } else if (operators.contains(t)) {
                ops.push(t);
            } else {
                result += t + " ";
            }
        }
        if(!ops.isEmpty()) {
            result += ops.pop() + " ";
        }
        return result;
    }
     
    // getExpressionTree constructs the expression tree from the infix expression. The tree is constructed by pushing the operands
    // onto the expressions stack and the operators onto the ops stack. When a closing parenthesis is encountered, the top two
    // operands are popped from the expressions stack and combined with the next operator from the ops stack. This process is repeated
    // until there are no more operators left.
    public TreeNode getExpressionTree() {
        Tokenizer tokenizer = new Tokenizer(infix);
        Stack<String> ops = new Stack<>();
        Stack<TreeNode> expressions = new Stack<>();

        while (tokenizer.hasNextToken()) {
            String t = tokenizer.nextToken();
            if (t.equals("(")) {
                // nothing
            } else if (operators.contains(t)) {
                ops.push(t);
            } else if (t.equals(")")) {
                expressions.push(new TreeNode(ops.pop(), expressions.pop(), expressions.pop()));
            } else {
                expressions.push(new TreeNode(t, null, null));
            }
        }
        if (!ops.isEmpty()) {
            expressions.push(new TreeNode(ops.pop(), expressions.pop(), expressions.pop()));
        }
        return expressions.pop();
    }
}