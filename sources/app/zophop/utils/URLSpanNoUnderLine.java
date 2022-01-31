package app.zophop.utils;

import android.text.TextPaint;
import android.text.style.URLSpan;

/* compiled from: URLSpanNoUnderLine.kt */
public final class URLSpanNoUnderLine extends URLSpan {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public URLSpanNoUnderLine(String str) {
        super(str);
        n86.e(str, "url");
    }

    public void updateDrawState(TextPaint textPaint) {
        n86.e(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
