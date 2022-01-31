package defpackage;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* renamed from: dk4  reason: default package */
/* compiled from: ImageMatrixProperty */
public class dk4 extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f849a = new Matrix();

    public dk4() {
        super(Matrix.class, "imageMatrixProperty");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.util.Property
    public Matrix get(ImageView imageView) {
        this.f849a.set(imageView.getImageMatrix());
        return this.f849a;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.Property
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
