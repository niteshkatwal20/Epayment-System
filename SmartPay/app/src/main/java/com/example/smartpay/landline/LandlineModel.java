package com.example.smartpay.landline;

public class LandlineModel {
    String id,landLineProvider,landLineClientName,landLineClientId,landLinebillAmount;

    public LandlineModel() {
    }

    public LandlineModel(String id, String landLineProvider, String landLineClientName, String landLineClientId, String landLinebillAmount) {
        this.id = id;
        this.landLineProvider = landLineProvider;
        this.landLineClientName = landLineClientName;
        this.landLineClientId = landLineClientId;
        this.landLinebillAmount = landLinebillAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandLineProvider() {
        return landLineProvider;
    }

    public void setLandLineProvider(String landLineProvider) {
        this.landLineProvider = landLineProvider;
    }

    public String getLandLineClientName() {
        return landLineClientName;
    }

    public void setLandLineClientName(String landLineClientName) {
        this.landLineClientName = landLineClientName;
    }

    public String getLandLineClientId() {
        return landLineClientId;
    }

    public void setLandLineClientId(String landLineClientId) {
        this.landLineClientId = landLineClientId;
    }

    public String getLandLinebillAmount() {
        return landLinebillAmount;
    }

    public void setLandLinebillAmount(String landLinebillAmount) {
        this.landLinebillAmount = landLinebillAmount;
    }
}
