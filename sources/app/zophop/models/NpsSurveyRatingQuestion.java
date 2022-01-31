package app.zophop.models;

import android.util.Pair;
import java.util.Map;

public class NpsSurveyRatingQuestion extends NpsSurveyQuestion {
    private String _highestRatingText;
    private String _lowestRatingText;
    private Map<String, Pair<CtaAction, CtaAction>> _thresholdActionMapping;

    public NpsSurveyRatingQuestion(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this._lowestRatingText = str4;
        this._highestRatingText = str5;
    }

    public String getHighestRatingText() {
        return this._highestRatingText;
    }

    public String getLowestRatingText() {
        return this._lowestRatingText;
    }

    public Map<String, Pair<CtaAction, CtaAction>> getThresholdActionMapping() {
        return this._thresholdActionMapping;
    }

    public void setTresholdActionMapping(Map<String, Pair<CtaAction, CtaAction>> map) {
        this._thresholdActionMapping = map;
    }
}
