package app.zophop.room;

import app.zophop.models.mTicketing.ProductBranding;
import app.zophop.models.mTicketing.cardRecharge.CardProperties;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeInfo;
import app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentProperties;
import app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeUIProperties;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class OnlineCardRechargeDao_Impl implements OnlineCardRechargeDao {
    private final wl __db;
    private final ql<OnlineCardRecharge> __insertionAdapterOfOnlineCardRecharge;
    private final bm __preparedStmtOfDeleteAllOnlineCardRechargeHistory;
    private final bm __preparedStmtOfDeleteAllOnlineCardRechargesForCity;

    /* renamed from: app.zophop.room.OnlineCardRechargeDao_Impl$11  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass11 {
        public static final /* synthetic */ int[] $SwitchMap$app$zophop$models$mTicketing$cardRecharge$CardRechargePaymentStatus;
        public static final /* synthetic */ int[] $SwitchMap$app$zophop$models$mTicketing$cardRecharge$CardRechargeStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|5|6|7|8|9|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
        static {
            /*
                app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus.values()
                r0 = 3
                int[] r1 = new int[r0]
                app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass11.$SwitchMap$app$zophop$models$mTicketing$cardRecharge$CardRechargeStatus = r1
                r2 = 0
                r3 = 1
                app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus r4 = app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus.PENDING     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                int[] r4 = app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass11.$SwitchMap$app$zophop$models$mTicketing$cardRecharge$CardRechargeStatus     // Catch:{ NoSuchFieldError -> 0x0015 }
                app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus r5 = app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0015 }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r4 = app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass11.$SwitchMap$app$zophop$models$mTicketing$cardRecharge$CardRechargeStatus     // Catch:{ NoSuchFieldError -> 0x001b }
                app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus r5 = app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x001b }
                r4[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001b }
            L_0x001b:
                app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus.values()
                int[] r4 = new int[r0]
                app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass11.$SwitchMap$app$zophop$models$mTicketing$cardRecharge$CardRechargePaymentStatus = r4
                app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus r5 = app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus.INITIATED     // Catch:{ NoSuchFieldError -> 0x0026 }
                r4[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                int[] r2 = app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass11.$SwitchMap$app$zophop$models$mTicketing$cardRecharge$CardRechargePaymentStatus     // Catch:{ NoSuchFieldError -> 0x002c }
                app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus r4 = app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus.SUCCESS     // Catch:{ NoSuchFieldError -> 0x002c }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002c }
            L_0x002c:
                int[] r2 = app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass11.$SwitchMap$app$zophop$models$mTicketing$cardRecharge$CardRechargePaymentStatus     // Catch:{ NoSuchFieldError -> 0x0032 }
                app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus r3 = app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass11.<clinit>():void");
        }
    }

    public OnlineCardRechargeDao_Impl(wl wlVar) {
        this.__db = wlVar;
        this.__insertionAdapterOfOnlineCardRecharge = new ql<OnlineCardRecharge>(wlVar) {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass1 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `online_card_recharge_table` (`payment_properties_card_recharge_transaction_id`,`payment_properties_card_recharge_payment_mode`,`payment_properties_card_recharge_payment_time`,`payment_properties_card_recharge_card_recharge_info_payment_status`,`payment_properties_card_recharge_card_recharge_info_recharge_status`,`payment_properties_card_recharge_card_recharge_info_recharge_amount`,`ui_properties_card_recharge_product_name`,`ui_properties_card_recharge_recharge_delay_copy`,`ui_properties_card_recharge_branding_is_visible`,`card_properties_card_recharge_card_no`,`card_properties_card_recharge_city`,`card_properties_card_recharge_agency`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, OnlineCardRecharge onlineCardRecharge) {
                CardRechargePaymentProperties cardRechargePaymentProperties = onlineCardRecharge.getCardRechargePaymentProperties();
                if (cardRechargePaymentProperties != null) {
                    if (cardRechargePaymentProperties.getTransactionId() == null) {
                        smVar.E0(1);
                    } else {
                        smVar.z(1, cardRechargePaymentProperties.getTransactionId());
                    }
                    if (cardRechargePaymentProperties.getPaymentMode() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, cardRechargePaymentProperties.getPaymentMode());
                    }
                    smVar.d0(3, cardRechargePaymentProperties.getPaymentTime());
                    CardRechargeInfo cardRechargeInfo = cardRechargePaymentProperties.getCardRechargeInfo();
                    if (cardRechargeInfo != null) {
                        if (cardRechargeInfo.getPaymentStatus() == null) {
                            smVar.E0(4);
                        } else {
                            smVar.z(4, OnlineCardRechargeDao_Impl.this.__CardRechargePaymentStatus_enumToString(cardRechargeInfo.getPaymentStatus()));
                        }
                        if (cardRechargeInfo.getRechargeStatus() == null) {
                            smVar.E0(5);
                        } else {
                            smVar.z(5, OnlineCardRechargeDao_Impl.this.__CardRechargeStatus_enumToString(cardRechargeInfo.getRechargeStatus()));
                        }
                        smVar.d0(6, cardRechargeInfo.getRechargeAmount());
                    } else {
                        smVar.E0(4);
                        smVar.E0(5);
                        smVar.E0(6);
                    }
                } else {
                    hj1.D0(smVar, 1, 2, 3, 4);
                    smVar.E0(5);
                    smVar.E0(6);
                }
                CardRechargeUIProperties cardRechargeUIProperties = onlineCardRecharge.getCardRechargeUIProperties();
                if (cardRechargeUIProperties != null) {
                    if (cardRechargeUIProperties.getProductName() == null) {
                        smVar.E0(7);
                    } else {
                        smVar.z(7, cardRechargeUIProperties.getProductName());
                    }
                    if (cardRechargeUIProperties.getRechargeDelayCopy() == null) {
                        smVar.E0(8);
                    } else {
                        smVar.z(8, cardRechargeUIProperties.getRechargeDelayCopy());
                    }
                    ProductBranding branding = cardRechargeUIProperties.getBranding();
                    if (branding != null) {
                        smVar.d0(9, branding.isVisible() ? 1 : 0);
                    } else {
                        smVar.E0(9);
                    }
                } else {
                    smVar.E0(7);
                    smVar.E0(8);
                    smVar.E0(9);
                }
                CardProperties cardProperties = onlineCardRecharge.getCardProperties();
                if (cardProperties != null) {
                    if (cardProperties.getCardNo() == null) {
                        smVar.E0(10);
                    } else {
                        smVar.z(10, cardProperties.getCardNo());
                    }
                    if (cardProperties.getCity() == null) {
                        smVar.E0(11);
                    } else {
                        smVar.z(11, cardProperties.getCity());
                    }
                    if (cardProperties.getAgency() == null) {
                        smVar.E0(12);
                    } else {
                        smVar.z(12, cardProperties.getAgency());
                    }
                } else {
                    smVar.E0(10);
                    smVar.E0(11);
                    smVar.E0(12);
                }
            }
        };
        this.__preparedStmtOfDeleteAllOnlineCardRechargeHistory = new bm(wlVar) {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass2 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM online_card_recharge_table";
            }
        };
        this.__preparedStmtOfDeleteAllOnlineCardRechargesForCity = new bm(wlVar) {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass3 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM online_card_recharge_table where card_properties_card_recharge_city = ?";
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String __CardRechargePaymentStatus_enumToString(CardRechargePaymentStatus cardRechargePaymentStatus) {
        if (cardRechargePaymentStatus == null) {
            return null;
        }
        int ordinal = cardRechargePaymentStatus.ordinal();
        if (ordinal == 0) {
            return "INITIATED";
        }
        if (ordinal == 1) {
            return "SUCCESS";
        }
        if (ordinal == 2) {
            return "FAILED";
        }
        throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + cardRechargePaymentStatus);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CardRechargePaymentStatus __CardRechargePaymentStatus_stringToEnum(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1757359925:
                if (str.equals("INITIATED")) {
                    c = 0;
                    break;
                }
                break;
            case -1149187101:
                if (str.equals("SUCCESS")) {
                    c = 1;
                    break;
                }
                break;
            case 2066319421:
                if (str.equals("FAILED")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return CardRechargePaymentStatus.INITIATED;
            case 1:
                return CardRechargePaymentStatus.SUCCESS;
            case 2:
                return CardRechargePaymentStatus.FAILED;
            default:
                throw new IllegalArgumentException(hj1.S("Can't convert value to enum, unknown value: ", str));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String __CardRechargeStatus_enumToString(CardRechargeStatus cardRechargeStatus) {
        if (cardRechargeStatus == null) {
            return null;
        }
        int ordinal = cardRechargeStatus.ordinal();
        if (ordinal == 0) {
            return "PENDING";
        }
        if (ordinal == 1) {
            return "SUCCESS";
        }
        if (ordinal == 2) {
            return "FAILED";
        }
        throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + cardRechargeStatus);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CardRechargeStatus __CardRechargeStatus_stringToEnum(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1149187101:
                if (str.equals("SUCCESS")) {
                    c = 0;
                    break;
                }
                break;
            case 35394935:
                if (str.equals("PENDING")) {
                    c = 1;
                    break;
                }
                break;
            case 2066319421:
                if (str.equals("FAILED")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return CardRechargeStatus.SUCCESS;
            case 1:
                return CardRechargeStatus.PENDING;
            case 2:
                return CardRechargeStatus.FAILED;
            default:
                throw new IllegalArgumentException(hj1.S("Can't convert value to enum, unknown value: ", str));
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // app.zophop.room.OnlineCardRechargeDao
    public Object deleteAllOnlineCardRechargeHistory(k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = OnlineCardRechargeDao_Impl.this.__preparedStmtOfDeleteAllOnlineCardRechargeHistory.acquire();
                OnlineCardRechargeDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    OnlineCardRechargeDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    OnlineCardRechargeDao_Impl.this.__db.endTransaction();
                    OnlineCardRechargeDao_Impl.this.__preparedStmtOfDeleteAllOnlineCardRechargeHistory.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.OnlineCardRechargeDao
    public Object deleteAllOnlineCardRechargesForCity(final String str, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass7 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = OnlineCardRechargeDao_Impl.this.__preparedStmtOfDeleteAllOnlineCardRechargesForCity.acquire();
                String str = str;
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                OnlineCardRechargeDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    OnlineCardRechargeDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    OnlineCardRechargeDao_Impl.this.__db.endTransaction();
                    OnlineCardRechargeDao_Impl.this.__preparedStmtOfDeleteAllOnlineCardRechargesForCity.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.OnlineCardRechargeDao
    public qe6<List<OnlineCardRecharge>> getAllOnlineCardRechargesForCity(String str) {
        final yl e = yl.e("SELECT * FROM online_card_recharge_table where card_properties_card_recharge_city = ? ORDER BY payment_properties_card_recharge_payment_time DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.a(this.__db, false, new String[]{"online_card_recharge_table"}, new Callable<List<OnlineCardRecharge>>() {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass8 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:43:0x0111 A[Catch:{ all -> 0x01a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0112 A[Catch:{ all -> 0x01a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0159 A[Catch:{ all -> 0x01a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x015a A[Catch:{ all -> 0x01a3 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 424
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass8.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.OnlineCardRechargeDao
    public qe6<List<OnlineCardRecharge>> getLatestOnlineCardRechargesForCity(String str) {
        final yl e = yl.e("SELECT * FROM online_card_recharge_table where card_properties_card_recharge_city = ? ORDER BY payment_properties_card_recharge_payment_time DESC LIMIT 3", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.a(this.__db, false, new String[]{"online_card_recharge_table"}, new Callable<List<OnlineCardRecharge>>() {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass10 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:43:0x0111 A[Catch:{ all -> 0x01a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0112 A[Catch:{ all -> 0x01a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0159 A[Catch:{ all -> 0x01a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x015a A[Catch:{ all -> 0x01a3 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 424
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass10.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.OnlineCardRechargeDao
    public qe6<OnlineCardRecharge> getOnlineCardRecharge(String str) {
        final yl e = yl.e("SELECT * FROM online_card_recharge_table where payment_properties_card_recharge_transaction_id = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.a(this.__db, false, new String[]{"online_card_recharge_table"}, new Callable<OnlineCardRecharge>() {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass9 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:42:0x00f5 A[Catch:{ all -> 0x016e }] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6 A[Catch:{ all -> 0x016e }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0141 A[Catch:{ all -> 0x016e }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0143 A[Catch:{ all -> 0x016e }] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x014d A[Catch:{ all -> 0x016e }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x014f A[Catch:{ all -> 0x016e }] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x0159 A[Catch:{ all -> 0x016e }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x015a A[Catch:{ all -> 0x016e }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 371
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass9.call():app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge");
            }
        });
    }

    @Override // app.zophop.room.OnlineCardRechargeDao
    public Object insertOnlineCardRecharge(final OnlineCardRecharge onlineCardRecharge, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                OnlineCardRechargeDao_Impl.this.__db.beginTransaction();
                try {
                    OnlineCardRechargeDao_Impl.this.__insertionAdapterOfOnlineCardRecharge.insert(onlineCardRecharge);
                    OnlineCardRechargeDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    OnlineCardRechargeDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.OnlineCardRechargeDao
    public Object insertOnlineCardRechargeList(final List<OnlineCardRecharge> list, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.OnlineCardRechargeDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                OnlineCardRechargeDao_Impl.this.__db.beginTransaction();
                try {
                    OnlineCardRechargeDao_Impl.this.__insertionAdapterOfOnlineCardRecharge.insert((Iterable) list);
                    OnlineCardRechargeDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    OnlineCardRechargeDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }
}
