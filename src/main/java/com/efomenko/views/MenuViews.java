package com.efomenko.views;

import com.efomenko.controller.ControllerEquip;
import com.efomenko.controller.EquipEditDialogController;
import com.efomenko.controller.EquipUpdateDialogController;
import com.efomenko.pojo.ConnectSql;
import com.efomenko.pojo.Equip;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MenuViews extends Application {
    private Stage primaryStage;
    private ObservableList<Equip> equipsData = FXCollections.observableArrayList();
    List<Equip> data = new ArrayList<Equip>();

    @Override
    public void start(Stage primaryStage) throws IOException{
        addData();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuViews.class.getResource("/menu.fxml"));
        Parent root = loader.load();

        ControllerEquip controllerEquip = loader.getController();
        controllerEquip.setMainApp(this);

        this.primaryStage = primaryStage;
        this.primaryStage.setScene(new Scene(root));
        this.primaryStage.setTitle("Учёт ремонтов оборудования");
        this.primaryStage.show();

    }
    public void addData(){
        ConnectSql connectSqlDao = new ConnectSql();
        data = connectSqlDao.findAll();
        if (data.isEmpty()) {
            connectSqlDao.insert(new Equip());
        }
        for (Equip el : data) {
            equipsData.add(el);
        }
    }
    public boolean showEquipsEditDialog(Equip equip) {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/EquipEditDialog.fxml"));
            AnchorPane root = (AnchorPane)loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New Equip");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            EquipEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setEquip(equip);
            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();
            return controller.isOkClicked();


        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
     }
    public boolean showEquipsUpdateDialog(Equip equip) {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/EquipUpdateDialog.fxml"));
            AnchorPane root = (AnchorPane)loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Update Equip");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            EquipUpdateDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setEquip(equip);
            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();
            return controller.isOkClicked();


        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Stage getPrimaryStage(){
        return primaryStage;
    }
    public ObservableList<Equip> getEquipsData() {
        return equipsData;
    }
}
