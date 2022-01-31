package com.freshchat.consumer.sdk.j.a;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.util.concurrent.Callable;

public class c implements Callable<Void> {
    public final /* synthetic */ b jv;

    public static class a {
        public int jM = 10485760;
        public int jN = 20971520;
        public File jO;
        public Bitmap.CompressFormat jP = d.fm();
        public int jQ = 90;
        public boolean jR = true;
        public boolean jS = true;
        public boolean jT = false;
        public boolean jU = false;

        public a(Context context, String str) {
            this.jO = d.y(context, str);
        }

        private static int bh(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }

        public void a(Context context, float f) {
            if (f < 0.05f || f > 0.8f) {
                throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
            }
            this.jM = Math.round(f * ((float) bh(context)) * 1024.0f * 1024.0f);
        }
    }

    public c(b bVar) {
        this.jv = bVar;
    }

    /* renamed from: fi */
    public Void call() throws Exception {
        synchronized (this.jv) {
            if (b.a(this.jv) == null) {
                return null;
            }
            b.b(this.jv);
            if (b.c(this.jv)) {
                b.d(this.jv);
                b.a(this.jv, 0);
            }
            return null;
        }
    }
}
