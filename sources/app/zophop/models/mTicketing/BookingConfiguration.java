package app.zophop.models.mTicketing;

import android.util.Pair;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BookingConfiguration {
    private long _activeDuration;
    private String _agencyName;
    private String _bookingType;
    private Map<String, String> _displayProps;
    private int _downPunches;
    private boolean _expiresAtMidNight;
    private String _id;
    private boolean _isBookingPersonalized;
    private boolean _isBookingValidOnAllRoutes;
    private boolean _isFixedFare;
    private boolean _isMultiPassengerBooking;
    private int _maxTotalPassengerCount;
    private boolean _multiLegs;
    private boolean _multiModes;
    private long _notificationDuration;
    private Map<String, BookingConfigPassengerInfo> _passengerDetailsMap;
    private List<PaymentMode> _paymentModes;
    private boolean _showNotification;
    private int _totalPunches;
    private int _upPunches;
    private List<Long> _validDurations;
    private boolean _verificationRequired;

    public long getActiveDuration() {
        return this._activeDuration;
    }

    public String getAgencyName() {
        return this._agencyName;
    }

    public String getBookingType() {
        return this._bookingType;
    }

    public Map<String, String> getDisplayProps() {
        return this._displayProps;
    }

    public int getDownPunches() {
        return this._downPunches;
    }

    public String getId() {
        return this._id;
    }

    public int getMaxTotalPassengerCount() {
        return this._maxTotalPassengerCount;
    }

    public long getNotificationDuration() {
        return this._notificationDuration;
    }

    public Map<String, BookingConfigPassengerInfo> getPassengerDetailsMap() {
        return this._passengerDetailsMap;
    }

    public List<String> getPassengerTypes() {
        ArrayList arrayList = new ArrayList();
        if (getPassengerDetailsMap() != null) {
            ArrayList arrayList2 = new ArrayList();
            for (String str : getPassengerDetailsMap().keySet()) {
                BookingConfigPassengerInfo bookingConfigPassengerInfo = getPassengerDetailsMap().get(str);
                if (bookingConfigPassengerInfo != null && bookingConfigPassengerInfo.isActive()) {
                    arrayList2.add(new Pair(str, Integer.valueOf(bookingConfigPassengerInfo.getDisplayOrder())));
                }
            }
            Collections.sort(arrayList2, new Object() {
                /* class app.zophop.models.mTicketing.BookingConfiguration.AnonymousClass1 */

                /* Return type fixed from 'java.util.Comparator' to match base method */
                @Override // j$.util.Comparator, java.util.Comparator
                public /* synthetic */ Comparator<Pair<String, Integer>> reversed() {
                    return Comparator.CC.$default$reversed(this);
                }

                @Override // j$.util.Comparator
                public /* synthetic */ java.util.Comparator thenComparing(Function function) {
                    return Comparator.CC.$default$thenComparing(this, function);
                }

                @Override // j$.util.Comparator
                public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
                    return Comparator.CC.$default$thenComparing(this, function, comparator);
                }

                /* Return type fixed from 'java.util.Comparator' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
                @Override // j$.util.Comparator, java.util.Comparator
                public /* synthetic */ java.util.Comparator<Pair<String, Integer>> thenComparing(java.util.Comparator<? super Pair<String, Integer>> comparator) {
                    return Comparator.CC.$default$thenComparing(this, comparator);
                }

                @Override // j$.util.Comparator
                public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
                    return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
                }

                @Override // j$.util.Comparator
                public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
                    return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
                }

                @Override // j$.util.Comparator
                public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
                    return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
                }

                public int compare(Pair<String, Integer> pair, Pair<String, Integer> pair2) {
                    return ((Integer) pair.second).compareTo((Integer) pair2.second);
                }
            });
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Pair) it.next()).first);
            }
        }
        return arrayList;
    }

    public List<PaymentMode> getPaymentModes() {
        return this._paymentModes;
    }

    public int getTotalPunches() {
        return this._totalPunches;
    }

    public int getUpPunches() {
        return this._upPunches;
    }

    public List<Long> getValidDurations() {
        return this._validDurations;
    }

    public boolean isExpiresAtMidNight() {
        return this._expiresAtMidNight;
    }

    public boolean isIsBookingPersonalized() {
        return this._isBookingPersonalized;
    }

    public boolean isIsBookingValidOnAllRoutes() {
        return this._isBookingValidOnAllRoutes;
    }

    public boolean isIsFixedFare() {
        return this._isFixedFare;
    }

    public boolean isMultiLegs() {
        return this._multiLegs;
    }

    public boolean isMultiModes() {
        return this._multiModes;
    }

    public boolean isMultiPassengerBooking() {
        return this._isMultiPassengerBooking;
    }

    public boolean isVerificationRequired() {
        return this._verificationRequired;
    }

    public void setActiveDuration(long j) {
        this._activeDuration = j;
    }

    public void setAgencyName(String str) {
        this._agencyName = str;
    }

    public void setBookingType(String str) {
        this._bookingType = str;
    }

    public void setDisplayProps(Map<String, String> map) {
        this._displayProps = map;
    }

    public void setDownPunches(int i) {
        this._downPunches = i;
    }

    public void setExpiresAtMidNight(boolean z) {
        this._expiresAtMidNight = z;
    }

    public void setId(String str) {
        this._id = str;
    }

    public void setIsBookingPersonalized(boolean z) {
        this._isBookingPersonalized = z;
    }

    public void setIsBookingValidOnAllRoutes(boolean z) {
        this._isBookingValidOnAllRoutes = z;
    }

    public void setIsFixedFare(boolean z) {
        this._isFixedFare = z;
    }

    public void setIsMultiPassengerBooking(boolean z) {
        this._isMultiPassengerBooking = z;
    }

    public void setMaxTotalPassengerCount(int i) {
        this._maxTotalPassengerCount = i;
    }

    public void setMultiLegs(boolean z) {
        this._multiLegs = z;
    }

    public void setMultiModes(boolean z) {
        this._multiModes = z;
    }

    public void setNotificationDuration(long j) {
        this._notificationDuration = j;
    }

    public void setPassengerDetailsMap(Map<String, BookingConfigPassengerInfo> map) {
        this._passengerDetailsMap = map;
    }

    public void setPaymentModes(List<PaymentMode> list) {
        this._paymentModes = list;
    }

    public void setShowNotification(boolean z) {
        this._showNotification = z;
    }

    public void setTotalPunches(int i) {
        this._totalPunches = i;
    }

    public void setUpPunches(int i) {
        this._upPunches = i;
    }

    public void setValidDurations(List<Long> list) {
        this._validDurations = list;
    }

    public void setVerificationRequired(boolean z) {
        this._verificationRequired = z;
    }

    public boolean showNotification() {
        return this._showNotification;
    }
}
