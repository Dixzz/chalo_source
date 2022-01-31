package com.google.android.gms.maps.model;

import android.os.RemoteException;
import java.util.Objects;

public final class IndoorLevel {
    private final ao3 zzdg;

    public IndoorLevel(ao3 ao3) {
        Objects.requireNonNull(ao3, "null reference");
        this.zzdg = ao3;
    }

    public final void activate() {
        try {
            this.zzdg.b2();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.zzdg.N0(((IndoorLevel) obj).zzdg);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getName() {
        try {
            return this.zzdg.getName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getShortName() {
        try {
            return this.zzdg.U();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zzdg.b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
