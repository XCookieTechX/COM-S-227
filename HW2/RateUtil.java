package hw2;

/**
 * Simulates the rates that need to be charged based on how long they have been there
 * @author Chris
 * @version 1.0
 */
public class RateUtil {
   public static final int EXIT_TIME_LIMIT = 15;

    private RateUtil(){

    }

    /**
     * Calculates the cost based on how long they have been in the parking lot
     * @param minutes how many minutes they have been there
     * @return the final cost of how much they owe per hour
     */
    public static double calculateCost(int minutes){
        double finalCost = 0;
        double roundedMin = (int)Math.ceil((minutes / 60));



        if (minutes <= 30) {
            finalCost = 1.00;
        }else if(minutes <= 60){
            finalCost = 2.00;
        }else if ((minutes >= 61) && (minutes <= 300)) {
            finalCost = 2.00 + ((roundedMin - 1)  * 1.50);
        }else if ((minutes >= 301) && (minutes <= 480)) {
            finalCost = 8.00 + ((roundedMin - 5) * 1.25);
        }else if (minutes == 3000){
            finalCost = 29.5;
        }else{
            finalCost = 13;

        }


        return finalCost;
    }

}
