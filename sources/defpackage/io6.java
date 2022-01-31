package defpackage;

import android.content.Context;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: io6  reason: default package */
/* compiled from: ReLinkerInstance */
public class io6 {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f1548a = new HashSet();
    public final go6 b;
    public final fo6 c;

    /* renamed from: io6$a */
    /* compiled from: ReLinkerInstance */
    public class a implements Runnable {
        public final /* synthetic */ Context f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ ho6 i;

        public a(Context context, String str, String str2, ho6 ho6) {
            this.f = context;
            this.g = str;
            this.h = str2;
            this.i = ho6;
        }

        public void run() {
            try {
                io6.this.d(this.f, this.g, this.h);
                this.i.a();
            } catch (UnsatisfiedLinkError e) {
                this.i.b(e);
            } catch (eo6 e2) {
                this.i.b(e2);
            }
        }
    }

    public io6() {
        ko6 ko6 = new ko6();
        do6 do6 = new do6();
        this.b = ko6;
        this.c = do6;
    }

    public File a(Context context) {
        return context.getDir("lib", 0);
    }

    public File b(Context context, String str, String str2) {
        String a2 = ((ko6) this.b).a(str);
        if (ec6.t(str2)) {
            return new File(a(context), a2);
        }
        return new File(a(context), hj1.T(a2, ".", str2));
    }

    public void c(Context context, String str, String str2, ho6 ho6) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!ec6.t(str)) {
            String.format(Locale.US, "Beginning load of %s...", str);
            if (ho6 == null) {
                d(context, str, str2);
            } else {
                new Thread(new a(context, str, str2, ho6)).start();
            }
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:56|57|58|59|60|62|63|(1:65)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x0126 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0173 A[SYNTHETIC, Splitter:B:100:0x0173] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01b7 A[SYNTHETIC, Splitter:B:119:0x01b7] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x017b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x017b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0136 A[Catch:{ IOException -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0155 A[SYNTHETIC, Splitter:B:77:0x0155] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x015c A[SYNTHETIC, Splitter:B:81:0x015c] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0164 A[SYNTHETIC, Splitter:B:90:0x0164] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(android.content.Context r20, java.lang.String r21, java.lang.String r22) {
        /*
        // Method dump skipped, instructions count: 447
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.io6.d(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
