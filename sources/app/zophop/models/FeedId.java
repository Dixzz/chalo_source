package app.zophop.models;

public enum FeedId {
    LOCAL("local"),
    BEST_AC("best_ac");
    
    private final String _feedId;

    private FeedId(String str) {
        this._feedId = str;
    }

    public static FeedId fromString(String str, FeedId feedId) {
        if (str != null) {
            FeedId[] values = values();
            for (int i = 0; i < 2; i++) {
                FeedId feedId2 = values[i];
                if (str.equalsIgnoreCase(feedId2.getFeedId())) {
                    return feedId2;
                }
            }
        }
        return feedId;
    }

    public String getFeedId() {
        return this._feedId;
    }
}
