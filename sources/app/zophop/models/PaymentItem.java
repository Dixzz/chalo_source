package app.zophop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PaymentItem implements Parcelable {
    public static final Parcelable.Creator<PaymentItem> CREATOR = new Parcelable.Creator<PaymentItem>() {
        /* class app.zophop.models.PaymentItem.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public PaymentItem createFromParcel(Parcel parcel) {
            return new PaymentItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PaymentItem[] newArray(int i) {
            return new PaymentItem[i];
        }
    };
    public int _appLogoDrawale;
    private String _appLogoUrl;
    private final String _appName;
    private String _bankName;
    private CardDetails _cardDetails;
    private String _desc;
    private boolean _isFromBankingScreen;
    private boolean _isItemEnabled;
    private boolean _isLazypayDisabled;
    private boolean _isModeEnable;
    private boolean _isPreferredMode;
    private String _label;
    private String _methodType;
    private String _packageName;
    private final String _tagName;
    private final String _warningMsg;

    public PaymentItem(Parcel parcel) {
        this._appLogoUrl = parcel.readString();
        this._appName = parcel.readString();
        this._packageName = parcel.readString();
        this._appLogoDrawale = parcel.readInt();
        this._bankName = parcel.readString();
        this._tagName = parcel.readString();
        boolean z = true;
        this._isPreferredMode = parcel.readByte() != 0;
        this._cardDetails = (CardDetails) parcel.readValue(CardDetails.class.getClassLoader());
        this._isFromBankingScreen = parcel.readByte() != 0;
        this._isItemEnabled = parcel.readByte() != 0;
        this._isModeEnable = parcel.readByte() == 0 ? false : z;
        this._desc = parcel.readString();
        this._label = parcel.readString();
        this._warningMsg = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public int getAppLogoDrawale() {
        return this._appLogoDrawale;
    }

    public String getAppLogoUrl() {
        return this._appLogoUrl;
    }

    public String getAppName() {
        return this._appName;
    }

    public String getBankName() {
        return this._bankName;
    }

    public CardDetails getCardDetails() {
        return this._cardDetails;
    }

    public String getDesc() {
        return this._desc;
    }

    public String getLabel() {
        return this._label;
    }

    public String getPackageName() {
        return this._packageName;
    }

    public String getTagName() {
        return this._tagName;
    }

    public String getWarningMsg() {
        return this._warningMsg;
    }

    public boolean isEnabled() {
        return this._isItemEnabled;
    }

    public boolean isLazypayDisabled() {
        return this._isLazypayDisabled;
    }

    public boolean isModeEnable() {
        return this._isModeEnable;
    }

    public boolean isPreferredMode() {
        return this._isPreferredMode;
    }

    public boolean is_isLazypayDisabled() {
        return this._isLazypayDisabled;
    }

    public void putBankName(String str) {
        this._bankName = str;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this._cardDetails = cardDetails;
    }

    public void setDesc(String str) {
        this._desc = str;
    }

    public void setIsEnabled(boolean z) {
        this._isItemEnabled = z;
    }

    public void setIsModeEnable(boolean z) {
        this._isModeEnable = z;
    }

    public void setLabel(String str) {
        this._label = str;
    }

    public void setPackageName(String str) {
        this._packageName = str;
    }

    public void setPreferredMode(boolean z) {
        this._isPreferredMode = z;
    }

    public void set_isLazypayDisabled(boolean z) {
        this._isLazypayDisabled = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._appLogoUrl);
        parcel.writeString(this._appName);
        parcel.writeString(this._packageName);
        parcel.writeInt(this._appLogoDrawale);
        parcel.writeString(this._bankName);
        parcel.writeString(this._tagName);
        parcel.writeByte(this._isPreferredMode ? (byte) 1 : 0);
        parcel.writeValue(this._cardDetails);
        parcel.writeByte(this._isFromBankingScreen ? (byte) 1 : 0);
        parcel.writeByte(this._isItemEnabled ? (byte) 1 : 0);
        parcel.writeByte(this._isModeEnable ? (byte) 1 : 0);
        parcel.writeString(this._desc);
        parcel.writeString(this._label);
        parcel.writeString(this._warningMsg);
    }

    public PaymentItem(String str, String str2, String str3, boolean z, String str4) {
        this._appLogoUrl = str;
        this._appName = str2;
        this._tagName = str3;
        this._isItemEnabled = z;
        this._warningMsg = str4;
    }

    public PaymentItem(int i, String str, String str2, boolean z, String str3) {
        this._appLogoDrawale = i;
        this._appName = str;
        this._tagName = str2;
        this._isItemEnabled = z;
        this._warningMsg = str3;
    }
}
