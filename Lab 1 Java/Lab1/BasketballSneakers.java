package Lab1;

public class BasketballSneakers extends Sneakers
{
	public static int BasketballCountProducer = 0;
	public BasketballSneakers(String name, int cost, String type, Producer producer)
	{
		super(name, cost, type, producer);
		BasketballCountProducer++;
	}

	/**
	 * возращает количество баскетбольных кроссовок
	 * @return - возращает количество баскетбольных кроссовок
	 */
	public final int GetBasketballCountProducer()
	{
		return BasketballCountProducer;
	}
}
