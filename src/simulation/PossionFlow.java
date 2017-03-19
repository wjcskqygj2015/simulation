package simulation;

import cern.jet.random.*;
import cern.jet.random.engine.DRand;

public class PossionFlow{

	private double lambda;
	
	public PossionFlow(){ this(1.0);}
	public PossionFlow(double lambda){
		setLambda(lambda);
	}
	public void setLambda(double lambda) {
		this.lambda=lambda;
	}
	public double getLambda() {
		return this.lambda;
	}
	
	public double cdf(double x)
	{
		return (new Exponential(lambda, new DRand())).cdf(x);
	}
	public double pdf(double x)
	{
		return (new Exponential(lambda, new DRand())).pdf(x);
	}
	
	public double nextDouble(){
		return Exponential.staticNextDouble(lambda);
	}
	
	static public void main(String[] args)
	{
		PossionFlow t = new PossionFlow();
		double counting[] = new double[10000];
		for(int i=0;i<10000;i++)
			counting[i] = t.nextDouble();
		int count=0;
		for(int i=0;i<10000;i++)
			if(counting[i]<=2)
				count++;
		System.out.println(count/10000.0);
		System.out.println(1-Math.exp(-2));
	}
}
