package defpackage;

/* renamed from: zp  reason: default package */
/* compiled from: WorkInfo */
public enum zp {
    ENQUEUED,
    RUNNING,
    SUCCEEDED,
    FAILED,
    BLOCKED,
    CANCELLED;

    public boolean isFinished() {
        return this == SUCCEEDED || this == FAILED || this == CANCELLED;
    }
}
