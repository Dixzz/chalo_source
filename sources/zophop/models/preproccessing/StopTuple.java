package zophop.models.preproccessing;

import java.io.Serializable;

public class StopTuple implements Serializable {
    private static final long serialVersionUID = 1;
    public String from_stop_id;
    public String to_stop_id;

    public StopTuple() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StopTuple stopTuple = (StopTuple) obj;
        String str = this.from_stop_id;
        if (str == null) {
            if (stopTuple.from_stop_id != null) {
                return false;
            }
        } else if (!str.equals(stopTuple.from_stop_id)) {
            return false;
        }
        String str2 = this.to_stop_id;
        if (str2 == null) {
            if (stopTuple.to_stop_id != null) {
                return false;
            }
        } else if (!str2.equals(stopTuple.to_stop_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.from_stop_id;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.to_stop_id;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public StopTuple(String str, String str2) {
        this.from_stop_id = str;
        this.to_stop_id = str2;
    }
}
