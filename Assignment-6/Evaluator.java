// CS 211 HW 6
// Ethan Hamilton

// This class contains the method to process the postfix expression and return the calculated result.
// Due to the limitations of storing floating point numbers, the result is marginally inaccurate.

import java.math.BigDecimal;
import java.util.*;

public class Evaluator {
    private String postfix;
    public Evaluator(String postfix) {
        this.postfix = postfix;
    }

    public double evaluate() { // This method evaluates the postfix expression, parsing the operands and applying both operators and operands to the calculate method.
        Tokenizer t = new Tokenizer(postfix);
        Stack<Double> operands = new Stack<>();
        String symbols = "+-*/";
        while (t.hasNextToken()) {
            String token = t.nextToken();
            if (symbols.contains(token)) {
                double op2 = operands.pop();
                double op1 = operands.pop();
                operands.push(calculate(token, op1, op2));
            } else {
                operands.push(Double.parseDouble(token));
            }
        }
        return operands.pop(); // This returns the final calculated result of the postfix expression.
    }

    private double calculate(String operator, double op1, double op2) { // This method calculates the result of the operation based on the operator and the two operands.
        if (operator.equals("+")) {
            return op1 + op2;
        } else if (operator.equals("-")) {
            return op1 - op2;
        } else if (operator.equals("*")) {
            return op1 * op2;
        } else if (operator.equals("/")) {
            return op1 / op2;
        } else {
            // impossible
            return -9999.0;
        }
    }
}
