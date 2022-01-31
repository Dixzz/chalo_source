package app.zophop.room;

import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.models.mTicketing.MagicPassPunchInfo;
import app.zophop.models.mTicketing.RideDetails;
import java.util.List;

public interface ProductDao {
    void addTripReceiptToMTicket(String str, MTicketTripReceipt mTicketTripReceipt);

    void deleteAllPassData();

    void deleteAllScanPayData();

    void deleteAllTicketData();

    void deletePassApplicationData(String str);

    int getActivePassCount(String str, long j);

    int getActiveScanPayCount(String str);

    int getActiveSuperSaverCount(String str, long j);

    LiveData<List<ScanPay>> getAllActiveScanPayTickets(String str);

    LiveData<List<Ticket>> getAllActiveTickets(String str);

    LiveData<List<PassApplications>> getAllApplications(String str);

    LiveData<List<Pass>> getAllPasses(String str);

    List<Pass> getAllPassesSync(String str);

    List<RideDetails> getAllRideDetails();

    LiveData<List<ScanPay>> getAllScanPayTickets(String str);

    List<ScanPay> getAllScanPayTicketsSync(String str);

    LiveData<List<Ticket>> getAllTickets(String str);

    List<Ticket> getAllTicketsSync(String str);

    int getCitySpecificPassCount(String str);

    int getCitySpecificScanPayCount(String str);

    int getCitySpecificTicketCount(String str);

    Ticket getCurrentTicket(String str, String str2);

    LiveData<Ticket> getLatestActive(String str);

    int getPassApplicationCount(String str);

    Pass getPassFromBookingId(String str);

    LiveData<Pass> getPassFromBookingIdAsync(String str);

    LiveData<PassApplications> getRecentAppliedPass(String str);

    LiveData<List<PassApplications>> getRecentAppliedPassesList(String str);

    LiveData<Pass> getRecentPass(String str, long j);

    LiveData<List<Pass>> getRecentPassList(String str, long j);

    LiveData<ScanPay> getRecentScanPayTicket(String str);

    RideDetails getRideDetails(String str);

    ScanPay getScanPayTicketFromBookingId(String str);

    Ticket getTicketFromBookingId(String str);

    Ticket getTicketId(String str, String str2);

    void insert(Ticket ticket);

    void insertAndReplacePass(Pass pass);

    void insertPass(Pass pass);

    void insertPendingPass(PassApplications passApplications);

    void insertRideDetails(RideDetails rideDetails);

    void insertScanPayTicket(ScanPay scanPay);

    void update(Ticket ticket);

    void updateActivationData(String str, boolean z, String str2);

    void updateExpiryState(String str);

    void updateExpiryStatus(String str, boolean z);

    void updatePass(Pass pass);

    void updatePunchStatus(List<MagicPassPunchInfo> list, String str);

    void updateQrCode(String str, String str2);
}
