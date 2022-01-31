package app.zophop.models;

import java.util.List;

public class NpsSurveyQuestion {
    private CtaAction _negativeCtaAction;
    private CtaAction _positiveCtaAction;
    private String _questionHint;
    private String _questionId;
    private String _questionText;
    private String _questionTitle;
    private String _questionType;
    private List<String> _suggestedTagsList;

    public NpsSurveyQuestion(String str, String str2, String str3) {
        this._questionId = str;
        this._questionType = str2;
        this._questionText = str3;
    }

    public CtaAction getNegativeCtaAction() {
        return this._negativeCtaAction;
    }

    public CtaAction getPositiveCtaAction() {
        return this._positiveCtaAction;
    }

    public String getQuestionHint() {
        return this._questionHint;
    }

    public String getQuestionId() {
        return this._questionId;
    }

    public String getQuestionText() {
        return this._questionText;
    }

    public String getQuestionTitle() {
        return this._questionTitle;
    }

    public String getQuestionType() {
        return this._questionType;
    }

    public List<String> getSuggestedTagsList() {
        return this._suggestedTagsList;
    }

    public void setNegativeCtaAction(CtaAction ctaAction) {
        this._negativeCtaAction = ctaAction;
    }

    public void setPositiveCtaAction(CtaAction ctaAction) {
        this._positiveCtaAction = ctaAction;
    }

    public void setQuestionHint(String str) {
        this._questionHint = str;
    }

    public void setQuestionId(String str) {
        this._questionId = str;
    }

    public void setQuestionText(String str) {
        this._questionText = str;
    }

    public void setQuestionTitle(String str) {
        this._questionTitle = str;
    }

    public void setSuggestedTagsList(List<String> list) {
        this._suggestedTagsList = list;
    }
}
