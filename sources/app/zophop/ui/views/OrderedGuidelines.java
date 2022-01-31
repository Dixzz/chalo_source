package app.zophop.ui.views;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Guideline;
import app.zophop.models.Guidelines;

public class OrderedGuidelines extends LinearLayout {
    public boolean f = false;
    public Guidelines g;

    public OrderedGuidelines(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        a();
    }

    public final void a() {
        Guidelines guidelines = this.g;
        if (guidelines != null && guidelines.getGuidelineList() != null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
            Guideline[] guidelineList = this.g.getGuidelineList();
            int i = 0;
            while (i < guidelineList.length) {
                int i2 = i + 1;
                Guideline guideline = guidelineList[i];
                int i3 = Build.VERSION.SDK_INT;
                View inflate = layoutInflater.inflate(R.layout.text_list_layout, (ViewGroup) this, false);
                int i4 = R.id.order_number;
                int i5 = R.id.order_text;
                TextView textView = (TextView) inflate.findViewById(R.id.order_text);
                ((TextView) inflate.findViewById(R.id.order_number)).setText(String.valueOf(i2));
                if (!this.f) {
                    textView.setText(guideline.getGuideline());
                } else if (i3 >= 24) {
                    textView.setText(Html.fromHtml(guideline.getGuideline(), 63));
                } else {
                    textView.setText(Html.fromHtml(guideline.getGuideline()));
                }
                addView(inflate);
                if (guideline.getSubGuidelines() != null) {
                    String[] subGuidelines = guideline.getSubGuidelines();
                    int length = subGuidelines.length;
                    int i6 = 0;
                    while (i6 < length) {
                        String str = subGuidelines[i6];
                        View inflate2 = layoutInflater.inflate(R.layout.text_list_subitem_layout, (ViewGroup) this, false);
                        TextView textView2 = (TextView) inflate2.findViewById(i5);
                        ((TextView) inflate2.findViewById(i4)).setVisibility(4);
                        ((ImageView) inflate2.findViewById(R.id.order_bullet)).setVisibility(0);
                        if (!this.f) {
                            textView2.setText(str);
                        } else if (i3 >= 24) {
                            textView2.setText(Html.fromHtml(str, 63));
                        } else {
                            textView2.setText(Html.fromHtml(str));
                        }
                        addView(inflate2);
                        i6++;
                        i4 = R.id.order_number;
                        i5 = R.id.order_text;
                    }
                }
                i = i2;
            }
        }
    }

    public void setData(Guidelines guidelines) {
        removeAllViews();
        this.g = guidelines;
        a();
    }

    public void setIsTextHTMLMarkup(boolean z) {
        this.f = z;
    }
}
