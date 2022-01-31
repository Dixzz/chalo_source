package defpackage;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* renamed from: aw1  reason: default package */
/* compiled from: MetadataBackendRegistry */
public class aw1 implements uv1 {

    /* renamed from: a  reason: collision with root package name */
    public final a f339a;
    public final yv1 b;
    public final Map<String, cw1> c = new HashMap();

    /* renamed from: aw1$a */
    /* compiled from: MetadataBackendRegistry */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f340a;
        public Map<String, String> b = null;

        public a(Context context) {
            this.f340a = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public defpackage.tv1 a(java.lang.String r14) {
            /*
            // Method dump skipped, instructions count: 207
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.aw1.a.a(java.lang.String):tv1");
        }
    }

    @Inject
    public aw1(Context context, yv1 yv1) {
        a aVar = new a(context);
        this.f339a = aVar;
        this.b = yv1;
    }

    @Override // defpackage.uv1
    public synchronized cw1 a(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        tv1 a2 = this.f339a.a(str);
        if (a2 == null) {
            return null;
        }
        yv1 yv1 = this.b;
        cw1 create = a2.create(new sv1(yv1.f4088a, yv1.b, yv1.c, str));
        this.c.put(str, create);
        return create;
    }
}
