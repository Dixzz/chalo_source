package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import defpackage.le5;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class Picasso {
    public static final Handler o = new a(Looper.getMainLooper());
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Picasso p = null;

    /* renamed from: a  reason: collision with root package name */
    public final c f706a = null;
    public final f b;
    public final b c;
    public final List<lf5> d;
    public final Context e;
    public final te5 f;
    public final oe5 g;
    public final nf5 h;
    public final Map<Object, le5> i;
    public final Map<ImageView, se5> j;
    public final ReferenceQueue<Object> k;
    public final Bitmap.Config l;
    public boolean m;
    public volatile boolean n;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                if (i == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ne5 ne5 = (ne5) list.get(i2);
                        Picasso picasso = ne5.g;
                        Objects.requireNonNull(picasso);
                        le5 le5 = ne5.p;
                        List<le5> list2 = ne5.q;
                        boolean z = true;
                        boolean z2 = list2 != null && !list2.isEmpty();
                        if (le5 == null && !z2) {
                            z = false;
                        }
                        if (z) {
                            Uri uri = ne5.l.c;
                            Exception exc = ne5.u;
                            Bitmap bitmap = ne5.r;
                            d dVar = ne5.t;
                            if (le5 != null) {
                                picasso.b(bitmap, dVar, le5, exc);
                            }
                            if (z2) {
                                int size2 = list2.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    picasso.b(bitmap, dVar, list2.get(i3), exc);
                                }
                            }
                            c cVar = picasso.f706a;
                            if (!(cVar == null || exc == null)) {
                                cVar.a(picasso, uri, exc);
                            }
                        }
                    }
                } else if (i == 13) {
                    List list3 = (List) message.obj;
                    int size3 = list3.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        le5 le52 = (le5) list3.get(i4);
                        Picasso picasso2 = le52.f2204a;
                        Objects.requireNonNull(picasso2);
                        Bitmap e = df5.shouldReadFromMemoryCache(le52.e) ? picasso2.e(le52.i) : null;
                        if (e != null) {
                            d dVar2 = d.MEMORY;
                            picasso2.b(e, dVar2, le52, null);
                            if (picasso2.n) {
                                String b = le52.b.b();
                                rf5.f("Main", "completed", b, "from " + dVar2);
                            }
                        } else {
                            picasso2.c(le52);
                            if (picasso2.n) {
                                rf5.f("Main", "resumed", le52.b.b(), "");
                            }
                        }
                    }
                } else {
                    StringBuilder i0 = hj1.i0("Unknown handler message received: ");
                    i0.append(message.what);
                    throw new AssertionError(i0.toString());
                }
            } else {
                le5 le53 = (le5) message.obj;
                if (le53.f2204a.n) {
                    rf5.f("Main", "canceled", le53.b.b(), "target got garbage collected");
                }
                le53.f2204a.a(le53.d());
            }
        }
    }

    public static class b extends Thread {
        public final ReferenceQueue<Object> f;
        public final Handler g;

        public class a implements Runnable {
            public final /* synthetic */ Exception f;

            public a(b bVar, Exception exc) {
                this.f = exc;
            }

            public void run() {
                throw new RuntimeException(this.f);
            }
        }

        public b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f = referenceQueue;
            this.g = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    le5.a aVar = (le5.a) this.f.remove(1000);
                    Message obtainMessage = this.g.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f2205a;
                        this.g.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.g.post(new a(this, e));
                    return;
                }
            }
        }
    }

    public interface c {
        void a(Picasso picasso, Uri uri, Exception exc);
    }

    public enum d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        public final int debugColor;

        private d(int i) {
            this.debugColor = i;
        }
    }

    public enum e {
        LOW,
        NORMAL,
        HIGH
    }

    public interface f {

        /* renamed from: a  reason: collision with root package name */
        public static final f f707a = new a();

        public static class a implements f {
        }
    }

    public Picasso(Context context, te5 te5, oe5 oe5, c cVar, f fVar, List<lf5> list, nf5 nf5, Bitmap.Config config, boolean z, boolean z2) {
        this.e = context;
        this.f = te5;
        this.g = oe5;
        this.b = fVar;
        this.l = null;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new mf5(context));
        arrayList.add(new qe5(context));
        arrayList.add(new cf5(context));
        arrayList.add(new re5(context));
        arrayList.add(new me5(context));
        arrayList.add(new we5(context));
        arrayList.add(new ff5(te5.d, nf5));
        this.d = Collections.unmodifiableList(arrayList);
        this.h = nf5;
        this.i = new WeakHashMap();
        this.j = new WeakHashMap();
        this.m = z;
        this.n = z2;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.k = referenceQueue;
        b bVar = new b(referenceQueue, o);
        this.c = bVar;
        bVar.start();
    }

    public static Picasso get() {
        if (p == null) {
            synchronized (Picasso.class) {
                if (p == null) {
                    Context context = PicassoProvider.f;
                    if (context == null) {
                        throw new IllegalStateException("context == null");
                    } else if (context != null) {
                        Context applicationContext = context.getApplicationContext();
                        gf5 gf5 = new gf5(applicationContext);
                        af5 af5 = new af5(applicationContext);
                        if5 if5 = new if5();
                        f fVar = f.f707a;
                        nf5 nf5 = new nf5(af5);
                        p = new Picasso(applicationContext, new te5(applicationContext, if5, o, gf5, af5, nf5), af5, null, fVar, null, nf5, null, false, false);
                    } else {
                        throw new IllegalArgumentException("Context must not be null.");
                    }
                }
            }
        }
        return p;
    }

    public void a(Object obj) {
        se5 remove;
        if (rf5.e()) {
            le5 remove2 = this.i.remove(obj);
            if (remove2 != null) {
                remove2.a();
                Handler handler = this.f.i;
                handler.sendMessage(handler.obtainMessage(2, remove2));
            }
            if ((obj instanceof ImageView) && (remove = this.j.remove((ImageView) obj)) != null) {
                Objects.requireNonNull(remove.f);
                remove.h = null;
                ImageView imageView = remove.g.get();
                if (imageView != null) {
                    remove.g.clear();
                    imageView.removeOnAttachStateChangeListener(remove);
                    ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(remove);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Method call should happen from the main thread.");
    }

    public final void b(Bitmap bitmap, d dVar, le5 le5, Exception exc) {
        if (!le5.l) {
            if (!le5.k) {
                this.i.remove(le5.d());
            }
            if (bitmap == null) {
                le5.c(exc);
                if (this.n) {
                    rf5.f("Main", "errored", le5.b.b(), exc.getMessage());
                }
            } else if (dVar != null) {
                le5.b(bitmap, dVar);
                if (this.n) {
                    String b2 = le5.b.b();
                    rf5.f("Main", "completed", b2, "from " + dVar);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    public void c(le5 le5) {
        Object d2 = le5.d();
        if (!(d2 == null || this.i.get(d2) == le5)) {
            a(d2);
            this.i.put(d2, le5);
        }
        Handler handler = this.f.i;
        handler.sendMessage(handler.obtainMessage(1, le5));
    }

    public kf5 d(Uri uri) {
        return new kf5(this, uri, 0);
    }

    public Bitmap e(String str) {
        Bitmap a2 = this.g.a(str);
        if (a2 != null) {
            this.h.c.sendEmptyMessage(0);
        } else {
            this.h.c.sendEmptyMessage(1);
        }
        return a2;
    }
}
