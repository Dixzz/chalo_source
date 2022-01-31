package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.perf.util.Constants;
import defpackage.n3;

/* renamed from: p4  reason: default package */
/* compiled from: Placeholder */
public class p4 extends View {
    public int f;
    public View g;
    public int h;

    public void a() {
        if (this.g != null) {
            ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.g.getLayoutParams();
            aVar2.l0.X = 0;
            n3.a l = aVar.l0.l();
            n3.a aVar3 = n3.a.FIXED;
            if (l != aVar3) {
                aVar.l0.G(aVar2.l0.q());
            }
            if (aVar.l0.p() != aVar3) {
                aVar.l0.B(aVar2.l0.k());
            }
            aVar2.l0.X = 8;
        }
    }

    public View getContent() {
        return this.g;
    }

    public int getEmptyVisibility() {
        return this.h;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(Constants.MAX_HOST_LENGTH, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) rect.height()) / 2.0f) + (((float) height) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f != i) {
            View view = this.g;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.a) this.g.getLayoutParams()).a0 = false;
                this.g = null;
            }
            this.f = i;
            if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i) {
        this.h = i;
    }
}
