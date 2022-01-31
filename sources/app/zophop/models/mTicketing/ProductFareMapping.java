package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class ProductFareMapping implements Parcelable {
    public static final Parcelable.Creator<ProductFareMapping> CREATOR = new Parcelable.Creator<ProductFareMapping>() {
        /* class app.zophop.models.mTicketing.ProductFareMapping.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ProductFareMapping createFromParcel(Parcel parcel) {
            return new ProductFareMapping(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProductFareMapping[] newArray(int i) {
            return new ProductFareMapping[i];
        }
    };
    private String _categoryId;
    private FareInfo _fareInfo;
    private int _fareMappingId;
    private Boolean _isActive;
    private Boolean _isRenewable;
    private Boolean _isVerificationRequired;
    private boolean _isVisible;
    private double _maxPricePerRide;
    private List<String> _proofsRequiredList;
    private String _subCategoryId;
    private String additionalInfo;
    private String desc;
    private int discountFare;
    private int discountPercentage;
    private long durationId;
    private String durationInfo;
    private String durationString;
    private int fare;
    private String inactiveReason;
    private int inactiveReasonPriority;
    private int maxRides;
    private int maxRidesPerDay;
    private String productDisplayName;
    private ProductDuration productDuration;
    private List<String> specialFeatures;

    public ProductFareMapping() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public String getCategoryId() {
        return this._categoryId;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getDiscountFare() {
        return this.discountFare;
    }

    public int getDiscountPercentage() {
        return this.discountPercentage;
    }

    public String getDurationDisplayName() {
        if (TextUtils.isEmpty(this.productDisplayName)) {
            return ui1.j(String.valueOf(this.durationId));
        }
        return this.productDisplayName;
    }

    public long getDurationId() {
        return this.durationId;
    }

    public String getDurationInfo() {
        return this.durationInfo;
    }

    public String getDurationString() {
        return this.durationString;
    }

    public int getFare() {
        return this.fare;
    }

    public FareInfo getFareInfo() {
        return this._fareInfo;
    }

    public int getFareMappingId() {
        return this._fareMappingId;
    }

    public String getInactiveReason() {
        return this.inactiveReason;
    }

    public int getInactiveReasonPriority() {
        return this.inactiveReasonPriority;
    }

    public Boolean getIsActive() {
        return this._isActive;
    }

    public Boolean getLegacyIsActive() {
        Boolean bool = this._isActive;
        return bool == null ? Boolean.TRUE : bool;
    }

    public double getMaxPricePerRide() {
        return this._maxPricePerRide;
    }

    public int getMaxRides() {
        return this.maxRides;
    }

    public int getMaxRidesPerDay() {
        return this.maxRidesPerDay;
    }

    public int getNoOfDays() {
        return (int) (this.durationId / 86400000);
    }

    public String getProductDisplayName() {
        return this.productDisplayName;
    }

    public ProductDuration getProductDuration() {
        return this.productDuration;
    }

    public List<String> getProofsRequiredList() {
        return this._proofsRequiredList;
    }

    public List<String> getSpecialFeatures() {
        return this.specialFeatures;
    }

    public String getSubCategoryId() {
        return this._subCategoryId;
    }

    public Boolean isRenewable() {
        return this._isRenewable;
    }

    public Boolean isVerificationRequired() {
        return this._isVerificationRequired;
    }

    public boolean isVisible() {
        return this._isVisible;
    }

    public void setAdditionalInfo(String str) {
        this.additionalInfo = str;
    }

    public void setCategoryId(String str) {
        this._categoryId = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDiscountFare(int i) {
        this.discountFare = i;
    }

    public void setDiscountPercentage(int i) {
        this.discountPercentage = i;
    }

    public void setDurationId(long j) {
        this.durationId = j;
    }

    public void setDurationInfo(String str) {
        this.durationInfo = str;
    }

    public void setDurationString(String str) {
        this.durationString = str;
    }

    public void setFare(int i) {
        this.fare = i;
    }

    public void setFareInfo(FareInfo fareInfo) {
        this._fareInfo = fareInfo;
    }

    public void setFareMappingId(int i) {
        this._fareMappingId = i;
    }

    public void setInactiveReason(String str) {
        this.inactiveReason = str;
    }

    public void setInactiveReasonPriority(int i) {
        this.inactiveReasonPriority = i;
    }

    public void setIsActive(Boolean bool) {
        this._isActive = bool;
    }

    public void setIsRenewable(Boolean bool) {
        this._isRenewable = bool;
    }

    public void setIsVerificationRequired(Boolean bool) {
        this._isVerificationRequired = bool;
    }

    public void setIsVisible(boolean z) {
        this._isVisible = z;
    }

    public void setMaxPricePerRide(double d) {
        this._maxPricePerRide = d;
    }

    public void setMaxRides(int i) {
        this.maxRides = i;
    }

    public void setMaxRidesPerDay(int i) {
        this.maxRidesPerDay = i;
    }

    public void setProductDisplayName(String str) {
        this.productDisplayName = str;
    }

    public void setProductDuration(ProductDuration productDuration2) {
        this.productDuration = productDuration2;
    }

    public void setProofsRequiredList(List<String> list) {
        this._proofsRequiredList = list;
    }

    public void setSpecialFeatures(List<String> list) {
        this.specialFeatures = list;
    }

    public void setSubCategoryId(String str) {
        this._subCategoryId = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.durationId);
        parcel.writeString(this.durationString);
        parcel.writeInt(this.fare);
        parcel.writeInt(this.discountFare);
        parcel.writeInt(this.discountPercentage);
        parcel.writeString(this.additionalInfo);
        parcel.writeString(this.durationInfo);
        parcel.writeString(this.desc);
        if (this.specialFeatures == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.specialFeatures);
        }
        parcel.writeString(this.productDisplayName);
        parcel.writeByte(this._isActive.booleanValue() ? (byte) 1 : 0);
        parcel.writeString(this.inactiveReason);
        parcel.writeValue(this.productDuration);
        parcel.writeInt(this.inactiveReasonPriority);
        parcel.writeInt(this._fareMappingId);
        parcel.writeString(this._categoryId);
        parcel.writeString(this._subCategoryId);
        parcel.writeByte(this._isVisible ? (byte) 1 : 0);
        parcel.writeInt(this.maxRides);
        parcel.writeInt(this.maxRidesPerDay);
        parcel.writeDouble(this._maxPricePerRide);
        Boolean bool = this._isVerificationRequired;
        if (bool == null) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte(bool.booleanValue() ? (byte) 1 : 0);
        }
        Boolean bool2 = this._isRenewable;
        if (bool2 == null) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte(bool2.booleanValue() ? (byte) 1 : 0);
        }
        if (this._proofsRequiredList == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._proofsRequiredList);
        }
        parcel.writeValue(this._fareInfo);
    }

    public ProductFareMapping(Parcel parcel) {
        this.durationId = parcel.readLong();
        this.durationString = parcel.readString();
        this.fare = parcel.readInt();
        this.discountFare = parcel.readInt();
        this.discountPercentage = parcel.readInt();
        this.additionalInfo = parcel.readString();
        this.durationInfo = parcel.readString();
        this.desc = parcel.readString();
        if (parcel.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this.specialFeatures = arrayList;
            parcel.readList(arrayList, String.class.getClassLoader());
        } else {
            this.specialFeatures = new ArrayList();
        }
        this.productDisplayName = parcel.readString();
        boolean z = false;
        this._isActive = Boolean.valueOf(parcel.readByte() != 0);
        this.inactiveReason = parcel.readString();
        this.productDuration = (ProductDuration) parcel.readValue(ProductDuration.class.getClassLoader());
        this.inactiveReasonPriority = parcel.readInt();
        this._fareMappingId = parcel.readInt();
        this._categoryId = parcel.readString();
        this._subCategoryId = parcel.readString();
        this._isVisible = parcel.readByte() != 0;
        this.maxRides = parcel.readInt();
        this.maxRidesPerDay = parcel.readInt();
        this._maxPricePerRide = parcel.readDouble();
        this._isVerificationRequired = Boolean.valueOf(parcel.readByte() != 0);
        this._isRenewable = Boolean.valueOf(parcel.readByte() != 0 ? true : z);
        if (parcel.readByte() == 1) {
            ArrayList arrayList2 = new ArrayList();
            this._proofsRequiredList = arrayList2;
            parcel.readList(arrayList2, String.class.getClassLoader());
        } else {
            this._proofsRequiredList = new ArrayList();
        }
        this._fareInfo = (FareInfo) parcel.readValue(FareInfo.class.getClassLoader());
    }
}
