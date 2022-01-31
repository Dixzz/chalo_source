package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final zn3 zzdd;
    private final zza zzde;

    public IndoorBuilding(zn3 zn3) {
        this(zn3, zza.zzdf);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zzdd.j3(((IndoorBuilding) obj).zzdd);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getActiveLevelIndex() {
        try {
            return this.zzdd.o2();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getDefaultLevelIndex() {
        try {
            return this.zzdd.x1();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final List<IndoorLevel> getLevels() {
        try {
            List<IBinder> m0 = this.zzdd.m0();
            ArrayList arrayList = new ArrayList(m0.size());
            for (IBinder iBinder : m0) {
                arrayList.add(zza.zza(zza.zza(iBinder)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zzdd.b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isUnderground() {
        try {
            return this.zzdd.I3();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private IndoorBuilding(zn3 zn3, zza zza2) {
        gj1.l(zn3, "delegate");
        this.zzdd = zn3;
        gj1.l(zza2, "shim");
        this.zzde = zza2;
    }

    public static class zza {
        public static final zza zzdf = new zza();

        private zza() {
        }

        public static ao3 zza(IBinder iBinder) {
            int i = bo3.f;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            if (queryLocalInterface instanceof ao3) {
                return (ao3) queryLocalInterface;
            }
            return new co3(iBinder);
        }

        public static IndoorLevel zza(ao3 ao3) {
            return new IndoorLevel(ao3);
        }
    }
}
