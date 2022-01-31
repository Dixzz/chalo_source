package zophop.models.preproccessing;

import java.io.Serializable;

public class RoadConnection implements Serializable {
    private static final long serialVersionUID = 1;
    public int distance;
    public String from_stop_id;
    public String polyline;
    public String to_stop_id;
}
