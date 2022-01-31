package app.zophop.pubsub.eventbus.events;

import app.zophop.models.universalPass.UniversalPassInfo;
import java.util.List;

/* compiled from: UniversalPassInfoFetchedEvent.kt */
public final class UniversalPassInfoFetchedEvent {
    private final boolean status;
    private final List<UniversalPassInfo> universalPassInfos;

    public UniversalPassInfoFetchedEvent(boolean z, List<UniversalPassInfo> list) {
        this.status = z;
        this.universalPassInfos = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: app.zophop.pubsub.eventbus.events.UniversalPassInfoFetchedEvent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UniversalPassInfoFetchedEvent copy$default(UniversalPassInfoFetchedEvent universalPassInfoFetchedEvent, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = universalPassInfoFetchedEvent.status;
        }
        if ((i & 2) != 0) {
            list = universalPassInfoFetchedEvent.universalPassInfos;
        }
        return universalPassInfoFetchedEvent.copy(z, list);
    }

    public final boolean component1() {
        return this.status;
    }

    public final List<UniversalPassInfo> component2() {
        return this.universalPassInfos;
    }

    public final UniversalPassInfoFetchedEvent copy(boolean z, List<UniversalPassInfo> list) {
        return new UniversalPassInfoFetchedEvent(z, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UniversalPassInfoFetchedEvent)) {
            return false;
        }
        UniversalPassInfoFetchedEvent universalPassInfoFetchedEvent = (UniversalPassInfoFetchedEvent) obj;
        return this.status == universalPassInfoFetchedEvent.status && n86.a(this.universalPassInfos, universalPassInfoFetchedEvent.universalPassInfos);
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final List<UniversalPassInfo> getUniversalPassInfos() {
        return this.universalPassInfos;
    }

    public int hashCode() {
        boolean z = this.status;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        List<UniversalPassInfo> list = this.universalPassInfos;
        return i4 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("UniversalPassInfoFetchedEvent(status=");
        i0.append(this.status);
        i0.append(", universalPassInfos=");
        i0.append(this.universalPassInfos);
        i0.append(')');
        return i0.toString();
    }
}
