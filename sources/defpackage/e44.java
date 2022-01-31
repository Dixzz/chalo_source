package defpackage;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Objects;

/* renamed from: e44  reason: default package */
public final class e44 {

    /* renamed from: a  reason: collision with root package name */
    public final l44 f924a;
    public j44 b;

    /* renamed from: e44$a */
    public interface a {
    }

    /* renamed from: e44$b */
    public interface b {
        View b(Marker marker);

        View d(Marker marker);
    }

    @Deprecated
    /* renamed from: e44$c */
    public interface c {
        void a(CameraPosition cameraPosition);
    }

    /* renamed from: e44$d */
    public interface d {
    }

    /* renamed from: e44$e */
    public interface e {
        void a(Marker marker);
    }

    /* renamed from: e44$f */
    public interface f {
        void c(Marker marker);
    }

    /* renamed from: e44$g */
    public interface g {
        void a();
    }

    /* renamed from: e44$h */
    public interface h {
        boolean a(Marker marker);
    }

    /* renamed from: e44$i */
    public static final class i extends f54 {
        public final a f;

        public i(a aVar) {
            this.f = aVar;
        }
    }

    public e44(l44 l44) {
        Objects.requireNonNull(l44, "null reference");
        this.f924a = l44;
    }

    public final Marker a(MarkerOptions markerOptions) {
        try {
            do3 D3 = this.f924a.D3(markerOptions);
            if (D3 != null) {
                return new Marker(D3);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(d44 d44) {
        try {
            this.f924a.I2(d44.f786a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c(d44 d44, int i2, a aVar) {
        i iVar;
        try {
            l44 l44 = this.f924a;
            ic2 ic2 = d44.f786a;
            if (aVar == null) {
                iVar = null;
            } else {
                iVar = new i(aVar);
            }
            l44.u1(ic2, i2, iVar);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final CameraPosition d() {
        try {
            return this.f924a.Q0();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final h44 e() {
        try {
            return new h44(this.f924a.B2());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final j44 f() {
        try {
            if (this.b == null) {
                this.b = new j44(this.f924a.c2());
            }
            return this.b;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void g(d44 d44) {
        try {
            this.f924a.P0(d44.f786a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void h(boolean z) {
        try {
            this.f924a.d3(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Deprecated
    public final void i(c cVar) {
        try {
            this.f924a.l0(new y54(cVar));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void j(g gVar) {
        try {
            this.f924a.u0(new x54(gVar));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void k(h hVar) {
        try {
            this.f924a.k3(new t54(hVar));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
