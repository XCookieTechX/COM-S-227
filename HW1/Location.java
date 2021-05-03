package hw1;
/**
 * The class Location has the name of the location and the lodging cost for that location
 * 
 * @author Chris Brown
 * @version 1.0
 */
public class Location {
	public static final double RELATIVE_COST_OF_POSTCARD= 0.05;
	private String locationName;
	private int lodgingCost;

	/**
	 * The constructor Location creates the location object and the location name and the lodging cost
	 * @param givenName
	 * @param givenLodgingCost
	 */
	
	public Location(String givenName, int givenLodgingCost) {
		locationName = givenName;
		this.lodgingCost = givenLodgingCost;
		
		
	}

	/**
	 * The method getName() gets the current location
	 * @return The current location
	 */
	public String getName() {
		return locationName;
	}

	/**
	 * The method lodgingCost gets the amount of money it will cost to stay at the current location
 	 * @return The cost of staying at the current location
	 */
	public int lodgingCost() {
		return this.lodgingCost;
	}

	/**
	 * The method costTtoSendPostcard gets the cost to send a postcard from the current location
 	 * @return The amount of money it will cost to send a postcard from the current location
	 */
	public int costToSendPostcard() {

		return (int) Math.round((double)lodgingCost * (double)RELATIVE_COST_OF_POSTCARD);
	}

	/**
	 * The method maxLengthOfStay generates the maximum number of nights that the backpacker can stay with the amount of funds he currently has
	 *
	 * @param funds The amount of funds that the backpacker currently has
	 * @return The maximum number of nights the backpacker can stay with the amount of funds he has
	 */
	public int maxLengthOfStay(int funds) {
		return funds / lodgingCost();

	}

	/**
	 * The method maxNumberOfPostcards gets the maximum number of postcards the backpacker can get with the amount of funds he currently has
	 * @param funds The amount of funds that the backpacker currently has
	 * @return The maximum number of postcards the backpacker can send with the amount of funds he has
	 */
	public int maxNumberOfPostcards(int funds) {
		return funds / costToSendPostcard();
	}
	
	
}

