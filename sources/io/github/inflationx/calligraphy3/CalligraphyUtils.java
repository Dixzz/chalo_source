package io.github.inflationx.calligraphy3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public final class CalligraphyUtils {
    public static final int[] ANDROID_ATTR_TEXT_APPEARANCE = {16842804};
    private static Boolean sAppCompatViewCheck;
    private static Boolean sToolbarCheck;

    private CalligraphyUtils() {
    }

    public static boolean applyFontToTextView(TextView textView, Typeface typeface) {
        return applyFontToTextView(textView, typeface, false);
    }

    public static CharSequence applyTypefaceSpan(CharSequence charSequence, Typeface typeface) {
        if (charSequence != null && charSequence.length() > 0) {
            if (!(charSequence instanceof Spannable)) {
                charSequence = new SpannableString(charSequence);
            }
            ((Spannable) charSequence).setSpan(TypefaceUtils.getSpan(typeface), 0, charSequence.length(), 33);
        }
        return charSequence;
    }

    public static boolean canAddV7AppCompatViews() {
        if (sAppCompatViewCheck == null) {
            try {
                Class.forName("androidx.appcompat.widget.AppCompatTextView");
                sAppCompatViewCheck = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                sAppCompatViewCheck = Boolean.FALSE;
            }
        }
        return sAppCompatViewCheck.booleanValue();
    }

    public static boolean canCheckForV7Toolbar() {
        if (sToolbarCheck == null) {
            try {
                Class.forName("androidx.appcompat.widget.Toolbar");
                sToolbarCheck = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                sToolbarCheck = Boolean.FALSE;
            }
        }
        return sToolbarCheck.booleanValue();
    }

    public static String pullFontPathFromStyle(Context context, AttributeSet attributeSet, int[] iArr) {
        TypedArray obtainStyledAttributes;
        if (!(iArr == null || attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr)) == null)) {
            try {
                String string = obtainStyledAttributes.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    obtainStyledAttributes.recycle();
                    return string;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
            obtainStyledAttributes.recycle();
        }
        return null;
    }

    public static String pullFontPathFromTextAppearance(Context context, AttributeSet attributeSet, int[] iArr) {
        if (!(iArr == null || attributeSet == null)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ANDROID_ATTR_TEXT_APPEARANCE);
            int i = -1;
            if (obtainStyledAttributes != null) {
                try {
                    i = obtainStyledAttributes.getResourceId(0, -1);
                } catch (Exception unused) {
                    return null;
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, iArr);
            if (obtainStyledAttributes2 != null) {
                try {
                    return obtainStyledAttributes2.getString(0);
                } catch (Exception unused2) {
                } finally {
                    obtainStyledAttributes2.recycle();
                }
            }
        }
        return null;
    }

    public static String pullFontPathFromTheme(Context context, int i, int[] iArr) {
        if (!(i == -1 || iArr == null)) {
            Resources.Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(i, typedValue, true);
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(typedValue.resourceId, iArr);
            try {
                return obtainStyledAttributes.getString(0);
            } catch (Exception unused) {
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        return null;
    }

    public static String pullFontPathFromView(Context context, AttributeSet attributeSet, int[] iArr) {
        String str;
        CharSequence charSequence;
        if (!(iArr == null || attributeSet == null)) {
            try {
                String resourceEntryName = context.getResources().getResourceEntryName(iArr[0]);
                int attributeResourceValue = attributeSet.getAttributeResourceValue(null, resourceEntryName, -1);
                if (attributeResourceValue > 0) {
                    str = context.getString(attributeResourceValue);
                } else {
                    str = attributeSet.getAttributeValue(null, resourceEntryName);
                }
                if (str == null || !str.startsWith("?") || str.length() <= 1) {
                    return str;
                }
                String substring = str.substring(1);
                if (!TextUtils.isDigitsOnly(substring)) {
                    return str;
                }
                int parseInt = Integer.parseInt(substring);
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(parseInt, typedValue, true);
                return (typedValue.type != 3 || (charSequence = typedValue.string) == null) ? str : charSequence.toString();
            } catch (Resources.NotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean applyFontToTextView(TextView textView, final Typeface typeface, boolean z) {
        if (textView == null || typeface == null) {
            return false;
        }
        textView.setPaintFlags(textView.getPaintFlags() | 128 | 1);
        textView.setTypeface(typeface);
        if (z) {
            textView.setText(applyTypefaceSpan(textView.getText(), typeface), TextView.BufferType.SPANNABLE);
            textView.addTextChangedListener(new TextWatcher() {
                /* class io.github.inflationx.calligraphy3.CalligraphyUtils.AnonymousClass1 */

                public void afterTextChanged(Editable editable) {
                    CalligraphyUtils.applyTypefaceSpan(editable, typeface);
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
        return true;
    }

    public static boolean applyFontToTextView(Context context, TextView textView, String str) {
        return applyFontToTextView(context, textView, str, false);
    }

    public static boolean applyFontToTextView(Context context, TextView textView, String str, boolean z) {
        if (textView == null || context == null) {
            return false;
        }
        return applyFontToTextView(textView, TypefaceUtils.load(context.getAssets(), str), z);
    }

    public static String pullFontPathFromTheme(Context context, int i, int i2, int[] iArr) {
        TypedArray obtainStyledAttributes;
        if (!(i == -1 || iArr == null)) {
            Resources.Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(i, typedValue, true);
            TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(typedValue.resourceId, new int[]{i2});
            try {
                int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
                if (!(resourceId == -1 || (obtainStyledAttributes = context.obtainStyledAttributes(resourceId, iArr)) == null)) {
                    try {
                        return obtainStyledAttributes.getString(0);
                    } catch (Exception unused) {
                    } finally {
                        obtainStyledAttributes.recycle();
                    }
                }
                return null;
            } catch (Exception unused2) {
            } finally {
                obtainStyledAttributes2.recycle();
            }
        }
        return null;
    }

    public static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig) {
        applyFontToTextView(context, textView, calligraphyConfig, false);
    }

    public static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, boolean z) {
        if (context != null && textView != null && calligraphyConfig != null && calligraphyConfig.isFontSet()) {
            applyFontToTextView(context, textView, calligraphyConfig.getFontPath(), z);
        }
    }

    public static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, String str) {
        applyFontToTextView(context, textView, calligraphyConfig, str, false);
    }

    public static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, String str, boolean z) {
        if (context != null && textView != null && calligraphyConfig != null) {
            if (TextUtils.isEmpty(str) || !applyFontToTextView(context, textView, str, z)) {
                applyFontToTextView(context, textView, calligraphyConfig, z);
            }
        }
    }
}
