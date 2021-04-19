package com.efomenko.controller;

import com.efomenko.pojo.ConnectSql;
import com.efomenko.views.MenuViews;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.efomenko.pojo.Equip;
import javafx.scene.control.TableColumn;

public class ControllerEquip {

    private MenuViews menuView;
    @FXML
    private TableView<Equip> tableEquip;

    @FXML
    private TableColumn<Equip, Integer> idColumn;

    @FXML
    private TableColumn<Equip, String> nameColumn;

    @FXML
    private TableColumn<Equip, String> serialNumberColumn;

    @FXML
    private TableColumn<Equip, String> statusColumn;

    @FXML
    private TableColumn<Equip, String> descriptionColumn;

    @FXML
    private TableColumn<Equip, String> dateStartColumn;

    @FXML
    private TableColumn<Equip, String> dateFinishColumn;

    private MenuViews menuViews ;

    ConnectSql connectSqlDao;
    // инициализируем форму данными
    @FXML
    private void initialize() {

        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<Equip, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Equip, String>("name"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<Equip, String>("serialNumber"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Equip, String>("status"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Equip, String>("description"));
        dateStartColumn.setCellValueFactory(new PropertyValueFactory<Equip, String>("dateStart"));
        dateFinishColumn.setCellValueFactory(new PropertyValueFactory<Equip, String>("dateFinish"));
    }

    public void setMainApp(MenuViews menuViews) {
        this.menuViews = menuViews;
        tableEquip.setItems(menuViews.getEquipsData());

    }
    //Метод удаления записи из таблицы
    @FXML
    private void handleDeleteEquip(){
        int selectedIndex = tableEquip.getSelectionModel().getSelectedIndex();
        int selEquip = tableEquip.getSelectionModel().getSelectedItem().getId();
        if (selectedIndex >=0) {
            tableEquip.getItems().remove(selectedIndex);
            connectSqlDao = new ConnectSql();
            connectSqlDao.delete(selEquip);
            }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //alert.initOwner(ControllerEquip.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No equip Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }
    public void updateDataTable(){
        tableEquip.getItems().clear();
        menuViews.addData();
        tableEquip.setItems(menuViews.getEquipsData());
    }
    @FXML
    private void handleNewEquip() {
        Equip tempEquip = new Equip();
        menuViews = new MenuViews();
        boolean okClicked = menuViews.showEquipsEditDialog(tempEquip);
        if (okClicked) {
            updateDataTable();
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопка Edit...
     * Открывает диалоговое окно для изменения выбранного адресата.
     */

    @FXML
    private void handleEditEquips() {
        Equip selectedEquips = tableEquip.getSelectionModel().getSelectedItem();
        menuViews = new MenuViews();
        System.out.println(selectedEquips.getId());

        if (selectedEquips != null) {

            boolean okClicked = menuViews.showEquipsUpdateDialog(selectedEquips);
            if (okClicked) {
                updateDataTable();
            }
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(menuViews.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }
/*
    private void showEquipDetails(Equip equips) {
        if (equips!=null){
            idColumn.setText(Integer.toString(equips.getId()));
            nameColumn.setText(equips.getName());
            serialNumberColumn.setText(equips.getSerialNumber());
            statusColumn.setText(equips.getStatus());
            descriptionColumn.setText(equips.getDescription());
            dateStartColumn.setText(equips.getDateStart());
            dateFinishColumn.setText(equips.getDateFinish());
        }else{
            idColumn.setText("");
            nameColumn.setText("");
            serialNumberColumn.setText("");
            statusColumn.setText("");
            descriptionColumn.setText("");
            dateStartColumn.setText("");
            dateFinishColumn.setText("");
        }
    }
 */

}