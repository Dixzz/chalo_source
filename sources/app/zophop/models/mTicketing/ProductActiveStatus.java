package app.zophop.models.mTicketing;

public class ProductActiveStatus {
    private String _inactiveReason;
    private boolean _isActive;

    public ProductActiveStatus(boolean z, String str) {
        this._isActive = z;
        this._inactiveReason = str;
    }

    public String getInactiveReason() {
        return this._inactiveReason;
    }

    public boolean getIsActive() {
        return this._isActive;
    }

    public void setInactiveReason(String str) {
        this._inactiveReason = str;
    }

    public void setIsActive(boolean z) {
        this._isActive = z;
    }
}
