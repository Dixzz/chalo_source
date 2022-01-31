package app.zophop.models;

import java.util.List;
import java.util.Map;

public class FeedbackMetadata {
    private Map<Integer, List<String>> _ratingTagListMap;
    private String _title;

    public Map<Integer, List<String>> getRatingTagListMap() {
        return this._ratingTagListMap;
    }

    public String getTitle() {
        return this._title;
    }

    public void setRatingTagListMap(Map<Integer, List<String>> map) {
        this._ratingTagListMap = map;
    }

    public void setTitle(String str) {
        this._title = str;
    }
}
