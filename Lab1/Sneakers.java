package lab1;

public class Sneakers
{
	public String Name;
	public int Cost;
	public String Type;
	public Producer producer;

	public Sneakers(String name, int cost, String type, Producer producer)
	{
		Name = name;
		Cost = cost;
		Type = type;
		this.producer = producer;
	}
}
