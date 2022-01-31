package app.zophop.models;

import java.util.List;
import java.util.Map;

public class ReportProblemMetadata {
    private String _hint;
    private Map<String, String> _tagDetailsMap;
    private List<String> _tagList;
    private String _title;

    public String getHint() {
        return this._hint;
    }

    public Map<String, String> getTagDetailsMap() {
        return this._tagDetailsMap;
    }

    public List<String> getTagList() {
        return this._tagList;
    }

    public String getTitle() {
        return this._title;
    }

    public void setHint(String str) {
        this._hint = str;
    }

    public void setTagDetailsMap(Map<String, String> map) {
        this._tagDetailsMap = map;
    }

    public void setTagList(List<String> list) {
        this._tagList = list;
    }

    public void setTitle(String str) {
        this._title = str;
    }
}
