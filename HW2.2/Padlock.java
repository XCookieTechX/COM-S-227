package hw2;

import java.util.Random;

/**
 * Simulates a Padlock that has 3 disks that rotate and simulates features such as, closing it, opening it, setting the positions of the disks, setting random positions of the disks, among other things.
 * @author Christopher Brown
 * @version 1.0
 */
public class Padlock {


    /**
     * The TOOTH variable stores the constant for the width of the tooth on a disk which in this case is represented in degrees and for this is 2
     */
    public static final int TOOTH = 2;
    /**
     * The isOpen variable stores the boolean of whether or not the lock is open
     */
    private boolean isOpen;
    /**
     * The isAligned variable stores the boolean of whether or not all three disks are aligned
     */
    private boolean isAligned;
    /**
     * The n1Pos variable stores the correct position to the first disk to which the padlock needs to open
     */
    private int n1Pos;
    /**
     * The n2Pos variable stores the correct position to the second disk to which the padlock needs to open
     */
    private int n2Pos;
    /**
     * The n3Pos variable stores the correct position to the third disk to which the padlock needs to open
     */
    private int n3Pos;
    /**
     * The n1Offset variable stores the offset for which the first disk is compared to its relative position
     */
    private final int N1OFFSET = -4;
    /**
     * The n2Offset variable stores the offset for which the first disk is compared to its relative position
     */
    private final int N2OFFSET = 2;
    /**
     * The currentN1Pos variable stores the current position for the first disk in the padlock
     */
    private int currentN1Pos;
    /**
     * The currentN2Pos variable stores the current position for the second disk in the padlock
     */
    private int currentN2Pos;
    /**
     * The currentN3 variable stores the current position for the third disk in the padlock
     */
    private int currentN3Pos;

    /**
     * Constructor that constructs a new padlock with the n1, n2, and n3, as the correct combination to unlock and open the padlock for each of the 3 disks respectively
     * @param n1 The correct position for disk one to unlock and open the padlock
     * @param n2 The correct position for disk two to unlock and open the padlock
     * @param n3 The correct position for disk three to unlock and open the padlock
     */
   public Padlock(int n1, int n2, int n3){

       n1Pos = n1;
       n2Pos = n2;
       n3Pos = n3;
       currentN1Pos = 2 * TOOTH;
       currentN2Pos = TOOTH;
       currentN3Pos = 0;
       isOpen = true;
       isAligned = false;


   }

    /**
     * Simulates closing the padlock by changing the variable isOpen to false
     */
   public void close(){
       isOpen = false;
   }

    /**
     * Accessor method that takes the input from the user and returns the position of the disk to which the user entered. If the user entered in a number other than the specified disks, it returns -1
     * @param which Determines which disk to return
     * @return The disk to which the user entered, if it is not part of the three disks, returns -1
     */
   public int getDiscPosition(int which){
        if(which == 1){
            return currentN1Pos;
        }else if(which == 2){
            return currentN2Pos;
        }else if(which == 3) {
            return currentN3Pos;
        }
        return -1;
   }

    /**
     * Checks to see if all the current positions for the disks are aligned (same position) as the correct position and if they are, it returns true, if not, returns false.
     * @return If the current positions are aligned (same position) as the correct position, returns true. Else, returns false
     */
   public boolean isAligned(){

       if((currentN1Pos == normalizeDiskPos(n1Pos + N1OFFSET)) && (currentN2Pos == normalizeDiskPos(n2Pos + N2OFFSET)) && (currentN3Pos == n3Pos)){
           isAligned = true;
       }else{
           isAligned = false;
       }
        return isAligned;
   }

    /**
     * Accessor method to see and return if the padlock is open or not
     * @return Returns true or false whether the padlock is open or closed
     */
   public boolean isOpen(){

       return isOpen;
   }

    /**
     * Mutator method that opens the padlock if all the disks are aligned to the correct position
     */
   public void open(){
	   isOpen = isAligned();

   }

    /**
     * Sets the three disks to random, valid positions
     * @param rand Random instance to use for selecting the three positions
     */
   public void randomizePositions(Random rand){

       setPositions(normalizeDiskPos(rand.nextInt(360)), normalizeDiskPos(rand.nextInt(360)), rand.nextInt(360));
   }

