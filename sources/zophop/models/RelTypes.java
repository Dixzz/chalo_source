package zophop.models;

import java.io.Serializable;
import org.neo4j.graphdb.RelationshipType;

public enum RelTypes implements RelationshipType, Serializable {
    TRAIN,
    ONBOARD,
    OFFBOARD,
    BUS,
    ROAD,
    TRIP,
    TRANSIT_EDGE,
    NON_TRANSIT_EDGE,
    TRANSFER_EDGE,
    STOP_TO_ROUTE_LEG,
    ROAD_TRANSFER_EDGE
}
