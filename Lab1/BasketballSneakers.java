package lab1;

public class BasketballSneakers extends Sneakers
{
	public static int BasketballCountProducer = 0;
	public BasketballSneakers(String name, int cost, String type, Producer producer)
	{
		super(name, cost, type, producer);
		BasketballCountProducer++;
	}

	public final int GetBasketballCountProducer()
	{
		return BasketballCountProducer;
	}
}
