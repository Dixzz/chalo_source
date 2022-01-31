package defpackage;

import android.content.Context;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.push.PushProvider;
import java.util.ArrayList;
import java.util.List;

/* renamed from: jk5  reason: default package */
/* compiled from: PushProviders */
public class jk5 {

    /* renamed from: a  reason: collision with root package name */
    public final List<PushProvider> f1949a = new ArrayList();
    public final List<PushProvider> b = new ArrayList();
    public final AirshipConfigOptions c;

    /* renamed from: jk5$a */
    /* compiled from: PushProviders */
    public static class a implements jp5<jk5> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1950a;
        public final AirshipConfigOptions b;
        public jk5 c = null;

        public a(Context context, AirshipConfigOptions airshipConfigOptions) {
            this.f1950a = context;
            this.b = airshipConfigOptions;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.jp5
        public jk5 get() {
            jk5 jk5;
            synchronized (this) {
                if (this.c == null) {
                    this.c = jk5.a(this.f1950a, this.b);
                }
                jk5 = this.c;
            }
            return jk5;
        }
    }

    public jk5(AirshipConfigOptions airshipConfigOptions) {
        this.c = airshipConfigOptions;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        r7 = null;
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0086, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        r7 = null;
        r6 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[ExcHandler: ClassNotFoundException (unused java.lang.ClassNotFoundException), SYNTHETIC, Splitter:B:16:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0051 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ab A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.jk5 a(android.content.Context r10, com.urbanairship.AirshipConfigOptions r11) {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jk5.a(android.content.Context, com.urbanairship.AirshipConfigOptions):jk5");
    }
}
