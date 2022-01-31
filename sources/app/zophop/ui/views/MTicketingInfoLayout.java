package app.zophop.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.views.InfoIndexView;

public class MTicketingInfoLayout extends LinearLayout {
    public InfoIndexView f = ((InfoIndexView) findViewById(R.id.info_index_view));

    public MTicketingInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.mticketing_info_layout, (ViewGroup) this, false);
        addView(inflate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MTicketingInfoLayout, 0, 0);
        String string = obtainStyledAttributes.getString(4);
        String string2 = obtainStyledAttributes.getString(3);
        ((TextView) inflate.findViewById(R.id.ticket_info_layout_title)).setText(string);
        ((TextView) inflate.findViewById(R.id.ticket_info_layout_subtitle)).setText(string2);
        setInfoPosition(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void setInfoPosition(TypedArray typedArray) {
        int i = typedArray.getInt(1, 1);
        if (i == 0) {
            this.f.setMode(InfoIndexView.a.START);
        } else if (i == 1) {
            this.f.setMode(InfoIndexView.a.INTERMEDIATE);
        } else if (i == 2) {
            this.f.setMode(InfoIndexView.a.END);
        }
    }
}
