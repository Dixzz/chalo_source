package app.zophop.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

public class OrderedBulletTextList extends LinearLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderedBulletTextList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        int i = 0;
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OrderedTextList, 0, 0);
        try {
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
            if (textArray != null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
                while (i < textArray.length) {
                    int i2 = i + 1;
                    a(layoutInflater, textArray[i]);
                    i = i2;
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void a(LayoutInflater layoutInflater, CharSequence charSequence) {
        View inflate = layoutInflater.inflate(R.layout.text_bullet_layout, (ViewGroup) this, false);
        ((TextView) inflate.findViewById(R.id.order_number)).setText("•");
        TextView textView = (TextView) inflate.findViewById(R.id.order_text);
        textView.setText(charSequence, TextView.BufferType.SPANNABLE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        addView(inflate);
    }
}
