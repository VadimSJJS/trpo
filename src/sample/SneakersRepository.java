package sample;

import java.util.ArrayList;
import java.util.List;

public class SneakersRepository {
    private List<Sneakers> sneakersList = new ArrayList<>();

    /**
     * Добавление нового объекта класса
     * @param sneakers - объект класс
     */
    public void addSneakers(Sneakers sneakers) {
        sneakersList.add(sneakers);
    }

    /**
     * Удаление объекта класса
     * @param sneakers - объект класс
     */
    public void removeSneakers(Sneakers sneakers) {
        sneakersList.remove(sneakers);
    }

    /**
     *  Изменение данных объекта класса
     * @param oldSneakers - старый объект класса
     * @param newSneakers - новый объект класса
     */
    public void updateSneakers(Sneakers oldSneakers, Sneakers newSneakers) {
        int index = sneakersList.indexOf(oldSneakers);
        if (index != -1) {
            sneakersList.set(index, newSneakers);
        }
    }

    /**
     * Получение всего списка
     * @return - возращает весь список
     */

    public List<Sneakers> getAllSneakers() {
        return sneakersList;
    }
}
