// CS 211 HW 6
// Ethan Hamilton

// This class contains the main method. It also converts infix expressions to postfix expressions,
// submitting the postfix expression to the Evaluator class to produce the result.
import java.io.*;
import java.util.*;

public class Converter {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("expressions.txt");
        Scanner s = new Scanner(f);

        while(s.hasNextLine()) {
            Converter c = new Converter(s.nextLine());
            System.out.println("infix:   " + c.getInfix());
            System.out.println("postfix: " + c.getPostfix());

            Evaluator e = new Evaluator(c.getPostfix());
            System.out.println(" result: " + e.evaluate());
            System.out.println("---");
        }
    }

    String infix;
    public Converter(String infix) {
        this.infix = infix;
    }

    public String getInfix() {
        return infix;
    }

    public String getPostfix() { // converts the infix expression to a postfix expression.
        String result = "";
        Tokenizer t = new Tokenizer(infix);
        String symbols = "+-*/";
        Stack<String> operators = new Stack<>();

        while (t.hasNextToken()) { // iterates through the infix expression, processing each token based on the conditions set forth in the assignment
            String token = t.nextToken();
            if (token.equals("(")) {
                continue;
            } else if (symbols.contains(token)) {
                operators.push(token);
            } else if (token.equals(")")) {
                result += operators.pop() + " ";
            } else {
                result += token + " ";
            }
        }
        while (!operators.isEmpty()) { // ensures that any remaining operators in the stack are added to the result.
            result += operators.pop() + " ";
        }
        return result;
    }
}
