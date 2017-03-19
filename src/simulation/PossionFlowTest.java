package simulation;

import static org.junit.Assert.*;

import java.lang.invoke.LambdaConversionException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PossionFlowTest {

	PossionFlow pf;
	@Before
	public void setUp() throws Exception {
		pf = new PossionFlow();
	}

	@After
	public void tearDown() throws Exception {
		pf = null;
	}

	@Test
	public void test() {
		
		double lambda = 2.0;
		double thres = 0.5;
		pf.setLambda(lambda);
		assertEquals(lambda, pf.getLambda(), 1e-6);
		assertEquals(pf.cdf(thres), 1-Math.exp(-lambda * thres),1e-6);
		
		double count = 0;
		
		int testCase = 1000;
		for(int i = 0;i<testCase;i++)
			if(pf.nextDouble()<thres)
				count++;
		count = count / testCase;
		assertEquals(pf.cdf(thres), count, 0.05);
		
	}

}
