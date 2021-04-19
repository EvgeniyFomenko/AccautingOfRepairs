package com.efomenko.controller;

import com.efomenko.pojo.ConnectSql;
import com.efomenko.pojo.Equip;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Окно для добавления/изменения информации о оборудовании в ремонте
 *
 * @author  Фоменко Евгений
 */

public class EquipUpdateDialogController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField serialNumberField;
    @FXML
    private TextField statusComboBox;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField startDateField;
    @FXML
    private TextField finishDateField;

    private Stage dialogStage;
    private Equip equip;
    private boolean okClicked = false;

    @FXML
    private void initialize(){
    }
    //установка сцены для этого окна
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage=dialogStage;
    }
    public void setEquip(Equip equip) {
        this.equip = equip;
        nameField.setText(equip.getName());
        serialNumberField.setText(equip.getSerialNumber());
        statusComboBox.setText(equip.getStatus());
        descriptionField.setText(equip.getDescription());
        startDateField.setText(equip.getDateStart());
        finishDateField.setText(equip.getDateFinish());
    }
    public boolean isOkClicked(){
        return okClicked;
    }
    @FXML
    private void handleOK(){
        if (isInputValid()){
            equip.setName(nameField.getText());
            equip.setSerialNumber(serialNumberField.getText());
            equip.setStatus(statusComboBox.getText());
            equip.setDescription(descriptionField.getText());
            equip.setDateStart(startDateField.getText());
            equip.setDateFinish(finishDateField.getText());
            okClicked=true;
            dialogStage.close();
            ConnectSql connectSqlDao = new ConnectSql();
            connectSqlDao.update(equip);
        }
    }
    @FXML
    private void handleCancel(){
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (serialNumberField.getText() == null || serialNumberField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (statusComboBox.getText() == null || statusComboBox.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (descriptionField.getText() == null || descriptionField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (startDateField.getText() == null || startDateField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (finishDateField.getText() == null || finishDateField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (errorMessage.length() == 0)
            return true;
        else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
