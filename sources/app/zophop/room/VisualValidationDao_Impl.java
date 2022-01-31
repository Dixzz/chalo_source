package app.zophop.room;

import android.database.Cursor;
import app.zophop.models.mTicketing.VisualValidationActivationDetails;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class VisualValidationDao_Impl implements VisualValidationDao {
    private final wl __db;
    private final ql<VisualValidationActivationDetails> __insertionAdapterOfVisualValidationActivationDetails;

    public VisualValidationDao_Impl(wl wlVar) {
        this.__db = wlVar;
        this.__insertionAdapterOfVisualValidationActivationDetails = new ql<VisualValidationActivationDetails>(wlVar) {
            /* class app.zophop.room.VisualValidationDao_Impl.AnonymousClass1 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `visual_validation_table` (`activation_time_stamp`,`booking_id`,`expiry_time`,`product_type`,`city_name`,`agency_name`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(sm smVar, VisualValidationActivationDetails visualValidationActivationDetails) {
                smVar.d0(1, visualValidationActivationDetails.getActivationTimeStamp());
                if (visualValidationActivationDetails.getBookingId() == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, visualValidationActivationDetails.getBookingId());
                }
                smVar.d0(3, visualValidationActivationDetails.getExpiryTime());
                if (visualValidationActivationDetails.getProductType() == null) {
                    smVar.E0(4);
                } else {
                    smVar.z(4, visualValidationActivationDetails.getProductType());
                }
                if (visualValidationActivationDetails.getCity() == null) {
                    smVar.E0(5);
                } else {
                    smVar.z(5, visualValidationActivationDetails.getCity());
                }
                if (visualValidationActivationDetails.getAgencyName() == null) {
                    smVar.E0(6);
                } else {
                    smVar.z(6, visualValidationActivationDetails.getAgencyName());
                }
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // app.zophop.room.VisualValidationDao
    public Object deleteSelectActivationDetails(final List<Long> list, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.VisualValidationDao_Impl.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                StringBuilder sb = new StringBuilder();
                sb.append("DELETE FROM visual_validation_table where activation_time_stamp in (");
                im.a(sb, list.size());
                sb.append(")");
                sm compileStatement = VisualValidationDao_Impl.this.__db.compileStatement(sb.toString());
                int i = 1;
                for (Long l : list) {
                    if (l == null) {
                        compileStatement.E0(i);
                    } else {
                        compileStatement.d0(i, l.longValue());
                    }
                    i++;
                }
                VisualValidationDao_Impl.this.__db.beginTransaction();
                try {
                    compileStatement.F();
                    VisualValidationDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    VisualValidationDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.VisualValidationDao
    public List<VisualValidationActivationDetails> getAllVisualValidationDetailsList() {
        String str;
        String str2;
        String str3;
        String str4;
        yl e = yl.e("SELECT * FROM visual_validation_table", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            int L = h.L(b, "activation_time_stamp");
            int L2 = h.L(b, "booking_id");
            int L3 = h.L(b, "expiry_time");
            int L4 = h.L(b, "product_type");
            int L5 = h.L(b, "city_name");
            int L6 = h.L(b, "agency_name");
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                long j = b.getLong(L);
                if (b.isNull(L2)) {
                    str = null;
                } else {
                    str = b.getString(L2);
                }
                long j2 = b.getLong(L3);
                if (b.isNull(L4)) {
                    str2 = null;
                } else {
                    str2 = b.getString(L4);
                }
                if (b.isNull(L5)) {
                    str3 = null;
                } else {
                    str3 = b.getString(L5);
                }
                if (b.isNull(L6)) {
                    str4 = null;
                } else {
                    str4 = b.getString(L6);
                }
                arrayList.add(new VisualValidationActivationDetails(j, str, j2, str2, str3, str4));
            }
            return arrayList;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.VisualValidationDao
    public Object insertActivationDetails(final VisualValidationActivationDetails visualValidationActivationDetails, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.VisualValidationDao_Impl.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                VisualValidationDao_Impl.this.__db.beginTransaction();
                try {
                    VisualValidationDao_Impl.this.__insertionAdapterOfVisualValidationActivationDetails.insert(visualValidationActivationDetails);
                    VisualValidationDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    VisualValidationDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }
}
