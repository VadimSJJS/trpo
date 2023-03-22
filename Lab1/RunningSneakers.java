package lab1;

public class RunningSneakers extends Sneakers
{
	public static int RunningCountProducer = 0;
	public RunningSneakers(String name, int cost, String type, Producer producer)
	{
		super(name, cost, type, producer);
		RunningCountProducer++;
	}

	public final int GetRunningCountProducer()
	{
		return RunningCountProducer;
	}
}
