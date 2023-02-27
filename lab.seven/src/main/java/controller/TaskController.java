package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.TaskLogic;
import logic.TaskNumber;
import test.DataContainer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class TaskController implements Initializable {
    @FXML
    private Button searchButtonTask10;
    @FXML
    private Button addArrayButtonTask10;
    @FXML
    private TextField inputArrayTextField;
    @FXML
    private ListView<String> listViewTask10;
    private final TaskLogic taskLogic = new TaskLogic(TaskNumber.TASK_TEN);
    private static void initializeHandlers(TaskController controller){
        controller.loadListViewHandler();
        controller.searchButtonTask10.setOnMouseClicked(controller::searchLocalMaxMinListViewHandler);
        controller.addArrayButtonTask10.setOnMouseClicked(controller::addArrayListViewHandler);
    }
    private void searchLocalMaxMinListViewHandler(MouseEvent event){
        fillListView(taskLogic.search());
    }
    private void loadListViewHandler(){
        fillListView(DataContainer.getListStringTask10());
    }
    private void addArrayListViewHandler(MouseEvent event){
        DataContainer.addListTask10(convertStringToArrayInteger(inputArrayTextField.getText()));
        inputArrayTextField.clear();
        fillListView(DataContainer.getListStringTask10());
    }
    private void fillListView(List<String> list){
        listViewTask10.getItems().clear();
        listViewTask10.setItems(FXCollections.observableArrayList(list));
    }
    private Integer[] convertStringToArrayInteger(String value){
        List<Integer> toReturn = new ArrayList<>();
        for(var number : inputArrayTextField.getText().split(",")){
            number = number.trim(); toReturn.add(Integer.parseInt(number));
        }
        Integer[] integerArray = new Integer[toReturn.size()];
        for(int i = 0; i < toReturn.size(); i++) integerArray[i] = toReturn.get(i);
        return integerArray;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TaskController.initializeHandlers(this);
    }
}
