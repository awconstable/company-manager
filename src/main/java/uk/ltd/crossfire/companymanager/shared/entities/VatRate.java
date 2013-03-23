package uk.ltd.crossfire.companymanager.shared.entities;

public class VatRate {

    private int id;
    private double rate;
    private boolean defaultRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isDefaultRate() {
        return defaultRate;
    }

    public void setDefaultRate(boolean defaultRate) {
        this.defaultRate = defaultRate;
    }
}
