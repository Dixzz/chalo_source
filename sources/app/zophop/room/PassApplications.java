package app.zophop.room;

import app.zophop.models.mTicketing.MPass;

public class PassApplications {
    private String agencyName;
    private String cityName;
    public MPass pass;
    private String passengerType;

    public String getAgencyName() {
        return this.agencyName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public MPass getPass() {
        return this.pass;
    }

    public String getPassengerType() {
        return this.passengerType;
    }

    public void setAgencyName(String str) {
        this.agencyName = str;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setPass(MPass mPass) {
        this.pass = mPass;
    }

    public void setPassengerType(String str) {
        this.passengerType = str;
    }
}