    /**
     * Sets the positions of all three disks to the given angles the user inputs while ensuring the positions are valid
     * @param n1 Position for disk one to which the user wants it to be
     * @param n2 Position for disk two to which the user wants it to be
     * @param n3 Position for disk three to which the user wants it to be
     */
   public void setPositions(int n1, int n2, int n3){

       currentN1Pos = normalizeDiskPos(n1);
       currentN2Pos = normalizeDiskPos(n2);
       currentN3Pos = normalizeDiskPos(n3);

       if((currentN2Pos < currentN3Pos + TOOTH) && (currentN2Pos > currentN3Pos - TOOTH)){
           currentN2Pos = currentN3Pos + TOOTH;
       }

       if((currentN1Pos < currentN2Pos + TOOTH) && (currentN1Pos > currentN2Pos - TOOTH)){
           currentN1Pos = currentN2Pos + TOOTH;
       }


   }

    /**
     * Turns the dial (disk 3) to the given number of degrees, where a positive number represents counter clockwise and a negative number represents a clockwise rotation
     * @param degrees The given degrees the user wants to turn the dial. If it is negative, it simulates turning counter clock wise. If it is positive, it simulates turning the dial clockwise.
     */
   public void turn(int degrees){
       int n1Turn;
	   int n2Turn;

       int currentDiff1 = normalizeDiskPos(currentN1Pos - currentN2Pos);
	   int currentDiff3 = normalizeDiskPos(currentN2Pos - currentN3Pos);

       if (degrees > 0) {
           if ((degrees + TOOTH) > currentDiff3) {
               n2Turn = (degrees + TOOTH) - currentDiff3;
           }else{
               n2Turn = 0;
           }
           if ((n2Turn + TOOTH) > currentDiff1) {
               n1Turn = (n2Turn + TOOTH) - currentDiff1;
           }else{
               n1Turn = 0;
           }
           currentN1Pos = normalizeDiskPos(currentN1Pos + n1Turn);
           currentN2Pos = normalizeDiskPos(currentN2Pos + n2Turn);
           currentN3Pos = normalizeDiskPos(currentN3Pos + degrees);

       }
       else {
           currentDiff1 = 360 - currentDiff1;
           currentDiff3 = 360 - currentDiff3;
           degrees *= -1;

           if ((degrees + TOOTH) > currentDiff3) {
               n2Turn = (degrees + TOOTH) - currentDiff3;
           }else{
               n2Turn = 0;
           }
           if ((n2Turn + TOOTH) > currentDiff1) {
               n1Turn = (n2Turn + TOOTH) - currentDiff1;
           }else{
               n1Turn = 0;
           }

           currentN1Pos = normalizeDiskPos(currentN1Pos - n1Turn);
           currentN2Pos = normalizeDiskPos(currentN2Pos - n2Turn);
           currentN3Pos = normalizeDiskPos(currentN3Pos - degrees);
           
       }
   }

    /**
     * Simulates turning the dial (disk 3) to the left (counter clockwise) to the given amount from the parameter
     * @param number The new dial position that the user wants to turn to
     */
   public void turnLeftTo(int number){
       if (number - currentN3Pos < 0){
           turn((number - currentN3Pos) + 360);
       }else{
           turn(number - currentN3Pos);
       }

   }

    /**
     * Simulates turning the dial (disk 3) to the right (clockwise) to the given amount from the parameter
     * @param number The new dial position that the user wants to turn to
     */
   public void turnRightTo(int number){
       if (currentN3Pos - number < 0){
           turn(((currentN3Pos - number) + 360) * -1);
       }else{
           turn((currentN3Pos - number) * -1);
       }
   }

    /**
     * "normalize" the position of the given disk. Makes it so the position of the disk is between 0 and 360
     * @param position The given position of the disk that is needed to be normalized
     * @return The normalized position of the disk
     */
   private int normalizeDiskPos(int position) {
	   int correctPos = position % 360;

	   if(correctPos < 0) {
		   correctPos += 360;
	   }
	   return correctPos;
   }


}
