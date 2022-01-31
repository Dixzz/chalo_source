package app.zophop.models.mTicketing;

public class ProductPromotionsObject {
    public static final String KEY_ACTION = "action";
    public static final String KEY_BACKGROUND = "background";
    public static final String KEY_BODY = "body";
    public static final String KEY_CITIES = "cities";
    public static final String KEY_CTA = "cta";
    public static final String KEY_DEFAULT_USER = "defaultUser";
    public static final String KEY_DISMISS_CONDITIONS = "dismissConditions";
    public static final String KEY_DISPLAY_THRESHOLD = "displayThreshold";
    public static final String KEY_ENABLED = "enabled";
    public static final String KEY_HEADER = "header";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_NEGATIVE_BTN = "negativeBtn";
    public static final String KEY_NEW_USER = "newUser";
    public static final String KEY_POSITIVE_BTN = "positiveBtn";
    public static final String KEY_PROMOTION_TYPE_AWARENESS = "awareness";
    public static final String KEY_REPEAT_USER = "repeatUser";
    public static final String KEY_TEXT = "text";
    public static final String KEY_TITLE = "title";
    public static final String KEY_URL = "url";
    public static final String KEY_VERSION = "version";
    public static final String KEY_VISIBILITY = "visible";
    private String _action;
    private String _bgUrl;
    private boolean _bgVisibility;
    private String _bodyText;
    private boolean _bodyVisibility;
    private String _headerText;
    private boolean _headerVisibility;
    private String _imgUrl;
    private boolean _imgVisibility;
    private boolean _isEnabled;
    private boolean _isNewUser;
    private String _negativeBtnCta;
    private String _negativeBtnText;
    private boolean _negativeBtnVisibility;
    private String _positiveBtnCta;
    private String _positiveBtnText;
    private boolean _positiveBtnVisibility;
    private int _revisionVersion;
    private int _threshold;
    private String _titleText;
    private boolean _titleVisibility;

    public String getAction() {
        return this._action;
    }

    public String getBgUrl() {
        return this._bgUrl;
    }

    public boolean getBgVisibility() {
        return this._bgVisibility;
    }

    public String getBodyText() {
        return this._bodyText;
    }

    public boolean getBodyVisibility() {
        return this._bodyVisibility;
    }

    public String getHeaderText() {
        return this._headerText;
    }

    public boolean getHeaderVisibility() {
        return this._headerVisibility;
    }

    public String getImgUrl() {
        return this._imgUrl;
    }

    public boolean getImgVisibility() {
        return this._imgVisibility;
    }

    public boolean getIsEnabled() {
        return this._isEnabled;
    }

    public String getNegativeBtnCta() {
        return this._negativeBtnCta;
    }

    public String getNegativeBtnText() {
        return this._negativeBtnText;
    }

    public boolean getNegativeBtnVisibility() {
        return this._negativeBtnVisibility;
    }

    public String getPositiveBtnCta() {
        return this._positiveBtnCta;
    }

    public String getPositiveBtnText() {
        return this._positiveBtnText;
    }

    public boolean getPositiveBtnVisibility() {
        return this._positiveBtnVisibility;
    }

    public int getRevisionVersion() {
        return this._revisionVersion;
    }

    public int getThreshold() {
        return this._threshold;
    }

    public String getTitleText() {
        return this._titleText;
    }

    public boolean getTitleVisibility() {
        return this._titleVisibility;
    }

    public boolean isIsNewUser() {
        return this._isNewUser;
    }

    public void setAction(String str) {
        this._action = str;
    }

    public void setBgUrl(String str) {
        this._bgUrl = str;
    }

    public void setBgVisibility(boolean z) {
        this._bgVisibility = z;
    }

    public void setBodyText(String str) {
        this._bodyText = str;
    }

    public void setBodyVisibility(boolean z) {
        this._bodyVisibility = z;
    }

    public void setHeaderText(String str) {
        this._headerText = str;
    }

    public void setHeaderVisibility(boolean z) {
        this._headerVisibility = z;
    }

    public void setImgUrl(String str) {
        this._imgUrl = str;
    }

    public void setImgVisibility(boolean z) {
        this._imgVisibility = z;
    }

    public void setIsEnabled(boolean z) {
        this._isEnabled = z;
    }

    public void setIsNewUser(boolean z) {
        this._isNewUser = z;
    }

    public void setNegativeBtnCta(String str) {
        this._negativeBtnCta = str;
    }

    public void setNegativeBtnText(String str) {
        this._negativeBtnText = str;
    }

    public void setNegativeBtnVisibility(boolean z) {
        this._negativeBtnVisibility = z;
    }

    public void setPositiveBtnCta(String str) {
        this._positiveBtnCta = str;
    }

    public void setPositiveBtnText(String str) {
        this._positiveBtnText = str;
    }

    public void setPositiveBtnVisibility(boolean z) {
        this._positiveBtnVisibility = z;
    }

    public void setRevisionVersion(int i) {
        this._revisionVersion = i;
    }

    public void setThreshold(int i) {
        this._threshold = i;
    }

    public void setTitleText(String str) {
        this._titleText = str;
    }

    public void setTitleVisibility(boolean z) {
        this._titleVisibility = z;
    }
}
