package zophop.models;

import java.io.Serializable;

public class Calendar implements Serializable {
    private static final long serialVersionUID = 1;
    public String feed_id;
    public String service_id;
    public String transport_type;

    public boolean equals(Object obj) {
        if (!(obj instanceof Calendar)) {
            return false;
        }
        Calendar calendar = (Calendar) obj;
        if (calendar.feed_id.equals(this.feed_id) && calendar.service_id.equals(this.service_id) && calendar.transport_type.equals(this.transport_type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.service_id.hashCode();
    }
}
