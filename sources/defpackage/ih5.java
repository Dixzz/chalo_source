package defpackage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.rabbitmq.client.AMQP;

/* renamed from: ih5  reason: default package */
/* compiled from: PermissionsFragment.kt */
public final class ih5 extends Fragment {
    public jh5 f;
    public String[] g;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        n86.e(strArr, "permissions");
        n86.e(iArr, "grantResults");
        jh5 jh5 = this.f;
        if (jh5 != null) {
            n86.e(strArr, "permissions");
            n86.e(iArr, "grantResults");
            if (i == 200) {
                int length = iArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (iArr[i2] == 0) {
                        jh5.c(strArr[i2], false);
                    } else {
                        if (!t4.d(jh5.c, strArr[i2])) {
                            jh5.c(strArr[i2], true);
                        }
                    }
                }
                jh5.d();
            }
            this.g = null;
            return;
        }
        n86.l("requestPermissionHandler");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String[] strArr = this.g;
        if (strArr != null) {
            requestPermissions(strArr, AMQP.REPLY_SUCCESS);
        }
        this.g = null;
    }
}
