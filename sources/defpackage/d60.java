package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import defpackage.n00;
import defpackage.xt;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: d60  reason: default package */
/* compiled from: SecurityHandler */
public class d60 implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f794a;
    public final Object b;

    /* renamed from: d60$a */
    /* compiled from: SecurityHandler */
    public class a implements n00.a1 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f795a;
        public final /* synthetic */ Method b;
        public final /* synthetic */ Object[] c;

        public a(Object obj, Method method, Object[] objArr) {
            this.f795a = obj;
            this.b = method;
            this.c = objArr;
        }
    }

    public d60(Context context, Object obj) {
        this.f794a = context;
        this.b = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        boolean z;
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        boolean z2 = true;
        if (declaredAnnotations != null) {
            int length = declaredAnnotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (declaredAnnotations[i] instanceof c60) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        z = false;
        if (!z) {
            return method.invoke(this.b, objArr);
        }
        SharedPreferences sharedPreferences = this.f794a.getSharedPreferences("accessToken", 0);
        sharedPreferences.edit();
        Long valueOf = Long.valueOf(sharedPreferences.getLong(SuperPassJsonKeys.EXPIRY_TIME, -1));
        Long valueOf2 = Long.valueOf(sharedPreferences.getLong("delta", -1));
        long longValue = Long.valueOf((valueOf.longValue() - Long.valueOf(System.currentTimeMillis() / 1000).longValue()) - valueOf2.longValue()).longValue();
        xt.t1 t1Var = xt.f3961a;
        if (longValue <= t1Var.t().c("secureClientExpiryTime")) {
            z2 = false;
        }
        if (z2) {
            return method.invoke(this.b, objArr);
        }
        String a2 = t1Var.L().a();
        if (a2 == null) {
            return null;
        }
        t1Var.c().z(a2, new a(obj, method, objArr));
        return null;
    }
}
