package defpackage;

import android.content.Context;
import android.content.Intent;
import defpackage.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: u  reason: default package */
/* compiled from: ActivityResultContracts */
public final class u extends t<String[], Map<String, Boolean>> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
    @Override // defpackage.t
    public Intent a(Context context, String[] strArr) {
        return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
    }

    /* Return type fixed from 't$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
    @Override // defpackage.t
    public t.a<Map<String, Boolean>> b(Context context, String[] strArr) {
        String[] strArr2 = strArr;
        if (strArr2 == null || strArr2.length == 0) {
            return new t.a(Collections.emptyMap());
        }
        n2 n2Var = new n2();
        boolean z = true;
        for (String str : strArr2) {
            boolean z2 = q5.a(context, str) == 0;
            n2Var.put(str, Boolean.valueOf(z2));
            if (!z2) {
                z = false;
            }
        }
        if (z) {
            return new t.a(n2Var);
        }
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.t
    public Map<String, Boolean> c(int i, Intent intent) {
        if (i != -1) {
            return Collections.emptyMap();
        }
        if (intent == null) {
            return Collections.emptyMap();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        int length = stringArrayExtra.length;
        for (int i2 = 0; i2 < length; i2++) {
            hashMap.put(stringArrayExtra[i2], Boolean.valueOf(intArrayExtra[i2] == 0));
        }
        return hashMap;
    }
}
