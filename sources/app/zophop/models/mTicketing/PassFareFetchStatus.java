package app.zophop.models.mTicketing;

/* compiled from: PassFareFetchStatus.kt */
public final class PassFareFetchStatus {
    private final boolean isFetchSuccessful;
    private final boolean isFetching;

    public PassFareFetchStatus(boolean z, boolean z2) {
        this.isFetching = z;
        this.isFetchSuccessful = z2;
    }

    public static /* synthetic */ PassFareFetchStatus copy$default(PassFareFetchStatus passFareFetchStatus, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = passFareFetchStatus.isFetching;
        }
        if ((i & 2) != 0) {
            z2 = passFareFetchStatus.isFetchSuccessful;
        }
        return passFareFetchStatus.copy(z, z2);
    }

    public final boolean component1() {
        return this.isFetching;
    }

    public final boolean component2() {
        return this.isFetchSuccessful;
    }

    public final PassFareFetchStatus copy(boolean z, boolean z2) {
        return new PassFareFetchStatus(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassFareFetchStatus)) {
            return false;
        }
        PassFareFetchStatus passFareFetchStatus = (PassFareFetchStatus) obj;
        return this.isFetching == passFareFetchStatus.isFetching && this.isFetchSuccessful == passFareFetchStatus.isFetchSuccessful;
    }

    public int hashCode() {
        boolean z = this.isFetching;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        boolean z2 = this.isFetchSuccessful;
        if (!z2) {
            i = z2 ? 1 : 0;
        }
        return i5 + i;
    }

    public final boolean isFetchSuccessful() {
        return this.isFetchSuccessful;
    }

    public final boolean isFetching() {
        return this.isFetching;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("PassFareFetchStatus(isFetching=");
        i0.append(this.isFetching);
        i0.append(", isFetchSuccessful=");
        i0.append(this.isFetchSuccessful);
        i0.append(')');
        return i0.toString();
    }
}
