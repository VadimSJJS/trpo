package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.Objects;

public class Sneakers {
    public String Name;
    public int Cost;
    public String Type;
    public Producer Producer;

    public Sneakers(String name, int cost, String type, Producer producer) {
        Name = name;
        Cost = cost;
        Type = type;
        this.Producer = producer;
    }

    public Sneakers()
    {

    }
    /**
     * возращает количество всех производителей
     * @param listSneakers - список кроссовок
     * @return - возращает количество всех производителей
     */
    static public int getAllCountProducers(ArrayList<Sneakers> listSneakers)
    {

        return listSneakers.size();
    }

    /**
     * возращает уникальные значения из списка
     * @param listSneakers - список кроссовок
     * @return - возращает уникальные значения из списка
     */
    public static List<String> getUniqNames(List<Sneakers> listSneakers) {
        Set<String> setUniqName = new HashSet<>();

        for (Sneakers sneaker : listSneakers) {
            setUniqName.add(sneaker.Producer.NameProducer);
        }

        return new ArrayList<>(setUniqName);
    }

    /**
     * возращает среднию цену каждого производителя
     * @param listSneakers - список кроссовок
     * @return - возращает среднию цену каждого производителя
     */
    public static List<String> getProducerStatistics(List<Sneakers> listSneakers) {
        List<String> statistics = new ArrayList<>();
        List<String> listUniqName = getUniqNames(listSneakers);

        // Вывод количества каждого производителя
        for (String name : listUniqName) {
            int count = (int) listSneakers.stream()
                    .filter(sneaker -> Objects.equals(name, sneaker.Producer.NameProducer))
                    .count();
            statistics.add(String.format("%1$s - %2$s", name, count));
        }

        statistics.add("\n\nСредняя цена каждого производителя:");

        // Вывод средней цены каждого производителя
        for (String name : listUniqName) {
            double price = listSneakers.stream()
                    .filter(sneaker -> Objects.equals(name, sneaker.Producer.NameProducer))
                    .mapToDouble(sneaker -> sneaker.Cost)
                    .average()
                    .orElse(Double.NaN);
            statistics.add(String.format("%1$s - %2$s", name, Double.isNaN(price) ? Double.NaN : Math.round(price * Math.pow(10, 2)) / Math.pow(10, 2)));
        }
        return statistics;
    }

    /**
     * возращает список с названием кроссовок и его среденей стоимостью
     * @param listSneakers - список кроссовок
     * @return - возращает список с названием кроссовок и его среденей стоимостью
     */
    public static List<String> getAverageCostByProducer(List<Sneakers> listSneakers) {
        return getUniqNames(listSneakers).stream()
                .map(name -> {
                    double avgPrice = listSneakers.stream()
                            .filter(sneaker -> Objects.equals(name, sneaker.Producer.NameProducer))
                            .mapToDouble(sneaker -> sneaker.Cost)
                            .average()
                            .orElse(Double.NaN);
                    return String.format("%s - %s", name, Double.isNaN(avgPrice) ? "NaN" : String.format("%.2f", avgPrice));
                })
                .collect(Collectors.toList());
    }

    /**
     * возращает среднюю стоимость каждого типа кроссовок
     * @param listSneakers - список кроссовок
     * @return - возращает среднюю стоимость каждого типа кроссовок
     */
    public static List<String> printAverageCostByType(List<Sneakers> listSneakers) {
        List<String> listUniqType = listSneakers.stream()
                .map(sneaker -> sneaker.Type)
                .distinct()
                .collect(Collectors.toList());

        for (String type : listUniqType) {
            int count = 0;
            double price = 0;

            for (Sneakers sneaker : listSneakers) {
                if (Objects.equals(type, sneaker.Type)) {
                    price += sneaker.Cost;
                    count++;
                }
            }
            System.out.printf("%1$s - %2$s%n", type, Double.isNaN((price / count)) ? Double.NaN : Math.round((price / count) * Math.pow(10, 2)) / Math.pow(10, 2));
        }
        return listUniqType;
    }
}
