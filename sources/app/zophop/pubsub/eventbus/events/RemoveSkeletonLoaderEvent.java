package app.zophop.pubsub.eventbus.events;

/* compiled from: RemoveSkeletonLoaderEvent.kt */
public final class RemoveSkeletonLoaderEvent {
    private String _loaderTag;

    public RemoveSkeletonLoaderEvent(String str) {
        n86.e(str, "_loaderTag");
        this._loaderTag = str;
    }

    public final String getLoaderTag() {
        return this._loaderTag;
    }
}
