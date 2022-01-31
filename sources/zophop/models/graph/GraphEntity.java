package zophop.models.graph;

import java.io.Serializable;
import java.util.HashMap;

public abstract class GraphEntity implements Serializable {
    public Label label;
    public HashMap<String, Object> properties = new HashMap<>();

    public Label getLabel() {
        return this.label;
    }

    public Object getProperty(String str) {
        return this.properties.get(str);
    }

    public boolean hasLabel(Label label2) {
        return this.label.equals(label2);
    }

    public boolean hasProperty(String str) {
        return this.properties.containsKey(str);
    }

    public void setLabel(Label label2) {
        this.label = label2;
    }

    public void setProperty(String str, Object obj) {
        this.properties.put(str, obj);
    }

    public String toString() {
        return this.properties.toString();
    }
}
