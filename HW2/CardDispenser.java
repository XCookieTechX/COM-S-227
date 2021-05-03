package hw2;


/**
 * Simulates a new card and sets a given clock
 * @author Chris
 * @version 1.0
 */
public class CardDispenser {
    public TimeClock time;

    /**
     * Sets a clock based on the card
     * @param givenClock the time it was made
     */
    public CardDispenser(TimeClock givenClock) {
        this.time = givenClock;


    }

    /**
     * Simulates a new card
     * @return a new card
     */
    public ParkingCard takeCard(){
       ParkingCard card = new ParkingCard(this.time.getTime());

        return card;
    }

}
