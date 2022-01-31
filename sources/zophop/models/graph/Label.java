package zophop.models.graph;

import java.io.Serializable;

public enum Label implements Serializable {
    ONBOARD,
    OFFBOARD,
    STOP,
    ROUTE_LEG,
    TRANSFER_EDGE,
    ROAD_TRANSFER_EDGE,
    STOP_TO_ROUTE_LEG
}
