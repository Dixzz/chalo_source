package app.zophop.pubsub.eventbus.events;

import app.zophop.models.NpsSurveyQuestion;
import java.util.List;

public class NpsSurveyEvent {
    public List<NpsSurveyQuestion> _npsSurveyQuestionList;
    public ad1 _responseType;

    public NpsSurveyEvent(ad1 ad1, List<NpsSurveyQuestion> list) {
        this._responseType = ad1;
        this._npsSurveyQuestionList = list;
    }

    public List<NpsSurveyQuestion> getNpsQuestionList() {
        return this._npsSurveyQuestionList;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
