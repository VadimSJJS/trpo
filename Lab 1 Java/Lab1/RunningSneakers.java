package Lab1;

public class RunningSneakers extends Sneakers
{
	public static int RunningCountProducer = 0;
	public RunningSneakers(String name, int cost, String type, Producer producer)
	{
		super(name, cost, type, producer);
		RunningCountProducer++;
	}

	/**
	 * возращает количество беговых кроссовок
	 * @return - возращает количество беговых кроссовок
	 */
	public final int GetRunningCountProducer()
	{
		return RunningCountProducer;
	}
}
