package lab2;
import java.util.Random;
/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel5
{
	private int rabitPop;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel5()
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
	  Random rand = new Random();
	  rabitPop = rabitPop + rand.nextInt(10);
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
