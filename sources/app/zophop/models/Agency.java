package app.zophop.models;

import app.zophop.models.mTicketing.BookingPassInfo;
import app.zophop.models.mTicketing.MagicPassInfo;
import app.zophop.models.mTicketing.PassengerType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Agency {
    private final String _agencyLogoUrl;
    private final String _agencyName;
    private String _agencyUrl;
    private List<BookingPassInfo> _bookingPassInfos = new ArrayList();
    private final boolean _isOnlineCardRechargeAvailable;
    private List<LineInfo> _lineInfoList = new ArrayList();
    private final boolean _liveDataAvailable;
    private final boolean _liveFeedUrlAvailable;
    private boolean _mTicketEnabled;
    private List<MagicPassInfo> _magicPassInfos = new ArrayList();
    private Map<PassengerType, List<String>> _passengerTypeFields = new HashMap();
    private Map<String, List<String>> _passengerTypeProofs = new HashMap();
    private int _priority;
    private final boolean _productEnabled;
    private Map<String, Set<String>> _proofDocumentGroups = new HashMap();
    private boolean _scanPayAvailable;
    private final boolean _ticketingEnabled;

    public Agency(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this._agencyName = str;
        this._agencyLogoUrl = str2;
        this._liveFeedUrlAvailable = z;
        this._liveDataAvailable = z2;
        this._productEnabled = z4;
        this._ticketingEnabled = z3;
        this._isOnlineCardRechargeAvailable = z5;
    }

    public String getAgencyLogoUrl() {
        return this._agencyLogoUrl;
    }

    public String getAgencyName() {
        return this._agencyName;
    }

    public String getAgencyUrl() {
        return this._agencyUrl;
    }

    public List<BookingPassInfo> getBookingPassInfos() {
        return this._bookingPassInfos;
    }

    public List<LineInfo> getLineInfoList() {
        return this._lineInfoList;
    }

    public List<MagicPassInfo> getMagicPassInfos() {
        return this._magicPassInfos;
    }

    public Map<PassengerType, List<String>> getPassengerTypeFields() {
        return this._passengerTypeFields;
    }

    public Map<String, List<String>> getPassengerTypeProofs() {
        return this._passengerTypeProofs;
    }

    public int getPriority() {
        return this._priority;
    }

    public Map<String, Set<String>> getProofDocumentGroups() {
        return this._proofDocumentGroups;
    }

    public boolean isLiveDataAvailable() {
        return this._liveDataAvailable;
    }

    public boolean isLiveFeedUrlAvailable() {
        return this._liveFeedUrlAvailable;
    }

    public boolean isOnlineCardRechargeAvailable() {
        return this._isOnlineCardRechargeAvailable;
    }

    public boolean isProductAvailable() {
        return this._productEnabled;
    }

    public boolean isScanPayAvailable() {
        return this._scanPayAvailable;
    }

    public boolean isTicketingEnabled() {
        return this._ticketingEnabled;
    }

    public void setAgencyUrl(String str) {
        this._agencyUrl = str;
    }

    public void setBookingPassInfo(List<BookingPassInfo> list) {
        this._bookingPassInfos = list;
    }

    public void setLineInfos(List<LineInfo> list) {
        this._lineInfoList = list;
    }

    public void setMagicPassInfos(List<MagicPassInfo> list) {
        this._magicPassInfos = list;
    }

    public void setPassengerTypeProofs(Map<String, List<String>> map) {
        this._passengerTypeProofs = map;
    }

    public void setPriority(int i) {
        this._priority = i;
    }

    public void setProofDocumentGroups(Map<String, Set<String>> map) {
        this._proofDocumentGroups = map;
    }

    public void setScanPayAvailable(boolean z) {
        this._scanPayAvailable = z;
    }

    public void set_passengerTypeFields(Map<PassengerType, List<String>> map) {
        this._passengerTypeFields = map;
    }
}
