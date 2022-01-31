package app.zophop.models;

public class Guideline {
    private String _guideline;
    private String[] _subGuidelines;

    public Guideline(String str, String[] strArr) {
        this._guideline = str;
        this._subGuidelines = strArr;
    }

    public String getGuideline() {
        return this._guideline;
    }

    public String[] getSubGuidelines() {
        return this._subGuidelines;
    }

    public void setGuideline(String str) {
        this._guideline = str;
    }

    public void setSubGuidelines(String[] strArr) {
        this._subGuidelines = strArr;
    }
}
