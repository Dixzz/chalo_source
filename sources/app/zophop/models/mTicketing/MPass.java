package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.CardDetails;
import app.zophop.models.RecentPaymentMethod;
import app.zophop.models.SuperSaver.RideInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MPass implements Parcelable {
    public static final Parcelable.Creator<MPass> CREATOR = new Parcelable.Creator<MPass>() {
        /* class app.zophop.models.mTicketing.MPass.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MPass[] newArray(int i) {
            return new MPass[0];
        }

        @Override // android.os.Parcelable.Creator
        public MPass createFromParcel(Parcel parcel) {
            return new MPass(parcel);
        }
    };
    private static String DUMMY_PARCEL_DEVICE_ID = "deviceId";
    private static String DUMMY_PARCEL_PAYMENT_DETAILS = "paymentDetails";
    private static String DUMMY_PARCEL_QR_CODE = "dummyQrCode";
    private static String DUMMY_PARCEL_REFERENCE_CODE = "referenceId";
    private String _agency;
    private String _bookingPassId;
    private BookingPassType _bookingPassType;
    private long _bookingTime;
    private List<CardDetails> _cardDetails;
    private String _catDisName;
    private String _cityName;
    private String _configId;
    private String _customerId;
    private String _deviceId;
    private Map<String, String> _displayProps;
    private long _expiryTime;
    private double _fare;
    private ProductCategory _grouping;
    private boolean _hasPassExpired;
    private boolean _isPaymentRequired;
    private boolean _isVerificationRequired;
    private int _maxTrips;
    private int _maxTripsPerDay;
    private int _maxTripsPrice;
    private int _noOfDays;
    private PassApplicationActionRequired _passApplicationActionRequired;
    private PassApplicationRejectionReasons _passApplicationRejectionReasons;
    private String _passRejectionReason;
    private String _passengerType;
    private String _paymentMode;
    private String _productCategory;
    private String _productName;
    private String _productType;
    private List<MagicPassPunchInfo> _punches;
    private String _qrCode;
    private List<RecentPaymentMethod> _recentPaymentMethod;
    private String _referenceId;
    private int _remainingTrips;
    private List<RideInfo> _rideInfo;
    private RouteStopsInfo _routeStopsInfo;
    private List<String> _specialFeatures;
    private long _startingTime;
    private String _status;
    private TicketStatus _ticketStatus;
    private String _tone;
    private UserProfile _userProfile;
    private int _validity;
    private long _verificationExpiryTime;
    private String orderId;

    public MPass(UserProfile userProfile, String str, String str2, double d, int i) {
        this._remainingTrips = -1;
        this._maxTrips = -1;
        this._maxTripsPerDay = -1;
        this._userProfile = userProfile;
        this._bookingPassType = BookingPassType.MAGIC;
        this._passengerType = str;
        this._agency = str2;
        this._fare = d;
        this._noOfDays = i;
        this._punches = new ArrayList();
        this._ticketStatus = TicketStatus.UNUSED;
        this._displayProps = new HashMap();
        this._hasPassExpired = false;
        this._isPaymentRequired = true;
        this._passApplicationRejectionReasons = new PassApplicationRejectionReasons();
        this._passApplicationActionRequired = PassApplicationActionRequired.FRESH;
    }

    public static Map<String, String> fromMapString(String str) {
        return (Map) new Gson().fromJson(str, new TypeToken<Map<String, String>>() {
            /* class app.zophop.models.mTicketing.MPass.AnonymousClass3 */
        }.getType());
    }

    public static List<MagicPassPunchInfo> fromPunchString(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<MagicPassPunchInfo>>() {
            /* class app.zophop.models.mTicketing.MPass.AnonymousClass2 */
        }.getType());
    }

    public static String fromStringMap(Map<String, String> map) {
        Gson gson = new Gson();
        if (map != null) {
            return gson.toJson(map);
        }
        return null;
    }

    public static String toPunchString(List<MagicPassPunchInfo> list) {
        return new Gson().toJson(list);
    }

    public void addPunch(MagicPassPunchInfo magicPassPunchInfo) {
        this._punches.add(magicPassPunchInfo);
        Collections.sort(this._punches);
    }

    public int describeContents() {
        return 0;
    }

    public String getAgency() {
        return this._agency;
    }

    public String getBookingPassId() {
        return this._bookingPassId;
    }

    public long getBookingTime() {
        return this._bookingTime;
    }

    public List<CardDetails> getCardDetails() {
        return this._cardDetails;
    }

    public String getCity() {
        return this._cityName;
    }

    public String getConfigId() {
        return this._configId;
    }

    public String getCustomerId() {
        return this._customerId;
    }

    public String getDeviceId() {
        return this._deviceId;
    }

    public Map<String, String> getDisplayProps() {
        return this._displayProps;
    }

    public long getExpiryTime() {
        return this._expiryTime;
    }

    public double getFare() {
        return this._fare;
    }

    public MagicPassPunchInfo getLastPunch() {
        int size = this._punches.size() - 1;
        if (size >= 0) {
            return this._punches.get(size);
        }
        return null;
    }

    public int getNoOfDays() {
        return this._noOfDays;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public BookingPassType getPassBookingType() {
        return this._bookingPassType;
    }

    public String getPassRejectionReason() {
        return this._passRejectionReason;
    }

    public String getPassengerType() {
        return this._passengerType;
    }

    public String getPaymentMode() {
        return this._paymentMode;
    }

    public List<MagicPassPunchInfo> getPunches() {
        return this._punches;
    }

    public String getQrCode() {
        return this._qrCode;
    }

    public List<RecentPaymentMethod> getRecentPaymentMethod() {
        return this._recentPaymentMethod;
    }

    public String getReferenceId() {
        return this._referenceId;
    }

    public RouteStopsInfo getRouteStopsInfo() {
        return this._routeStopsInfo;
    }

    public List<String> getSpecialFeatures() {
        return this._specialFeatures;
    }

    public long getStartingTime() {
        return this._startingTime;
    }

    public String getStatus() {
        return this._status;
    }

    public TicketStatus getTicketStatus() {
        return this._ticketStatus;
    }

    public String getTone() {
        if (AnalyticsConstants.NULL.equalsIgnoreCase(this._tone)) {
            return null;
        }
        return this._tone;
    }

    public UserProfile getUserProfile() {
        return this._userProfile;
    }

    public int getValidity() {
        return this._validity;
    }

    public long getVerificationExpiryTime() {
        return this._verificationExpiryTime;
    }

    public BookingPassType get_bookingPassType() {
        return this._bookingPassType;
    }

    public String get_catDisName() {
        return this._catDisName;
    }

    public String get_cityName() {
        return this._cityName;
    }

    public ProductCategory get_grouping() {
        return this._grouping;
    }

    public int get_maxTrips() {
        return this._maxTrips;
    }

    public int get_maxTripsPerDay() {
        return this._maxTripsPerDay;
    }

    public int get_maxTripsPrice() {
        return this._maxTripsPrice;
    }

    public PassApplicationActionRequired get_passApplicationActionRequired() {
        PassApplicationActionRequired passApplicationActionRequired = this._passApplicationActionRequired;
        return passApplicationActionRequired == null ? PassApplicationActionRequired.INVALID : passApplicationActionRequired;
    }

    public PassApplicationRejectionReasons get_passApplicationRejectionReasons() {
        return this._passApplicationRejectionReasons;
    }

    public String get_productCategory() {
        return this._productCategory;
    }

    public String get_productName() {
        return this._productName;
    }

    public String get_productType() {
        return this._productType;
    }

    public int get_remainingTrips() {
        return this._remainingTrips;
    }

    public List<RideInfo> get_rideInfo() {
        return this._rideInfo;
    }

    public boolean isPassExpired() {
        return this._hasPassExpired;
    }

    public boolean isPaymentRequired() {
        return this._isPaymentRequired;
    }

    public boolean is_hasPassExpired() {
        return this._hasPassExpired;
    }

    public boolean is_isVerificationRequired() {
        return this._isVerificationRequired;
    }

    public void setAgency(String str) {
        this._agency = str;
    }

    public void setBookingPassId(String str) {
        this._bookingPassId = str;
    }

    public void setBookingTime(long j) {
        this._bookingTime = j;
    }

    public void setCardDetails(List<CardDetails> list) {
        this._cardDetails = list;
    }

    public void setCity(String str) {
        this._cityName = str;
    }

    public void setConfigId(String str) {
        this._configId = str;
    }

    public void setCustomerId(String str) {
        this._customerId = str;
    }

    public void setDeviceId(String str) {
        this._deviceId = str;
    }

    public void setDisplayProps(Map<String, String> map) {
        this._displayProps = map;
    }

    public void setExpiryTime(long j) {
        this._expiryTime = j;
    }

    public void setFare(double d) {
        this._fare = d;
    }

    public void setNoOfDays(int i) {
        this._noOfDays = i;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPassExpired(boolean z) {
        this._hasPassExpired = z;
    }

    public void setPassRejectionReason(String str) {
        this._passRejectionReason = str;
    }

    public void setPassengerType(String str) {
        this._passengerType = str;
    }

    public void setPaymentMode(String str) {
        this._paymentMode = str;
    }

    public void setPaymentRequired(boolean z) {
        this._isPaymentRequired = z;
    }

    public void setPunches(List<MagicPassPunchInfo> list) {
        this._punches = list;
    }

    public void setQrCode(String str) {
        this._qrCode = str;
    }

    public void setRecentPaymentMethod(List<RecentPaymentMethod> list) {
        this._recentPaymentMethod = list;
    }

    public void setReferenceId(String str) {
        this._referenceId = str;
    }

    public void setRouteStopsInfo(RouteStopsInfo routeStopsInfo) {
        this._routeStopsInfo = routeStopsInfo;
    }

    public void setSpecialFeatures(List<String> list) {
        this._specialFeatures = list;
    }

    public void setStartingTime(long j) {
        this._startingTime = j;
    }

    public void setStatus(String str) {
        this._status = str;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this._ticketStatus = ticketStatus;
    }

    public void setTone(String str) {
        this._tone = str;
    }

    public void setUserProfile(UserProfile userProfile) {
        this._userProfile = userProfile;
    }

    public void setValidity(int i) {
        this._validity = i;
    }

    public void setVerificationExpiryTime(long j) {
        this._verificationExpiryTime = j;
    }

    public void set_bookingPassType(BookingPassType bookingPassType) {
        this._bookingPassType = bookingPassType;
    }

    public void set_catDisName(String str) {
        this._catDisName = str;
    }

    public void set_cityName(String str) {
        this._cityName = str;
    }

    public void set_grouping(ProductCategory productCategory) {
        this._grouping = productCategory;
    }

    public void set_hasPassExpired(boolean z) {
        this._hasPassExpired = z;
    }

    public void set_isPaymentRequired(boolean z) {
        this._isPaymentRequired = z;
    }

    public void set_isVerificationRequired(boolean z) {
        this._isVerificationRequired = z;
    }

    public void set_maxTrips(int i) {
        this._maxTrips = i;
    }

    public void set_maxTripsPerDay(int i) {
        this._maxTripsPerDay = i;
    }

    public void set_maxTripsPrice(int i) {
        this._maxTripsPrice = i;
    }

    public void set_passApplicationActionRequired(PassApplicationActionRequired passApplicationActionRequired) {
        this._passApplicationActionRequired = passApplicationActionRequired;
    }

    public void set_passApplicationRejectionReasons(PassApplicationRejectionReasons passApplicationRejectionReasons) {
        this._passApplicationRejectionReasons = passApplicationRejectionReasons;
    }

    public void set_productCategory(String str) {
        this._productCategory = str;
    }

    public void set_productName(String str) {
        this._productName = str;
    }

    public void set_productType(String str) {
        this._productType = str;
    }

    public void set_remainingTrips(int i) {
        this._remainingTrips = i;
    }

    public void set_rideInfo(List<RideInfo> list) {
        this._rideInfo = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._bookingPassId);
        parcel.writeString(this._referenceId);
        parcel.writeValue(this._bookingPassType);
        parcel.writeValue(this._userProfile);
        parcel.writeLong(this._bookingTime);
        parcel.writeLong(this._expiryTime);
        parcel.writeLong(this._startingTime);
        parcel.writeString(this._passengerType);
        parcel.writeValue(this._ticketStatus);
        parcel.writeString(this._agency);
        parcel.writeDouble(this._fare);
        parcel.writeInt(this._noOfDays);
        if (this._punches == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._punches);
        }
        if (this._rideInfo == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._rideInfo);
        }
        parcel.writeString(this._qrCode);
        parcel.writeString(this._status);
        parcel.writeString(this._paymentMode);
        parcel.writeInt(this._validity);
        parcel.writeLong(this._verificationExpiryTime);
        parcel.writeString(this._cityName);
        parcel.writeString(this._passRejectionReason);
        parcel.writeByte(this._isVerificationRequired ? (byte) 1 : 0);
        parcel.writeByte(this._hasPassExpired ? (byte) 1 : 0);
        parcel.writeString(this._deviceId);
        parcel.writeString(this._customerId);
        if (this._recentPaymentMethod == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._recentPaymentMethod);
        }
        if (this._cardDetails == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._cardDetails);
        }
        parcel.writeString(this._configId);
        parcel.writeString(this.orderId);
        parcel.writeByte(this._isPaymentRequired ? (byte) 1 : 0);
        if (this._specialFeatures == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._specialFeatures);
        }
        parcel.writeMap(this._displayProps);
        parcel.writeValue(this._routeStopsInfo);
        parcel.writeString(this._productName);
        parcel.writeValue(this._grouping);
        parcel.writeString(this._productType);
        parcel.writeString(this._productCategory);
        parcel.writeInt(this._remainingTrips);
        parcel.writeInt(this._maxTrips);
        parcel.writeInt(this._maxTripsPerDay);
        parcel.writeString(this._catDisName);
        parcel.writeInt(this._maxTripsPrice);
        parcel.writeString(this._tone);
        parcel.writeValue(this._passApplicationRejectionReasons);
        parcel.writeValue(this._passApplicationActionRequired);
    }

    public MPass() {
        this._remainingTrips = -1;
        this._maxTrips = -1;
        this._maxTripsPerDay = -1;
        this._passApplicationRejectionReasons = new PassApplicationRejectionReasons();
        this._passApplicationActionRequired = PassApplicationActionRequired.FRESH;
    }

    public MPass(Parcel parcel) {
        this._remainingTrips = -1;
        this._maxTrips = -1;
        this._maxTripsPerDay = -1;
        this._bookingPassId = parcel.readString();
        this._referenceId = parcel.readString();
        this._bookingPassType = (BookingPassType) parcel.readValue(BookingPassType.class.getClassLoader());
        this._userProfile = (UserProfile) parcel.readValue(UserProfile.class.getClassLoader());
        this._bookingTime = parcel.readLong();
        this._expiryTime = parcel.readLong();
        this._startingTime = parcel.readLong();
        this._passengerType = parcel.readString();
        this._ticketStatus = (TicketStatus) parcel.readValue(TicketStatus.class.getClassLoader());
        this._agency = parcel.readString();
        this._fare = parcel.readDouble();
        this._noOfDays = parcel.readInt();
        if (parcel.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this._punches = arrayList;
            parcel.readList(arrayList, MagicPassPunchInfo.class.getClassLoader());
        } else {
            this._punches = null;
        }
        if (parcel.readByte() == 1) {
            this._rideInfo = new ArrayList();
            parcel.readList(this._punches, RideInfo.class.getClassLoader());
        } else {
            this._rideInfo = null;
        }
        this._qrCode = parcel.readString();
        this._status = parcel.readString();
        this._paymentMode = parcel.readString();
        this._validity = parcel.readInt();
        this._verificationExpiryTime = parcel.readLong();
        this._cityName = parcel.readString();
        this._passRejectionReason = parcel.readString();
        boolean z = false;
        this._isVerificationRequired = parcel.readByte() != 0;
        this._hasPassExpired = parcel.readByte() != 0;
        this._deviceId = parcel.readString();
        this._customerId = parcel.readString();
        if (parcel.readByte() == 1) {
            ArrayList arrayList2 = new ArrayList();
            this._recentPaymentMethod = arrayList2;
            parcel.readList(arrayList2, RecentPaymentMethod.class.getClassLoader());
        } else {
            this._recentPaymentMethod = null;
        }
        if (parcel.readByte() == 1) {
            ArrayList arrayList3 = new ArrayList();
            this._cardDetails = arrayList3;
            parcel.readList(arrayList3, CardDetails.class.getClassLoader());
        } else {
            this._cardDetails = null;
        }
        this._configId = parcel.readString();
        this.orderId = parcel.readString();
        this._isPaymentRequired = parcel.readByte() != 0 ? true : z;
        if (parcel.readByte() == 1) {
            ArrayList arrayList4 = new ArrayList();
            this._specialFeatures = arrayList4;
            parcel.readList(arrayList4, String.class.getClassLoader());
        } else {
            this._specialFeatures = null;
        }
        this._displayProps = parcel.readHashMap(getClass().getClassLoader());
        this._routeStopsInfo = (RouteStopsInfo) parcel.readValue(RouteStopsInfo.class.getClassLoader());
        this._productName = parcel.readString();
        this._grouping = (ProductCategory) parcel.readValue(ProductCategory.class.getClassLoader());
        this._productType = parcel.readString();
        this._productCategory = parcel.readString();
        this._remainingTrips = parcel.readInt();
        this._maxTrips = parcel.readInt();
        this._maxTripsPerDay = parcel.readInt();
        this._catDisName = parcel.readString();
        this._maxTripsPrice = parcel.readInt();
        this._tone = parcel.readString();
        this._passApplicationRejectionReasons = (PassApplicationRejectionReasons) parcel.readValue(PassApplicationRejectionReasons.class.getClassLoader());
        this._passApplicationActionRequired = (PassApplicationActionRequired) parcel.readValue(PassApplicationActionRequired.class.getClassLoader());
    }
}
