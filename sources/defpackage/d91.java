package defpackage;

import android.app.Application;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: d91  reason: default package */
/* compiled from: SplashScreenViewModel.kt */
public final class d91 extends lg {
    public final j56 d = hd3.a2(b.f);
    public final j56 e;
    public final m66 f;

    /* renamed from: d91$a */
    /* compiled from: SplashScreenViewModel.kt */
    public static final class a extends o86 implements h76<rf1> {
        public final /* synthetic */ Application f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            super(0);
            this.f = application;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public rf1 invoke() {
            return new rf1(this.f, "app_open_daily_store");
        }
    }

    /* renamed from: d91$b */
    /* compiled from: SplashScreenViewModel.kt */
    public static final class b extends o86 implements h76<Map<String, String>> {
        public static final b f = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Map<String, String> invoke() {
            HashMap hashMap = new HashMap();
            Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
            instance.setTimeInMillis(System.currentTimeMillis() - ((long) 19800000));
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(instance.getTime());
            n86.d(format, "lDate");
            hashMap.put("firstSeen", format);
            return hashMap;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d91(Application application) {
        super(application);
        n86.e(application, "application");
        this.e = hd3.a2(new a(application));
        kb6 kb6 = xb6.c;
        int i = CoroutineExceptionHandler.d;
        this.f = kb6.plus(new lh1(CoroutineExceptionHandler.a.f));
    }
}
