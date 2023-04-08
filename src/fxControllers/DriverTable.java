package fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DriverTable {
    private final SimpleIntegerProperty colId = new SimpleIntegerProperty();
    private final SimpleStringProperty colLog = new SimpleStringProperty();
    private final SimpleStringProperty colName = new SimpleStringProperty();
    private final SimpleStringProperty colSurname = new SimpleStringProperty();
    private final SimpleStringProperty colEmail = new SimpleStringProperty();
    private final SimpleStringProperty colBirth = new SimpleStringProperty();
    private final SimpleStringProperty colLicense = new SimpleStringProperty();
    private final SimpleStringProperty colCertificate = new SimpleStringProperty();

    public DriverTable() {
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

    public String getColBirth() {
        return colBirth.get();
    }

    public SimpleStringProperty colBirthProperty() {
        return colBirth;
    }

    public void setColBirth(String colBirth) {
        this.colBirth.set(colBirth);
    }

    public String getColLicense() {
        return colLicense.get();
    }

    public SimpleStringProperty colLicenseProperty() {
        return colLicense;
    }

    public void setColLicense(String colLicense) {
        this.colLicense.set(colLicense);
    }

    public String getColCertificate() {
        return colCertificate.get();
    }

    public SimpleStringProperty colCertificateProperty() {
        return colCertificate;
    }

    public void setColCertificate(String colCertificate) {
        this.colCertificate.set(colCertificate);
    }
}
