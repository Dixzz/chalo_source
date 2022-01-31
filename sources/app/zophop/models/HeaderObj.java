package app.zophop.models;

public class HeaderObj {
    public String headerText;
    public String hookCta;
    public String hookText;

    public HeaderObj(String str) {
        this.headerText = str;
    }

    public String getHeaderText() {
        return this.headerText;
    }

    public String getHookCta() {
        return this.hookCta;
    }

    public String getHookText() {
        return this.hookText;
    }

    public void setHeaderText(String str) {
        this.headerText = str;
    }

    public void setHookCta(String str) {
        this.hookCta = str;
    }

    public void setHookText(String str) {
        this.hookText = str;
    }
}
