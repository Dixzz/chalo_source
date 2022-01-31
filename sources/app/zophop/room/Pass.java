package app.zophop.room;

import app.zophop.models.mTicketing.MPass;

public class Pass {
    public MPass pass;
    public String passId;

    public MPass getPass() {
        return this.pass;
    }

    public String getPassId() {
        return this.passId;
    }

    public void setPass(MPass mPass) {
        this.pass = mPass;
    }

    public void setPassId(String str) {
        this.passId = str;
    }
}
