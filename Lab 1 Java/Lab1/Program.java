package Lab1;

import java.util.*;
import java.util.Arrays;

public class Program
{
	public static void main(String[] args)
	{

		// Создание производителей
		Producer producer1 = new Producer("Nike", "Вьетнам");
		Producer producer2 = new Producer("Adidas", "США");
		Producer producer3 = new Producer("Adidas", "Индонезия");
		Producer producer4 = new Producer("Nike", "Китай");
		Producer producer5 = new Producer("Brooks", "США");
		Producer producer6 = new Producer("Salomon", "Франция");
		Producer producer7 = new Producer("Mizzen", "Япония");
		Producer producer8 = new Producer("Asics", "Япония");

		// Создание объектов
		BasketballSneakers basketballSneakers1 = new BasketballSneakers("Nike Kobe A.D. Mid", 150, "Бескетбольные", producer1);
		BasketballSneakers basketballSneakers2 = new BasketballSneakers("Nike Hyperdunk 2017", 75, "Бескетбольные", producer1);
		BasketballSneakers basketballSneakers3 = new BasketballSneakers("Adidas Crazy Explosive 2017", 270, "Бескетбольные", producer2);
		FootbalSneakers footballSneakers1 = new FootbalSneakers("Firm Ground boots (FG)", 200, "Футбольные", producer2);
		FootbalSneakers footballSneakers2 = new FootbalSneakers("Turf Trainers (TF)", 100, "Футбольные", producer3);
		FootbalSneakers footballSneakers3 = new FootbalSneakers("Artificial Grass boots (AG)", 355, "Футбольные", producer4);
		RunningSneakers runningSneakers1 = new RunningSneakers("Ghost 9", 95, "Беговые", producer5);
		RunningSneakers runningSneakers2 = new RunningSneakers("Speed-cross 4", 195, "Беговые", producer6);
		RunningSneakers runningSneakers3 = new RunningSneakers("Wave Rider 25", 225, "Беговые", producer7);
		RunningSneakers runningSneakers4 = new RunningSneakers("Gel Sonoma 4", 335, "Беговые", producer8);

		ArrayList<Sneakers> listSneakers = new ArrayList<>(Arrays.asList(
				basketballSneakers1, basketballSneakers2,
				basketballSneakers3, footballSneakers1,
				footballSneakers2, footballSneakers3,
				runningSneakers1, runningSneakers2,
				runningSneakers3, runningSneakers4)
		);

		// Вывод общего количества производителей
		int countAllProducers = Sneakers.getAllCountProducers(listSneakers);
		System.out.print("Общее количество производителей - " + countAllProducers);

		// Получение списка, в котором содержатся уникальные наименования производителей
		List<String> listUniNames = Sneakers.getUniqNames(listSneakers);

		// Вывод каждого производителя
		System.out.println("\n\nСписок производителей:");
		for (String item : listUniNames) {
			System.out.print(item + " ");
		}

		System.out.println("\n\nКоличество каждого производителя:");

		// вызываем метод getProducerStatistics() и выводим количество каждого производителя
		List<String> statistics = Sneakers.getProducerStatistics(listSneakers);
		for (String stat : statistics) {
			System.out.println(stat);
		}

		System.out.println("\n\nСредняя цена каждого производителя:");

		// Вывод средней цены каждого производителя
		List<String> averagePrices = Sneakers.getAverageCostByProducer(listSneakers);
		System.out.println(averagePrices);

		String[] arrayType = new String[listSneakers.size()];

		for (int i = 0; i < listSneakers.size(); i++)
		{
			arrayType[i] = listSneakers.get(i).Type;
		}


		System.out.println("\n\nСредняя цена по каждому типу кроссовок: ");

		List<String> averageCostByType = Sneakers.printAverageCostByType(listSneakers); // вызов метода getAverageCostByType
		System.out.println(averageCostByType); // вывод результата



		// создаем репозиторий и добавляем туда объекты
		SneakersRepository sneakersRepository = new SneakersRepository();
		sneakersRepository.addSneakers(footballSneakers1);
		sneakersRepository.addSneakers(basketballSneakers1);
		sneakersRepository.addSneakers(runningSneakers1);

		System.out.print("\n\n");

		// выводим на экран все объекты в репозитории
		for (Sneakers sneakers : sneakersRepository.getAllSneakers()) {
			System.out.println("Модель: " + sneakers.Name + ", Стоимость: " + sneakers.Cost + ", Тип: " + sneakers.Type + ", Производитель: " + sneakers.Producer.NameProducer + " (" + sneakers.Producer.country + ")");
		}

		// изменяем объект в репозитории
		sneakersRepository.updateSneakers(basketballSneakers1, new RunningSneakers("Air Zoom", 8000, "running", producer2));
		System.out.println("\nПосле обновления:");
		for (Sneakers sneakers : sneakersRepository.getAllSneakers()) {
			System.out.println("Модель: " + sneakers.Name + ", Стоимость: " + sneakers.Cost + ", Тип: " + sneakers.Type + ", Производитель: " + sneakers.Producer.NameProducer + " (" + sneakers.Producer.country + ")");
		}

		// удаляем объект из репозитория
		sneakersRepository.removeSneakers(footballSneakers1);
		System.out.println("\nПосле удаления:");
		for (Sneakers sneakers : sneakersRepository.getAllSneakers()) {
			System.out.println("Модель: " + sneakers.Name + ", Стоимость: " + sneakers.Cost + ", Тип: " + sneakers.Type + ", Производитель: " + sneakers.Producer.NameProducer + " (" + sneakers.Producer.country + ")");
		}
	}
}
