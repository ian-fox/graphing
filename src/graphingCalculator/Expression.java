package graphingCalculator;

class Expression {
    Expression left;
    Expression right;
    boolean isStatic = false;
    double val;
    boolean error = false;
    String op = "";
    
    // Constructors
    public Expression() {} // Default to x
    
    public Expression(double i) {
        isStatic = true;
        val = i;
    }
    
    public Expression(Expression leftArg, String opArg, Expression rightArg) {
        left = leftArg;
        right = rightArg;
        op = opArg;
    }
    
    public Expression(String opArg, Expression arg) {
        left = arg;
        op = opArg;
    }
        
    public double eval(double x) {
        switch(op) {
        case "": return isStatic ? val : x;
        case "+": return left.eval(x) + right.eval(x);
        case "-": return left.eval(x) - right.eval(x);
        case "/": return left.eval(x) / right.eval(x);
        case "*": return left.eval(x) * right.eval(x);
        case "^": return Math.pow(left.eval(x), right.eval(x));
        case "sin": return Math.sin(left.eval(x));
        case "cos": return Math.cos(left.eval(x));
        case "tan": return Math.tan(left.eval(x));
        case "ln": return Math.log(left.eval(x));
        case "log": return Math.log(left.eval(x)) / Math.log(right.eval(x));
        }
        return Double.NaN;
    }
}
