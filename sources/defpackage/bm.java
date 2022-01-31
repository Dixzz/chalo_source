package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: bm  reason: default package */
/* compiled from: SharedSQLiteStatement */
public abstract class bm {
    private final wl mDatabase;
    private final AtomicBoolean mLock = new AtomicBoolean(false);
    private volatile sm mStmt;

    public bm(wl wlVar) {
        this.mDatabase = wlVar;
    }

    private sm createNewStatement() {
        return this.mDatabase.compileStatement(createQuery());
    }

    private sm getStmt(boolean z) {
        if (!z) {
            return createNewStatement();
        }
        if (this.mStmt == null) {
            this.mStmt = createNewStatement();
        }
        return this.mStmt;
    }

    public sm acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(sm smVar) {
        if (smVar == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
