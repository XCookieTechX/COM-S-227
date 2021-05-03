package lab3;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import balloon.Balloon;


public class BalloonTests {
	public class BaloonTests {
	    // margin of error for floating-point comparisons
//	    private static final double EPSILON = 10e-07;
	    
//	    @Test
//	    public void testInitial()
//	    {
//	      balloon.Balloon b = new Balloon(5);
//	      assertEquals(false, b.isDribbleable());
//	    }

	    @Test
	    public void testInitialRadius()
	    {
	      Baloon b = new Baloon(5);
	      assertEquals(5.0, b.getRadius());
	    }

	    @Test
	    public void testInflate()
	    {
	      Basketball b = new Basketball(5);
	      b.inflate();
	      assertEquals(true, b.isDribbleable());
	    }

	    @Test
	    public void testDiameterAfterInflation()
	    {
	      Basketball b = new Basketball(5);
	      b.inflate();
	      assertEquals(5.0, b.getDiameter(), EPSILON);
	    }

	}
}
