package app.zophop.models;

import java.util.Map;

public class DismissConditions {
    private Map<String, Integer> dismissConditions;

    public Map<String, Integer> getDismissConditions() {
        return this.dismissConditions;
    }

    public void setDismissConditions(Map<String, Integer> map) {
        this.dismissConditions = map;
    }
}
