package defpackage;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.Gender;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import server.zophop.queue.TaskKeys;

/* renamed from: da1  reason: default package */
/* compiled from: SuperPassBasicUserDetailsFragmentViewModel.kt */
public final class da1 extends zh {
    public final wh c;
    public final ArrayList<Gender> d;
    public String e;
    public final j56 f = hd3.a2(new e(this));
    public final j56 g = hd3.a2(new d(this));
    public final j56 h = hd3.a2(new c(this));
    public final j56 i = hd3.a2(new b(this));

    /* renamed from: da1$a */
    /* compiled from: SuperPassBasicUserDetailsFragmentViewModel.kt */
    public static final class a extends kg {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(mm mmVar, Bundle bundle) {
            super(mmVar, bundle);
            n86.e(mmVar, TaskKeys.OWNER);
        }

        @Override // defpackage.kg
        public <T extends zh> T d(String str, Class<T> cls, wh whVar) {
            n86.e(str, AnalyticsConstants.KEY);
            n86.e(cls, "modelClass");
            n86.e(whVar, "handle");
            return new da1(whVar);
        }
    }

    /* renamed from: da1$b */
    /* compiled from: SuperPassBasicUserDetailsFragmentViewModel.kt */
    public static final class b extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ da1 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(da1 da1) {
            super(0);
            this.f = da1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.c.a("keyAreAllRequiredFieldsSet", Boolean.FALSE);
        }
    }

    /* renamed from: da1$c */
    /* compiled from: SuperPassBasicUserDetailsFragmentViewModel.kt */
    public static final class c extends o86 implements h76<oh<String>> {
        public final /* synthetic */ da1 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(da1 da1) {
            super(0);
            this.f = da1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<String> invoke() {
            return this.f.c.a("keyDob", null);
        }
    }

    /* renamed from: da1$d */
    /* compiled from: SuperPassBasicUserDetailsFragmentViewModel.kt */
    public static final class d extends o86 implements h76<oh<Long>> {
        public final /* synthetic */ da1 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(da1 da1) {
            super(0);
            this.f = da1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Long> invoke() {
            return this.f.c.a("keyPassStartDate", null);
        }
    }

    /* renamed from: da1$e */
    /* compiled from: SuperPassBasicUserDetailsFragmentViewModel.kt */
    public static final class e extends o86 implements h76<oh<Gender>> {
        public final /* synthetic */ da1 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(da1 da1) {
            super(0);
            this.f = da1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Gender> invoke() {
            return this.f.c.a("keyGender", null);
        }
    }

    public da1(wh whVar) {
        n86.e(whVar, "savedStateHandle");
        this.c = whVar;
        ArrayList<Gender> arrayList = new ArrayList<>();
        this.d = arrayList;
        this.e = (String) whVar.f3779a.get("keyFullName");
        arrayList.add(Gender.MALE);
        arrayList.add(Gender.FEMALE);
        arrayList.add(Gender.OTHER);
    }

    public final void d() {
        String str = this.e;
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            String d2 = f().d();
            if (d2 != null) {
                if (d2.length() > 0) {
                    z = true;
                }
            }
            if (!(!z || h().d() == null || g().d() == null)) {
                e().j(Boolean.TRUE);
                return;
            }
        }
        e().j(Boolean.FALSE);
    }

    public final oh<Boolean> e() {
        Object value = this.i.getValue();
        n86.d(value, "<get-areAllRequiredFieldsSet>(...)");
        return (oh) value;
    }

    public final LiveData<String> f() {
        Object value = this.h.getValue();
        n86.d(value, "<get-dateOfBirth>(...)");
        return (LiveData) value;
    }

    public final LiveData<Long> g() {
        Object value = this.g.getValue();
        n86.d(value, "<get-passStartDate>(...)");
        return (LiveData) value;
    }

    public final LiveData<Gender> h() {
        Object value = this.f.getValue();
        n86.d(value, "<get-selectedGender>(...)");
        return (LiveData) value;
    }
}
