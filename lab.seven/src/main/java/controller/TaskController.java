package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    @FXML
    private ListView<String> listViewTask23;
    @FXML
    private Button selectionSequencesButton;
    @FXML
    private ComboBox<String> sequenceComboBox;
    private TaskLogic taskLogic;
    private static void initializeHandlers(TaskController controller){
        controller.loadListViewHandler();
        controller.loadComboBoxHandler();
        controller.searchButtonTask10.setOnMouseClicked(controller::searchLocalMaxMinListViewHandler);
        controller.addArrayButtonTask10.setOnMouseClicked(controller::addArrayListViewHandler);
        controller.selectionSequencesButton.setOnMouseClicked(controller::selectionSequencesButtonHandler);
    }
    private void searchLocalMaxMinListViewHandler(MouseEvent event){
        taskLogic = new TaskLogic(TaskNumber.TASK_TEN);
        fillListView(listViewTask10, taskLogic.search());
    }
    private void loadListViewHandler(){
        fillListView(listViewTask10, DataContainer.getListStringTask10());
    }
    private void loadComboBoxHandler(){
        sequenceComboBox.getItems().clear();
        sequenceComboBox.setItems(FXCollections.observableArrayList(DataContainer.getListStringTask(DataContainer.getListTask23())));
        sequenceComboBox.setValue(sequenceComboBox.getItems().get(0));
    }
    private void addArrayListViewHandler(MouseEvent event){
        DataContainer.addListTask10(convertStringToArrayInteger(inputArrayTextField.getText()));
        inputArrayTextField.clear();
        fillListView(listViewTask10, DataContainer.getListStringTask10());
    }
    private void selectionSequencesButtonHandler(MouseEvent event){
        DataContainer.setCurrentArrayListTask24(convertStringToArrayInteger(sequenceComboBox.getValue()));
        taskLogic = new TaskLogic(TaskNumber.TASK_TWENTY_THREE);
        fillListView(listViewTask23, taskLogic.search());
    }
    private void fillListView(ListView<String> listView, List<String> list){
        listView.getItems().clear();
        listView.setItems(FXCollections.observableArrayList(list));
    }
    private Integer[] convertStringToArrayInteger(String value){
        List<Integer> toReturn = new ArrayList<>();
        for(String number : value.split(",")){
            number = number.replaceAll("[\\[||\\]]", "");
            number = number.trim();
            toReturn.add(Integer.parseInt(number));
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
