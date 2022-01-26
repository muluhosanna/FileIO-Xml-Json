package com.java.module3;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.ArrayList;
import java.util.Objects;

public class WorkerModel {

    @JsonAlias("id")
    private int id;

    @JsonAlias("firstname")
    private String fName;

    @JsonAlias("lastname")
    private String lName;

    @JsonAlias("phone")
    private ArrayList<PhoneModel> phoneList;

    public WorkerModel() {
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public ArrayList<PhoneModel> getPhoneList() {
        return phoneList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPhoneList(ArrayList<PhoneModel> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerModel that = (WorkerModel) o;
        return id == that.id && Objects.equals(fName, that.fName) && Objects.equals(lName, that.lName) && Objects.equals(phoneList, that.phoneList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fName, lName, phoneList);
    }


    static class PhoneModel {
        @JsonAlias("type")
        private String type;

        @JsonAlias("number")
        private Long phoneNumber;

        public String getType() {
            return type;
        }

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }


    }
}
