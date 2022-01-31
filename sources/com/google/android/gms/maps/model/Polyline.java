package com.google.android.gms.maps.model;

import android.os.RemoteException;
import java.util.List;
import java.util.Objects;

public final class Polyline {
    private final ho3 zzeb;

    public Polyline(ho3 ho3) {
        Objects.requireNonNull(ho3, "null reference");
        this.zzeb = ho3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.zzeb.Y0(((Polyline) obj).zzeb);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getColor() {
        try {
            return this.zzeb.m3();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Cap getEndCap() {
        try {
            return this.zzeb.u3().zzh();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        try {
            return this.zzeb.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getJointType() {
        try {
            return this.zzeb.y1();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final List<PatternItem> getPattern() {
        try {
            return PatternItem.zza(this.zzeb.e1());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final List<LatLng> getPoints() {
        try {
            return this.zzeb.t();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Cap getStartCap() {
        try {
            return this.zzeb.v0().zzh();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Object getTag() {
        try {
            return kc2.L(this.zzeb.c());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getWidth() {
        try {
            return this.zzeb.k();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getZIndex() {
        try {
            return this.zzeb.d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zzeb.b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isClickable() {
        try {
            return this.zzeb.g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isGeodesic() {
        try {
            return this.zzeb.D();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zzeb.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void remove() {
        try {
            this.zzeb.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setClickable(boolean z) {
        try {
            this.zzeb.i(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setColor(int i) {
        try {
            this.zzeb.k1(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setEndCap(Cap cap) {
        gj1.l(cap, "endCap must not be null");
        try {
            this.zzeb.K0(cap);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setGeodesic(boolean z) {
        try {
            this.zzeb.v(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setJointType(int i) {
        try {
            this.zzeb.n2(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPattern(List<PatternItem> list) {
        try {
            this.zzeb.i0(list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPoints(List<LatLng> list) {
        try {
            this.zzeb.y(list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStartCap(Cap cap) {
        gj1.l(cap, "startCap must not be null");
        try {
            this.zzeb.V2(cap);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTag(Object obj) {
        try {
            this.zzeb.e(new kc2(obj));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zzeb.setVisible(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setWidth(float f) {
        try {
            this.zzeb.s2(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZIndex(float f) {
        try {
            this.zzeb.a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
