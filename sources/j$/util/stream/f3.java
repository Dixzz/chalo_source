package j$.util.stream;

class f3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f1788a;
    final /* synthetic */ Runnable b;

    f3(Runnable runnable, Runnable runnable2) {
        this.f1788a = runnable;
        this.b = runnable2;
    }

    public void run() {
        try {
            this.f1788a.run();
            this.b.run();
            return;
        } catch (Throwable th) {
            try {
                th.addSuppressed(th);
            } catch (Throwable unused) {
            }
        }
        throw th;
    }
}
