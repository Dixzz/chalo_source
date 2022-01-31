package defpackage;

import android.R;
import android.content.Context;
import android.util.SparseArray;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* renamed from: zc5  reason: default package */
/* compiled from: ResourceReader */
public abstract class zc5 implements yc5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4157a;
    public final Map<String, Integer> b = new HashMap();
    public final SparseArray<String> c = new SparseArray<>();

    /* renamed from: zc5$a */
    /* compiled from: ResourceReader */
    public static class a extends zc5 {
        public final String d;

        public a(String str, Context context) {
            super(context);
            this.d = str;
            d();
        }

        @Override // defpackage.zc5
        public String a(Context context) {
            return hj1.a0(new StringBuilder(), this.d, ".R$drawable");
        }

        @Override // defpackage.zc5
        public Class<?> b() {
            return R.drawable.class;
        }
    }

    /* renamed from: zc5$b */
    /* compiled from: ResourceReader */
    public static class b extends zc5 {
        public final String d;

        public b(String str, Context context) {
            super(context);
            this.d = str;
            d();
        }

        @Override // defpackage.zc5
        public String a(Context context) {
            return hj1.a0(new StringBuilder(), this.d, ".R$id");
        }

        @Override // defpackage.zc5
        public Class<?> b() {
            return R.id.class;
        }
    }

    public zc5(Context context) {
        this.f4157a = context;
    }

    public static void e(Class<?> cls, String str, Map<String, Integer> map) {
        try {
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    try {
                        String name = field.getName();
                        int i = field.getInt(null);
                        if (str != null) {
                            name = str + ProductDiscountsObject.KEY_DELIMITER + name;
                        }
                        map.put(name, Integer.valueOf(i));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (IllegalAccessException unused2) {
            cls.getName();
        }
    }

    public abstract String a(Context context);

    public abstract Class<?> b();

    public int c(String str) {
        return this.b.get(str).intValue();
    }

    public void d() {
        this.b.clear();
        this.c.clear();
        e(b(), "android", this.b);
        try {
            e(Class.forName(a(this.f4157a)), null, this.b);
        } catch (ClassNotFoundException unused) {
        }
        for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
            this.c.put(entry.getValue().intValue(), entry.getKey());
        }
    }
}
