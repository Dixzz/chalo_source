package defpackage;

import java.io.PrintWriter;

/* renamed from: of5  reason: default package */
/* compiled from: StatsSnapshot */
public class of5 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2685a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;

    public of5(int i2, int i3, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, int i4, int i5, int i6, long j10) {
        this.f2685a = i2;
        this.b = i3;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.i = j8;
        this.j = j9;
        this.k = i4;
        this.l = i5;
        this.m = i6;
        this.n = j10;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f2685a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.b) / ((float) this.f2685a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("StatsSnapshot{maxSize=");
        i0.append(this.f2685a);
        i0.append(", size=");
        i0.append(this.b);
        i0.append(", cacheHits=");
        i0.append(this.c);
        i0.append(", cacheMisses=");
        i0.append(this.d);
        i0.append(", downloadCount=");
        i0.append(this.k);
        i0.append(", totalDownloadSize=");
        i0.append(this.e);
        i0.append(", averageDownloadSize=");
        i0.append(this.h);
        i0.append(", totalOriginalBitmapSize=");
        i0.append(this.f);
        i0.append(", totalTransformedBitmapSize=");
        i0.append(this.g);
        i0.append(", averageOriginalBitmapSize=");
        i0.append(this.i);
        i0.append(", averageTransformedBitmapSize=");
        i0.append(this.j);
        i0.append(", originalBitmapCount=");
        i0.append(this.l);
        i0.append(", transformedBitmapCount=");
        i0.append(this.m);
        i0.append(", timeStamp=");
        i0.append(this.n);
        i0.append('}');
        return i0.toString();
    }
}
