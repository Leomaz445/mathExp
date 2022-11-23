import java.util.ArrayList;
import java.util.Random;

/**
 * The Driver Class - Here we:
 * 1.Generate The Expressions.
 * 2.Printing all the Expressions.
 * 3.Printing only equal expressions and counting them.
 */
public class Main {
    private final static int NUMBER_OF_EXPRESSIONS = 100;
    private final static int RANDOM_UPPER_BOUND = 10;
    private final static int MAX_ARGUMENT_BOUND = 10;

    //Main method
    public static void main(String[] args) {
        ArrayList<Expression> expressions = new ArrayList();
        generateRandomExpressions(expressions);
        printAllExpressions(expressions);
        printOnlyEqualExpressions(expressions);
    }

    /**
     * Generate the Expressions,we can control the number of expressions
     * and the number of argument in the expression.
     *
     * @param expressions - Expressions that we're building
     */
    private static void generateRandomExpressions(ArrayList<Expression> expressions) {
        Random rand = new Random();
        int randomNumber;
        for (int i = 0; i < NUMBER_OF_EXPRESSIONS; i++) {
            randomNumber = rand.nextInt(RANDOM_UPPER_BOUND) + 1;
            Expression leftOperator = new AtomicExpression(randomNumber);
            int numberOfArguments = rand.nextInt(MAX_ARGUMENT_BOUND) + 1;
            for (int j = 0; j < numberOfArguments; j++) {
                randomNumber = rand.nextInt(RANDOM_UPPER_BOUND) + 1;
                Expression rightOperator = new AtomicExpression(randomNumber);
                if (rand.nextBoolean()) {
                    leftOperator = new AdditionExpression(leftOperator, rightOperator);
                } else {
                    leftOperator = new SubtractionExpression(leftOperator, rightOperator);
                }
            }
            expressions.add(leftOperator);
        }
    }

    /**
     * Printing the expressions, were implementing the toString method we OverRide.
     *
     * @param expressions - the expression we want to print
     */
    private static void printAllExpressions(ArrayList<Expression> expressions) {
        System.out.println("-------------Begin Parenting Expressions----------------------");
        for (int i = 0; i < NUMBER_OF_EXPRESSIONS; i++) {
            System.out.println("(" + (i + 1) + ") " + expressions.get(i) + " = " + expressions.get(i).calculate());
        }
        System.out.println("-------------Finish Parenting Expressions----------------------" + '\n');
    }

    /**
     * Travel through expressions list and looking for equal expressions,for each equal:
     * 1.We print the equal expressions.
     * 2.Printing the value of the expressions.
     * 3.Printing the number of the expressions.
     *
     * @param expressions - the expressions we travel through.
     */
    private static void printOnlyEqualExpressions(ArrayList<Expression> expressions) {
        int counterEqualExpressions = 0;
        System.out.println("-------------Begin Printing Equal Expression Only----------------------");
        for (int i = 0; i < NUMBER_OF_EXPRESSIONS; i++) {
            for (int j = i; j < NUMBER_OF_EXPRESSIONS; j++) {
                if (expressions.get(i).equals(expressions.get(j)) && (i != j)) {
                    counterEqualExpressions++;
                    System.out.println("(" + counterEqualExpressions + ") Expression " + (i + 1) + " and Expression " + (j + 1) + " are Equal");
                    System.out.println("Expression " + (i + 1) + " is: " + expressions.get(i));
                    System.out.println("Expression " + (j + 1) + " is: " + expressions.get(j));
                    System.out.println("They have the value of : " + expressions.get(i).calculate() + '\n');
                }
            }
        }
        if (counterEqualExpressions == 0) {
            System.out.println("Sorry but we didn't find any Equal Expressions");
        } else {
            System.out.println("Total number of equal expressions is: " + counterEqualExpressions);
        }
        System.out.println("-------------Finish Printing Equal Expression Only----------------------" + '\n');
        System.out.println("--------------------------THANK YOU-------------------------------------");
        System.out.println("---------------------------GOOD BYE-------------------------------------");
    }

}

