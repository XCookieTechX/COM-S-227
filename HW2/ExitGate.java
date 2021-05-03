package hw2;

/**
 * Simulates the amount of cars that exit
 * @author Chris
 * @version 1.0
 */
public class ExitGate {
    public TimeClock time;
    private int exitCount;

    /**
     * Creates time with the given time
     * @param givenClock time when it was made
     */
    public ExitGate(TimeClock givenClock){
        this.time = givenClock;

    }

    /**
     * Checks to see if the card that is inserted is within the time limit and if so, adds to the exit count
     * @param c the parking card
     * @return if the time limit was within the time, it returns true, if not, returns false
     */
    public boolean insertCard(ParkingCard c){
        if ((c.getPaymentTime() <= RateUtil.EXIT_TIME_LIMIT) && (c.getPaymentTime() >= 0)){
            exitCount ++;
            return true;
        }else{
            return false;
        }
    }

    /**
     * gets the total exit count
     * @return the exit count
     */
    public int getExitCount(){
        return exitCount;
    }

}
