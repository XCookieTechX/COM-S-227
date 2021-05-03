package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel3
{
	private int rabitPop;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel3()
  {
    rabitPop = 0;
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
    rabitPop = (rabitPop + 1) % 5;
 
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    rabitPop = 0;
  }
}
