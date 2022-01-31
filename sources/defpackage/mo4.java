package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import defpackage.no4;
import java.util.List;

/* renamed from: mo4  reason: default package */
/* compiled from: ShapePath */
public class mo4 extends no4.f {
    public final /* synthetic */ List b;
    public final /* synthetic */ Matrix c;

    public mo4(no4 no4, List list, Matrix matrix) {
        this.b = list;
        this.c = matrix;
    }

    @Override // defpackage.no4.f
    public void a(Matrix matrix, zn4 zn4, int i, Canvas canvas) {
        for (no4.f fVar : this.b) {
            fVar.a(this.c, zn4, i, canvas);
        }
    }
}
