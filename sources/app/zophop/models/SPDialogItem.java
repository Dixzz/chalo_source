package app.zophop.models;

public class SPDialogItem {
    public final String desc;
    public final String header;
    public final int imageDrawable;

    public SPDialogItem(int i, String str, String str2) {
        this.imageDrawable = i;
        this.header = str;
        this.desc = str2;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getHeader() {
        return this.header;
    }

    public int getImageDrawable() {
        return this.imageDrawable;
    }
}
