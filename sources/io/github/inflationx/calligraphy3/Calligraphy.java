package io.github.inflationx.calligraphy3;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class Calligraphy {
    private static final String ACTION_BAR_SUBTITLE = "action_bar_subtitle";
    private static final String ACTION_BAR_TITLE = "action_bar_title";
    private final int[] mAttributeId;
    private final CalligraphyConfig mCalligraphyConfig;

    public static class ToolbarLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public static String BLANK = " ";
        private final WeakReference<Calligraphy> mCalligraphyFactory;
        private final WeakReference<Context> mContextRef;
        private final WeakReference<Toolbar> mToolbarReference;
        private final CharSequence originalSubTitle;

        private void removeSelf(Toolbar toolbar) {
            toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @TargetApi(16)
        public void onGlobalLayout() {
            Toolbar toolbar = this.mToolbarReference.get();
            Context context = this.mContextRef.get();
            Calligraphy calligraphy = this.mCalligraphyFactory.get();
            if (toolbar != null) {
                if (calligraphy == null || context == null) {
                    removeSelf(toolbar);
                    return;
                }
                int childCount = toolbar.getChildCount();
                if (childCount != 0) {
                    for (int i = 0; i < childCount; i++) {
                        calligraphy.onViewCreated(toolbar.getChildAt(i), context, null);
                    }
                }
                removeSelf(toolbar);
                toolbar.setSubtitle(this.originalSubTitle);
            }
        }

        private ToolbarLayoutListener(Calligraphy calligraphy, Context context, Toolbar toolbar) {
            this.mCalligraphyFactory = new WeakReference<>(calligraphy);
            this.mContextRef = new WeakReference<>(context);
            this.mToolbarReference = new WeakReference<>(toolbar);
            this.originalSubTitle = toolbar.getSubtitle();
            toolbar.setSubtitle(BLANK);
        }
    }

    public Calligraphy(CalligraphyConfig calligraphyConfig) {
        this.mCalligraphyConfig = calligraphyConfig;
        this.mAttributeId = new int[]{calligraphyConfig.getAttrId()};
    }

    private String applyFontMapper(String str) {
        FontMapper fontMapper = this.mCalligraphyConfig.getFontMapper();
        return fontMapper != null ? fontMapper.map(str) : str;
    }

    private Typeface getDefaultTypeface(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.mCalligraphyConfig.getFontPath();
        }
        if (!TextUtils.isEmpty(str)) {
            return TypefaceUtils.load(context.getAssets(), str);
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static boolean isActionBarSubTitle(TextView textView) {
        if (matchesResourceIdName(textView, ACTION_BAR_SUBTITLE)) {
            return true;
        }
        if (parentIsToolbarV7(textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getSubtitle(), textView.getText());
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static boolean isActionBarTitle(TextView textView) {
        if (matchesResourceIdName(textView, ACTION_BAR_TITLE)) {
            return true;
        }
        if (parentIsToolbarV7(textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getTitle(), textView.getText());
        }
        return false;
    }

    public static boolean matchesResourceIdName(View view, String str) {
        if (view.getId() == -1) {
            return false;
        }
        return view.getResources().getResourceEntryName(view.getId()).equalsIgnoreCase(str);
    }

    public static boolean parentIsToolbarV7(View view) {
        return CalligraphyUtils.canCheckForV7Toolbar() && view.getParent() != null && (view.getParent() instanceof Toolbar);
    }

    private String resolveFontPath(Context context, AttributeSet attributeSet) {
        String pullFontPathFromView = CalligraphyUtils.pullFontPathFromView(context, attributeSet, this.mAttributeId);
        if (TextUtils.isEmpty(pullFontPathFromView)) {
            pullFontPathFromView = CalligraphyUtils.pullFontPathFromStyle(context, attributeSet, this.mAttributeId);
        }
        return TextUtils.isEmpty(pullFontPathFromView) ? CalligraphyUtils.pullFontPathFromTextAppearance(context, attributeSet, this.mAttributeId) : pullFontPathFromView;
    }

    public int[] getStyleForTextView(TextView textView) {
        int[] iArr = {-1, -1};
        if (isActionBarTitle(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843512;
        } else if (isActionBarSubTitle(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843513;
        }
        if (iArr[0] == -1) {
            iArr[0] = this.mCalligraphyConfig.getClassStyles().containsKey(textView.getClass()) ? this.mCalligraphyConfig.getClassStyles().get(textView.getClass()).intValue() : 16842804;
        }
        return iArr;
    }

    public View onViewCreated(View view, Context context, AttributeSet attributeSet) {
        int i;
        Boolean bool;
        if (!(view == null || view.getTag((i = R.id.calligraphy_tag_id)) == (bool = Boolean.TRUE))) {
            onViewCreatedInternal(view, context, attributeSet);
            view.setTag(i, bool);
        }
        return view;
    }

    public void onViewCreatedInternal(View view, Context context, AttributeSet attributeSet) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!TypefaceUtils.isLoaded(textView.getTypeface())) {
                String resolveFontPath = resolveFontPath(context, attributeSet);
                if (TextUtils.isEmpty(resolveFontPath)) {
                    int[] styleForTextView = getStyleForTextView(textView);
                    if (styleForTextView[1] != -1) {
                        resolveFontPath = CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], styleForTextView[1], this.mAttributeId);
                    } else {
                        resolveFontPath = CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], this.mAttributeId);
                    }
                }
                CalligraphyUtils.applyFontToTextView(context, textView, this.mCalligraphyConfig, applyFontMapper(resolveFontPath), matchesResourceIdName(view, ACTION_BAR_TITLE) || matchesResourceIdName(view, ACTION_BAR_SUBTITLE));
            } else {
                return;
            }
        }
        if (CalligraphyUtils.canCheckForV7Toolbar() && (view instanceof Toolbar)) {
            Toolbar toolbar = (Toolbar) view;
            toolbar.getViewTreeObserver().addOnGlobalLayoutListener(new ToolbarLayoutListener(context, toolbar));
        }
        if (view instanceof HasTypeface) {
            Typeface defaultTypeface = getDefaultTypeface(context, applyFontMapper(resolveFontPath(context, attributeSet)));
            if (defaultTypeface != null) {
                ((HasTypeface) view).setTypeface(defaultTypeface);
            }
        } else if (this.mCalligraphyConfig.isCustomViewTypefaceSupport() && this.mCalligraphyConfig.isCustomViewHasTypeface(view)) {
            Method method = ReflectionUtils.getMethod(view.getClass(), "setTypeface");
            Typeface defaultTypeface2 = getDefaultTypeface(context, applyFontMapper(resolveFontPath(context, attributeSet)));
            if (method != null && defaultTypeface2 != null) {
                ReflectionUtils.invokeMethod(view, method, defaultTypeface2);
            }
        }
    }
}
