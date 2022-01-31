package defpackage;

import android.content.Context;
import android.content.Intent;
import defpackage.t;

/* renamed from: v  reason: default package */
/* compiled from: ActivityResultContracts */
public final class v extends t<String, Boolean> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
    @Override // defpackage.t
    public Intent a(Context context, String str) {
        return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{str});
    }

    /* Return type fixed from 't$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
    @Override // defpackage.t
    public t.a<Boolean> b(Context context, String str) {
        String str2 = str;
        if (str2 == null) {
            return new t.a(Boolean.FALSE);
        }
        if (q5.a(context, str2) == 0) {
            return new t.a(Boolean.TRUE);
        }
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.t
    public Boolean c(int i, Intent intent) {
        int[] intArrayExtra;
        Boolean bool = Boolean.FALSE;
        if (intent == null || i != -1 || (intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS")) == null || intArrayExtra.length == 0) {
            return bool;
        }
        boolean z = false;
        if (intArrayExtra[0] == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
