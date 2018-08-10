package com.example.sunil.pragati.model;

/**
 * Created by SUNIL on 3/22/2018.
 */

public class Farmers {

    public String farmersId;
   public String farmersName;
    public String farmersContact;
   public String farmerType;
   public String farmerAdd;

    public String getFarmerVillage() {
        return farmerVillage;
    }

    public void setFarmerVillage(String farmerVillage) {
        this.farmerVillage = farmerVillage;
    }

    String farmerVillage;

    public Farmers(){

    }

    public String getFarmerType() {
        return farmerType;
    }

    public void setFarmerType(String farmerType) {
        this.farmerType = farmerType;
    }

    public String getFarmerAdd() {
        return farmerAdd;
    }

    public void setFarmerAdd(String farmerAdd) {
        this.farmerAdd = farmerAdd;
    }



    public Farmers(String farmersId, String farmersName, String farmersContact, String farmerType, String farmerAdd, String farmerVillage) {
        this.farmersId = farmersId;
        this.farmersName = farmersName;
        this.farmersContact = farmersContact;
        this.farmerType = farmerType;
        this.farmerAdd = farmerAdd;
        this.farmerVillage = farmerVillage;

    }

    public String getFarmersId() {
        return farmersId;
    }

    public void setFarmersId(String farmersId) {
        this.farmersId = farmersId;
    }

    public String getFarmersName() {
        return farmersName;
    }

    public void setFarmersName(String farmersName) {
        this.farmersName = farmersName;
    }

    public String getFarmersContact() {
        return farmersContact;
    }

    public void setFarmersContact(String farmersContact) {
        this.farmersContact = farmersContact;
    }



}
