package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: y5  reason: default package */
/* compiled from: ResourcesCompat */
public final class y5 {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f3999a = new ThreadLocal<>();
    public static final WeakHashMap<b, SparseArray<a>> b = new WeakHashMap<>(0);
    public static final Object c = new Object();

    /* renamed from: y5$a */
    /* compiled from: ResourcesCompat */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ColorStateList f4000a;
        public final Configuration b;

        public a(ColorStateList colorStateList, Configuration configuration) {
            this.f4000a = colorStateList;
            this.b = configuration;
        }
    }

    /* renamed from: y5$b */
    /* compiled from: ResourcesCompat */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f4001a;
        public final Resources.Theme b;

        public b(Resources resources, Resources.Theme theme) {
            this.f4001a = resources;
            this.b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f4001a.equals(bVar.f4001a) || !Objects.equals(this.b, bVar.b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(this.f4001a, this.b);
        }
    }

    /* renamed from: y5$c */
    /* compiled from: ResourcesCompat */
    public static abstract class c {

        /* renamed from: y5$c$a */
        /* compiled from: ResourcesCompat */
        public class a implements Runnable {
            public final /* synthetic */ Typeface f;

            public a(Typeface typeface) {
                this.f = typeface;
            }

            public void run() {
                c.this.onFontRetrieved(this.f);
            }
        }

        /* renamed from: y5$c$b */
        /* compiled from: ResourcesCompat */
        public class b implements Runnable {
            public final /* synthetic */ int f;

            public b(int i) {
                this.f = i;
            }

            public void run() {
                c.this.onFontRetrievalFailed(this.f);
            }
        }

        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(int i, Handler handler) {
            getHandler(handler).post(new b(i));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            getHandler(handler).post(new a(typeface));
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    public static Typeface a(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return b(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface b(Context context, int i, TypedValue typedValue, int i2, c cVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            if (charSequence2.startsWith("res/")) {
                Typeface typeface2 = d6.b.get(d6.c(resources, i, i2));
                if (typeface2 != null) {
                    if (cVar != null) {
                        cVar.callbackSuccessAsync(typeface2, handler);
                    }
                    typeface = typeface2;
                } else if (!z2) {
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            t5 m0 = h.m0(resources.getXml(i), resources);
                            if (m0 != null) {
                                typeface = d6.a(context, m0, resources, i, i2, cVar, handler, z);
                            } else if (cVar != null) {
                                cVar.callbackFailAsync(-3, handler);
                            }
                        } else {
                            Typeface b2 = d6.b(context, resources, i, charSequence2, i2);
                            if (cVar != null) {
                                if (b2 != null) {
                                    cVar.callbackSuccessAsync(b2, handler);
                                } else {
                                    cVar.callbackFailAsync(-3, handler);
                                }
                            }
                            typeface = b2;
                        }
                    } catch (IOException | XmlPullParserException unused) {
                        if (cVar != null) {
                            cVar.callbackFailAsync(-3, handler);
                        }
                    }
                }
            } else if (cVar != null) {
                cVar.callbackFailAsync(-3, handler);
            }
            if (typeface != null || cVar != null || z2) {
                return typeface;
            }
            StringBuilder i0 = hj1.i0("Font resource ID #0x");
            i0.append(Integer.toHexString(i));
            i0.append(" could not be retrieved.");
            throw new Resources.NotFoundException(i0.toString());
        }
        StringBuilder i02 = hj1.i0("Resource \"");
        i02.append(resources.getResourceName(i));
        i02.append("\" (");
        i02.append(Integer.toHexString(i));
        i02.append(") is not a Font: ");
        i02.append(typedValue);
        throw new Resources.NotFoundException(i02.toString());
    }
}
