package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import defpackage.ho4;
import defpackage.no4;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Objects;

/* renamed from: lo4  reason: default package */
/* compiled from: ShapeAppearancePathProvider */
public class lo4 {

    /* renamed from: a  reason: collision with root package name */
    public final no4[] f2249a = new no4[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final no4 g = new no4();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public boolean l = true;

    /* renamed from: lo4$a */
    /* compiled from: ShapeAppearancePathProvider */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final lo4 f2250a = new lo4();
    }

    /* renamed from: lo4$b */
    /* compiled from: ShapeAppearancePathProvider */
    public interface b {
    }

    public lo4() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f2249a[i2] = new no4();
            this.b[i2] = new Matrix();
            this.c[i2] = new Matrix();
        }
    }

    public void a(ko4 ko4, float f2, RectF rectF, b bVar, Path path) {
        float f3;
        go4 go4;
        do4 do4;
        eo4 eo4;
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        int i2 = 0;
        while (i2 < 4) {
            if (i2 == 1) {
                do4 = ko4.g;
            } else if (i2 == 2) {
                do4 = ko4.h;
            } else if (i2 != 3) {
                do4 = ko4.f;
            } else {
                do4 = ko4.e;
            }
            if (i2 == 1) {
                eo4 = ko4.c;
            } else if (i2 == 2) {
                eo4 = ko4.d;
            } else if (i2 != 3) {
                eo4 = ko4.b;
            } else {
                eo4 = ko4.f2092a;
            }
            no4 no4 = this.f2249a[i2];
            Objects.requireNonNull(eo4);
            eo4.a(no4, 90.0f, f2, do4.a(rectF));
            int i3 = i2 + 1;
            float f4 = (float) (i3 * 90);
            this.b[i2].reset();
            PointF pointF = this.d;
            if (i2 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i2 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i2 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            Matrix matrix = this.b[i2];
            PointF pointF2 = this.d;
            matrix.setTranslate(pointF2.x, pointF2.y);
            this.b[i2].preRotate(f4);
            float[] fArr = this.h;
            no4[] no4Arr = this.f2249a;
            fArr[0] = no4Arr[i2].c;
            fArr[1] = no4Arr[i2].d;
            this.b[i2].mapPoints(fArr);
            this.c[i2].reset();
            Matrix matrix2 = this.c[i2];
            float[] fArr2 = this.h;
            matrix2.setTranslate(fArr2[0], fArr2[1]);
            this.c[i2].preRotate(f4);
            i2 = i3;
        }
        int i4 = 0;
        while (i4 < 4) {
            float[] fArr3 = this.h;
            no4[] no4Arr2 = this.f2249a;
            fArr3[0] = no4Arr2[i4].f2581a;
            fArr3[1] = no4Arr2[i4].b;
            this.b[i4].mapPoints(fArr3);
            if (i4 == 0) {
                float[] fArr4 = this.h;
                path.moveTo(fArr4[0], fArr4[1]);
            } else {
                float[] fArr5 = this.h;
                path.lineTo(fArr5[0], fArr5[1]);
            }
            this.f2249a[i4].c(this.b[i4], path);
            if (bVar != null) {
                no4 no42 = this.f2249a[i4];
                Matrix matrix3 = this.b[i4];
                ho4.a aVar = (ho4.a) bVar;
                BitSet bitSet = ho4.this.i;
                Objects.requireNonNull(no42);
                bitSet.set(i4, false);
                no4.f[] fVarArr = ho4.this.g;
                no42.b(no42.f);
                fVarArr[i4] = new mo4(no42, new ArrayList(no42.h), new Matrix(matrix3));
            }
            int i5 = i4 + 1;
            int i6 = i5 % 4;
            float[] fArr6 = this.h;
            no4[] no4Arr3 = this.f2249a;
            fArr6[0] = no4Arr3[i4].c;
            fArr6[1] = no4Arr3[i4].d;
            this.b[i4].mapPoints(fArr6);
            float[] fArr7 = this.i;
            no4[] no4Arr4 = this.f2249a;
            fArr7[0] = no4Arr4[i6].f2581a;
            fArr7[1] = no4Arr4[i6].b;
            this.b[i6].mapPoints(fArr7);
            float[] fArr8 = this.h;
            float f5 = fArr8[0];
            float[] fArr9 = this.i;
            float max = Math.max(((float) Math.hypot((double) (f5 - fArr9[0]), (double) (fArr8[1] - fArr9[1]))) - 0.001f, 0.0f);
            float[] fArr10 = this.h;
            no4[] no4Arr5 = this.f2249a;
            fArr10[0] = no4Arr5[i4].c;
            fArr10[1] = no4Arr5[i4].d;
            this.b[i4].mapPoints(fArr10);
            if (i4 == 1 || i4 == 3) {
                f3 = Math.abs(rectF.centerX() - this.h[0]);
            } else {
                f3 = Math.abs(rectF.centerY() - this.h[1]);
            }
            this.g.e(0.0f, 0.0f, 270.0f, 0.0f);
            if (i4 == 1) {
                go4 = ko4.k;
            } else if (i4 == 2) {
                go4 = ko4.l;
            } else if (i4 != 3) {
                go4 = ko4.j;
            } else {
                go4 = ko4.i;
            }
            go4.a(max, f3, f2, this.g);
            this.j.reset();
            this.g.c(this.c[i4], this.j);
            if (!this.l || (!b(this.j, i4) && !b(this.j, i6))) {
                this.g.c(this.c[i4], path);
            } else {
                Path path2 = this.j;
                path2.op(path2, this.f, Path.Op.DIFFERENCE);
                float[] fArr11 = this.h;
                no4 no43 = this.g;
                fArr11[0] = no43.f2581a;
                fArr11[1] = no43.b;
                this.c[i4].mapPoints(fArr11);
                Path path3 = this.e;
                float[] fArr12 = this.h;
                path3.moveTo(fArr12[0], fArr12[1]);
                this.g.c(this.c[i4], this.e);
            }
            if (bVar != null) {
                no4 no44 = this.g;
                Matrix matrix4 = this.c[i4];
                ho4.a aVar2 = (ho4.a) bVar;
                Objects.requireNonNull(no44);
                ho4.this.i.set(i4 + 4, false);
                no4.f[] fVarArr2 = ho4.this.h;
                no44.b(no44.f);
                fVarArr2[i4] = new mo4(no44, new ArrayList(no44.h), new Matrix(matrix4));
            }
            i4 = i5;
        }
        path.close();
        this.e.close();
        if (!this.e.isEmpty()) {
            path.op(this.e, Path.Op.UNION);
        }
    }

    public final boolean b(Path path, int i2) {
        this.k.reset();
        this.f2249a[i2].c(this.b[i2], this.k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.k.computeBounds(rectF, true);
        path.op(this.k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return false;
        }
        return true;
    }
}
