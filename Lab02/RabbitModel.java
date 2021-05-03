package lab2;
/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel
{
	private int rabitPop;
	private  int lastYear;
	private  int yearBefore;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
  {
    rabitPop = 1;
    lastYear = 1;
	yearBefore = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
   
	  return rabitPop;
	  
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  yearBefore = lastYear;
	  lastYear = rabitPop;
	  rabitPop = yearBefore + lastYear;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	    rabitPop = 1;
	    lastYear = 1;
		yearBefore = 0;
  }
}
