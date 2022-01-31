package app.zophop.pubsub.eventbus.events;

public class RouteListScrollEvent {

    public enum TYPE {
        TOP,
        BOTTOM,
        INTERMEDIATE
    }

    public RouteListScrollEvent(TYPE type) {
    }

    public void getType() {
    }
}
