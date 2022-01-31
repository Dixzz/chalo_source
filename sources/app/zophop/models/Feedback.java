package app.zophop.models;

import java.util.Map;

public class Feedback {
    private FeedbackMetadata _feedbackMetadata;
    private Map<String, String> _tags;

    public FeedbackMetadata getFeedbackMetadata() {
        return this._feedbackMetadata;
    }

    public Map<String, String> getTags() {
        return this._tags;
    }

    public void setFeedbackMetadata(FeedbackMetadata feedbackMetadata) {
        this._feedbackMetadata = feedbackMetadata;
    }

    public void setTags(Map<String, String> map) {
        this._tags = map;
    }
}
