package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/* renamed from: q61  reason: default package */
/* compiled from: ResourceUtils */
public class q61 extends BitmapDrawable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f2903a;
    public final /* synthetic */ Bitmap b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q61(Resources resources, Bitmap bitmap, float f, Bitmap bitmap2) {
        super(resources, bitmap);
        this.f2903a = f;
        this.b = bitmap2;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.f2903a, (float) (this.b.getWidth() / 2), (float) (this.b.getHeight() / 2));
        super.draw(canvas);
        canvas.restore();
    }
}
