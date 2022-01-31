package app.zophop.room;

import android.content.Context;
import androidx.lifecycle.LiveData;
import app.zophop.ZophopApplication;
import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import com.razorpay.AnalyticsConstants;
import java.util.List;
import org.json.JSONObject;

/* compiled from: DigitalTripReceiptRepository.kt */
public final class DigitalTripReceiptRepository {
    private final j56 applicationScope$delegate = hd3.a2(new DigitalTripReceiptRepository$applicationScope$2(this));
    private final Context context;
    private final j56 digitalRideReceiptDao$delegate = hd3.a2(new DigitalTripReceiptRepository$digitalRideReceiptDao$2(this));

    public DigitalTripReceiptRepository(Context context2) {
        n86.e(context2, AnalyticsConstants.CONTEXT);
        this.context = context2;
    }

    private final ZophopApplication getApplicationScope() {
        return (ZophopApplication) this.applicationScope$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DigitalTripReceiptDao getDigitalRideReceiptDao() {
        return (DigitalTripReceiptDao) this.digitalRideReceiptDao$delegate.getValue();
    }

    public final void deleteSelectActivationDetails(List<ProductActivationDetails> list) {
        if (!(list == null || list.isEmpty())) {
            hd3.Y1(getApplicationScope(), null, null, new DigitalTripReceiptRepository$deleteSelectActivationDetails$1(list, this, null), 3, null);
        }
    }

    public final LiveData<List<SuperPassTripReceipt>> getAllSuperPassTripReceiptsList(String str) {
        n86.e(str, "lSuperPassId");
        return getDigitalRideReceiptDao().getAllSuperPassTripReceiptsList(str);
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<ProductActivationDetails> getProductActivationDetailsListMap() {
        return getDigitalRideReceiptDao().getAllProductActivationDetailsList();
    }

    public final LiveData<SuperPassTripReceipt> getSuperPassTripReceipt(String str, long j) {
        n86.e(str, "lSuperPassId");
        return getDigitalRideReceiptDao().getSuperPassTripReceipt(str, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object insertProductActivationDetails(app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails r11, defpackage.k66<? super java.lang.Boolean> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof app.zophop.room.DigitalTripReceiptRepository$insertProductActivationDetails$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            app.zophop.room.DigitalTripReceiptRepository$insertProductActivationDetails$1 r0 = (app.zophop.room.DigitalTripReceiptRepository$insertProductActivationDetails$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            app.zophop.room.DigitalTripReceiptRepository$insertProductActivationDetails$1 r0 = new app.zophop.room.DigitalTripReceiptRepository$insertProductActivationDetails$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            p66 r1 = defpackage.p66.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            defpackage.hd3.Y2(r12)
            goto L_0x004f
        L_0x0027:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x002f:
            defpackage.hd3.Y2(r12)
            app.zophop.ZophopApplication r4 = r10.getApplicationScope()
            r5 = 0
            r6 = 0
            app.zophop.room.DigitalTripReceiptRepository$insertProductActivationDetails$lInsertionJob$1 r7 = new app.zophop.room.DigitalTripReceiptRepository$insertProductActivationDetails$lInsertionJob$1
            r12 = 0
            r7.<init>(r10, r11, r12)
            r8 = 3
            r9 = 0
            rb6 r11 = defpackage.hd3.t(r4, r5, r6, r7, r8, r9)
            r0.label = r3
            sb6 r11 = (defpackage.sb6) r11
            java.lang.Object r11 = r11.v(r0)
            if (r11 != r1) goto L_0x004f
            return r1
        L_0x004f:
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.DigitalTripReceiptRepository.insertProductActivationDetails(app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails, k66):java.lang.Object");
    }

    public final void updateSuperPassTripReceiptFromPunch(SuperPassTripReceipt superPassTripReceipt) {
        if (superPassTripReceipt != null) {
            hd3.Y1(getApplicationScope(), null, null, new DigitalTripReceiptRepository$updateSuperPassTripReceiptFromPunch$1(this, superPassTripReceipt, null), 3, null);
        }
    }

    public final void updateSuperPassTripReceiptTable(JSONObject jSONObject) {
        n86.e(jSONObject, "lSuperPassTripHistoryObject");
        hd3.Y1(getApplicationScope(), null, null, new DigitalTripReceiptRepository$updateSuperPassTripReceiptTable$1(jSONObject, this, null), 3, null);
    }
}
