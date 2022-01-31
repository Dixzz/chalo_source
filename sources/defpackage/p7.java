package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* renamed from: p7  reason: default package */
/* compiled from: PrecomputedTextCompat */
public class p7 implements Spannable {
    public char charAt(int i) {
        throw null;
    }

    public int getSpanEnd(Object obj) {
        throw null;
    }

    public int getSpanFlags(Object obj) {
        throw null;
    }

    public int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        throw null;
    }

    public int length() {
        throw null;
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        throw null;
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        } else {
            throw null;
        }
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        } else {
            throw null;
        }
    }

    public CharSequence subSequence(int i, int i2) {
        throw null;
    }

    public String toString() {
        throw null;
    }

    /* renamed from: p7$a */
    /* compiled from: PrecomputedTextCompat */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextPaint f2774a;
        public final TextDirectionHeuristic b;
        public final int c;
        public final int d;

        @SuppressLint({"NewApi"})
        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.f2774a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = i;
            this.d = i2;
        }

        public boolean a(a aVar) {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.c != aVar.c || this.d != aVar.d)) || this.f2774a.getTextSize() != aVar.f2774a.getTextSize() || this.f2774a.getTextScaleX() != aVar.f2774a.getTextScaleX() || this.f2774a.getTextSkewX() != aVar.f2774a.getTextSkewX() || this.f2774a.getLetterSpacing() != aVar.f2774a.getLetterSpacing() || !TextUtils.equals(this.f2774a.getFontFeatureSettings(), aVar.f2774a.getFontFeatureSettings()) || this.f2774a.getFlags() != aVar.f2774a.getFlags()) {
                return false;
            }
            if (i >= 24) {
                if (!this.f2774a.getTextLocales().equals(aVar.f2774a.getTextLocales())) {
                    return false;
                }
            } else if (!this.f2774a.getTextLocale().equals(aVar.f2774a.getTextLocale())) {
                return false;
            }
            if (this.f2774a.getTypeface() == null) {
                if (aVar.f2774a.getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f2774a.getTypeface().equals(aVar.f2774a.getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.b == aVar.b;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Objects.hash(Float.valueOf(this.f2774a.getTextSize()), Float.valueOf(this.f2774a.getTextScaleX()), Float.valueOf(this.f2774a.getTextSkewX()), Float.valueOf(this.f2774a.getLetterSpacing()), Integer.valueOf(this.f2774a.getFlags()), this.f2774a.getTextLocales(), this.f2774a.getTypeface(), Boolean.valueOf(this.f2774a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            return Objects.hash(Float.valueOf(this.f2774a.getTextSize()), Float.valueOf(this.f2774a.getTextScaleX()), Float.valueOf(this.f2774a.getTextSkewX()), Float.valueOf(this.f2774a.getLetterSpacing()), Integer.valueOf(this.f2774a.getFlags()), this.f2774a.getTextLocale(), this.f2774a.getTypeface(), Boolean.valueOf(this.f2774a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder i0 = hj1.i0("textSize=");
            i0.append(this.f2774a.getTextSize());
            sb.append(i0.toString());
            sb.append(", textScaleX=" + this.f2774a.getTextScaleX());
            sb.append(", textSkewX=" + this.f2774a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            StringBuilder i02 = hj1.i0(", letterSpacing=");
            i02.append(this.f2774a.getLetterSpacing());
            sb.append(i02.toString());
            sb.append(", elegantTextHeight=" + this.f2774a.isElegantTextHeight());
            if (i >= 24) {
                StringBuilder i03 = hj1.i0(", textLocale=");
                i03.append(this.f2774a.getTextLocales());
                sb.append(i03.toString());
            } else {
                StringBuilder i04 = hj1.i0(", textLocale=");
                i04.append(this.f2774a.getTextLocale());
                sb.append(i04.toString());
            }
            StringBuilder i05 = hj1.i0(", typeface=");
            i05.append(this.f2774a.getTypeface());
            sb.append(i05.toString());
            if (i >= 26) {
                StringBuilder i06 = hj1.i0(", variationSettings=");
                i06.append(this.f2774a.getFontVariationSettings());
                sb.append(i06.toString());
            }
            StringBuilder i07 = hj1.i0(", textDir=");
            i07.append(this.b);
            sb.append(i07.toString());
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f2774a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }
    }
}
