package defpackage;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* renamed from: m16  reason: default package */
/* compiled from: GZIPQueueFileEventStorage */
public class m16 implements i16 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2309a;
    public final File b;
    public final String c;
    public final File d;
    public p06 e;
    public File f;

    public m16(Context context, File file, String str, String str2) throws IOException {
        this.f2309a = context;
        this.b = file;
        this.c = str2;
        File file2 = new File(file, str);
        this.d = file2;
        this.e = new p06(file2);
        a();
    }

    public final void a() {
        File file = new File(this.b, this.c);
        this.f = file;
        if (!file.exists()) {
            this.f.mkdirs();
        }
    }

    public void b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            Context context = this.f2309a;
            String.format("deleting sent analytics file %s", file.getName());
            j06.i(context);
            file.delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.OutputStream, java.io.Closeable, java.util.zip.GZIPOutputStream] */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:11|12|13|14|15|17) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0023 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0036 A[SYNTHETIC, Splitter:B:25:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003d A[SYNTHETIC, Splitter:B:29:0x003d] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.io.File r6, java.io.File r7) {
        /*
            r5 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0032 }
            r1.<init>(r6)     // Catch:{ all -> 0x0032 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x002d }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x002d }
            r3.<init>(r7)     // Catch:{ all -> 0x002d }
            r2.<init>(r3)     // Catch:{ all -> 0x002d }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x002a }
        L_0x0014:
            int r0 = r1.read(r7)     // Catch:{ all -> 0x002a }
            r3 = -1
            if (r0 == r3) goto L_0x0020
            r3 = 0
            r2.write(r7, r3, r0)     // Catch:{ all -> 0x002a }
            goto L_0x0014
        L_0x0020:
            r1.close()     // Catch:{ IOException -> 0x0023 }
        L_0x0023:
            r2.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0026:
            r6.delete()
            return
        L_0x002a:
            r7 = move-exception
            r0 = r2
            goto L_0x002e
        L_0x002d:
            r7 = move-exception
        L_0x002e:
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0034
        L_0x0032:
            r7 = move-exception
            r1 = r0
        L_0x0034:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003b
        L_0x003a:
        L_0x003b:
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            r6.delete()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m16.c(java.io.File, java.io.File):void");
    }
}
