package lab3;

public class Basketball {
	public boolean isInflated;
	public double diameter;
	public Basketball(double givenDiameter)
	  {
		isInflated = false;
		diameter = givenDiameter;
		
	  }

	  public boolean isDribbleable()
	  {
	    return isInflated;
	  }

	  public double getDiameter()
	  {
	    return diameter;
	  }

	  public double getCircumference()
	  {
	    return Math.PI * diameter;
	  }

	  public void inflate()
	  {
		  isInflated = true;
	  }
}
