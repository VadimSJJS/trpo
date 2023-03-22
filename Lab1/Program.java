package lab1;

import java.util.*;

public class Program
{
	public static void main(String[] args)
	{

		// Создание объектов
		BasketballSneakers basketballSneakers1 = new BasketballSneakers("Nike Kobe A.D. Mid", 150, "Бескетбольные", new Producer("Nike", "Вьетнам"));
		BasketballSneakers basketballSneakers2 = new BasketballSneakers("Nike Hyperdunk 2017", 75, "Бескетбольные", new Producer("Nike", "Вьетнам"));
		BasketballSneakers basketballSneakers3 = new BasketballSneakers("Adidas Crazy Explosive 2017", 270, "Бескетбольные", new Producer("Adidas", "США"));
		FootbalSneakers footbalSneakers1 = new FootbalSneakers("Firm Ground boots (FG)", 200, "Футбольные", new Producer("Adidas", "США"));
		FootbalSneakers footbalSneakers2 = new FootbalSneakers("Turf Trainers (TF)", 100, "Футбольные", new Producer("Adidas", "Индонезия"));
		FootbalSneakers footbalSneakers3 = new FootbalSneakers("Artificial Grass boots (AG)", 355, "Футбольные", new Producer("Nike", "Китай"));
		RunningSneakers runningSneakers1 = new RunningSneakers("Ghost 9", 95, "Беговые", new Producer("Brooks", "США"));
		RunningSneakers runningSneakers2 = new RunningSneakers("Speedcross 4", 195, "Беговые", new Producer("Salomon", "Франция"));
		RunningSneakers runningSneakers3 = new RunningSneakers("Wave Rider 25", 225, "Беговые", new Producer("Mizuno", "Япония"));
		RunningSneakers runningSneakers4 = new RunningSneakers("Gel Sonoma 4", 335, "Беговые", new Producer("Asics", "Япония"));

		ArrayList <Sneakers> listSneakers = new ArrayList<Sneakers>(Arrays.asList(basketballSneakers1, basketballSneakers2, basketballSneakers3, footbalSneakers1, footbalSneakers2, footbalSneakers3, runningSneakers1, runningSneakers2, runningSneakers3, runningSneakers4));

		System.out.print("Общее количество производителей - " + listSneakers.size());

		ArrayList<String> listUniqName = new ArrayList<String>();

		String[] arrayName = new String[listSneakers.size()];

		for (int i = 0; i < listSneakers.size(); i++)
		{
			arrayName[i] = listSneakers.get(i).producer.name;
		}

		listUniqName = arrayName.Distinct().ToList();

		System.out.println("\n\nКоличество каждого производителя: ");

		// Вывод количества каждого производителя
		for (int i = 0; i < listUniqName.size(); i++)
		{
			int count = 0;
			for (int j = 0; j < listSneakers.size(); j++)
			{
				if (Objects.equals(listUniqName.get(i), listSneakers.get(j).producer.name))
				{
					count++;
				}
			}
			System.out.println(String.format("%1$s - %2$s", listUniqName.get(i), count));
		}

		System.out.println("\n\nСредняя цена каждого производителя:");
		// Вывод средней цены каждого производителя
		for (int i = 0; i < listUniqName.size(); i++)
		{
			int count = 0;
			double price = 0;
			for (int j = 0; j < listSneakers.size(); j++)
			{
				if (Objects.equals(listUniqName.get(i), listSneakers.get(j).producer.name))
				{
					price += listSneakers.get(j).Cost;
					count++;
				}
			}
			System.out.println(String.format("%1$s - %2$s", listUniqName.get(i), Double.isNaN((price / count)) ? Double.NaN : Math.round((price / count) * Math.pow(10, 2)) / Math.pow(10, 2)));
		}

		ArrayList<String> listUniqType = new ArrayList<String>();

		String[] arrayType = new String[listSneakers.size()];

		for (int i = 0; i < listSneakers.size(); i++)
		{
			arrayType[i] = listSneakers.get(i).Type;
		}

		listUniqType = arrayType.Distinct().ToList();

		System.out.println("\n\nСредняя цена по каждому типу кроссовок: ");

		for (int i = 0; i < listUniqType.size(); i++)
		{
			int count = 0;
			double price = 0;

			for (int j = 0; j < listSneakers.size(); j++)
			{
				if (Objects.equals(listUniqType.get(i), listSneakers.get(j).Type))
				{
					price += listSneakers.get(j).Cost;
					count++;
				}
			}
			System.out.println(String.format("%1$s - %2$s", listUniqType.get(i), Double.isNaN((price / count)) ? Double.NaN : Math.round((price / count) * Math.pow(10, 2)) / Math.pow(10, 2)));
		}

	}
}
