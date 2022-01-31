package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.google.firebase.perf.util.Constants;
import com.squareup.picasso.Picasso;

/* renamed from: hf5  reason: default package */
/* compiled from: PicassoDrawable */
public final class hf5 extends BitmapDrawable {
    public static final Paint h = new Paint();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1366a;
    public final float b;
    public final Picasso.d c;
    public Drawable d;
    public long e;
    public boolean f;
    public int g = Constants.MAX_HOST_LENGTH;

    public hf5(Context context, Bitmap bitmap, Drawable drawable, Picasso.d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f1366a = z2;
        this.b = context.getResources().getDisplayMetrics().density;
        this.c = dVar;
        if (dVar != Picasso.d.MEMORY && !z) {
            this.d = drawable;
            this.f = true;
            this.e = SystemClock.uptimeMillis();
        }
    }

    public static Path a(int i, int i2, int i3) {
        Path path = new Path();
        float f2 = (float) i;
        float f3 = (float) i2;
        path.moveTo(f2, f3);
        path.lineTo((float) (i + i3), f3);
        path.lineTo(f2, (float) (i2 + i3));
        return path;
    }

    public static void b(ImageView imageView, Context context, Bitmap bitmap, Picasso.d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new hf5(context, bitmap, drawable, dVar, z, z2));
    }

    public static void c(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.f) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.e)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f = false;
                this.d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.g) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.g);
            }
        }
        if (this.f1366a) {
            Paint paint = h;
            paint.setColor(-1);
            canvas.drawPath(a(0, 0, (int) (this.b * 16.0f)), paint);
            paint.setColor(this.c.debugColor);
            canvas.drawPath(a(0, 0, (int) (this.b * 15.0f)), paint);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i) {
        this.g = i;
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
