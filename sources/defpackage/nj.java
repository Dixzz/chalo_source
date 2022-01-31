package defpackage;

import android.annotation.SuppressLint;
import defpackage.mj;
import java.util.HashMap;

@SuppressLint({"TypeParameterUnusedInFormals"})
/* renamed from: nj  reason: default package */
/* compiled from: NavigatorProvider */
public class nj {
    public static final HashMap<Class<?>, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, mj<? extends ej>> f2563a = new HashMap<>();

    public static String b(Class<? extends mj> cls) {
        HashMap<Class<?>, String> hashMap = b;
        String str = hashMap.get(cls);
        if (str == null) {
            mj.b bVar = (mj.b) cls.getAnnotation(mj.b.class);
            str = bVar != null ? bVar.value() : null;
            if (d(str)) {
                hashMap.put(cls, str);
            } else {
                StringBuilder i0 = hj1.i0("No @Navigator.Name annotation found for ");
                i0.append(cls.getSimpleName());
                throw new IllegalArgumentException(i0.toString());
            }
        }
        return str;
    }

    public static boolean d(String str) {
        return str != null && !str.isEmpty();
    }

    public final mj<? extends ej> a(mj<? extends ej> mjVar) {
        String b2 = b(mjVar.getClass());
        if (d(b2)) {
            return this.f2563a.put(b2, mjVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public <T extends mj<?>> T c(String str) {
        if (d(str)) {
            mj<? extends ej> mjVar = this.f2563a.get(str);
            if (mjVar != null) {
                return mjVar;
            }
            throw new IllegalStateException(hj1.T("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}
