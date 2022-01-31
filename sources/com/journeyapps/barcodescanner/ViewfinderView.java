package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.perf.util.Constants;
import com.google.zxing.client.android.R;
import defpackage.u95;
import java.util.ArrayList;
import java.util.List;

public class ViewfinderView extends View {
    public static final int[] q = {0, 64, 128, 192, Constants.MAX_HOST_LENGTH, 192, 128, 64};
    public final Paint f = new Paint(1);
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public int k;
    public List<g35> l;
    public List<g35> m;
    public u95 n;
    public Rect o;
    public Rect p;

    public class a implements u95.e {
        public a() {
        }

        @Override // defpackage.u95.e
        public void a() {
            ViewfinderView.this.a();
            ViewfinderView.this.invalidate();
        }

        @Override // defpackage.u95.e
        public void b(Exception exc) {
        }

        @Override // defpackage.u95.e
        public void c() {
        }

        @Override // defpackage.u95.e
        public void d() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_finder);
        this.g = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R.color.zxing_viewfinder_mask));
        this.h = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_result_view, resources.getColor(R.color.zxing_result_view));
        this.i = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R.color.zxing_viewfinder_laser));
        this.j = obtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R.color.zxing_possible_result_points));
        obtainStyledAttributes.recycle();
        this.k = 0;
        this.l = new ArrayList(5);
        this.m = null;
    }

    public void a() {
        u95 u95 = this.n;
        if (u95 != null) {
            Rect framingRect = u95.getFramingRect();
            Rect previewFramingRect = this.n.getPreviewFramingRect();
            if (framingRect != null && previewFramingRect != null) {
                this.o = framingRect;
                this.p = previewFramingRect;
            }
        }
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Rect rect;
        a();
        Rect rect2 = this.o;
        if (!(rect2 == null || (rect = this.p) == null)) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f.setColor(this.g);
            float f2 = (float) width;
            canvas.drawRect(0.0f, 0.0f, f2, (float) rect2.top, this.f);
            canvas.drawRect(0.0f, (float) rect2.top, (float) rect2.left, (float) (rect2.bottom + 1), this.f);
            canvas.drawRect((float) (rect2.right + 1), (float) rect2.top, f2, (float) (rect2.bottom + 1), this.f);
            canvas.drawRect(0.0f, (float) (rect2.bottom + 1), f2, (float) height, this.f);
            this.f.setColor(this.i);
            Paint paint = this.f;
            int[] iArr = q;
            paint.setAlpha(iArr[this.k]);
            this.k = (this.k + 1) % iArr.length;
            int height2 = (rect2.height() / 2) + rect2.top;
            canvas.drawRect((float) (rect2.left + 2), (float) (height2 - 1), (float) (rect2.right - 1), (float) (height2 + 2), this.f);
            float width2 = ((float) rect2.width()) / ((float) rect.width());
            float height3 = ((float) rect2.height()) / ((float) rect.height());
            List<g35> list = this.l;
            List<g35> list2 = this.m;
            int i2 = rect2.left;
            int i3 = rect2.top;
            if (list.isEmpty()) {
                this.m = null;
            } else {
                this.l = new ArrayList(5);
                this.m = list;
                this.f.setAlpha(160);
                this.f.setColor(this.j);
                for (g35 g35 : list) {
                    canvas.drawCircle((float) (((int) (g35.f1210a * width2)) + i2), (float) (((int) (g35.b * height3)) + i3), 6.0f, this.f);
                }
            }
            if (list2 != null) {
                this.f.setAlpha(80);
                this.f.setColor(this.j);
                for (g35 g352 : list2) {
                    canvas.drawCircle((float) (((int) (g352.f1210a * width2)) + i2), (float) (((int) (g352.b * height3)) + i3), 3.0f, this.f);
                }
            }
            postInvalidateDelayed(80, rect2.left - 6, rect2.top - 6, rect2.right + 6, rect2.bottom + 6);
        }
    }

    public void setCameraPreview(u95 u95) {
        this.n = u95;
        u95.o.add(new a());
    }
}
