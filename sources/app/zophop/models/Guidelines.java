package app.zophop.models;

public class Guidelines {
    private Guideline[] _guidelineList;
    private String _title;
    private String _url;

    public Guidelines() {
    }

    public Guideline[] getGuidelineList() {
        return this._guidelineList;
    }

    public String getTitle() {
        return this._title;
    }

    public String getUrl() {
        return this._url;
    }

    public void setGuidelineList(Guideline[] guidelineArr) {
        this._guidelineList = guidelineArr;
    }

    public void setTitle(String str) {
        this._title = str;
    }

    public void setUrl(String str) {
        this._url = str;
    }

    public Guidelines(String str, Guideline[] guidelineArr) {
        this._title = str;
        this._guidelineList = guidelineArr;
    }
}
