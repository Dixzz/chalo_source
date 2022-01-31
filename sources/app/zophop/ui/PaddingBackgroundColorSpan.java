package app.zophop.ui;

import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;

public class PaddingBackgroundColorSpan extends BackgroundColorSpan {
    public final int f;

    public PaddingBackgroundColorSpan(int i, int i2) {
        super(i);
        this.f = i2;
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.baselineShift = -this.f;
    }
}
