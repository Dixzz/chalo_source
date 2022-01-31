package com.freshchat.consumer.sdk.j.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.freshchat.consumer.sdk.j.ai;

public class e extends f {
    public int ka;
    public int kb;

    public e(Context context, int i) {
        super(context);
        A(i);
    }

    private Bitmap B(int i) {
        ai.d("ImageResizer", "processBitmap - " + i);
        return a(this.kj, i, this.ka, this.kb);
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        float f;
        float f2;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        if (i4 > i3) {
            f2 = (float) i3;
            f = (float) i2;
        } else {
            f2 = (float) i4;
            f = (float) i;
        }
        int round = Math.round(f2 / f);
        while (((float) (i4 * i3)) / ((float) (round * round)) > ((float) (i * i2 * 2))) {
            round++;
        }
        return round;
    }

    public static Bitmap a(Resources resources, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(java.io.FileDescriptor r7, int r8, int r9) {
        /*
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r2 = 1
            r1.inJustDecodeBounds = r2
            r2 = 0
            android.graphics.BitmapFactory.decodeFileDescriptor(r7, r2, r1)
            int r3 = a(r1, r8, r9)
            r1.inSampleSize = r3
            int r3 = r1.outHeight
            int r4 = r1.outWidth
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r6 = 2048(0x800, float:2.87E-42)
            if (r3 > r9) goto L_0x0020
            if (r4 <= r8) goto L_0x0040
        L_0x0020:
            if (r4 <= r3) goto L_0x0031
            if (r6 >= r4) goto L_0x0040
            float r8 = (float) r3
            float r9 = (float) r6
            float r3 = (float) r4
            float r9 = r9 / r3
            float r9 = r9 * r8
            int r3 = java.lang.Math.round(r9)
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0041
        L_0x0031:
            if (r6 >= r3) goto L_0x0040
            float r8 = (float) r4
            float r9 = (float) r6
            float r3 = (float) r3
            float r9 = r9 / r3
            float r9 = r9 * r8
            int r4 = java.lang.Math.round(r9)
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0041
        L_0x0040:
            r0 = r5
        L_0x0041:
            r8 = 0
            r1.inJustDecodeBounds = r8
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeFileDescriptor(r7, r2, r1)
            boolean r9 = r0.booleanValue()
            if (r9 == 0) goto L_0x0052
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createScaledBitmap(r7, r4, r3, r8)
        L_0x0052:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.e.a(java.io.FileDescriptor, int, int):android.graphics.Bitmap");
    }

    public void A(int i) {
        c(i, i);
    }

    public void c(int i, int i2) {
        this.ka = i;
        this.kb = i2;
    }

    @Override // com.freshchat.consumer.sdk.j.a.f
    public Bitmap d(Object obj) {
        return B(Integer.parseInt(String.valueOf(obj)));
    }
}
