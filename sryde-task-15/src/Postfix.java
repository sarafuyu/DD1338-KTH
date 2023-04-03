/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  Sara Rydell
 * @version 2023-02-03
 * 
 * 
 */
public class Postfix {
    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr  Arithmetic expression in postfix notation
     * @return      The value of the evaluated expression
     * @throws      ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        
        expr = expr.trim(); // removes blank spaces
        String[] list = expr.split("\s+\t*"); // creates a list of all characters 

        LinkedList<Integer> stack = new LinkedList<>(); // creates our stack

        for (String element : list) {
            if (isInteger(element)) {
                int num = Integer.parseInt(element);
                stack.push(num);
            }
            else if (isOperator(element)) {
                // ensures there are enough values on the stack
                if (stack.size()<2) {
                    throw new ExpressionException(""); 
                }
                // accesses the correct values for our calculations
                int num1 = stack.pop();
                int num2 = stack.pop();
                // switches to the correct case based on the given operation
                switch(element){
                    case "+": 
                        stack.push(num2+num1);
                        break;

                    case "-":
                        stack.push(num2-num1);
                        break;

                    case "*": 
                        stack.push(num2*num1);
                        break;

                    case "/": 
                        // ensures that the expression should not be divided by 0
                        if (num1==0) {
                            throw new ExpressionException(""); 
                        }   
                        stack.push(num2/num1);
                        break;
                }
            }
            else {
                // if the element is not an integer or an operator the input is invalid
                throw new ExpressionException("");
            }
        }
        if (stack.size()!=1) {
            throw new ExpressionException("");
        }
        int calculation = stack.pop();
        return calculation;
    }

    /**
     * Returns true if s is an operator.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        return s.matches("[(\\+)|(\\-)|(\\*)|(\\/)]");
    }

    /**
     * Returns true if s is an integer.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * We accept two types of integers:
     *
     * - the first type consists of an optional '-'
     *   followed by a non-zero digit
     *   followed by zero or more digits,
     *
     * - the second type consists of an optional '-'
     *   followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        return s.matches("(\\-)?[1-9](\\d*)|(\\-)?0");
    }
}
