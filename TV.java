
package hw1;

/**
 * Simulates a TV with different functions like a regular TV would have like volume and channel
 * @author Christopher Brown
 */
public class TV {
    /**
     * the VOLUME_INCREMENT variable stores the constant increment when the volume is turned up or down
     * the currentVolume variable stores the current volume the TV is at
     * the currentChannel variable stores the current channel the tv is at
     * the lowestChannel variable stores the lowest channel the TV can be turned to
     * the highestChannel variable stores the highest channel the TV can be turned to
     * the previousChannel variable stores the previous channel the TV was at
     * the numChannels variable stores how many channels the TV currently has
     */
    public static final double VOLUME_INCREMENT = 0.07;

    private double currentVolume;
    private int currentChannel;
    private int lowestChannel;
    private int highestChannel;
    private int previousChannel;
    private int numChannels;

    /**
     * Constructor that constructs a new tv with channels starting at givenStart and with a number of channels
     * @param givenStart the start/lowest channel that the TV starts with
     * @param givenNumChannels the number of channels that the TV starts with
     */
    public TV(int givenStart, int givenNumChannels){
        lowestChannel = givenStart;
        highestChannel = givenStart + givenNumChannels - 1;
        currentChannel = givenStart;
        previousChannel = 2;
        currentVolume = 0.5;
        numChannels = givenNumChannels;

    }

    /**
     * Changes the channel down by 1, if the current channel is the lowest, it "wraps" around to the highest channel
     */
    public void channelDown(){
        previousChannel = currentChannel;
        if (currentChannel - 1 >= lowestChannel){
            currentChannel -= 1;
        }else{
            currentChannel = highestChannel;
        }
    }

    /**
     * Changes the channel up by 1, if the current channel is the highest channel, it "wraps" around to the lowest channel
     */
    public void channelUp(){
        previousChannel = currentChannel;
        if (currentChannel + 1 <= highestChannel){
            currentChannel += 1;
        }else{
            currentChannel = lowestChannel;
        }
    }

    /**
     * Returns a string representing the current channel and volume
     * @return Returns the string representing what volume and channel the TV is on
     */
    public String display(){
        double roundedVol;
        roundedVol = Math.round(currentVolume * 100);

        return "Channel " + currentChannel + " Volume " + (int)roundedVol + "%";
    }

    /**
     * Accessor class that returns the current channel
     * @return returns the current channel of the TV
     */
    public int getChannel(){

        return currentChannel;
    }

    /**
     * Accessor class that returns the current volume
     * @return returns the current volume of the TV
     */
    public double getVolume(){

        return currentVolume;
    }

    /**
     * Sets the current channel to the most recent previous channel
     */
    public void goToPreviousChannel(){
        int previousChannel2;
        previousChannel2 = currentChannel;
        currentChannel = previousChannel;
        previousChannel = previousChannel2;

    }

    /**
     * Resets the TV so that its available channels are now from the new givenStart
     * @param givenStart the new start/lowest channel to the TV
     */
    public void resetStart(int givenStart){
    	lowestChannel = givenStart;
    	highestChannel = givenStart + numChannels - 1;
    	if (currentChannel < lowestChannel){
    	    currentChannel = lowestChannel;
        }
    	if (previousChannel < lowestChannel){
    	    previousChannel = lowestChannel;
        }
        if (currentChannel > highestChannel){
            currentChannel = highestChannel;
        }
        if(previousChannel > highestChannel){
            previousChannel = highestChannel;
        }
        
    }

    /**
     * Resets this TV so taht its avalible channels are now from start through the new given channels
     * @param givenNumChannels the new amount of given channels for the TV
     */
    public void resetNumChannels(int givenNumChannels){
        highestChannel = lowestChannel + givenNumChannels - 1;
        if (currentChannel > highestChannel){
            currentChannel = highestChannel;
        }
        if(previousChannel > highestChannel){
            previousChannel = highestChannel;
        }
        if (currentChannel < lowestChannel){
            currentChannel = lowestChannel;
        }
        if (previousChannel < lowestChannel){
            previousChannel = lowestChannel;
        }


    }

    /**
     * Sets the channel to the given channel number
     * @param channelNumber the channel number that the user wants to turn the TV to
     */
    public void setChannel(int channelNumber){
    	previousChannel = currentChannel;
    	if((channelNumber <= highestChannel) && (channelNumber >= lowestChannel)){
            currentChannel = channelNumber;
        }else if(channelNumber > highestChannel){
            currentChannel = highestChannel;
        }else{
            currentChannel = lowestChannel;
        }

    }

    /**
     * Lowers the volume by VOLUME_INCREMENT but not below 0.0
     */
    public void volumeDown(){
        if (currentVolume - VOLUME_INCREMENT >= 0.0){
            currentVolume -= VOLUME_INCREMENT;
        }else{
            currentVolume = 0.0;
        }
    }

    /**
     * Raises the volume by VOLUME_INCREMENT but not above 1.0
     */
    public void volumeUp(){
        if(currentVolume + VOLUME_INCREMENT <= 1.0){
            currentVolume += VOLUME_INCREMENT;
        }else{
            currentVolume = 1.0;
        }
    }
}
