package app.zophop.utilities.external.fadingactionbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ObservableScrollView extends ScrollView {
    public boolean f = true;
    public td1 g;

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public float getBottomFadingEdgeStrength() {
        boolean z = this.f;
        return super.getBottomFadingEdgeStrength();
    }

    public float getTopFadingEdgeStrength() {
        boolean z = this.f;
        return super.getTopFadingEdgeStrength();
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        td1 td1 = this.g;
        if (td1 != null) {
            td1.a(i, i2);
        }
    }

    public void setOnScrollChangedCallback(td1 td1) {
        this.g = td1;
    }
}
