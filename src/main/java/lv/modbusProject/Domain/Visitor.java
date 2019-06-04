package lv.modbusProject.Domain;


import java.sql.Timestamp;

public class Visitor {

        private String visitorId;

        private String inDateString;
        private String inTimeString;
        private String outDateString;
        private String outTimeString;
       private Timestamp inDate;
        private Timestamp inTime;
        private Timestamp outDate;
        private Timestamp outTime;
        private String firstName;
        private String lastName;

        private String cardNumber;
        private String company;
        private String responsiblePerson;
        private String roomName;
        private int orderNumber;
        private String responsiblePersonIdentity;
        private int UserId;
        private String accessPoint;


    public String getAccessPoint() {
        return accessPoint;
    }

    public void setAccessPoint(String accessPoint) {
        this.accessPoint = accessPoint;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getOutDateString() {
        return outDateString;
    }

    public void setOutDateString(String outDateString) {
        this.outDateString = outDateString;
    }

    public String getOutTimeString() {
        return outTimeString;
    }

    public void setOutTimeString(String outTimeString) {
        this.outTimeString = outTimeString;
    }
    public String getResponsiblePerson() {


        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }


    public String getInDateString() {
        return inDateString;
    }

    public void setInDateString(String inDateString) {
        this.inDateString = inDateString;
    }

    public String getInTimeString() {
        return inTimeString;
    }

    public void setInTimeString(String inTimeString) {
        this.inTimeString = inTimeString;
    }


    public String getResponsiblePersonIdentity() {
        return responsiblePersonIdentity;
    }

    public void setResponsiblePersonIdentity(String responsiblePersonIdentity) {
        this.responsiblePersonIdentity = responsiblePersonIdentity;
    }

    public Timestamp getInDate() {
        return inDate;
    }

    public void setInDate(Timestamp inDate) {
        this.inDate = inDate;
    }

    public Timestamp getOutDate() {
        return outDate;
    }

    public void setOutDate(Timestamp outDate) {
        this.outDate = outDate;
    }


    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

       public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }
}
