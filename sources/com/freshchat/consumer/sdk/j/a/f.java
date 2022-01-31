package com.freshchat.consumer.sdk.j.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.freshchat.consumer.sdk.j.a.c;
import com.freshchat.consumer.sdk.j.ai;
import com.rabbitmq.client.AMQP;
import java.lang.ref.WeakReference;

public abstract class f {
    private com.freshchat.consumer.sdk.f.a bZ;
    private d kc;
    private c.a kd;
    private Bitmap ke;
    private boolean kf = true;
    private boolean kg = false;
    public boolean kh = false;
    private final Object ki = new Object();
    public Resources kj;

    public static class a extends BitmapDrawable {
        private final WeakReference<b> kk;

        public a(Resources resources, Bitmap bitmap, b bVar) {
            super(resources, bitmap);
            this.kk = new WeakReference<>(bVar);
        }

        public b fz() {
            return this.kk.get();
        }
    }

    public class b extends a<Object, Void, Bitmap> {
        private Object data;
        private final WeakReference<ImageView> gS;

        public b(ImageView imageView) {
            this.gS = new WeakReference<>(imageView);
        }

        private ImageView fA() {
            ImageView imageView = this.gS.get();
            if (this == f.a(imageView)) {
                return imageView;
            }
            return null;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0010 */
        /* JADX WARNING: Removed duplicated region for block: B:2:0x0010 A[LOOP:0: B:2:0x0010->B:36:0x0010, LOOP_START, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap doInBackground(java.lang.Object... r5) {
            /*
            // Method dump skipped, instructions count: 132
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.f.b.doInBackground(java.lang.Object[]):android.graphics.Bitmap");
        }

        public void onCancelled(Bitmap bitmap) {
            super.onCancelled((Object) bitmap);
            synchronized (f.this.ki) {
                f.this.ki.notifyAll();
            }
        }

        public void onPostExecute(Bitmap bitmap) {
            if (isCancelled() || f.this.kg) {
                bitmap = null;
            }
            ImageView fA = fA();
            if (bitmap == null || fA == null) {
                f.this.fx();
                return;
            }
            ai.d("ImageWorker", "onPostExecute - setting bitmap");
            f.this.a((f) fA, (ImageView) bitmap);
        }
    }

    public class c extends a<Object, Void, Void> {
        public c() {
        }

        @Override // com.freshchat.consumer.sdk.j.a.a
        public Void doInBackground(Object... objArr) {
            int intValue = ((Integer) objArr[0]).intValue();
            if (intValue == 0) {
                f.this.fr();
                return null;
            } else if (intValue == 1) {
                f.this.fp();
                return null;
            } else if (intValue == 2) {
                f.this.fs();
                return null;
            } else if (intValue == 3) {
                f.this.ft();
                return null;
            } else if (intValue != 4) {
                return null;
            } else {
                f.this.fy();
                return null;
            }
        }
    }

    public f(Context context) {
        this.kj = context.getResources();
    }

    /* access modifiers changed from: private */
    public static b a(ImageView imageView) {
        if (imageView == null) {
            return null;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof a) {
            return ((a) drawable).fz();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(ImageView imageView, Bitmap bitmap) {
        if (this.kf) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), new BitmapDrawable(this.kj, bitmap)});
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(AMQP.REPLY_SUCCESS);
        } else {
            imageView.setImageBitmap(bitmap);
        }
        fw();
    }

    public static boolean b(Object obj, ImageView imageView) {
        b a2 = a(imageView);
        if (a2 != null) {
            Object obj2 = a2.data;
            if (obj2 != null && obj2.equals(obj)) {
                return false;
            }
            a2.cancel(true);
            ai.d("ImageWorker", "cancelPotentialWork - cancelled work for " + obj);
        }
        return true;
    }

    private void fv() {
        com.freshchat.consumer.sdk.f.a aVar = this.bZ;
        if (aVar != null) {
            aVar.aG();
        }
    }

    private void fw() {
        com.freshchat.consumer.sdk.f.a aVar = this.bZ;
        if (aVar != null) {
            aVar.aH();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fx() {
        com.freshchat.consumer.sdk.f.a aVar = this.bZ;
        if (aVar != null) {
            aVar.aI();
        }
    }

    public void a(d dVar) {
        this.kc = dVar;
    }

    public void a(Object obj, ImageView imageView) {
        if (obj != null) {
            Bitmap bitmap = null;
            d dVar = this.kc;
            if (dVar != null) {
                bitmap = dVar.aT(String.valueOf(obj));
            }
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else if (b(obj, imageView)) {
                fv();
                b bVar = new b(imageView);
                imageView.setImageDrawable(new a(this.kj, this.ke, bVar));
                bVar.a(a.iL, obj);
            }
        }
    }

    public void a(Object obj, ImageView imageView, com.freshchat.consumer.sdk.f.a aVar) {
        this.bZ = aVar;
        a(obj, imageView);
    }

    public void c(c.a aVar) {
        this.kd = aVar;
        a(d.a(aVar));
        new c().a(1);
    }

    public abstract Bitmap d(Object obj);

    public void fp() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.fk();
        }
    }

    public void fr() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.clearCache();
        }
    }

    public void fs() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.flush();
        }
    }

    public void ft() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.close();
            this.kc = null;
        }
    }

    public void fy() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.fl();
            this.kc = null;
        }
    }
}
