package defpackage;

import app.zophop.ui.activities.CabBookingActivity;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import defpackage.e44;
import java.util.Objects;

/* renamed from: ed0  reason: default package */
/* compiled from: CabBookingActivity */
public class ed0 implements g44 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CabBookingActivity f958a;

    /* renamed from: ed0$a */
    /* compiled from: CabBookingActivity */
    public class a implements e44.c {
        public a() {
        }

        @Override // defpackage.e44.c
        public void a(CameraPosition cameraPosition) {
            Objects.requireNonNull(ed0.this.f958a);
        }
    }

    /* renamed from: ed0$b */
    /* compiled from: CabBookingActivity */
    public class b implements e44.h {
        public b(ed0 ed0) {
        }

        @Override // defpackage.e44.h
        public boolean a(Marker marker) {
            return false;
        }
    }

    /* renamed from: ed0$c */
    /* compiled from: CabBookingActivity */
    public class c implements e44.g {
        public c() {
        }

        @Override // defpackage.e44.g
        public void a() {
            CabBookingActivity cabBookingActivity = ed0.this.f958a;
            int i = CabBookingActivity.K;
            cabBookingActivity.J0();
            ed0.this.f958a.n.g(hd3.j2(xt.f3961a.k().d().getBounds(), 0));
            Objects.requireNonNull(ed0.this.f958a);
        }
    }

    public ed0(CabBookingActivity cabBookingActivity) {
        this.f958a = cabBookingActivity;
    }

    @Override // defpackage.g44
    public void a(e44 e44) {
        this.f958a.n = e44;
        e44.f().d(false);
        this.f958a.n.f().b(false);
        this.f958a.n.h(true);
        this.f958a.n.i(new a());
        this.f958a.n.k(new b(this));
        this.f958a.n.j(new c());
        this.f958a.N0();
        e44 e442 = this.f958a.n;
        if (e442 != null) {
            vn.V0(e442);
        }
    }
}
