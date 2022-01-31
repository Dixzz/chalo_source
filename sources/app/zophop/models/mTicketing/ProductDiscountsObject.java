package app.zophop.models.mTicketing;

import java.util.List;

public class ProductDiscountsObject {
    public static final String KEY_ACTION = "action";
    public static final String KEY_DELIMITER = ":";
    public static final String KEY_ENABLED = "enabled";
    public static final String KEY_HIGHLIGHT = "highlight";
    public static final String KEY_IMG_URL = "imgUrl";
    public static final String KEY_IMPRESSION_THRESHOLD = "impressionThreshold";
    public static final String KEY_ORDER = "order";
    public static final String KEY_PRODUCT_TYPE_DEFAULT = "default";
    public static final String KEY_PRODUCT_TYPE_MTICKET = "mticket";
    public static final String KEY_PRODUCT_TYPE_ROUTE_PASS = "routepass";
    public static final String KEY_ROUTES = "routes";
    public static final String KEY_SHOW_IMAGE = "imgVisible";
    public static final String KEY_TEXT = "text";
    public static final String KEY_VERSION = "version";
    private String _action;
    private String _bookingType;
    private String _highlight;
    private String _imageUrl;
    private int _impressionThreshold;
    private boolean _isEnabled;
    private int _order;
    private List<String> _routes;
    private boolean _showDiscountImage;
    private String _text;
    private int _version;

    public String getAction() {
        return this._action;
    }

    public String getBookingType() {
        return this._bookingType;
    }

    public String getHighlight() {
        return this._highlight;
    }

    public String getImageUrl() {
        return this._imageUrl;
    }

    public int getImpressionThreshold() {
        return this._impressionThreshold;
    }

    public int getOrder() {
        return this._order;
    }

    public List<String> getRoutes() {
        return this._routes;
    }

    public String getText() {
        return this._text;
    }

    public int getVersion() {
        return this._version;
    }

    public boolean isIsEnabled() {
        return this._isEnabled;
    }

    public boolean isShowDiscountImage() {
        return this._showDiscountImage;
    }

    public void setAction(String str) {
        this._action = str;
    }

    public void setBookingType(String str) {
        this._bookingType = str;
    }

    public void setHighlight(String str) {
        this._highlight = str;
    }

    public void setImageUrl(String str) {
        this._imageUrl = str;
    }

    public void setImpressionThreshold(int i) {
        this._impressionThreshold = i;
    }

    public void setIsEnabled(boolean z) {
        this._isEnabled = z;
    }

    public void setOrder(int i) {
        this._order = i;
    }

    public void setRoutes(List<String> list) {
        this._routes = list;
    }

    public void setShowDiscountImage(boolean z) {
        this._showDiscountImage = z;
    }

    public void setText(String str) {
        this._text = str;
    }

    public void setVersion(int i) {
        this._version = i;
    }
}
