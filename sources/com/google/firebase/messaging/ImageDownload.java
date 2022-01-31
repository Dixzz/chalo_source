package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class ImageDownload implements Closeable {
    private volatile InputStream connectionInputStream;
    private yi4<Bitmap> task;
    private final URL url;

    private ImageDownload(URL url2) {
        this.url = url2;
    }

    private byte[] blockingDownloadBytes() throws IOException {
        byte[] a2;
        URLConnection openConnection = this.url.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                this.connectionInputStream = inputStream;
                int i = bb3.f404a;
                ab3 ab3 = new ab3(inputStream);
                ArrayDeque arrayDeque = new ArrayDeque(20);
                int i2 = RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST;
                int i3 = 0;
                loop0:
                while (true) {
                    if (i3 < 2147483639) {
                        int min = Math.min(i2, 2147483639 - i3);
                        byte[] bArr = new byte[min];
                        arrayDeque.add(bArr);
                        int i4 = 0;
                        while (i4 < min) {
                            int read = ab3.read(bArr, i4, min - i4);
                            if (read == -1) {
                                a2 = bb3.a(arrayDeque, i3);
                                break loop0;
                            }
                            i4 += read;
                            i3 += read;
                        }
                        long j = (long) i2;
                        long j2 = j + j;
                        i2 = j2 > 2147483647L ? Integer.MAX_VALUE : j2 < -2147483648L ? RtlSpacingHelper.UNDEFINED : (int) j2;
                    } else if (ab3.read() == -1) {
                        a2 = bb3.a(arrayDeque, 2147483639);
                    } else {
                        throw new OutOfMemoryError("input is too large to fit in a byte array");
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable(Constants.TAG, 2)) {
                    String.valueOf(this.url).length();
                }
                if (a2.length <= 1048576) {
                    return a2;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                jb3.f1900a.a(th, th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public static ImageDownload create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Not downloading image, bad URL: ".concat(valueOf);
            } else {
                new String("Not downloading image, bad URL: ");
            }
            return null;
        }
    }

    public Bitmap blockingDownload() throws IOException {
        String.valueOf(this.url).length();
        byte[] blockingDownloadBytes = blockingDownloadBytes();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(blockingDownloadBytes, 0, blockingDownloadBytes.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String.valueOf(this.url).length();
            }
            return decodeByteArray;
        }
        String valueOf = String.valueOf(this.url);
        throw new IOException(hj1.a0(new StringBuilder(valueOf.length() + 24), "Failed to decode image: ", valueOf));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            InputStream inputStream = this.connectionInputStream;
            Logger logger = cb3.f543a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    try {
                        cb3.f543a.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", (Throwable) e);
                    } catch (IOException e2) {
                        throw new AssertionError(e2);
                    }
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    public yi4<Bitmap> getTask() {
        yi4<Bitmap> yi4 = this.task;
        Objects.requireNonNull(yi4, "null reference");
        return yi4;
    }

    public void start(Executor executor) {
        this.task = hd3.A(executor, new ImageDownload$$Lambda$0(this));
    }
}
