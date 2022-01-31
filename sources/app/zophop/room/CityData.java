package app.zophop.room;

public class CityData {
    private String cityName;
    private String data;
    private String dataId;
    private String etag;
    private String mode;
    private String type;
    private int version;

    public CityData(String str, String str2, String str3, String str4, String str5) {
        this.data = str3;
        this.type = str;
        this.cityName = str2;
        this.mode = str4;
        this.dataId = str5;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getData() {
        return this.data;
    }

    public String getDataId() {
        return this.dataId;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getMode() {
        return this.mode;
    }

    public String getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CityData{type='");
        hj1.U0(i0, this.type, '\'', ", cityName='");
        hj1.U0(i0, this.cityName, '\'', ", mode='");
        hj1.U0(i0, this.mode, '\'', ", id='");
        hj1.U0(i0, this.dataId, '\'', ", data='");
        hj1.U0(i0, this.data, '\'', ", etag='");
        hj1.U0(i0, this.etag, '\'', ", version=");
        return hj1.W(i0, this.version, '}');
    }
}
