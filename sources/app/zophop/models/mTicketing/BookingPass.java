package app.zophop.models.mTicketing;

import android.text.format.DateUtils;
import app.zophop.models.Agency;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.PunchInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingPass {
    private final String _agency;
    private String _bookingPassId;
    private final List<BookingPassRouteInfo> _bookingPassRouteInfos;
    private final BookingPassType _bookingPassType;
    private long _bookingTime;
    private Map<String, String> _displayProps = new HashMap();
    private final String _endStopId;
    private final String _endStopName;
    private long _expiryTime;
    private final double _fare;
    private final int _noOfDays;
    private final String _passengerType;
    private List<PunchInfo> _punches = new ArrayList();
    private final String _startStopId;
    private final String _startStopName;
    private long _startingTime;
    private TicketStatus _ticketStatus = TicketStatus.UNUSED;
    private final UserProfile _userProfile;

    public BookingPass(UserProfile userProfile, BookingPassType bookingPassType, String str, String str2, List<BookingPassRouteInfo> list, String str3, String str4, String str5, String str6, int i, double d) {
        this._userProfile = userProfile;
        this._bookingPassType = bookingPassType;
        this._passengerType = str;
        this._agency = str2;
        this._bookingPassRouteInfos = list;
        this._startStopName = str3;
        this._startStopId = str4;
        this._endStopName = str5;
        this._endStopId = str6;
        this._noOfDays = i;
        this._fare = d;
    }

    private PunchInfo getLastPunch(PunchInfo.PunchDirection punchDirection) {
        for (int size = this._punches.size() - 1; size >= 0; size--) {
            PunchInfo punchInfo = this._punches.get(size);
            punchInfo.getPunchingTime();
            punchInfo.getPunchDirection().name();
            punchDirection.name();
            if (punchInfo.getPunchDirection().equals(punchDirection)) {
                String str = "returning a punch at " + size + " for " + punchDirection;
                return punchInfo;
            }
        }
        String str2 = "returning null for last punchc for " + punchDirection;
        return null;
    }

    public void addPunch(PunchInfo punchInfo) {
        this._punches.add(punchInfo);
        Collections.sort(this._punches);
    }

    public String getAgency() {
        return this._agency;
    }

    public String getBookingPassId() {
        return this._bookingPassId;
    }

    public List<BookingPassRouteInfo> getBookingPassRouteInfos() {
        return this._bookingPassRouteInfos;
    }

    public BookingPassType getBookingPassType() {
        return this._bookingPassType;
    }

    public long getBookingTime() {
        return this._bookingTime;
    }

    public Map<String, String> getDisplayProperties() {
        return this._displayProps;
    }

    public String getEndStopId() {
        return this._endStopId;
    }

    public String getEndStopName() {
        return this._endStopName;
    }

    public long getExpiryTime() {
        return this._expiryTime;
    }

    public double getFare() {
        return this._fare;
    }

    public int getMaxPunchesPerDay() {
        return getNoOfPunchesForAPass(this._agency, this._bookingPassType);
    }

    public int getNoOfDays() {
        return this._noOfDays;
    }

    public int getNoOfPunchesForAPass(String str, BookingPassType bookingPassType) {
        for (Agency agency : xt.f3961a.k().d().getModeAgencyMap().get(TransitMode.bus)) {
            if (str.equalsIgnoreCase(agency.getAgencyName())) {
                for (BookingPassInfo bookingPassInfo : agency.getBookingPassInfos()) {
                    if (bookingPassType.equals(bookingPassInfo.getBookingPassType())) {
                        return bookingPassInfo.getNoOfPunches();
                    }
                }
                continue;
            }
        }
        return -1;
    }

    public String getPassengerType() {
        return this._passengerType;
    }

    public List<PunchInfo> getPunches() {
        return this._punches;
    }

    public int getRemainingPunchesForToday() {
        int i = isDownDirectionPunchRemaining() ? 1 : 0;
        return isUpDirectionPunchRemaining() ? i + 1 : i;
    }

    public String getStartStopId() {
        return this._startStopId;
    }

    public String getStartStopName() {
        return this._startStopName;
    }

    public long getStartingTime() {
        return this._startingTime;
    }

    public TicketStatus getTicketStatus() {
        return this._ticketStatus;
    }

    public UserProfile getUserProfile() {
        return this._userProfile;
    }

    public boolean isDownDirectionPunchRemaining() {
        return isPunchRemainingToday(PunchInfo.PunchDirection.DOWN);
    }

    public boolean isPunchRemainingToday(PunchInfo.PunchDirection punchDirection) {
        for (PunchInfo punchInfo : this._punches) {
            if (punchInfo.getPunchDirection().equals(punchDirection) && DateUtils.isToday(punchInfo.getPunchingTime())) {
                return false;
            }
        }
        return true;
    }

    public boolean isUpDirectionPunchRemaining() {
        return isPunchRemainingToday(PunchInfo.PunchDirection.UP);
    }

    public void setBookingTime(long j) {
        this._bookingTime = j;
    }

    public void setDisplayProperties(Map<String, String> map) {
        this._displayProps = map;
    }

    public void setExpiryTime(long j) {
        this._expiryTime = j;
    }

    public void setPassId(String str) {
        this._bookingPassId = str;
    }

    public void setPunches(List<PunchInfo> list) {
        this._punches = list;
        Collections.sort(list);
    }

    public void setStartingTime(long j) {
        this._startingTime = j;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this._ticketStatus = ticketStatus;
    }
}
