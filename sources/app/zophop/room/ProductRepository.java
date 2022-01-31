package app.zophop.room;

import android.content.Context;
import androidx.lifecycle.LiveData;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.models.mTicketing.MagicPassPunchInfo;
import app.zophop.models.mTicketing.RideDetails;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private String DB_NAME = "db_app";
    private final ProductDao _productDao;
    private final String city;
    private final long currentTime;

    public ProductRepository(Context context) {
        this._productDao = AppDatabase.getDatabase(context).getTicketDao();
        this.city = hj1.C(xt.f3961a);
        this.currentTime = ui1.Q();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setOldProperties(Pass pass, Pass pass2) {
        MPass pass3 = pass.getPass();
        MPass pass4 = pass2.getPass();
        pass4.set_rideInfo(pass3.get_rideInfo());
        pass2.setPass(pass4);
    }

    public void addTripReceiptToMTicket(final String str, final MTicketTripReceipt mTicketTripReceipt) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass6 */

            public void run() {
                ProductRepository.this._productDao.addTripReceiptToMTicket(str, mTicketTripReceipt);
            }
        });
    }

    public void deleteAllData() {
        this._productDao.deleteAllPassData();
        this._productDao.deleteAllScanPayData();
        this._productDao.deleteAllTicketData();
    }

    public void deleteAllPassApplications() {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass1 */

            public void run() {
                ProductRepository.this._productDao.deletePassApplicationData(ProductRepository.this.city);
            }
        });
    }

    public void deleteAllPassData() {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass2 */

            public void run() {
                ProductRepository.this._productDao.deleteAllPassData();
            }
        });
    }

    public void deleteAllScanPayData() {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass3 */

            public void run() {
                ProductRepository.this._productDao.deleteAllScanPayData();
            }
        });
    }

    public void deleteAllTicketData() {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass12 */

            public void run() {
                ProductRepository.this._productDao.deleteAllTicketData();
            }
        });
    }

    public RideDetails fetchRidedetails(String str) {
        return this._productDao.getRideDetails(str);
    }

    public int getActivePassCount() {
        return this._productDao.getActivePassCount(this.city, this.currentTime);
    }

    public int getActiveScanPayCount() {
        return this._productDao.getActiveScanPayCount(this.city);
    }

    public int getActiveSuperSaverPassCount() {
        return this._productDao.getActiveSuperSaverCount(this.city, this.currentTime);
    }

    public LiveData<List<ScanPay>> getAllActiveScanPayTickets() {
        return this._productDao.getAllActiveScanPayTickets(this.city);
    }

    public LiveData<List<Ticket>> getAllActiveTickets() {
        return this._productDao.getAllActiveTickets(this.city);
    }

    public LiveData<List<PassApplications>> getAllPassApplications() {
        return this._productDao.getAllApplications(this.city);
    }

    public LiveData<List<Pass>> getAllPasses() {
        return this._productDao.getAllPasses(this.city);
    }

    public List<MPass> getAllPassesSync() {
        ArrayList arrayList = new ArrayList();
        List<Pass> allPassesSync = this._productDao.getAllPassesSync(this.city);
        for (int i = 0; i < allPassesSync.size(); i++) {
            arrayList.add(allPassesSync.get(i).getPass());
        }
        return arrayList;
    }

    public List<RideDetails> getAllRideDetails() {
        return this._productDao.getAllRideDetails();
    }

    public List<ScanPayTicket> getAllScanPaySync() {
        ArrayList arrayList = new ArrayList();
        List<ScanPay> allScanPayTicketsSync = this._productDao.getAllScanPayTicketsSync(this.city);
        for (int i = 0; i < allScanPayTicketsSync.size(); i++) {
            arrayList.add(allScanPayTicketsSync.get(i).getScanPayTicket());
        }
        return arrayList;
    }

    public LiveData<List<ScanPay>> getAllScanPayTickets() {
        return this._productDao.getAllScanPayTickets(this.city);
    }

    public LiveData<List<Ticket>> getAllTickets() {
        return this._productDao.getAllTickets(this.city);
    }

    public List<MTicket> getAllTicketsSync() {
        ArrayList arrayList = new ArrayList();
        List<Ticket> allTicketsSync = this._productDao.getAllTicketsSync(this.city);
        for (int i = 0; i < allTicketsSync.size(); i++) {
            arrayList.add(allTicketsSync.get(i).getmTicket());
        }
        return arrayList;
    }

    public int getCitySpecificPassCount() {
        return this._productDao.getCitySpecificPassCount(this.city);
    }

    public int getCitySpecificScanPayCount() {
        return this._productDao.getCitySpecificScanPayCount(this.city);
    }

    public int getCitySpecificTicketCount() {
        return this._productDao.getCitySpecificTicketCount(this.city);
    }

    public Ticket getCurrentTicket(String str) {
        return this._productDao.getCurrentTicket(str, this.city);
    }

    public LiveData<Pass> getLatestActivePass() {
        return this._productDao.getRecentPass(this.city, this.currentTime);
    }

    public LiveData<PassApplications> getLatestAppliedPass() {
        return this._productDao.getRecentAppliedPass(this.city);
    }

    public int getPassApplicationCount() {
        return this._productDao.getPassApplicationCount(this.city);
    }

    public Pass getPassFromBookingId(String str) {
        return this._productDao.getPassFromBookingId(str);
    }

    public LiveData<List<Pass>> getRecentActivePasses() {
        return this._productDao.getRecentPassList(this.city, this.currentTime);
    }

    public LiveData<Ticket> getRecentActiveTicket() {
        return this._productDao.getLatestActive(this.city);
    }

    public LiveData<List<PassApplications>> getRecentAppliedPasses() {
        return this._productDao.getRecentAppliedPassesList(this.city);
    }

    public LiveData<ScanPay> getRecentScanPayTicket() {
        return this._productDao.getRecentScanPayTicket(this.city);
    }

    public ScanPay getScanPayFromBookingId(String str) {
        return this._productDao.getScanPayTicketFromBookingId(str);
    }

    public Ticket getTicketFromBookingId(String str) {
        return this._productDao.getTicketFromBookingId(str);
    }

    public void insertAndReplacePass(final Pass pass) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass8 */

            public void run() {
                ProductRepository.this._productDao.insertAndReplacePass(pass);
            }
        });
    }

    public void insertOrUpdate(Ticket ticket) {
        if (this._productDao.getCurrentTicket(ticket.getmTicket().getMTicketId(), this.city) == null) {
            insertTicket(ticket);
        } else {
            updateTicket(ticket);
        }
    }

    public void insertPass(final Pass pass) {
        final Pass passFromBookingId = this._productDao.getPassFromBookingId(pass.passId);
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass9 */

            public void run() {
                Pass pass = passFromBookingId;
                if (pass != null) {
                    ProductRepository.this.setOldProperties(pass, pass);
                }
                ProductRepository.this._productDao.insertPass(pass);
            }
        });
    }

    public void insertPendingPass(final PassApplications passApplications) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass11 */

            public void run() {
                ProductRepository.this._productDao.insertPendingPass(passApplications);
            }
        });
    }

    public void insertRideDetails(RideDetails rideDetails) {
        this._productDao.insertRideDetails(rideDetails);
    }

    public void insertScanPayTicket(final ScanPay scanPay) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass10 */

            public void run() {
                ProductRepository.this._productDao.insertScanPayTicket(scanPay);
            }
        });
    }

    public void insertTicket(final Ticket ticket) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass7 */

            public void run() {
                ProductRepository.this._productDao.insert(ticket);
                ticket.getTicketId();
                ticket.getmTicket().isUpTripActivated();
            }
        });
    }

    public void updateActivationDetails(String str, boolean z, long j) {
        this._productDao.updateActivationData(str, z, String.valueOf(j));
    }

    public void updateExpiryState(String str) {
        this._productDao.updateExpiryState(str);
    }

    public void updatePunchInfo(ArrayList<MagicPassPunchInfo> arrayList, String str) {
        this._productDao.updatePunchStatus(arrayList, str);
    }

    public void updateQrCode(final String str, final String str2) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass4 */

            public void run() {
                ProductRepository.this._productDao.updateQrCode(str, str2);
            }
        });
    }

    public void updateTicket(final Ticket ticket) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            /* class app.zophop.room.ProductRepository.AnonymousClass5 */

            public void run() {
                ProductRepository.this._productDao.update(ticket);
                ticket.getTicketId();
                ticket.getmTicket().isUpTripActivated();
            }
        });
    }
}
