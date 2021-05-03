package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel2
{
	private int rabitPop;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel2()
  {
    rabitPop = 2;
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
    rabitPop = rabitPop + 1;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    rabitPop = 2;
  }
}
