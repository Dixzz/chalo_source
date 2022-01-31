package defpackage;

import androidx.appcompat.widget.ListPopupWindow;
import com.google.firebase.perf.util.Constants;

/* renamed from: d55  reason: default package */
/* compiled from: Base256Encoder */
public final class d55 implements i55 {
    @Override // defpackage.i55
    public void a(j55 j55) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!j55.d()) {
                break;
            }
            sb.append(j55.b());
            int i = j55.f + 1;
            j55.f = i;
            if (hd3.e2(j55.f1880a, i, 5) != 5) {
                j55.g = 0;
                break;
            }
        }
        int length = sb.length() - 1;
        int a2 = j55.a() + length + 1;
        j55.f(a2);
        boolean z = j55.h.b - a2 > 0;
        if (j55.d() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / ListPopupWindow.EXPAND_LIST_TIMEOUT) + 249));
                sb.insert(1, (char) (length % ListPopupWindow.EXPAND_LIST_TIMEOUT));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            int a3 = (((j55.a() + 1) * 149) % Constants.MAX_HOST_LENGTH) + 1 + sb.charAt(i2);
            if (a3 > 255) {
                a3 -= 256;
            }
            j55.e.append((char) a3);
        }
    }
}
