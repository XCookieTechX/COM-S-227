package hw2;

/**
 *
 *  Paystation class acts as a paystation for the card to get inserted and checks to make sure there is a card in the machine
 * @author Chris
 * @version 1.0
 */
public class PayStation {
    private TimeClock time;
    private ParkingCard card;
    private boolean isInsert;
    private double totalPayment = 0;

    /**
     * The paystation method sets the time to the given clock
     * @param givenClock gets the time of the card
     */
    public PayStation (TimeClock givenClock){
        this.time = givenClock;
    }

    /**
     * The insertCard method simulates the card getting inserted into the machine
     * @param t is the card that gets passed through
     */
    public void insertCard (ParkingCard t){
        this.card = t;
        isInsert = true;

    }

    /**
     *The getCurrentCard method returns the card if there is a card inserted, if not, it returns null
     * @return returns the card info if there is a card inserted in the machine
     */
    public ParkingCard getCurrentCard(){
        if (inProgress() == true){
            return card;
        }else{
            return null;
        }
    }

    /**
     * The inProgress method checks to see if there is a card in the machine and returns if there is one or not
     *
     * @return returns true if there is a card inserted, if not, returns false
     */
    public boolean inProgress(){
       if (isInsert == true){
           return true;
       }else{
           return false;
       }

    }

    /**
     * gets the payment that is due and returns the value of what the cost will be
     * @return the cost of parking from the time they arrived and when they made their payment
     */
    public double getPaymentDue(){
        if (inProgress() == true) {
            if ((this.time.getTime() - card.getPaymentTime() > 0) && (card.getPaymentTime() != 0)){
                return (RateUtil.calculateCost(time.getTime() - card.getStartTime()));

            }else{
                return RateUtil.calculateCost(time.getTime() - card.getStartTime());
            }
        }else{
            return 0.0;
        }
    }

    /**
     * Simulates the payment of the card if there is a card inserted
     */
    public void makePayment(){
        if (inProgress() == true){

            totalPayment += getPaymentDue();
            card.setPaymentTime(time.getTime());

        }


    }

    /**
     * simulates the card ejecting if there is a card already in there, if not, it does nothing. Makes room for a new card and erases the old card
     */
    public void ejectCard(){
        if (inProgress() == true){
            card = null;
            isInsert = false;
        }

    }

    /**
     * Returns the total payment amount
     * @return the total amount of money that needs to be payed
     */
    public double getTotalPayments(){
        return totalPayment;
    }
}
