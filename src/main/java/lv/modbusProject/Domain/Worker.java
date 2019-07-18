package lv.modbusProject.Domain;

import java.sql.Timestamp;

public class Worker {


private int workerID;
private String firstName;
private String lastName;
private int workerKeyID;
private Timestamp keyLifeStart;
private Timestamp keyLifeEnd;
private String keyString;


    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWorkerKeyID() {
        return workerKeyID;
    }

    public void setWorkerKeyID(int workerKeyID) {
        this.workerKeyID = workerKeyID;
    }

    public Timestamp getKeyLifeStart() {
        return keyLifeStart;
    }

    public void setKeyLifeStart(Timestamp keyLifeStart) {
        this.keyLifeStart = keyLifeStart;
    }

    public Timestamp getKeyLifeEnd() {
        return keyLifeEnd;
    }

    public void setKeyLifeEnd(Timestamp keyLifeEnd) {
        this.keyLifeEnd = keyLifeEnd;
    }

    public String getKeyString() {
        return keyString;
    }

    public void setKeyString(String keyString) {
        this.keyString = keyString;
    }



}
