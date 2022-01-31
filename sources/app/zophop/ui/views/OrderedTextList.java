package app.zophop.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import java.util.List;

public class OrderedTextList extends LinearLayout {
    public boolean f = false;
    public boolean g;
    public boolean h;

    public OrderedTextList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OrderedTextList, 0, 0);
        try {
            a(obtainStyledAttributes.getTextArray(0), -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void a(CharSequence[] charSequenceArr, int i) {
        View view;
        if (charSequenceArr != null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
            int i2 = 0;
            while (i2 < charSequenceArr.length) {
                int i3 = i2 + 1;
                CharSequence charSequence = charSequenceArr[i2];
                if (i == -1) {
                    view = layoutInflater.inflate(R.layout.text_list_layout, (ViewGroup) this, false);
                } else {
                    view = layoutInflater.inflate(i, (ViewGroup) this, false);
                }
                TextView textView = (TextView) view.findViewById(R.id.order_number);
                TextView textView2 = (TextView) view.findViewById(R.id.order_text);
                if (this.f) {
                    if (this.g) {
                        textView.setText(i3 + ")");
                    } else if (this.h) {
                        textView.setText(i3 + ".");
                    } else {
                        textView.setText(i3 + "");
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        textView2.setText(Html.fromHtml(charSequence.toString(), 63));
                    } else {
                        textView2.setText(Html.fromHtml(charSequence.toString()));
                    }
                } else {
                    if (this.g) {
                        textView.setText(i3 + ")");
                    } else if (this.h) {
                        textView.setText(i3 + ".");
                    } else {
                        textView.setText(i3 + "");
                    }
                    textView2.setText(charSequence, TextView.BufferType.SPANNABLE);
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                }
                addView(view);
                i2 = i3;
            }
        }
    }

    public void b(List<String> list, int i) {
        removeAllViews();
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = list.get(i2);
        }
        a(strArr, i);
    }

    public void setData(int i) {
        removeAllViews();
        a(getResources().getStringArray(i), -1);
    }

    public void setShowBracketAfterNumber(boolean z) {
        this.g = z;
    }

    public void setShowDotAfterNumber(boolean z) {
        this.h = z;
    }

    public void setShowFromHTMLMarkUp(boolean z) {
        this.f = z;
    }

    public void setData(String[] strArr) {
        removeAllViews();
        a(strArr, -1);
    }

    public void setData(List<String> list) {
        removeAllViews();
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = list.get(i);
        }
        a(strArr, -1);
    }
}
