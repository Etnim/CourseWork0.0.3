package fxControllers;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ManagerTable {
    private final SimpleIntegerProperty colId = new SimpleIntegerProperty();
    private final SimpleStringProperty colLog = new SimpleStringProperty();
    private final SimpleStringProperty colName = new SimpleStringProperty();
    private final SimpleStringProperty colSurname = new SimpleStringProperty();
    private final SimpleStringProperty colEmail = new SimpleStringProperty();
    private final SimpleStringProperty colPhone = new SimpleStringProperty();
    private final SimpleBooleanProperty colIsAdmin = new SimpleBooleanProperty();

    public ManagerTable() {
    }

    public int getColId() {
        return colId.get();
    }

    public SimpleIntegerProperty colIdProperty() {
        return colId;
    }

    public void setColId(int colId) {
        this.colId.set(colId);
    }

    public String getColLog() {
        return colLog.get();
    }

    public SimpleStringProperty colLogProperty() {
        return colLog;
    }

    public void setColLog(String colLog) {
        this.colLog.set(colLog);
    }

    public String getColName() {
        return colName.get();
    }

    public SimpleStringProperty colNameProperty() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName.set(colName);
    }

    public String getColSurname() {
        return colSurname.get();
    }

    public SimpleStringProperty colSurnameProperty() {
        return colSurname;
    }

    public void setColSurname(String colSurname) {
        this.colSurname.set(colSurname);
    }

    public String getColEmail() {
        return colEmail.get();
    }

    public SimpleStringProperty colEmailProperty() {
        return colEmail;
    }

    public void setColEmail(String colEmail) {
        this.colEmail.set(colEmail);
    }

    public String getColPhone() {
        return colPhone.get();
    }

    public SimpleStringProperty colPhoneProperty() {
        return colPhone;
    }

    public void setColPhone(String colPhone) {
        this.colPhone.set(colPhone);
    }

    public boolean isColIsAdmin() {
        return colIsAdmin.get();
    }

    public SimpleBooleanProperty colIsAdminProperty() {
        return colIsAdmin;
    }

    public void setColIsAdmin(boolean colIsAdmin) {
        this.colIsAdmin.set(colIsAdmin);
    }
}
