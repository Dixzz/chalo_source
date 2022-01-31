package defpackage;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import defpackage.km;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: wh  reason: default package */
/* compiled from: SavedStateHandle */
public final class wh {
    public static final Class[] e = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f3779a;
    public final Map<String, km.b> b;
    public final Map<String, b<?>> c;
    public final km.b d;

    /* renamed from: wh$a */
    /* compiled from: SavedStateHandle */
    public class a implements km.b {
        public a() {
        }

        @Override // defpackage.km.b
        public Bundle a() {
            for (Map.Entry entry : new HashMap(wh.this.b).entrySet()) {
                wh.this.b((String) entry.getKey(), ((km.b) entry.getValue()).a());
            }
            Set<String> keySet = wh.this.f3779a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(wh.this.f3779a.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    /* renamed from: wh$b */
    /* compiled from: SavedStateHandle */
    public static class b<T> extends oh<T> {
        public String l;
        public wh m;

        public b(wh whVar, String str, T t) {
            super(t);
            this.l = str;
            this.m = whVar;
        }

        @Override // androidx.lifecycle.LiveData, defpackage.oh
        public void l(T t) {
            wh whVar = this.m;
            if (whVar != null) {
                whVar.f3779a.put(this.l, t);
            }
            super.l(t);
        }
    }

    public wh(Map<String, Object> map) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new a();
        this.f3779a = new HashMap(map);
    }

    public <T> oh<T> a(String str, @SuppressLint({"UnknownNullness"}) T t) {
        b<?> bVar = this.c.get(str);
        if (bVar == null) {
            if (this.f3779a.containsKey(str)) {
                bVar = new b<>(this, str, this.f3779a.get(str));
            } else {
                bVar = new b<>(this, str, t);
            }
            this.c.put(str, bVar);
        }
        return bVar;
    }

    public <T> void b(String str, T t) {
        if (t != null) {
            for (Class cls : e) {
                if (!cls.isInstance(t)) {
                }
            }
            StringBuilder i0 = hj1.i0("Can't put value with type ");
            i0.append(t.getClass());
            i0.append(" into saved state");
            throw new IllegalArgumentException(i0.toString());
        }
        b<?> bVar = this.c.get(str);
        if (bVar != null) {
            bVar.l(t);
        } else {
            this.f3779a.put(str, t);
        }
    }

    public wh() {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new a();
        this.f3779a = new HashMap();
    }
}
