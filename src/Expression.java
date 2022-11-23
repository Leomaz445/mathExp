/**
 * This is abstract class that represent Expression.
 */
public abstract class Expression {

    //abstract method to calculate/
    public abstract double calculate();

    /**
     * Checking if the expression are equal
     *
     * @param obj - The expression we want to compare to.
     * @return True if the expression are equal or false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Expression)) {
            return false;
        }
        return this.calculate() == ((Expression) obj).calculate();
    }
}
