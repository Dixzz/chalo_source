package app.zophop.room;

import android.content.Context;
import app.zophop.ZophopApplication;
import app.zophop.models.mTicketing.VisualValidationActivationDetails;
import com.razorpay.AnalyticsConstants;
import java.util.List;

/* compiled from: VisualValidationRepository.kt */
public final class VisualValidationRepository {
    private final j56 applicationContext$delegate = hd3.a2(new VisualValidationRepository$applicationContext$2(this));
    private final Context context;
    private final j56 visualValidationDao$delegate = hd3.a2(new VisualValidationRepository$visualValidationDao$2(this));

    public VisualValidationRepository(Context context2) {
        n86.e(context2, AnalyticsConstants.CONTEXT);
        this.context = context2;
    }

    private final ZophopApplication getApplicationContext() {
        return (ZophopApplication) this.applicationContext$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final VisualValidationDao getVisualValidationDao() {
        return (VisualValidationDao) this.visualValidationDao$delegate.getValue();
    }

    public final void deleteSelectActivationDetails(List<VisualValidationActivationDetails> list) {
        if (!(list == null || list.isEmpty())) {
            hd3.Y1(getApplicationContext(), null, null, new VisualValidationRepository$deleteSelectActivationDetails$1(list, this, null), 3, null);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<VisualValidationActivationDetails> getVisualValidationActivationDetailsListMap() {
        return getVisualValidationDao().getAllVisualValidationDetailsList();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object insertVisualValidationActivationDetails(app.zophop.models.mTicketing.VisualValidationActivationDetails r11, defpackage.k66<? super java.lang.Boolean> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof app.zophop.room.VisualValidationRepository$insertVisualValidationActivationDetails$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            app.zophop.room.VisualValidationRepository$insertVisualValidationActivationDetails$1 r0 = (app.zophop.room.VisualValidationRepository$insertVisualValidationActivationDetails$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            app.zophop.room.VisualValidationRepository$insertVisualValidationActivationDetails$1 r0 = new app.zophop.room.VisualValidationRepository$insertVisualValidationActivationDetails$1
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
            app.zophop.ZophopApplication r4 = r10.getApplicationContext()
            r5 = 0
            r6 = 0
            app.zophop.room.VisualValidationRepository$insertVisualValidationActivationDetails$lInsertionJob$1 r7 = new app.zophop.room.VisualValidationRepository$insertVisualValidationActivationDetails$lInsertionJob$1
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
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.VisualValidationRepository.insertVisualValidationActivationDetails(app.zophop.models.mTicketing.VisualValidationActivationDetails, k66):java.lang.Object");
    }
}
