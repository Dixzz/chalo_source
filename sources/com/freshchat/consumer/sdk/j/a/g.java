package com.freshchat.consumer.sdk.j.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class g extends e {
    private static b jW = null;
    private static File jX = null;
    private static boolean jY = true;
    private static final Object jZ = new Object();
    private static g lv;

    public g(Context context, int i) {
        super(context, i);
        if (lv == null) {
            synchronized (g.class) {
                if (lv == null) {
                    lv = this;
                    d(context);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.io.Closeable[] */
    /* JADX DEBUG: Multi-variable search result rejected for r9v8, resolved type: java.io.Closeable[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.io.Closeable[] */
    /* JADX DEBUG: Multi-variable search result rejected for r9v14, resolved type: java.io.FileInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x001d */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x001d A[LOOP:0: B:2:0x001d->B:53:0x001d, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap aW(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.g.aW(java.lang.String):android.graphics.Bitmap");
    }

    private void bi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            i.a(context, R.string.freshchat_error_message_not_connected_to_internet);
        }
    }

    private void d(Context context) {
        bi(context);
        jX = d.y(context, "http");
    }

    private void fn() {
        synchronized (jZ) {
            b bVar = jW;
            if ((bVar == null || bVar.isClosed()) && d.d(jX) > 10485760) {
                try {
                    jW = b.a(jX, 1, 1, 10485760);
                    ai.d("ImageFetcher", "HTTP cache initialized");
                } catch (IOException unused) {
                    jW = null;
                }
            }
            jY = false;
            jZ.notifyAll();
        }
    }

    public static void fo() {
    }

    public boolean a(String str, OutputStream outputStream) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        IOException e;
        if (as.isEmpty(str)) {
            return false;
        }
        fo();
        URLConnection uRLConnection = null;
        try {
            URLConnection uRLConnection2 = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            try {
                bufferedInputStream = new BufferedInputStream(uRLConnection2.getInputStream(), RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                uRLConnection = uRLConnection2;
                try {
                    ai.d("FRESHCHAT", "Failed to load URL " + str);
                    q.a(e);
                    ((HttpURLConnection) uRLConnection).disconnect();
                    ad.a(bufferedInputStream, bufferedOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                    }
                    ad.a(bufferedInputStream, bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                uRLConnection = uRLConnection2;
                ((HttpURLConnection) uRLConnection).disconnect();
                ad.a(bufferedInputStream, bufferedOutputStream);
                throw th;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                while (true) {
                    try {
                        int read = bufferedInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(read);
                    } catch (IOException e3) {
                        e = e3;
                        uRLConnection = uRLConnection2;
                        ai.d("FRESHCHAT", "Failed to load URL " + str);
                        q.a(e);
                        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
                            ((HttpURLConnection) uRLConnection).disconnect();
                        }
                        ad.a(bufferedInputStream, bufferedOutputStream);
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        uRLConnection = uRLConnection2;
                        ((HttpURLConnection) uRLConnection).disconnect();
                        ad.a(bufferedInputStream, bufferedOutputStream);
                        throw th;
                    }
                }
                if (uRLConnection2 instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection2).disconnect();
                }
                ad.a(bufferedInputStream, bufferedOutputStream);
                return true;
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = null;
                uRLConnection = uRLConnection2;
                ai.d("FRESHCHAT", "Failed to load URL " + str);
                q.a(e);
                ((HttpURLConnection) uRLConnection).disconnect();
                ad.a(bufferedInputStream, bufferedOutputStream);
                return false;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                uRLConnection = uRLConnection2;
                ((HttpURLConnection) uRLConnection).disconnect();
                ad.a(bufferedInputStream, bufferedOutputStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            ai.d("FRESHCHAT", "Failed to load URL " + str);
            q.a(e);
            ((HttpURLConnection) uRLConnection).disconnect();
            ad.a(bufferedInputStream, bufferedOutputStream);
            return false;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            ((HttpURLConnection) uRLConnection).disconnect();
            ad.a(bufferedInputStream, bufferedOutputStream);
            throw th;
        }
    }

    @Override // com.freshchat.consumer.sdk.j.a.f, com.freshchat.consumer.sdk.j.a.e
    public Bitmap d(Object obj) {
        return aW(String.valueOf(obj));
    }

    @Override // com.freshchat.consumer.sdk.j.a.f
    public void fp() {
        super.fp();
        fn();
    }

    @Override // com.freshchat.consumer.sdk.j.a.f
    public void fr() {
        super.fr();
        synchronized (jZ) {
            b bVar = jW;
            if (bVar != null && !bVar.isClosed()) {
                try {
                    jW.delete();
                    ai.d("ImageFetcher", "HTTP cache cleared");
                } catch (IOException e) {
                    q.a(e);
                }
                jW = null;
                jY = true;
                fn();
            }
        }
    }

    @Override // com.freshchat.consumer.sdk.j.a.f
    public void fs() {
        super.fs();
        synchronized (jZ) {
            b bVar = jW;
            if (bVar != null) {
                try {
                    bVar.flush();
                    ai.d("ImageFetcher", "HTTP cache flushed");
                } catch (IOException e) {
                    q.a(e);
                }
            }
        }
    }

    @Override // com.freshchat.consumer.sdk.j.a.f
    public void ft() {
        super.ft();
        synchronized (jZ) {
            b bVar = jW;
            if (bVar != null) {
                try {
                    if (!bVar.isClosed()) {
                        jW.close();
                        jW = null;
                        ai.d("ImageFetcher", "HTTP cache closed");
                    }
                } catch (IOException e) {
                    q.a(e);
                }
            }
        }
    }
}
