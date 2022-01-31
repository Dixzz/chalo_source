package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: no4  reason: default package */
/* compiled from: ShapePath */
public class no4 {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f2581a;
    @Deprecated
    public float b;
    @Deprecated
    public float c;
    @Deprecated
    public float d;
    @Deprecated
    public float e;
    @Deprecated
    public float f;
    public final List<e> g = new ArrayList();
    public final List<f> h = new ArrayList();

    /* renamed from: no4$a */
    /* compiled from: ShapePath */
    public static class a extends f {
        public final c b;

        public a(c cVar) {
            this.b = cVar;
        }

        @Override // defpackage.no4.f
        public void a(Matrix matrix, zn4 zn4, int i, Canvas canvas) {
            c cVar = this.b;
            float f = cVar.f;
            float f2 = cVar.g;
            c cVar2 = this.b;
            RectF rectF = new RectF(cVar2.b, cVar2.c, cVar2.d, cVar2.e);
            int[] iArr = zn4.k;
            boolean z = f2 < 0.0f;
            Path path = zn4.g;
            if (z) {
                iArr[0] = 0;
                iArr[1] = zn4.f;
                iArr[2] = zn4.e;
                iArr[3] = zn4.d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = (float) (-i);
                rectF.inset(f3, f3);
                iArr[0] = 0;
                iArr[1] = zn4.d;
                iArr[2] = zn4.e;
                iArr[3] = zn4.f;
            }
            float width = rectF.width() / 2.0f;
            if (width > 0.0f) {
                float f4 = 1.0f - (((float) i) / width);
                float[] fArr = zn4.l;
                fArr[1] = f4;
                fArr[2] = ((1.0f - f4) / 2.0f) + f4;
                zn4.b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP));
                canvas.save();
                canvas.concat(matrix);
                if (!z) {
                    canvas.clipPath(path, Region.Op.DIFFERENCE);
                    canvas.drawPath(path, zn4.h);
                }
                canvas.drawArc(rectF, f, f2, true, zn4.b);
                canvas.restore();
            }
        }
    }

    /* renamed from: no4$b */
    /* compiled from: ShapePath */
    public static class b extends f {
        public final d b;
        public final float c;
        public final float d;

        public b(d dVar, float f, float f2) {
            this.b = dVar;
            this.c = f;
            this.d = f2;
        }

        @Override // defpackage.no4.f
        public void a(Matrix matrix, zn4 zn4, int i, Canvas canvas) {
            d dVar = this.b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (dVar.c - this.d), (double) (dVar.b - this.c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.d);
            matrix2.preRotate(b());
            Objects.requireNonNull(zn4);
            rectF.bottom += (float) i;
            rectF.offset(0.0f, (float) (-i));
            int[] iArr = zn4.i;
            iArr[0] = zn4.f;
            iArr[1] = zn4.e;
            iArr[2] = zn4.d;
            Paint paint = zn4.c;
            float f = rectF.left;
            paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, iArr, zn4.j, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, zn4.c);
            canvas.restore();
        }

        public float b() {
            d dVar = this.b;
            return (float) Math.toDegrees(Math.atan((double) ((dVar.c - this.d) / (dVar.b - this.c))));
        }
    }

    /* renamed from: no4$c */
    /* compiled from: ShapePath */
    public static class c extends e {
        public static final RectF h = new RectF();
        @Deprecated
        public float b;
        @Deprecated
        public float c;
        @Deprecated
        public float d;
        @Deprecated
        public float e;
        @Deprecated
        public float f;
        @Deprecated
        public float g;

        public c(float f2, float f3, float f4, float f5) {
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
        }

        @Override // defpackage.no4.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2582a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = h;
            rectF.set(this.b, this.c, this.d, this.e);
            path.arcTo(rectF, this.f, this.g, false);
            path.transform(matrix);
        }
    }

    /* renamed from: no4$d */
    /* compiled from: ShapePath */
    public static class d extends e {
        public float b;
        public float c;

        @Override // defpackage.no4.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2582a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.c);
            path.transform(matrix);
        }
    }

    /* renamed from: no4$e */
    /* compiled from: ShapePath */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f2582a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* renamed from: no4$f */
    /* compiled from: ShapePath */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        public static final Matrix f2583a = new Matrix();

        public abstract void a(Matrix matrix, zn4 zn4, int i, Canvas canvas);
    }

    public no4() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f = f6;
        cVar.g = f7;
        this.g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.h.add(aVar);
        this.e = f9;
        double d2 = (double) f8;
        this.c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.e;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.c;
                float f6 = this.d;
                c cVar = new c(f5, f6, f5, f6);
                cVar.f = this.e;
                cVar.g = f4;
                this.h.add(new a(cVar));
                this.e = f2;
            }
        }
    }

    public void c(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d dVar = new d();
        dVar.b = f2;
        dVar.c = f3;
        this.g.add(dVar);
        b bVar = new b(dVar, this.c, this.d);
        b(bVar.b() + 270.0f);
        this.h.add(bVar);
        this.e = bVar.b() + 270.0f;
        this.c = f2;
        this.d = f3;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.f2581a = f2;
        this.b = f3;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = (f4 + f5) % 360.0f;
        this.g.clear();
        this.h.clear();
    }
}
