package app.zophop.models;

public class CtaAction {
    private String _ctaAction;
    private String _ctaText;
    private String _ctaType;

    public CtaAction(String str, String str2, String str3) {
        this._ctaType = str;
        this._ctaText = str2;
        this._ctaAction = str3;
    }

    public String getCtaAction() {
        return this._ctaAction;
    }

    public String getCtaText() {
        return this._ctaText;
    }

    public String getCtaType() {
        return this._ctaType;
    }

    public void setCtaAction(String str) {
        this._ctaAction = str;
    }

    public void setCtaText(String str) {
        this._ctaText = str;
    }

    public void setCtaType(String str) {
        this._ctaType = str;
    }
}
