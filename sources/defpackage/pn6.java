package defpackage;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: pn6  reason: default package */
/* compiled from: JvmOkio.kt */
public final class pn6 extends rm6 {
    public final Logger l = Logger.getLogger("okio.Okio");
    public final Socket m;

    public pn6(Socket socket) {
        n86.f(socket, "socket");
        this.m = socket;
    }

    @Override // defpackage.rm6
    public IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // defpackage.rm6
    public void l() {
        try {
            this.m.close();
        } catch (Exception e) {
            Logger logger = this.l;
            Level level = Level.WARNING;
            StringBuilder i0 = hj1.i0("Failed to close timed out socket ");
            i0.append(this.m);
            logger.log(level, i0.toString(), (Throwable) e);
        } catch (AssertionError e2) {
            if (ec6.s(e2)) {
                Logger logger2 = this.l;
                Level level2 = Level.WARNING;
                StringBuilder i02 = hj1.i0("Failed to close timed out socket ");
                i02.append(this.m);
                logger2.log(level2, i02.toString(), (Throwable) e2);
                return;
            }
            throw e2;
        }
    }
}
