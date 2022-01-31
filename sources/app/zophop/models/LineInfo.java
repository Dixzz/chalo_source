package app.zophop.models;

public class LineInfo {
    private final String _colorCode;
    private final String _details;
    private final String _lineName;

    public LineInfo(String str, String str2, String str3) {
        this._lineName = str;
        this._details = str2;
        this._colorCode = str3;
    }

    public String getColorCode() {
        return this._colorCode;
    }

    public String getDetails() {
        return this._details;
    }

    public String getLineName() {
        return this._lineName;
    }
}
