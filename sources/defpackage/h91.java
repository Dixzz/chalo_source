package defpackage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import java.util.List;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: h91  reason: default package */
/* compiled from: CardDetailsFragmentViewModel.kt */
public final class h91 extends lg {
    public final wh d;
    public final m66 e;
    public final CardRechargeConfiguration f;
    public String g;
    public String h;
    public final j56 i;
    public final j56 j;
    public final j56 k;
    public final j56 l;
    public String m;
    public final j56 n;
    public long o;
    public final j56 p;
    public final LiveData<List<OnlineCardRecharge>> q;

    /* renamed from: h91$a */
    /* compiled from: CardDetailsFragmentViewModel.kt */
    public static final class a extends o86 implements h76<oh<String>> {
        public final /* synthetic */ h91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h91 h91) {
            super(0);
            this.f = h91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<String> invoke() {
            return this.f.d.a("keyErrorMessage", "");
        }
    }

    /* renamed from: h91$b */
    /* compiled from: CardDetailsFragmentViewModel.kt */
    public static final class b extends o86 implements h76<oh<String>> {
        public final /* synthetic */ h91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h91 h91) {
            super(0);
            this.f = h91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<String> invoke() {
            return this.f.d.a("keyGenericErrorToastMessage", "");
        }
    }

    /* renamed from: h91$c */
    /* compiled from: CardDetailsFragmentViewModel.kt */
    public static final class c extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ h91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(h91 h91) {
            super(0);
            this.f = h91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.d.a("keyIsEnteredCardNoOk", Boolean.FALSE);
        }
    }

    /* renamed from: h91$d */
    /* compiled from: CardDetailsFragmentViewModel.kt */
    public static final class d extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ h91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(h91 h91) {
            super(0);
            this.f = h91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.d.a("keyIsReEnteredCardNoOk", Boolean.FALSE);
        }
    }

    /* renamed from: h91$e */
    /* compiled from: CardDetailsFragmentViewModel.kt */
    public static final class e extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ h91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(h91 h91) {
            super(0);
            this.f = h91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.d.a("keyShouldShowCardNoDoesNotMatchError", Boolean.FALSE);
        }
    }

    /* renamed from: h91$f */
    /* compiled from: CardDetailsFragmentViewModel.kt */
    public static final class f extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ h91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(h91 h91) {
            super(0);
            this.f = h91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.d.a("keyShouldShowLoader", Boolean.FALSE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        kb6 kb6 = xb6.b;
        int i2 = CoroutineExceptionHandler.d;
        this.e = kb6.plus(new lh1(CoroutineExceptionHandler.a.f));
        Object obj = whVar.f3779a.get("keyCardRechargeConfiguration");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<Car…RECHARGE_CONFIGURATION)!!");
        this.f = (CardRechargeConfiguration) obj;
        String str = (String) whVar.f3779a.get("keyCardNo");
        String str2 = "";
        this.g = str == null ? str2 : str;
        String str3 = (String) whVar.f3779a.get("keyReEnteredCardNo");
        this.h = str3 != null ? str3 : str2;
        this.i = hd3.a2(new c(this));
        this.j = hd3.a2(new d(this));
        this.k = hd3.a2(new e(this));
        this.l = hd3.a2(new f(this));
        this.m = new String();
        this.n = hd3.a2(new a(this));
        Long l2 = (Long) whVar.f3779a.get("keyRechargeLimit");
        this.o = l2 == null ? -1 : l2.longValue();
        this.p = hd3.a2(new b(this));
        this.q = wg.a(xt.f3961a.K().getRecentOnlineCardRecharges(), null, 0, 3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(defpackage.h91 r16, java.lang.String r17, boolean r18, defpackage.k66 r19) {
        /*
        // Method dump skipped, instructions count: 560
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h91.d(h91, java.lang.String, boolean, k66):java.lang.Object");
    }
}
