package app.zophop.models.PaymentMethod;

public class MethodDetails {
    private String _desc;
    private boolean _isTopMode;
    private boolean _isVisible;
    private String _label;
    private final String _methodName;
    private final boolean _methodStatus;
    private int _order;
    private String _warning;

    public MethodDetails(String str, boolean z) {
        this._methodName = str;
        this._methodStatus = z;
    }

    public String getDesc() {
        return this._desc;
    }

    public String getLabel() {
        return this._label;
    }

    public String getMethodName() {
        return this._methodName;
    }

    public boolean getMethodStatus() {
        return this._methodStatus;
    }

    public int getOrder() {
        return this._order;
    }

    public boolean getVisibility() {
        return this._isVisible;
    }

    public String getWarning() {
        return this._warning;
    }

    public boolean isTopMode() {
        return this._isTopMode;
    }

    public void setDesc(String str) {
        this._desc = str;
    }

    public void setIsTopMode(boolean z) {
        this._isTopMode = z;
    }

    public void setIsVisible(boolean z) {
        this._isVisible = z;
    }

    public void setLabel(String str) {
        this._label = str;
    }

    public void setOrder(int i) {
        this._order = i;
    }

    public void setWarning(String str) {
        this._warning = str;
    }
}
