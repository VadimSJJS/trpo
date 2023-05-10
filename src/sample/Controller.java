package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.util.Arrays;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Add_Button;

    @FXML
    private Button Change_Button;

    @FXML
    private TextField Label_Cost;

    @FXML
    private TextField Label_Country_Producer;

    @FXML
    private TextField Label_Model;

    @FXML
    private TextField Label_Name_Producer;

    @FXML
    private TextField Label_Type;

    @FXML
    private Button Print_Info;

    @FXML
    private Button Remove_Button;

    @FXML
    private TextArea textArea_Info;


    @FXML
    void initialize() {
        assert Add_Button != null : "fx:id=\"Add_Button\" was not injected: check your FXML file 'sample.fxml'.";
        assert Change_Button != null : "fx:id=\"Change_Button\" was not injected: check your FXML file 'sample.fxml'.";
        assert Label_Cost != null : "fx:id=\"Label_Cost\" was not injected: check your FXML file 'sample.fxml'.";
        assert Label_Country_Producer != null : "fx:id=\"Label_Country_Producer\" was not injected: check your FXML file 'sample.fxml'.";
        assert Label_Model != null : "fx:id=\"Label_Model\" was not injected: check your FXML file 'sample.fxml'.";
        assert Label_Name_Producer != null : "fx:id=\"Label_Name_Producer\" was not injected: check your FXML file 'sample.fxml'.";
        assert Label_Type != null : "fx:id=\"Label_Type\" was not injected: check your FXML file 'sample.fxml'.";
        assert Print_Info != null : "fx:id=\"Print_Info\" was not injected: check your FXML file 'sample.fxml'.";
        assert Remove_Button != null : "fx:id=\"Remove_Button\" was not injected: check your FXML file 'sample.fxml'.";
        assert textArea_Info != null : "fx:id=\"textArea_Info\" was not injected: check your FXML file 'sample.fxml'.";


        ArrayList<Sneakers> listSneakers = new ArrayList<Sneakers>();
        SneakersRepository sneakersRepository = new SneakersRepository();

        // Кнопка добавления объекта в ArrayList
        Add_Button.setOnAction(actionEvent -> {

            Producer producer = new Producer(Label_Name_Producer.getText(), Label_Country_Producer.getText());
            Sneakers sneakers = new Sneakers(Label_Model.getText(), Integer.valueOf(Label_Cost.getText()), Label_Type.getText(), producer);
            listSneakers.add(sneakers);


            sneakersRepository.addSneakers(sneakers);
        });

        // Кнопка вывода данных
        Print_Info.setOnAction(actionEvent -> {
            String str = "";
            for (Sneakers item : sneakersRepository.getAllSneakers()) {
                str += ("Модель: " + item.Name + ", Стоимость: " + item.Cost + ", Тип: " + item.Type + ", Производитель: " + item.Producer.NameProducer + "(" + item.Producer.country + ")\n");
            }

            textArea_Info.setText("");
            textArea_Info.appendText(str);
            str = "";
        });

        Remove_Button.setOnAction(actionEvent -> {
            for (Sneakers item : sneakersRepository.getAllSneakers()) {
                if (item.Name.equals(Label_Model.getText())) {
                    sneakersRepository.removeSneakers(item);
                    System.out.println("Удалено успешно!");
                    break;
                }
            }
        });

        Change_Button.setOnAction(actionEvent -> {
            Producer producer = new Producer(Label_Name_Producer.getText(), Label_Country_Producer.getText());
            for (Sneakers item : sneakersRepository.getAllSneakers())
            {
                if (item.Name.equals(Label_Model.getText()))
                {
                    item.Cost = Integer.valueOf(Label_Cost.getText());
                    System.out.println("Изменено успешно!");
                }
            }
        });
    }
}