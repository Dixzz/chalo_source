package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
/* renamed from: io1  reason: default package */
/* compiled from: SizeConfigStrategy */
public class io1 implements go1 {
    public static final Bitmap.Config[] d = {Bitmap.Config.ARGB_8888, null};
    public static final Bitmap.Config[] e = {Bitmap.Config.RGB_565};
    public static final Bitmap.Config[] f = {Bitmap.Config.ARGB_4444};
    public static final Bitmap.Config[] g = {Bitmap.Config.ALPHA_8};

    /* renamed from: a  reason: collision with root package name */
    public final c f1544a = new c();
    public final co1<b, Bitmap> b = new co1<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap();

    /* renamed from: io1$a */
    /* compiled from: SizeConfigStrategy */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1545a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                defpackage.io1.a.f1545a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = defpackage.io1.a.f1545a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = defpackage.io1.a.f1545a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = defpackage.io1.a.f1545a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.io1.a.<clinit>():void");
        }
    }

    /* renamed from: io1$b */
    /* compiled from: SizeConfigStrategy */
    public static final class b implements ho1 {

        /* renamed from: a  reason: collision with root package name */
        public final c f1546a;
        public int b;
        public Bitmap.Config c;

        public b(c cVar) {
            this.f1546a = cVar;
        }

        @Override // defpackage.ho1
        public void a() {
            this.f1546a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b != bVar.b || !rt1.b(this.c, bVar.c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.b * 31;
            Bitmap.Config config = this.c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return io1.c(this.b, this.c);
        }
    }

    /* renamed from: io1$c */
    /* compiled from: SizeConfigStrategy */
    public static class c extends yn1<b> {
        /* Return type fixed from 'ho1' to match base method */
        @Override // defpackage.yn1
        public b a() {
            return new b(this);
        }

        public b d(int i, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b = i;
            bVar.c = config;
            return bVar;
        }
    }

    public static String c(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> d2 = d(bitmap.getConfig());
        Integer num2 = (Integer) d2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            d2.remove(num);
        } else {
            d2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int c2 = rt1.c(i, i2, config);
        b bVar = (b) this.f1544a.b();
        bVar.b = c2;
        bVar.c = config;
        int i3 = a.f1545a[config.ordinal()];
        int i4 = 0;
        if (i3 == 1) {
            configArr = d;
        } else if (i3 == 2) {
            configArr = e;
        } else if (i3 != 3) {
            configArr = i3 != 4 ? new Bitmap.Config[]{config} : g;
        } else {
            configArr = f;
        }
        int length = configArr.length;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i4];
            Integer ceilingKey = d(config2).ceilingKey(Integer.valueOf(c2));
            if (ceilingKey == null || ceilingKey.intValue() > c2 * 8) {
                i4++;
            } else if (ceilingKey.intValue() != c2 || config2 == null || !config2.equals(config)) {
                this.f1544a.c(bVar);
                bVar = this.f1544a.d(ceilingKey.intValue(), config2);
            }
        }
        Bitmap a2 = this.b.a(bVar);
        if (a2 != null) {
            a(Integer.valueOf(bVar.b), a2);
            a2.reconfigure(i, i2, a2.getConfig() != null ? a2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a2;
    }

    public final NavigableMap<Integer, Integer> d(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(config, treeMap);
        return treeMap;
    }

    public String e(Bitmap bitmap) {
        return c(rt1.d(bitmap), bitmap.getConfig());
    }

    public void f(Bitmap bitmap) {
        b d2 = this.f1544a.d(rt1.d(bitmap), bitmap.getConfig());
        this.b.b(d2, bitmap);
        NavigableMap<Integer, Integer> d3 = d(bitmap.getConfig());
        Integer num = (Integer) d3.get(Integer.valueOf(d2.b));
        Integer valueOf = Integer.valueOf(d2.b);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        d3.put(valueOf, Integer.valueOf(i));
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SizeConfigStrategy{groupedMap=");
        i0.append(this.b);
        i0.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.c.entrySet()) {
            i0.append(entry.getKey());
            i0.append('[');
            i0.append(entry.getValue());
            i0.append("], ");
        }
        if (!this.c.isEmpty()) {
            i0.replace(i0.length() - 2, i0.length(), "");
        }
        i0.append(")}");
        return i0.toString();
    }
}
