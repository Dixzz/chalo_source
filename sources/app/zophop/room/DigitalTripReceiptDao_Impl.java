package app.zophop.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import app.zophop.models.CustomTypeConverters;
import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class DigitalTripReceiptDao_Impl implements DigitalTripReceiptDao {
    private final CustomTypeConverters __customTypeConverters = new CustomTypeConverters();
    private final wl __db;
    private final ql<ProductActivationDetails> __insertionAdapterOfProductActivationDetails;
    private final ql<SuperPassTripReceipt> __insertionAdapterOfSuperPassTripReceipt;
    private final bm __preparedStmtOfDeleteSelectSuperPassTripReceipts;
    private final bm __preparedStmtOfDeleteSuperPassTripReceipt;

    public DigitalTripReceiptDao_Impl(wl wlVar) {
        this.__db = wlVar;
        this.__insertionAdapterOfProductActivationDetails = new ql<ProductActivationDetails>(wlVar) {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass1 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `product_activation_details_table` (`activation_time_stamp`,`booking_id`,`expiry_time`,`product_type`,`product_sub_type`,`city_name`,`agency_name`) VALUES (?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, ProductActivationDetails productActivationDetails) {
                smVar.d0(1, productActivationDetails.getActivationTimeStamp());
                if (productActivationDetails.getBookingId() == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, productActivationDetails.getBookingId());
                }
                smVar.d0(3, productActivationDetails.getExpiryTime());
                if (productActivationDetails.getProductType() == null) {
                    smVar.E0(4);
                } else {
                    smVar.z(4, productActivationDetails.getProductType());
                }
                if (productActivationDetails.getProductSubType() == null) {
                    smVar.E0(5);
                } else {
                    smVar.z(5, productActivationDetails.getProductSubType());
                }
                if (productActivationDetails.getCity() == null) {
                    smVar.E0(6);
                } else {
                    smVar.z(6, productActivationDetails.getCity());
                }
                if (productActivationDetails.getAgencyName() == null) {
                    smVar.E0(7);
                } else {
                    smVar.z(7, productActivationDetails.getAgencyName());
                }
            }
        };
        this.__insertionAdapterOfSuperPassTripReceipt = new ql<SuperPassTripReceipt>(wlVar) {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass2 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `super_pass_trip_receipt_table` (`pass_id`,`product_type`,`product_sub_type`,`activation_time_stamp`,`punch_time_stamp`,`vehicle_no`,`conductor_id`,`start_stop_name`,`end_stop_name`,`route_name`,`special_features_list`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, SuperPassTripReceipt superPassTripReceipt) {
                if (superPassTripReceipt.getPassId() == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, superPassTripReceipt.getPassId());
                }
                if (superPassTripReceipt.getProductType() == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, superPassTripReceipt.getProductType());
                }
                if (superPassTripReceipt.getProductSubType() == null) {
                    smVar.E0(3);
                } else {
                    smVar.z(3, superPassTripReceipt.getProductSubType());
                }
                smVar.d0(4, superPassTripReceipt.getActivationTimeStamp());
                smVar.d0(5, superPassTripReceipt.getPunchTimeStamp());
                if (superPassTripReceipt.getVehicleNo() == null) {
                    smVar.E0(6);
                } else {
                    smVar.z(6, superPassTripReceipt.getVehicleNo());
                }
                if (superPassTripReceipt.getConductorId() == null) {
                    smVar.E0(7);
                } else {
                    smVar.z(7, superPassTripReceipt.getConductorId());
                }
                if (superPassTripReceipt.getStartStopName() == null) {
                    smVar.E0(8);
                } else {
                    smVar.z(8, superPassTripReceipt.getStartStopName());
                }
                if (superPassTripReceipt.getEndStopName() == null) {
                    smVar.E0(9);
                } else {
                    smVar.z(9, superPassTripReceipt.getEndStopName());
                }
                if (superPassTripReceipt.getRouteName() == null) {
                    smVar.E0(10);
                } else {
                    smVar.z(10, superPassTripReceipt.getRouteName());
                }
                String customTypeConverters = DigitalTripReceiptDao_Impl.this.__customTypeConverters.toString(superPassTripReceipt.getSpecialFeatureList());
                if (customTypeConverters == null) {
                    smVar.E0(11);
                } else {
                    smVar.z(11, customTypeConverters);
                }
            }
        };
        this.__preparedStmtOfDeleteSuperPassTripReceipt = new bm(wlVar) {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass3 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM super_pass_trip_receipt_table where pass_id = ? and activation_time_stamp = ? and punch_time_stamp = ?";
            }
        };
        this.__preparedStmtOfDeleteSelectSuperPassTripReceipts = new bm(wlVar) {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass4 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM super_pass_trip_receipt_table where pass_id = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public Object deleteSelectActivationDetails(final List<Long> list, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass12 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                StringBuilder sb = new StringBuilder();
                sb.append("DELETE FROM product_activation_details_table where activation_time_stamp in (");
                im.a(sb, list.size());
                sb.append(")");
                sm compileStatement = DigitalTripReceiptDao_Impl.this.__db.compileStatement(sb.toString());
                int i = 1;
                for (Long l : list) {
                    if (l == null) {
                        compileStatement.E0(i);
                    } else {
                        compileStatement.d0(i, l.longValue());
                    }
                    i++;
                }
                DigitalTripReceiptDao_Impl.this.__db.beginTransaction();
                try {
                    compileStatement.F();
                    DigitalTripReceiptDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    DigitalTripReceiptDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public Object deleteSelectSuperPassTripReceipts(final String str, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass9 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = DigitalTripReceiptDao_Impl.this.__preparedStmtOfDeleteSelectSuperPassTripReceipts.acquire();
                String str = str;
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                DigitalTripReceiptDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    DigitalTripReceiptDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    DigitalTripReceiptDao_Impl.this.__db.endTransaction();
                    DigitalTripReceiptDao_Impl.this.__preparedStmtOfDeleteSelectSuperPassTripReceipts.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public Object deleteSuperPassTripReceipt(final String str, final long j, final long j2, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass8 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = DigitalTripReceiptDao_Impl.this.__preparedStmtOfDeleteSuperPassTripReceipt.acquire();
                String str = str;
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                acquire.d0(2, j);
                acquire.d0(3, j2);
                DigitalTripReceiptDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    DigitalTripReceiptDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    DigitalTripReceiptDao_Impl.this.__db.endTransaction();
                    DigitalTripReceiptDao_Impl.this.__preparedStmtOfDeleteSuperPassTripReceipt.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public List<ProductActivationDetails> getAllProductActivationDetailsList() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        yl e = yl.e("SELECT * FROM product_activation_details_table", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            int L = h.L(b, "activation_time_stamp");
            int L2 = h.L(b, "booking_id");
            int L3 = h.L(b, "expiry_time");
            int L4 = h.L(b, "product_type");
            int L5 = h.L(b, "product_sub_type");
            int L6 = h.L(b, "city_name");
            int L7 = h.L(b, "agency_name");
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
                if (b.isNull(L7)) {
                    str5 = null;
                } else {
                    str5 = b.getString(L7);
                }
                arrayList.add(new ProductActivationDetails(j, str, j2, str2, str3, str4, str5));
            }
            return arrayList;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public LiveData<List<SuperPassTripReceipt>> getAllSuperPassTripReceiptsList(String str) {
        final yl e = yl.e("SELECT * FROM super_pass_trip_receipt_table where pass_id = ? ORDER BY activation_time_stamp DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"super_pass_trip_receipt_table"}, false, new Callable<List<SuperPassTripReceipt>>() {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass10 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            @Override // java.util.concurrent.Callable
            public List<SuperPassTripReceipt> call() throws Exception {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10 = null;
                Cursor b = hm.b(DigitalTripReceiptDao_Impl.this.__db, e, false, null);
                try {
                    int L = h.L(b, "pass_id");
                    int L2 = h.L(b, "product_type");
                    int L3 = h.L(b, "product_sub_type");
                    int L4 = h.L(b, "activation_time_stamp");
                    int L5 = h.L(b, "punch_time_stamp");
                    int L6 = h.L(b, "vehicle_no");
                    int L7 = h.L(b, "conductor_id");
                    int L8 = h.L(b, "start_stop_name");
                    int L9 = h.L(b, "end_stop_name");
                    int L10 = h.L(b, "route_name");
                    int L11 = h.L(b, "special_features_list");
                    ArrayList arrayList = new ArrayList(b.getCount());
                    while (b.moveToNext()) {
                        if (b.isNull(L)) {
                            str = str10;
                        } else {
                            str = b.getString(L);
                        }
                        if (b.isNull(L2)) {
                            str2 = str10;
                        } else {
                            str2 = b.getString(L2);
                        }
                        if (b.isNull(L3)) {
                            str3 = str10;
                        } else {
                            str3 = b.getString(L3);
                        }
                        long j = b.getLong(L4);
                        long j2 = b.getLong(L5);
                        if (b.isNull(L6)) {
                            str4 = str10;
                        } else {
                            str4 = b.getString(L6);
                        }
                        if (b.isNull(L7)) {
                            str5 = str10;
                        } else {
                            str5 = b.getString(L7);
                        }
                        if (b.isNull(L8)) {
                            str6 = str10;
                        } else {
                            str6 = b.getString(L8);
                        }
                        if (b.isNull(L9)) {
                            str7 = str10;
                        } else {
                            str7 = b.getString(L9);
                        }
                        if (b.isNull(L10)) {
                            str8 = str10;
                        } else {
                            str8 = b.getString(L10);
                        }
                        if (b.isNull(L11)) {
                            str9 = str10;
                        } else {
                            str9 = b.getString(L11);
                        }
                        arrayList.add(new SuperPassTripReceipt(str, str2, str3, j, j2, str4, str5, str6, str7, str8, DigitalTripReceiptDao_Impl.this.__customTypeConverters.fromString(str9)));
                        str10 = null;
                    }
                    return arrayList;
                } finally {
                    b.close();
                }
            }
        });
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public LiveData<SuperPassTripReceipt> getSuperPassTripReceipt(String str, long j) {
        final yl e = yl.e("SELECT * FROM super_pass_trip_receipt_table where pass_id = ? and activation_time_stamp = ?", 2);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        e.d0(2, j);
        return this.__db.getInvalidationTracker().b(new String[]{"super_pass_trip_receipt_table"}, false, new Callable<SuperPassTripReceipt>() {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass11 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            @Override // java.util.concurrent.Callable
            public SuperPassTripReceipt call() throws Exception {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                SuperPassTripReceipt superPassTripReceipt = null;
                String str9 = null;
                Cursor b = hm.b(DigitalTripReceiptDao_Impl.this.__db, e, false, null);
                try {
                    int L = h.L(b, "pass_id");
                    int L2 = h.L(b, "product_type");
                    int L3 = h.L(b, "product_sub_type");
                    int L4 = h.L(b, "activation_time_stamp");
                    int L5 = h.L(b, "punch_time_stamp");
                    int L6 = h.L(b, "vehicle_no");
                    int L7 = h.L(b, "conductor_id");
                    int L8 = h.L(b, "start_stop_name");
                    int L9 = h.L(b, "end_stop_name");
                    int L10 = h.L(b, "route_name");
                    int L11 = h.L(b, "special_features_list");
                    if (b.moveToFirst()) {
                        if (b.isNull(L)) {
                            str = null;
                        } else {
                            str = b.getString(L);
                        }
                        if (b.isNull(L2)) {
                            str2 = null;
                        } else {
                            str2 = b.getString(L2);
                        }
                        if (b.isNull(L3)) {
                            str3 = null;
                        } else {
                            str3 = b.getString(L3);
                        }
                        long j = b.getLong(L4);
                        long j2 = b.getLong(L5);
                        if (b.isNull(L6)) {
                            str4 = null;
                        } else {
                            str4 = b.getString(L6);
                        }
                        if (b.isNull(L7)) {
                            str5 = null;
                        } else {
                            str5 = b.getString(L7);
                        }
                        if (b.isNull(L8)) {
                            str6 = null;
                        } else {
                            str6 = b.getString(L8);
                        }
                        if (b.isNull(L9)) {
                            str7 = null;
                        } else {
                            str7 = b.getString(L9);
                        }
                        if (b.isNull(L10)) {
                            str8 = null;
                        } else {
                            str8 = b.getString(L10);
                        }
                        if (!b.isNull(L11)) {
                            str9 = b.getString(L11);
                        }
                        superPassTripReceipt = new SuperPassTripReceipt(str, str2, str3, j, j2, str4, str5, str6, str7, str8, DigitalTripReceiptDao_Impl.this.__customTypeConverters.fromString(str9));
                    }
                    return superPassTripReceipt;
                } finally {
                    b.close();
                }
            }
        });
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public Object insertActivationDetails(final ProductActivationDetails productActivationDetails, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                DigitalTripReceiptDao_Impl.this.__db.beginTransaction();
                try {
                    DigitalTripReceiptDao_Impl.this.__insertionAdapterOfProductActivationDetails.insert(productActivationDetails);
                    DigitalTripReceiptDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    DigitalTripReceiptDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public Object insertSuperPassTripReceipt(final SuperPassTripReceipt superPassTripReceipt, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                DigitalTripReceiptDao_Impl.this.__db.beginTransaction();
                try {
                    DigitalTripReceiptDao_Impl.this.__insertionAdapterOfSuperPassTripReceipt.insert(superPassTripReceipt);
                    DigitalTripReceiptDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    DigitalTripReceiptDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.DigitalTripReceiptDao
    public Object insertSuperPassTripReceiptsList(final List<SuperPassTripReceipt> list, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.DigitalTripReceiptDao_Impl.AnonymousClass7 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                DigitalTripReceiptDao_Impl.this.__db.beginTransaction();
                try {
                    DigitalTripReceiptDao_Impl.this.__insertionAdapterOfSuperPassTripReceipt.insert((Iterable) list);
                    DigitalTripReceiptDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    DigitalTripReceiptDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }
}
