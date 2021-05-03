package hw1;

/**
 * The backpacker class has the private variables and the sympathy factor which is used when the backpacker calls home
 * @author Chris
 * @version 1.0
 */
public class Backpacker {
    public static final int SYMPATHY_FACTOR = 30;
    private int funds;
    private Location locationName;
    private String journal;
    private int postCardsSent;
    private int trainNights;

    /**
     * The constructor method Backpacker creates a backpacker object that creates the initial funds that the backpacker is going to use and the initial location that the backpacker is going to start in
     * @param initialFunds The amount of funds the backpacker is going to start out with
     * @param initialLocation The location which the backpacker is going to start in
     */
    public Backpacker(int initialFunds, Location initialLocation){
        funds = initialFunds;
        locationName = initialLocation;
        journal = initialLocation.getName() + "(start)";

    }

    /**
     * The method getCurrentLocaiton gets the backpackers current location
     * @return The backpackers current location
     */
    public String getCurrentLocation(){

        return locationName.getName();
    }

    /**
     * The method getcurrentFunds gets the current amount of funds the backpacker has
     * @return The amount of funds he currently has
     */
    public int getCurrentFunds(){
        return funds;
    }

    /**
     * The method getJournal gets the current journal of the backpacker
     * @return The journal of the backpacker
     */
    public String getJournal(){

        return journal;
    }

    /**
     * The method isSOL gets true or false depending on if he has enough funds
     * @return True or false depending if the backpacker has enough funds
     */
    public boolean isSOL(){

       return getCurrentFunds() < locationName.costToSendPostcard();
    }

    /**
     * The method getTotalNightsInTrainStation gets the amount of nights the backpacker spent in the train station
     * @return The amount of nights the backpacker spent in the train station
     */
    public int getTotalNightsInTrainStation(){
        return trainNights;
    }

    /**
     * The method visit simulates a visit by this backpacker to the given location for the given number of nights. The backpacker's funds are reduced based on the number of nights of lodging purchased. When the funds are not sufficient for numNights nights of lodging in the location, the number of nights spent in the train station is updated accordingly. The journal is updated by appending a comma, the location name, and the number of nights in parentheses.
     * @param c The location that the backpacker is currently at, simulates a new location
     * @param numNights The amount of nights that the backpacker is wanting to stay
     */
    public void visit(Location c, int numNights){

        this.locationName = c;

        trainNights += Math.max((numNights - locationName.maxLengthOfStay(funds)), 0);
        funds -= Math.min(locationName.maxLengthOfStay(funds), numNights ) * locationName.lodgingCost();

        this.journal = this.journal + "," + locationName.getName() + "(" + numNights + ")";

    }

    /**
     * The method sendPostCardsHome removes the amount of funds based on how many postcards he can send with either the amount of funds he has or how many postcards he wants to send
     * @param howMany The amount of postcards the backpacker is wanting to send
     */
    public void sendPostcardsHome(int howMany){

        postCardsSent += Math.min(locationName.maxNumberOfPostcards(funds), howMany);

      
        funds -= Math.min(locationName.maxNumberOfPostcards(funds), howMany) * locationName.costToSendPostcard();
        

    }

    /**
     * The method callHomeForMoney increases the funds based on the amount of postcards sent. It also resets the amount of postcards sent to 0.
     */
    public void callHomeForMoney(){

        this.funds = this.funds + (SYMPATHY_FACTOR * postCardsSent);
        postCardsSent = 0;
    }



}
