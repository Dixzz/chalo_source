package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.QuerySpec;

public final class TrackedQuery {
    public final boolean active;
    public final boolean complete;
    public final long id;
    public final long lastUse;
    public final QuerySpec querySpec;

    public TrackedQuery(long j, QuerySpec querySpec2, long j2, boolean z, boolean z2) {
        this.id = j;
        if (!querySpec2.loadsAllData() || querySpec2.isDefault()) {
            this.querySpec = querySpec2;
            this.lastUse = j2;
            this.complete = z;
            this.active = z2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != TrackedQuery.class) {
            return false;
        }
        TrackedQuery trackedQuery = (TrackedQuery) obj;
        if (this.id == trackedQuery.id && this.querySpec.equals(trackedQuery.querySpec) && this.lastUse == trackedQuery.lastUse && this.complete == trackedQuery.complete && this.active == trackedQuery.active) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.querySpec.hashCode();
        int hashCode2 = Long.valueOf(this.lastUse).hashCode();
        int hashCode3 = Boolean.valueOf(this.complete).hashCode();
        return Boolean.valueOf(this.active).hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (Long.valueOf(this.id).hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public TrackedQuery setActiveState(boolean z) {
        return new TrackedQuery(this.id, this.querySpec, this.lastUse, this.complete, z);
    }

    public TrackedQuery setComplete() {
        return new TrackedQuery(this.id, this.querySpec, this.lastUse, true, this.active);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TrackedQuery{id=");
        i0.append(this.id);
        i0.append(", querySpec=");
        i0.append(this.querySpec);
        i0.append(", lastUse=");
        i0.append(this.lastUse);
        i0.append(", complete=");
        i0.append(this.complete);
        i0.append(", active=");
        i0.append(this.active);
        i0.append("}");
        return i0.toString();
    }

    public TrackedQuery updateLastUse(long j) {
        return new TrackedQuery(this.id, this.querySpec, j, this.complete, this.active);
    }
}
