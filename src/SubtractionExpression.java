/**
 * This class is handling the subtraction expression - the minus (-) operator.
 * We implement the CompoundExpression abstract class methods.
 */
public class SubtractionExpression extends CompoundExpression {

    /**
     * Builder of the atomic expression,we use super to use the CompoundExpression constructor.
     *
     * @param leftOperator  - the left expression.
     * @param rightOperator - the right expression.
     */
    public SubtractionExpression(Expression leftOperator, Expression rightOperator) {
        super(leftOperator, rightOperator);
    }

    /**
     * Calculate the result of left operator minus the right operator.
     *
     * @return the result of the calculation.
     */
    @Override
    public double calculate() {
        return leftOperator.calculate() - rightOperator.calculate();
    }

    /**
     * Building the string to represent two operators and the minus operand.
     * in this class the  casting is redundant because the CompoundExpression and the AtomicExpression
     * are the children of Expression, and we do Up-Casting.
     *
     * @return expression that is using two operators and the minus operand.
     */
    @Override
    public String toString() {
        String leftOperatorStringValue;
        String rightOperatorStringValue;
        if (leftOperator instanceof CompoundExpression) {
            leftOperatorStringValue = ((CompoundExpression) leftOperator).toString();
        } else {
            leftOperatorStringValue = ((AtomicExpression) leftOperator).toString();
        }
        if (rightOperator instanceof CompoundExpression) {
            rightOperatorStringValue = ((CompoundExpression) rightOperator).toString();
        } else {
            rightOperatorStringValue = ((AtomicExpression) rightOperator).toString();
        }
        return "(" + leftOperatorStringValue + " - " + rightOperatorStringValue + ")";
    }
}