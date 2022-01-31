package zophop.models;

import java.io.Serializable;

public class LineMap implements Serializable {
    private static final long serialVersionUID = 1;
    public String name;
    public String url;

    public LineMap(String str, String str2) {
        this.name = str;
        this.url = str2;
    }
}
