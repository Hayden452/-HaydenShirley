// Price prediction function

// Takes a fixed number of data points. The data points entered should be listed from most recent to latest.
//      ex: pricePrediction(Jan5, Jan4, Jan3, Jan2, Jan1...)
// Function call to present price predictions -> PricePrediction
// Function call to present company history
// Function call to present facts about company

import java.util.ArrayList;
///////////////////////////////

public class PricePredictionTester {
    public static void main(String[] args) {
        // Creating the arraylist to pass to the pricePredictor. Adding price points, cna be done with a simple
        // 'for' loop later.
        // The price points must be entered chronologically,
        // with the most recent price being at location inputValues.get(0).
        ArrayList<Double> inputValues = new ArrayList<>();
        ArrayList<Double> outputValues;

        inputValues.add(-999.0);
        inputValues.add(-7.0);
        inputValues.add(-5.0);
        inputValues.add(11.0);
        inputValues.add(12.0);
        inputValues.add(13.0);
        inputValues.add(14.0);
        inputValues.add(15.0);
        inputValues.add(16.0);
        inputValues.add(17.0);

        // Output:
        outputValues = presentPricePrediction(inputValues);
        System.out.println(outputValues);
        System.out.println("Assuming Market Equilibrium: " + (outputValues.get(0).toString()));
        System.out.println("Assuming Linear Movement: " + (outputValues.get(1).toString()));
        // System.out.println("Assuming Linear Movement progressing towards Market Equilibrium: " + (outputValues.get(2).toString()));
    } // main

    private static ArrayList<Double> presentPricePrediction(ArrayList<Double> inputValues) {
        // Returns: predictedPrices = {predictedMarketEquilibrium, nextLinearPricePoint, combinedPointPrediction}
        ArrayList<Double> predictedPrices = new ArrayList<>();

        // For Market Equilibrium
        double predictedMarketEquilibrium;
        double tempValueHolder = 0.0;
        int numberOfValues = 0;

        // For linear movement
        double nextLinearPricePoint;
        double currentPricePoint;
        double averageMovement;
        double lastPricePoint;
        double tempMovement;
        double numberOfAverages = 0.0;
        double movement = 0.0;

        // Grabs the latest value
        double latestValue = inputValues.get(0);

        //////////////////////////////////////
        // Predicts the basic market equilibrium by grabbing a basic average for all values.

        // Size of all added together
        for (int counter = 0; counter < inputValues.size(); counter++) {
            tempValueHolder = tempValueHolder + inputValues.get(counter);
            numberOfValues = counter + 1;
        } // for

        // Calculating equilibrium
        predictedMarketEquilibrium = (tempValueHolder / numberOfValues);
        predictedPrices.add(predictedMarketEquilibrium);

        //////////////////////////////////////
        // Grabs the average movement within the given price points and adds it to the most recent price point.
        // Linear movement is assumed in this prediction.

        // Determining movement
        for (int counter = 1; counter < inputValues.size(); counter++) {
            lastPricePoint = inputValues.get(counter - 1);
            currentPricePoint = inputValues.get(counter);

            if (currentPricePoint < lastPricePoint) {
                tempMovement = (lastPricePoint - currentPricePoint);
                movement = movement + tempMovement;
            } else {
                tempMovement = (currentPricePoint - lastPricePoint);
                movement = movement - tempMovement;
            } // if
            numberOfAverages = counter;
        } // for

        // Calculating average movement
        averageMovement = movement / numberOfAverages;
        nextLinearPricePoint = averageMovement + latestValue;
        predictedPrices.add(nextLinearPricePoint);

        // Combining the previous predictions to make a more informed decision
        // Saying that the current linear progression is 1000 times our current number of data points of the way there, so
        // 1000 price points in the future we will be at market equilibrium.
        // past price points -> how we get to -> predicted price point 1000x in the future
        // Assuming that 1000x the input size is the eventual market equilibrium.

        // Returning
        return(predictedPrices);
    } // presentPricePrediction
    private static String presentCompanyHistory(String companyName) {
        return
    } // PresentCompanyHistory
} // PricePredictionTester

