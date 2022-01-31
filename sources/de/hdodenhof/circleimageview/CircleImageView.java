package de.hdodenhof.circleimageview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

public class CircleImageView extends ImageView {
    public static final Bitmap.Config A = Bitmap.Config.ARGB_8888;
    public static final ImageView.ScaleType z = ImageView.ScaleType.CENTER_CROP;
    public final RectF f = new RectF();
    public final RectF g = new RectF();
    public final Matrix h = new Matrix();
    public final Paint i = new Paint();
    public final Paint j = new Paint();
    public final Paint k = new Paint();
    public int l = -16777216;
    public int m = 0;
    public int n = 0;
    public Bitmap o;
    public BitmapShader p;
    public int q;
    public int r;
    public float s;
    public float t;
    public ColorFilter u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;

    public class b extends ViewOutlineProvider {
        public b(a aVar) {
        }

        public void getOutline(View view, Outline outline) {
            if (CircleImageView.this.y) {
                ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                return;
            }
            Rect rect = new Rect();
            CircleImageView.this.g.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, 0, 0);
        this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_civ_border_width, 0);
        this.l = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_border_color, -16777216);
        this.x = obtainStyledAttributes.getBoolean(R.styleable.CircleImageView_civ_border_overlay, false);
        this.n = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_circle_background_color, 0);
        obtainStyledAttributes.recycle();
        super.setScaleType(z);
        this.v = true;
        setOutlineProvider(new b(null));
        if (this.w) {
            b();
            this.w = false;
        }
    }

    public final void a() {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        if (this.y) {
            this.o = null;
        } else {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                if (drawable instanceof BitmapDrawable) {
                    bitmap2 = ((BitmapDrawable) drawable).getBitmap();
                } else {
                    try {
                        if (drawable instanceof ColorDrawable) {
                            bitmap = Bitmap.createBitmap(2, 2, A);
                        } else {
                            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), A);
                        }
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                        drawable.draw(canvas);
                        bitmap2 = bitmap;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.o = bitmap2;
        }
        b();
    }

    public final void b() {
        float f2;
        float f3;
        int i2;
        if (!this.v) {
            this.w = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.o == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.o;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.p = new BitmapShader(bitmap, tileMode, tileMode);
            this.i.setAntiAlias(true);
            this.i.setDither(true);
            this.i.setFilterBitmap(true);
            this.i.setShader(this.p);
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setAntiAlias(true);
            this.j.setColor(this.l);
            this.j.setStrokeWidth((float) this.m);
            this.k.setStyle(Paint.Style.FILL);
            this.k.setAntiAlias(true);
            this.k.setColor(this.n);
            this.r = this.o.getHeight();
            this.q = this.o.getWidth();
            RectF rectF = this.g;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int min = Math.min(width, height);
            float paddingLeft = (((float) (width - min)) / 2.0f) + ((float) getPaddingLeft());
            float paddingTop = (((float) (height - min)) / 2.0f) + ((float) getPaddingTop());
            float f4 = (float) min;
            rectF.set(new RectF(paddingLeft, paddingTop, paddingLeft + f4, f4 + paddingTop));
            this.t = Math.min((this.g.height() - ((float) this.m)) / 2.0f, (this.g.width() - ((float) this.m)) / 2.0f);
            this.f.set(this.g);
            if (!this.x && (i2 = this.m) > 0) {
                float f5 = ((float) i2) - 1.0f;
                this.f.inset(f5, f5);
            }
            this.s = Math.min(this.f.height() / 2.0f, this.f.width() / 2.0f);
            Paint paint = this.i;
            if (paint != null) {
                paint.setColorFilter(this.u);
            }
            this.h.set(null);
            float f6 = 0.0f;
            if (this.f.height() * ((float) this.q) > this.f.width() * ((float) this.r)) {
                f3 = this.f.height() / ((float) this.r);
                f6 = (this.f.width() - (((float) this.q) * f3)) * 0.5f;
                f2 = 0.0f;
            } else {
                f3 = this.f.width() / ((float) this.q);
                f2 = (this.f.height() - (((float) this.r) * f3)) * 0.5f;
            }
            this.h.setScale(f3, f3);
            Matrix matrix = this.h;
            RectF rectF2 = this.f;
            matrix.postTranslate(((float) ((int) (f6 + 0.5f))) + rectF2.left, ((float) ((int) (f2 + 0.5f))) + rectF2.top);
            this.p.setLocalMatrix(this.h);
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.l;
    }

    public int getBorderWidth() {
        return this.m;
    }

    public int getCircleBackgroundColor() {
        return this.n;
    }

    public ColorFilter getColorFilter() {
        return this.u;
    }

    public ImageView.ScaleType getScaleType() {
        return z;
    }

    public void onDraw(Canvas canvas) {
        if (this.y) {
            super.onDraw(canvas);
        } else if (this.o != null) {
            if (this.n != 0) {
                canvas.drawCircle(this.f.centerX(), this.f.centerY(), this.s, this.k);
            }
            canvas.drawCircle(this.f.centerX(), this.f.centerY(), this.s, this.i);
            if (this.m > 0) {
                canvas.drawCircle(this.g.centerX(), this.g.centerY(), this.t, this.j);
            }
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        b();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.y) {
            return super.onTouchEvent(motionEvent);
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (!this.g.isEmpty()) {
            if (Math.pow((double) (y2 - this.g.centerY()), 2.0d) + Math.pow((double) (x2 - this.g.centerX()), 2.0d) > Math.pow((double) this.t, 2.0d)) {
                z2 = false;
                if (!z2 && super.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
        }
        z2 = true;
        return !z2 ? false : false;
    }

    public void setAdjustViewBounds(boolean z2) {
        if (z2) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i2) {
        if (i2 != this.l) {
            this.l = i2;
            this.j.setColor(i2);
            invalidate();
        }
    }

    public void setBorderOverlay(boolean z2) {
        if (z2 != this.x) {
            this.x = z2;
            b();
        }
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.m) {
            this.m = i2;
            b();
        }
    }

    public void setCircleBackgroundColor(int i2) {
        if (i2 != this.n) {
            this.n = i2;
            this.k.setColor(i2);
            invalidate();
        }
    }

    public void setCircleBackgroundColorResource(int i2) {
        setCircleBackgroundColor(getContext().getResources().getColor(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.u) {
            this.u = colorFilter;
            Paint paint = this.i;
            if (paint != null) {
                paint.setColorFilter(colorFilter);
            }
            invalidate();
        }
    }

    public void setDisableCircularTransformation(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
            a();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        a();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        a();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        a();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        b();
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        b();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != z) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }
}
