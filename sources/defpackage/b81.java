package defpackage;

import androidx.lifecycle.LiveData;
import app.zophop.models.City;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: b81  reason: default package */
/* compiled from: CitySelectionViewModel.kt */
public final class b81 extends zh {
    public final wh c;
    public final j56 d = hd3.a2(c.f);
    public List<? extends City> e;
    public final j56 f = hd3.a2(new b(this));
    public final j56 g = hd3.a2(new a(this));

    /* renamed from: b81$a */
    /* compiled from: CitySelectionViewModel.kt */
    public static final class a extends o86 implements h76<oh<List<? extends wi0.b>>> {
        public final /* synthetic */ b81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b81 b81) {
            super(0);
            this.f = b81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<List<? extends wi0.b>> invoke() {
            return new oh((List) this.f.f.getValue());
        }
    }

    /* renamed from: b81$b */
    /* compiled from: CitySelectionViewModel.kt */
    public static final class b extends o86 implements h76<List<? extends wi0.b>> {
        public final /* synthetic */ b81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b81 b81) {
            super(0);
            this.f = b81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public List<? extends wi0.b> invoke() {
            b81 b81 = this.f;
            Objects.requireNonNull(b81);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            List<? extends City> list = b81.e;
            if (list != null) {
                for (T t : list) {
                    if (!t.isCityDiscontinued()) {
                        if (t.isBetaCity()) {
                            arrayList2.add(t);
                        } else {
                            arrayList.add(t);
                        }
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList3.add(new wi0.b(wi0.c.CITY, (City) it.next()));
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(new wi0.b(wi0.c.CITY, (City) it2.next()));
            }
            arrayList3.add(new wi0.b(wi0.c.FOOTER, null));
            return arrayList3;
        }
    }

    /* renamed from: b81$c */
    /* compiled from: CitySelectionViewModel.kt */
    public static final class c extends o86 implements h76<e80> {
        public static final c f = new c();

        public c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public e80 invoke() {
            return xt.f3961a.k();
        }
    }

    public b81(wh whVar) {
        n86.e(whVar, "savedStateHandle");
        this.c = whVar;
    }

    public final e80 d() {
        return (e80) this.d.getValue();
    }

    public final LiveData<String> e() {
        oh a2 = this.c.a("currentQuery", "");
        n86.d(a2, "savedStateHandle.getLiveData(KEY_CURRENT_QUERY,\"\")");
        return a2;
    }

    public final boolean f() {
        List<City> e2 = d().e();
        this.e = e2;
        if (e2 != null) {
            return true;
        }
        d().g();
        return false;
    }
}
