package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.CardDetails;
import app.zophop.models.LastRideInfo;
import app.zophop.models.RecentPaymentMethod;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;

public class MTicket implements Parcelable {
    public static final Parcelable.Creator<MTicket> CREATOR = new Parcelable.Creator<MTicket>() {
        /* class app.zophop.models.mTicketing.MTicket.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MTicket createFromParcel(Parcel parcel) {
            return new MTicket(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MTicket[] newArray(int i) {
            return new MTicket[i];
        }
    };
    private String _agency;
    private long _bookingTime;
    private List<CardDetails> _cardDetails;
    private String _cityName;
    private String _customerId;
    private String _deviceId;
    private long _expirationTime;
    private boolean _isExpired;
    private boolean _isFreeRide;
    private boolean _isPaymentRequired;
    private boolean _isUpTripActivated;
    private MTicketConfiguration _mTicketConfiguration;
    private String _mTicketId;
    private MTicketTripReceipt _mticketTripReceipt;
    private String _orderId;
    private HashMap<String, MTicketPassengerInfo> _passengerDetails;
    private String _paymentMode;
    private String _qrCode;
    private List<RecentPaymentMethod> _recentPaymentMethod;
    private String _status;
    private String _tone;
    private long _upTripActivationTime;
    private long _upTripPunchingTime;
    private RouteStopsInfo _upTripRouteStopsInfo;
    private RouteStopsInfo _upTripRouteStopsStageInfo;
    private String _userId;
    private UserProfile _userProfile;

    public MTicket(String str, String str2, String str3, MTicketConfiguration mTicketConfiguration) {
        this._userId = str;
        this._cityName = str2;
        this._agency = str3;
        this._mTicketConfiguration = mTicketConfiguration;
        this._passengerDetails = new HashMap<>();
        this._isExpired = false;
        this._isUpTripActivated = false;
        this._isPaymentRequired = true;
    }

    public static List<CardDetails> fromCardString(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<CardDetails>>() {
            /* class app.zophop.models.mTicketing.MTicket.AnonymousClass3 */
        }.getType());
    }

    public static HashMap<String, MTicketPassengerInfo> fromMapString(String str) {
        return (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, MTicketPassengerInfo>>() {
            /* class app.zophop.models.mTicketing.MTicket.AnonymousClass4 */
        }.getType());
    }

    public static List<RecentPaymentMethod> fromString(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<RecentPaymentMethod>>() {
            /* class app.zophop.models.mTicketing.MTicket.AnonymousClass2 */
        }.getType());
    }

    public static String fromStringMap(HashMap<String, MTicketPassengerInfo> hashMap) {
        Gson gson = new Gson();
        if (hashMap != null) {
            return gson.toJson(hashMap);
        }
        return null;
    }

    public static String toCardString(List<CardDetails> list) {
        return new Gson().toJson(list);
    }

    public static String toString(List<RecentPaymentMethod> list) {
        return new Gson().toJson(list);
    }

    public int describeContents() {
        return 0;
    }

    public long getActivationDuration() {
        if (getMTicketConfiguration() == null) {
            return 14400000;
        }
        return vn.y(getMTicketConfiguration().getId());
    }

    public String getAgency() {
        return this._agency;
    }

    public long getBookingTime() {
        return this._bookingTime;
    }

    public List<CardDetails> getCardDetails() {
        return this._cardDetails;
    }

    public String getCityName() {
        return this._cityName;
    }

    public String getCustomerId() {
        return this._customerId;
    }

    public String getDeviceId() {
        return this._deviceId;
    }

    public double getDiscountedFare() {
        double d;
        if (getPassengerDetails() != null) {
            d = 0.0d;
            for (MTicketPassengerInfo mTicketPassengerInfo : getPassengerDetails().values()) {
                if (mTicketPassengerInfo != null) {
                    d += mTicketPassengerInfo.getTotalFare();
                }
            }
        } else {
            d = 0.0d;
        }
        return d - FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public long getExpirationTime() {
        return this._expirationTime;
    }

    public MTicketConfiguration getMTicketConfiguration() {
        return this._mTicketConfiguration;
    }

    public long getMTicketExpirationTime() {
        if (!isMTicketActive()) {
            return getExpirationTime();
        }
        if (getBookingTime() > getUpTripActivationTime()) {
            return getExpirationTime();
        }
        return Math.min(getActivationDuration() + getUpTripActivationTime(), getExpirationTime());
    }

    public String getMTicketId() {
        return this._mTicketId;
    }

    public long getMTicketUsedTime() {
        if (isExpired()) {
            if (getUpTripPunchingTime() == 0) {
                return getExpirationTime();
            }
            return getUpTripPunchingTime();
        } else if (getExpirationTime() < ui1.Q()) {
            return getExpirationTime();
        } else {
            return getActivationDuration() + getUpTripActivationTime();
        }
    }

    public MTicketTripReceipt getMticketTripReceipt() {
        return this._mticketTripReceipt;
    }

    public String getOrderId() {
        return this._orderId;
    }

    public HashMap<String, MTicketPassengerInfo> getPassengerDetails() {
        return this._passengerDetails;
    }

    public String getPaymentMode() {
        return this._paymentMode;
    }

    public String getQrCode() {
        return this._qrCode;
    }

    public List<RecentPaymentMethod> getRecentPaymentMethod() {
        return this._recentPaymentMethod;
    }

    public String getStatus() {
        return this._status;
    }

    public String getTone() {
        if (AnalyticsConstants.NULL.equalsIgnoreCase(this._tone)) {
            return null;
        }
        return this._tone;
    }

    public double getTotalDiscountAmount() {
        return getTotalFareWithoutDiscount() - getDiscountedFare();
    }

    public double getTotalFare() {
        long j;
        long j2;
        int i = 0;
        if (getPassengerDetails() != null) {
            j2 = 0;
            j = 0;
            for (MTicketPassengerInfo mTicketPassengerInfo : getPassengerDetails().values()) {
                if (mTicketPassengerInfo != null) {
                    j2 = (long) (mTicketPassengerInfo.getIndividualTotalFareInPaisa() + ((double) j2));
                    i = mTicketPassengerInfo.getRoundingLogic();
                    if (isFreeRide()) {
                        j = Math.max(j, mTicketPassengerInfo.getTotalFareInPaisa());
                    }
                }
            }
        } else {
            j2 = 0;
            j = 0;
        }
        long j3 = j2 - j;
        if (i == 0) {
            return vn.o(j3);
        }
        if (i == 1) {
            return vn.o(j3 - (j3 % 100));
        }
        if (i == 2) {
            long j4 = j3 % 100;
            if (j4 == 0) {
                return vn.o(j3);
            }
            return vn.o((100 - j4) + j3);
        } else if (i != 3) {
            return vn.o(j3);
        } else {
            long j5 = j3 % 100;
            if (j5 == 0) {
                return vn.o(j3);
            }
            return vn.o(j5 < 50 ? j3 - j5 : j3 + (100 - j5));
        }
    }

    public double getTotalFareWithoutDiscount() {
        HashMap<String, MTicketPassengerInfo> passengerDetails = getPassengerDetails();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (passengerDetails != null) {
            for (MTicketPassengerInfo mTicketPassengerInfo : getPassengerDetails().values()) {
                if (mTicketPassengerInfo != null) {
                    d += mTicketPassengerInfo.getTotalFareWithoutDiscount();
                }
            }
        }
        return d;
    }

    public long getUpTripActivationTime() {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.s().b() == null || this._mTicketId != t1Var.s().b().getBookingId()) {
            return this._upTripActivationTime;
        }
        return t1Var.s().b().getActivationTimeStamp();
    }

    public long getUpTripPunchingTime() {
        return this._upTripPunchingTime;
    }

    public RouteStopsInfo getUpTripRouteStopsInfo() {
        return this._upTripRouteStopsInfo;
    }

    public RouteStopsInfo getUpTripRouteStopsStageInfo() {
        return this._upTripRouteStopsStageInfo;
    }

    public String getUserId() {
        return this._userId;
    }

    public UserProfile get_userProfile() {
        return this._userProfile;
    }

    public boolean isExpired() {
        return this._isExpired;
    }

    public boolean isFreeRide() {
        return this._isFreeRide;
    }

    public boolean isMTicketActive() {
        LastRideInfo b = xt.f3961a.s().b();
        if (b == null || b.getBookingId() != this._mTicketId) {
            return isUpTripActivated();
        }
        if (!isUpTripActivated()) {
            return ui1.Q() <= getActivationDuration() + b.getActivationTimeStamp();
        }
    }

    public boolean isMTicketExpired() {
        if (this._isExpired || getExpirationTime() < ui1.Q() || xt.f3961a.c().Z(this._mTicketId)) {
            return true;
        }
        if (this._isUpTripActivated) {
            if (getActivationDuration() + getUpTripActivationTime() < ui1.Q()) {
                return true;
            }
        }
        return false;
    }

    public boolean isPaymentRequired() {
        return this._isPaymentRequired;
    }

    public boolean isUpTripActivated() {
        return this._isUpTripActivated;
    }

    public void setAgency(String str) {
        this._agency = str;
    }

    public void setBookingTime(long j) {
        this._bookingTime = j;
    }

    public void setCardDetails(List<CardDetails> list) {
        this._cardDetails = list;
    }

    public void setCityName(String str) {
        this._cityName = str;
    }

    public void setCustomerId(String str) {
        this._customerId = str;
    }

    public void setDeviceId(String str) {
        this._deviceId = str;
    }

    public void setExpirationTime(long j) {
        this._expirationTime = j;
    }

    public void setIsExpired(boolean z) {
        this._isExpired = z;
    }

    public void setIsUpTripActivated(boolean z) {
        this._isUpTripActivated = z;
    }

    public void setMTicketConfiguration(MTicketConfiguration mTicketConfiguration) {
        this._mTicketConfiguration = mTicketConfiguration;
    }

    public void setMTicketId(String str) {
        this._mTicketId = str;
    }

    public void setMticketTripReceipt(MTicketTripReceipt mTicketTripReceipt) {
        this._mticketTripReceipt = mTicketTripReceipt;
    }

    public void setOrderId(String str) {
        this._orderId = str;
    }

    public void setPassengerDetails(HashMap<String, MTicketPassengerInfo> hashMap) {
        this._passengerDetails = hashMap;
    }

    public void setPaymentMode(String str) {
        this._paymentMode = str;
    }

    public void setPaymentRequired(boolean z) {
        this._isPaymentRequired = z;
    }

    public void setQrCode(String str) {
        this._qrCode = str;
    }

    public void setRecentPaymentMethod(List<RecentPaymentMethod> list) {
        this._recentPaymentMethod = list;
    }

    public void setStatus(String str) {
        this._status = str;
    }

    public void setTone(String str) {
        this._tone = str;
    }

    public void setUpTripActivationTime(long j) {
        this._upTripActivationTime = j;
    }

    public void setUpTripPunchingTime(long j) {
        this._upTripPunchingTime = j;
    }

    public void setUpTripRouteStopsInfo(RouteStopsInfo routeStopsInfo) {
        this._upTripRouteStopsInfo = routeStopsInfo;
    }

    public void setUpTripRouteStopsStageInfo(RouteStopsInfo routeStopsInfo) {
        this._upTripRouteStopsStageInfo = routeStopsInfo;
    }

    public void setUserId(String str) {
        this._userId = str;
    }

    public void setUserProfile(UserProfile userProfile) {
        this._userProfile = userProfile;
    }

    public void set_isFreeRide(boolean z) {
        this._isFreeRide = z;
    }

    public void set_isPaymentRequired(boolean z) {
        this._isPaymentRequired = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._mTicketId);
        parcel.writeString(this._userId);
        parcel.writeString(this._deviceId);
        parcel.writeString(this._cityName);
        parcel.writeString(this._agency);
        parcel.writeValue(this._upTripRouteStopsInfo);
        parcel.writeMap(this._passengerDetails);
        parcel.writeLong(this._bookingTime);
        parcel.writeLong(this._expirationTime);
        parcel.writeByte(this._isExpired ? (byte) 1 : 0);
        parcel.writeLong(this._upTripActivationTime);
        parcel.writeByte(this._isUpTripActivated ? (byte) 1 : 0);
        parcel.writeLong(this._upTripPunchingTime);
        parcel.writeString(this._qrCode);
        parcel.writeValue(this._mTicketConfiguration);
        parcel.writeValue(this._upTripRouteStopsStageInfo);
        parcel.writeByte(this._isFreeRide ? (byte) 1 : 0);
        parcel.writeByte(this._isPaymentRequired ? (byte) 1 : 0);
        parcel.writeList(this._recentPaymentMethod);
        parcel.writeList(this._cardDetails);
        parcel.writeString(this._customerId);
        parcel.writeString(this._orderId);
        parcel.writeString(this._status);
        parcel.writeString(this._paymentMode);
        parcel.writeValue(this._userProfile);
        parcel.writeString(this._tone);
        parcel.writeValue(this._mticketTripReceipt);
    }

    public MTicket(Parcel parcel) {
        this._mTicketId = parcel.readString();
        this._userId = parcel.readString();
        this._deviceId = parcel.readString();
        this._cityName = parcel.readString();
        this._agency = parcel.readString();
        this._upTripRouteStopsInfo = (RouteStopsInfo) parcel.readValue(RouteStopsInfo.class.getClassLoader());
        this._passengerDetails = parcel.readHashMap(getClass().getClassLoader());
        this._bookingTime = parcel.readLong();
        this._expirationTime = parcel.readLong();
        boolean z = true;
        this._isExpired = parcel.readByte() != 0;
        this._upTripActivationTime = parcel.readLong();
        this._isUpTripActivated = parcel.readByte() != 0;
        this._upTripPunchingTime = parcel.readLong();
        this._qrCode = parcel.readString();
        this._mTicketConfiguration = (MTicketConfiguration) parcel.readValue(MTicketConfiguration.class.getClassLoader());
        this._upTripRouteStopsStageInfo = (RouteStopsInfo) parcel.readValue(RouteStopsInfo.class.getClassLoader());
        this._isFreeRide = parcel.readByte() != 0;
        this._isPaymentRequired = parcel.readByte() == 0 ? false : z;
        this._recentPaymentMethod = parcel.readArrayList(RecentPaymentMethod.class.getClassLoader());
        this._cardDetails = parcel.readArrayList(CardDetails.class.getClassLoader());
        this._customerId = parcel.readString();
        this._orderId = parcel.readString();
        this._status = parcel.readString();
        this._paymentMode = parcel.readString();
        this._userProfile = (UserProfile) parcel.readValue(UserProfile.class.getClassLoader());
        this._tone = parcel.readString();
        this._mticketTripReceipt = (MTicketTripReceipt) parcel.readValue(MTicketTripReceipt.class.getClassLoader());
    }
}
