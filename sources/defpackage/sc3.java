package defpackage;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: sc3  reason: default package */
public final class sc3 extends yb3 {
    public volatile String h;
    public Future<String> i;

    public sc3(ac3 ac3) {
        super(ac3);
    }

    @Override // defpackage.yb3
    public final void a0() {
    }

    public final boolean i0(Context context, String str) {
        gj1.j(str);
        gj1.k("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            k("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e) {
                L("Failed to close clientId writing stream", e);
                return true;
            }
        } catch (FileNotFoundException e2) {
            L("Error creating clientId file", e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    L("Failed to close clientId writing stream", e3);
                }
            }
            return false;
        } catch (IOException e4) {
            L("Error writing to clientId file", e4);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    L("Failed to close clientId writing stream", e5);
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    L("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }

    public final String j0() {
        String str;
        g0();
        synchronized (this) {
            if (this.h == null) {
                this.i = w().a(new tc3(this));
            }
            Future<String> future = this.i;
            if (future != null) {
                try {
                    this.h = future.get();
                } catch (InterruptedException e) {
                    J("ClientId loading or generation was interrupted", e);
                    this.h = "0";
                } catch (ExecutionException e2) {
                    L("Failed to load or generate client id", e2);
                    this.h = "0";
                }
                if (this.h == null) {
                    this.h = "0";
                }
                k("Loaded clientId", this.h);
                this.i = null;
            }
            str = this.h;
        }
        return str;
    }

    public final String m0() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            if (!i0(w().f1998a, lowerCase)) {
                return "0";
            }
            return lowerCase;
        } catch (Exception e) {
            L("Error saving clientId file", e);
            return "0";
        }
    }
}
