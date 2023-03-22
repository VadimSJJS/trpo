package lab1;

public class FootbalSneakers extends Sneakers
{
	public static int FootbalCountProducer = 0;
	public FootbalSneakers(String name, int cost, String type, Producer producer)
	{
		super(name, cost, type, producer);
		FootbalCountProducer++;
	}

	public final int GetFootballCountProducer()
	{
		return FootbalCountProducer;
	}
}
