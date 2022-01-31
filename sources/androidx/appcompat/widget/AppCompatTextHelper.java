package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import defpackage.y5;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight = -1;
    private int mStyle = 0;
    private final TextView mView;

    public AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            TextView textView = this.mView;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
                TextView textView2 = this.mView;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            TextView textView3 = this.mView;
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            Drawable drawable8 = compoundDrawablesRelative2[2];
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
        }
    }

    private void setCompoundTints() {
        TintInfo tintInfo = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int i, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i, f);
    }

    private void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        int i = Build.VERSION.SDK_INT;
        this.mStyle = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        boolean z = false;
        if (i >= 28) {
            int i2 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i2;
            if (i2 != -1) {
                this.mStyle = (this.mStyle & 2) | 0;
            }
        }
        int i3 = R.styleable.TextAppearance_android_fontFamily;
        if (tintTypedArray.hasValue(i3) || tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            this.mFontTypeface = null;
            int i4 = R.styleable.TextAppearance_fontFamily;
            if (tintTypedArray.hasValue(i4)) {
                i3 = i4;
            }
            final int i5 = this.mFontWeight;
            final int i6 = this.mStyle;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.mView);
                try {
                    Typeface font = tintTypedArray.getFont(i3, this.mStyle, new y5.c() {
                        /* class androidx.appcompat.widget.AppCompatTextHelper.AnonymousClass1 */

                        @Override // defpackage.y5.c
                        public void onFontRetrievalFailed(int i) {
                        }

                        @Override // defpackage.y5.c
                        public void onFontRetrieved(Typeface typeface) {
                            int i;
                            if (Build.VERSION.SDK_INT >= 28 && (i = i5) != -1) {
                                typeface = Typeface.create(typeface, i, (i6 & 2) != 0);
                            }
                            AppCompatTextHelper.this.onAsyncTypefaceReceived(weakReference, typeface);
                        }
                    });
                    if (font != null) {
                        if (i < 28 || this.mFontWeight == -1) {
                            this.mFontTypeface = font;
                        } else {
                            this.mFontTypeface = Typeface.create(Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                        }
                    }
                    this.mAsyncFontPending = this.mFontTypeface == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null && (string = tintTypedArray.getString(i3)) != null) {
                if (i < 28 || this.mFontWeight == -1) {
                    this.mFontTypeface = Typeface.create(string, this.mStyle);
                    return;
                }
                Typeface create = Typeface.create(string, 0);
                int i7 = this.mFontWeight;
                if ((this.mStyle & 2) != 0) {
                    z = true;
                }
                this.mFontTypeface = Typeface.create(create, i7, z);
                return;
            }
            return;
        }
        int i8 = R.styleable.TextAppearance_android_typeface;
        if (tintTypedArray.hasValue(i8)) {
            this.mAsyncFontPending = false;
            int i9 = tintTypedArray.getInt(i8, 1);
            if (i9 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
            } else if (i9 == 2) {
                this.mFontTypeface = Typeface.SERIF;
            } else if (i9 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
            }
        }
    }

    public void applyCompoundDrawablesTints() {
        if (!(this.mDrawableLeftTint == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null)) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }

    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    public ColorStateList getCompoundDrawableTintList() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01cd  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFromAttributes(android.util.AttributeSet r24, int r25) {
        /*
        // Method dump skipped, instructions count: 816
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }

    public void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            final TextView textView = weakReference.get();
            if (textView != null) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (textView.isAttachedToWindow()) {
                    final int i = this.mStyle;
                    textView.post(new Runnable() {
                        /* class androidx.appcompat.widget.AppCompatTextHelper.AnonymousClass2 */

                        public void run() {
                            textView.setTypeface(typeface, i);
                        }
                    });
                    return;
                }
                textView.setTypeface(typeface, this.mStyle);
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!r9.f3059a) {
            autoSizeText();
        }
    }

    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    public void onSetTextAppearance(Context context, int i) {
        String string;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
        int i2 = R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i2)) {
            setAllCaps(obtainStyledAttributes.getBoolean(i2, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            int i4 = R.styleable.TextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i4) && (colorStateList3 = obtainStyledAttributes.getColorStateList(i4)) != null) {
                this.mView.setTextColor(colorStateList3);
            }
            int i5 = R.styleable.TextAppearance_android_textColorLink;
            if (obtainStyledAttributes.hasValue(i5) && (colorStateList2 = obtainStyledAttributes.getColorStateList(i5)) != null) {
                this.mView.setLinkTextColor(colorStateList2);
            }
            int i6 = R.styleable.TextAppearance_android_textColorHint;
            if (obtainStyledAttributes.hasValue(i6) && (colorStateList = obtainStyledAttributes.getColorStateList(i6)) != null) {
                this.mView.setHintTextColor(colorStateList);
            }
        }
        int i7 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i7) && obtainStyledAttributes.getDimensionPixelSize(i7, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        if (i3 >= 26) {
            int i8 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i8) && (string = obtainStyledAttributes.getString(i8)) != null) {
                this.mView.setFontVariationSettings(string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    public void populateSurroundingTextIfNeeded(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        CharSequence charSequence;
        int i = Build.VERSION.SDK_INT;
        if (i < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            Objects.requireNonNull(text);
            if (i >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            int i2 = editorInfo.initialSelStart;
            int i3 = editorInfo.initialSelEnd;
            int i4 = i2 > i3 ? i3 + 0 : i2 + 0;
            int i5 = i2 > i3 ? i2 - 0 : i3 + 0;
            int length = text.length();
            if (i4 < 0 || i5 > length) {
                h9.b(editorInfo, null, 0, 0);
                return;
            }
            int i6 = editorInfo.inputType & 4095;
            if (i6 == 129 || i6 == 225 || i6 == 18) {
                h9.b(editorInfo, null, 0, 0);
            } else if (length <= 2048) {
                h9.b(editorInfo, text, i4, i5);
            } else {
                int i7 = i5 - i4;
                int i8 = i7 > 1024 ? 0 : i7;
                int i9 = 2048 - i8;
                int min = Math.min(text.length() - i5, i9 - Math.min(i4, (int) (((double) i9) * 0.8d)));
                int min2 = Math.min(i4, i9 - min);
                int i10 = i4 - min2;
                if (h9.a(text, i10, 0)) {
                    i10++;
                    min2--;
                }
                if (h9.a(text, (i5 + min) - 1, 1)) {
                    min--;
                }
                int i11 = min2 + i8 + min;
                if (i8 != i7) {
                    charSequence = TextUtils.concat(text.subSequence(i10, i10 + min2), text.subSequence(i5, min + i5));
                } else {
                    charSequence = text.subSequence(i10, i11 + i10);
                }
                int i12 = min2 + 0;
                h9.b(editorInfo, charSequence, i12, i8 + i12);
            }
        }
    }

    public void setAllCaps(boolean z) {
        this.mView.setAllCaps(z);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i);
    }

    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        setCompoundTints();
    }

    public void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        setCompoundTints();
    }

    public void setTextSize(int i, float f) {
        if (!r9.f3059a && !isAutoSizeEnabled()) {
            setTextSizeInternal(i, f);
        }
    }
}
