package app.zophop.models.mTicketing;

public class AgencyProfileField {
    private final boolean _editable;
    private String _existingValue;
    private final String _fieldName;

    public AgencyProfileField(boolean z, String str, String str2) {
        this._editable = z;
        this._existingValue = str;
        this._fieldName = str2;
    }

    public String getExistingValue() {
        return this._existingValue;
    }

    public String getFieldName() {
        return this._fieldName;
    }

    public boolean isEditable() {
        return this._editable;
    }

    public void setExistingValue(String str) {
        this._existingValue = str;
    }
}
