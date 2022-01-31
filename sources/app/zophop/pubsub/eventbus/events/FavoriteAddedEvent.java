package app.zophop.pubsub.eventbus.events;

public class FavoriteAddedEvent {
    private final boolean isFavoriteAdded;

    public FavoriteAddedEvent(boolean z) {
        this.isFavoriteAdded = z;
    }

    public boolean getIsFavoriteAdded() {
        return this.isFavoriteAdded;
    }
}
