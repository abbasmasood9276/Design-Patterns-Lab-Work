import java.util.Arrays;
import java.util.Random;

public class Regression {
    private static final int INTERCEPT_INDEX = 0;
    private static final int SLOPE_INDEX = 1;

    private double learningRate;
    private int numIterations;
    private double[] coefficients;
    private double[] inputValues;
    private double[] outputValues;

    public Regression(double learningRate, int numIterations) {
        this.learningRate = learningRate;
        this.numIterations = numIterations;
        this.coefficients = new double[2]; 
    }

    public void train(double[] inputValues, double[] outputValues) {
        this.inputValues = inputValues;
        this.outputValues = outputValues;

        for (int iteration = 0; iteration < numIterations; iteration++) {
            double[] predictions = calculatePredictions(inputValues);
            double[] errors = calculateErrors(predictions, outputValues);
            updateCoefficients(errors);
        }
    }

    public double[] calculatePredictions(double[] inputValues) {
        double[] predictions = new double[inputValues.length];

        for (int i = 0; i < inputValues.length; i++) {
            predictions[i] = coefficients[INTERCEPT_INDEX] + coefficients[SLOPE_INDEX] * inputValues[i];
        }

        return predictions;
    }

    private double[] calculateErrors(double[] predictions, double[] outputValues) {
        double[] errors = new double[predictions.length];

        for (int i = 0; i < predictions.length; i++) {
            errors[i] = predictions[i] - outputValues[i];
        }

        return errors;
    }

    private void updateCoefficients(double[] errors) {
        int m = inputValues.length;
        double sumErrors = Arrays.stream(errors).sum();

        coefficients[INTERCEPT_INDEX] -= learningRate * sumErrors / m;

        for (int i = 0; i < m; i++) {
            coefficients[SLOPE_INDEX] -= learningRate * errors[i] * inputValues[i] / m;
        }
    }

    public double calculateCost(double[] inputValues, double[] outputValues) {
        int m = inputValues.length;
        double sum = 0;

        for (int i = 0; i < m; i++) {
            double prediction = coefficients[INTERCEPT_INDEX] + coefficients[SLOPE_INDEX] * inputValues[i];
            double error = prediction - outputValues[i];
            sum += Math.pow(error, 2);
        }

        return sum / (2 * m);
    }

    public void drawCostFunction(double[] inputValues, double[] outputValues) {
       
    }

    public static void main(String[] args) {
        double[] inputValues = new double[50];
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            inputValues[i] = random.nextDouble();
        }

        double[] outputValues = new double[50];

        for (int i = 0; i < 50; i++) {
            outputValues[i] = 3 + 2 * inputValues[i] + random.nextDouble() * 0.1;
        }

        int numThetas = 2; 
        int numHypotheses = 5;
        Regression[] regressions = new Regression[numHypotheses];

        for (int i = 0; i < numHypotheses; i++) {
            double[] initialThetas = new double[numThetas];

            // Initialize random theta values
            for (int j = 0; j < numThetas; j++) {
                initialThetas[j] = random.nextDouble();
            }

            regressions[i] = new Regression(0.01, 1000);
            regressions[i].coefficients = initialThetas; 
            regressions[i].train(inputValues, outputValues);

            double cost = regressions[i].calculateCost(inputValues, outputValues);
            System.out.println("Hypothesis " + (i + 1) + " Thetas: " + Arrays.toString(regressions[i].coefficients));
            System.out.println("Cost for hypothesis " + (i + 1) + ": " + cost);
            regressions[i].drawCostFunction(inputValues, outputValues);
        }

        int bestHypothesisIndex = findBestHypothesis(regressions, inputValues, outputValues);
        System.out.println("Best hypothesis has index: " + bestHypothesisIndex);
        System.out.println("Best hypothesis coefficients: " + Arrays.toString(regressions[bestHypothesisIndex].coefficients));
    }

    private static int findBestHypothesis(Regression[] regressions, double[] inputValues, double[] outputValues) {
        double minCost = Double.MAX_VALUE;
        int bestHypothesisIndex = -1;

        for (int i = 0; i < regressions.length; i++) {
            double cost = regressions[i].calculateCost(inputValues, outputValues);

            if (cost < minCost) {
                minCost = cost;
                bestHypothesisIndex = i;
            }
        }

        return bestHypothesisIndex;
    }
}
