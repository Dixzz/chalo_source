package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import com.google.firebase.perf.util.Constants;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.InputStream;

/* renamed from: k6  reason: default package */
/* compiled from: TypefaceCompatBaseImpl */
public class k6 {
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Long, u5> f2027a = new ConcurrentHashMap<>();

    /* renamed from: k6$a */
    /* compiled from: TypefaceCompatBaseImpl */
    public interface a<T> {
        int a(T t);

        boolean b(T t);
    }

    public static <T> T e(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : Constants.FROZEN_FRAME_TIME;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.a(t2) - i2) * 2) + (aVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    public Typeface a(Context context, u5 u5Var, Resources resources, int i) {
        throw null;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, k7[] k7VarArr, int i) {
        throw null;
    }

    public Typeface c(Context context, InputStream inputStream) {
        File W = h.W(context);
        if (W == null) {
            return null;
        }
        try {
            if (!h.y(W, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(W.getPath());
            W.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            W.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File W = h.W(context);
        if (W == null) {
            return null;
        }
        try {
            if (!h.x(W, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(W.getPath());
            W.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            W.delete();
        }
    }
}
