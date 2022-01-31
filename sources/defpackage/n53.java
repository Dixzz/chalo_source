package defpackage;

import android.text.TextUtils;
import java.lang.reflect.Type;

/* renamed from: n53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class n53 {
    public static Object a(String str, Type type) throws e13 {
        String str2;
        String str3;
        String str4;
        if (type == String.class) {
            try {
                v63 v63 = new v63();
                v63.a(str);
                if (!TextUtils.isEmpty(v63.f)) {
                    return v63.f;
                }
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str4 = "No error message: ".concat(valueOf);
                } else {
                    str4 = new String("No error message: ");
                }
                throw new e13(str4);
            } catch (Exception e) {
                String valueOf2 = String.valueOf(e.getMessage());
                if (valueOf2.length() != 0) {
                    str3 = "Json conversion failed! ".concat(valueOf2);
                } else {
                    str3 = new String("Json conversion failed! ");
                }
                throw new e13(str3, e);
            }
        } else if (type == Void.class) {
            return null;
        } else {
            try {
                p53 p53 = (p53) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0]);
                try {
                    p53.zza(str);
                    return p53;
                } catch (Exception e2) {
                    String valueOf3 = String.valueOf(e2.getMessage());
                    if (valueOf3.length() != 0) {
                        str2 = "Json conversion failed! ".concat(valueOf3);
                    } else {
                        str2 = new String("Json conversion failed! ");
                    }
                    throw new e13(str2, e2);
                }
            } catch (Exception e3) {
                String valueOf4 = String.valueOf(type);
                throw new e13(hj1.a0(new StringBuilder(valueOf4.length() + 38), "Instantiation of JsonResponse failed! ", valueOf4), e3);
            }
        }
    }
}
