package app.zophop.pubsub.eventbus.events;

public class UserProfileEvent {
    private RESPONSE_CODE _code;
    private final TYPE _eventType;
    private String _message;
    private final ad1 _responseType;

    public enum RESPONSE_CODE {
        SUCCESS,
        USER_NOT_FOUND,
        JSON_EXCEPTION,
        VOLLEY_ERROR
    }

    public enum TYPE {
        REGISTRATION,
        PROFILE_FETCH,
        PROFILE_UPDATE,
        CONFIRM_PROFILE,
        REGISTRATION_DETAIL_UPDATE,
        LOGOUT
    }

    public UserProfileEvent(ad1 ad1, TYPE type) {
        this._responseType = ad1;
        this._eventType = type;
    }

    public RESPONSE_CODE getCode() {
        return this._code;
    }

    public String getMessage() {
        return this._message;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public TYPE getUserProfileEventType() {
        return this._eventType;
    }

    public UserProfileEvent(ad1 ad1, TYPE type, String str) {
        this._responseType = ad1;
        this._eventType = type;
        this._message = str;
    }

    public UserProfileEvent(ad1 ad1, TYPE type, RESPONSE_CODE response_code) {
        this._responseType = ad1;
        this._eventType = type;
        this._code = response_code;
    }

    public UserProfileEvent(ad1 ad1, TYPE type, String str, RESPONSE_CODE response_code) {
        this._responseType = ad1;
        this._eventType = type;
        this._message = str;
        this._code = response_code;
    }
}
