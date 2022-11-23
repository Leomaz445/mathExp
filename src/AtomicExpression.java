/**
 * This class is representing an Atomic expression - that is a number.
 */
public class AtomicExpression extends Expression {
    private double realNumber;

    /**
     * The constructor that initialize the real number,we're using the super function just to show that this is
     * a child class.
     *
     * @param realNumber - the number we want to initialize.
     */
    public AtomicExpression(double realNumber) {
        super();
        this.realNumber = realNumber;
    }

    //Getting the realNumber
    public double getRealNumber() {
        return realNumber;
    }

    //Returning the realNumber
    @Override
    public double calculate() {
        return realNumber;
    }

    //return the string of the real Number
    @Override
    public String toString() {
        return String.valueOf(realNumber);
    }
}
