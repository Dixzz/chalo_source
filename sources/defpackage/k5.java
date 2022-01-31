package defpackage;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: k5  reason: default package */
/* compiled from: NotificationCompatJellybean */
public class k5 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2023a = new Object();

    public static Bundle a(c5 c5Var) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat a2 = c5Var.a();
        bundle2.putInt("icon", a2 != null ? a2.c() : 0);
        bundle2.putCharSequence(ProductPromotionsObject.KEY_TITLE, c5Var.j);
        bundle2.putParcelable("actionIntent", c5Var.k);
        if (c5Var.f519a != null) {
            bundle = new Bundle(c5Var.f519a);
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c5Var.e);
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", b(c5Var.c));
        bundle2.putBoolean("showsUserInterface", c5Var.f);
        bundle2.putInt("semanticAction", c5Var.g);
        return bundle2;
    }

    public static Bundle[] b(n5[] n5VarArr) {
        if (n5VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[n5VarArr.length];
        for (int i = 0; i < n5VarArr.length; i++) {
            n5 n5Var = n5VarArr[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", n5Var.f2515a);
            bundle.putCharSequence(Constants.ScionAnalytics.PARAM_LABEL, n5Var.b);
            bundle.putCharSequenceArray("choices", n5Var.c);
            bundle.putBoolean("allowFreeFormInput", n5Var.d);
            bundle.putBundle("extras", n5Var.f);
            Set<String> set = n5Var.g;
            if (set != null && !set.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>(set.size());
                for (String str : set) {
                    arrayList.add(str);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }
}
