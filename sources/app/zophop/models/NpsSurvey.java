package app.zophop.models;

import java.util.Map;

public class NpsSurvey {
    private long _idleTimeout;
    private Map<String, NpsSurveyQuestion> _npsSurveyQuestionMap;
    private String _startingQuestionId;
    private String _surveyId;

    public NpsSurvey(String str, long j, String str2) {
        this._surveyId = str;
        this._idleTimeout = j;
        this._startingQuestionId = str2;
    }

    public long getIdleTimeout() {
        return this._idleTimeout;
    }

    public Map<String, NpsSurveyQuestion> getNpsSurveyQuestionMap() {
        return this._npsSurveyQuestionMap;
    }

    public String getStartingQuestionId() {
        return this._startingQuestionId;
    }

    public String getSurveyId() {
        return this._surveyId;
    }

    public void setNpsSurveyQuestionMap(Map<String, NpsSurveyQuestion> map) {
        this._npsSurveyQuestionMap = map;
    }
}
