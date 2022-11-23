/**
 * Abstract class that inherits from the abstract class Expression
 * this class is representing the compound expression.
 */
public abstract class CompoundExpression extends Expression {
    protected Expression leftOperator;
    protected Expression rightOperator;

    /**
     * Constructor
     *
     * @param leftOperator  - left operator
     * @param rightOperator - right operator
     */
    public CompoundExpression(Expression leftOperator, Expression rightOperator) {
        super();
        if (leftOperator instanceof AtomicExpression) {
            this.leftOperator = new AtomicExpression(((AtomicExpression) leftOperator).getRealNumber());
        } else {
            this.leftOperator = leftOperator;
        }

        if (rightOperator instanceof AtomicExpression) {
            this.rightOperator = new AtomicExpression(((AtomicExpression) rightOperator).getRealNumber());
        } else {
            this.rightOperator = rightOperator;
        }
    }

    // abstract method
    public abstract String toString();
}
