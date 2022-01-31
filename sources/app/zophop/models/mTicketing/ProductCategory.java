package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ProductCategory implements Parcelable {
    public static final Parcelable.Creator<ProductCategory> CREATOR = new Parcelable.Creator<ProductCategory>() {
        /* class app.zophop.models.mTicketing.ProductCategory.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ProductCategory createFromParcel(Parcel parcel) {
            return new ProductCategory(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProductCategory[] newArray(int i) {
            return new ProductCategory[i];
        }
    };
    private String _catInfoNote;
    private String _categoryId;
    private String _categoryInfo;
    private boolean _categoryIsActive;
    private boolean _categoryIsRenewable;
    private boolean _categoryIsVerificationRequired;
    private int _categoryMaxIssueCount;
    private String _categoryName;
    private List<String> _categoryProofsList;
    private int _displayOrder;
    private String _documentDescription;
    private String _inactiveReason;
    private boolean _isVisible;
    private int _maxPricePerRide;
    private int _maxRidesPerDay;
    private int _position;

    public ProductCategory() {
    }

    public static ProductCategory fromJsonString(String str) {
        if (str == null) {
            return null;
        }
        return (ProductCategory) hj1.s(str, ProductCategory.class);
    }

    public static String toString(ProductCategory productCategory) {
        if (productCategory == null) {
            return null;
        }
        return new Gson().toJson(productCategory);
    }

    public int describeContents() {
        return 0;
    }

    public String getCategoryId() {
        return this._categoryId;
    }

    public String getCategoryInfo() {
        return this._categoryInfo;
    }

    public int getCategoryMaxIssueCount() {
        return this._categoryMaxIssueCount;
    }

    public List<String> getCategoryProofsList() {
        return this._categoryProofsList;
    }

    public String getDocumentDescription() {
        return this._documentDescription;
    }

    public String getInactiveReason() {
        return this._inactiveReason;
    }

    public int getPosition() {
        return this._position;
    }

    public String get_catInfoNote() {
        return this._catInfoNote;
    }

    public String get_categoryName() {
        return this._categoryName;
    }

    public int get_displayOrder() {
        return this._displayOrder;
    }

    public int get_maxPricePerRide() {
        return this._maxPricePerRide;
    }

    public int get_maxRidesPerDay() {
        return this._maxRidesPerDay;
    }

    public boolean isCategoryActive() {
        return this._categoryIsActive;
    }

    public boolean isCategoryIsRenewable() {
        return this._categoryIsRenewable;
    }

    public boolean isCategoryVerificationRequired() {
        return this._categoryIsVerificationRequired;
    }

    public boolean isVisible() {
        return this._isVisible;
    }

    public void setCategoryActive(boolean z) {
        this._categoryIsActive = z;
    }

    public void setCategoryId(String str) {
        this._categoryId = str;
    }

    public void setCategoryInfo(String str) {
        this._categoryInfo = str;
    }

    public void setCategoryIsRenewable(boolean z) {
        this._categoryIsRenewable = z;
    }

    public void setCategoryMaxIssueCount(int i) {
        this._categoryMaxIssueCount = i;
    }

    public void setCategoryProofsList(List<String> list) {
        this._categoryProofsList = list;
    }

    public void setCategoryVerificationRequired(boolean z) {
        this._categoryIsVerificationRequired = z;
    }

    public void setDocumentDescription(String str) {
        this._documentDescription = str;
    }

    public void setInactiveReason(String str) {
        this._inactiveReason = str;
    }

    public void setIsVisible(boolean z) {
        this._isVisible = z;
    }

    public void setPosition(int i) {
        this._position = i;
    }

    public void set_catInfoNote(String str) {
        this._catInfoNote = str;
    }

    public void set_categoryName(String str) {
        this._categoryName = str;
    }

    public void set_displayOrder(int i) {
        this._displayOrder = i;
    }

    public void set_maxPricePerRide(int i) {
        this._maxPricePerRide = i;
    }

    public void set_maxRidesPerDay(int i) {
        this._maxRidesPerDay = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._categoryId);
        if (this._categoryProofsList == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._categoryProofsList);
        }
        parcel.writeByte(this._categoryIsActive ? (byte) 1 : 0);
        parcel.writeByte(this._categoryIsRenewable ? (byte) 1 : 0);
        parcel.writeByte(this._categoryIsVerificationRequired ? (byte) 1 : 0);
        parcel.writeByte(this._isVisible ? (byte) 1 : 0);
        parcel.writeInt(this._categoryMaxIssueCount);
        parcel.writeString(this._categoryInfo);
        parcel.writeString(this._documentDescription);
        parcel.writeString(this._inactiveReason);
        parcel.writeString(this._categoryName);
        parcel.writeInt(this._displayOrder);
        parcel.writeInt(this._maxPricePerRide);
        parcel.writeInt(this._maxRidesPerDay);
        parcel.writeString(this._catInfoNote);
    }

    public ProductCategory(Parcel parcel) {
        this._categoryId = parcel.readString();
        boolean z = true;
        if (parcel.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this._categoryProofsList = arrayList;
            parcel.readList(arrayList, String.class.getClassLoader());
        } else {
            this._categoryProofsList = null;
        }
        this._categoryIsActive = parcel.readByte() != 0;
        this._categoryIsRenewable = parcel.readByte() != 0;
        this._isVisible = parcel.readByte() != 0;
        this._categoryIsVerificationRequired = parcel.readByte() == 0 ? false : z;
        this._categoryMaxIssueCount = parcel.readInt();
        this._categoryInfo = parcel.readString();
        this._documentDescription = parcel.readString();
        this._inactiveReason = parcel.readString();
        this._categoryName = parcel.readString();
        this._displayOrder = parcel.readInt();
        this._maxPricePerRide = parcel.readInt();
        this._maxRidesPerDay = parcel.readInt();
        this._catInfoNote = parcel.readString();
    }
}
