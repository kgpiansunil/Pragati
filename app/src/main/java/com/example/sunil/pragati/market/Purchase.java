package com.example.sunil.pragati.market;

/**
 * Created by SUNIL on 3/22/2018.
 */

public class Purchase {

    String farmersId;
    String farmersName;
    String farmersContact;
    String farmerProduct;
    String farmerPrice;

    public Purchase(){


    }

    public Purchase(String farmersId, String farmersName, String farmersContact, String farmerProduct, String farmerPrice) {
        this.farmersId = farmersId;
        this.farmersName = farmersName;
        this.farmersContact = farmersContact;
        this.farmerProduct = farmerProduct;
        this.farmerPrice = farmerPrice;
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

    public String getFarmerProduct() {
        return farmerProduct;
    }

    public void setFarmerProduct(String farmerProduct) {
        this.farmerProduct = farmerProduct;
    }

    public String getFarmerPrice() {
        return farmerPrice;
    }

    public void setFarmerPrice(String farmerPrice) {
        this.farmerPrice = farmerPrice;
    }


}
