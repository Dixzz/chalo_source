package com.urbanairship.messagecenter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageItemView extends FrameLayout {
    public static final int[] l = {R.attr.ua_state_highlighted};
    public TextView f;
    public TextView g;
    public ImageView h;
    public CheckBox i;
    public boolean j;
    public View.OnClickListener k;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageItemView(android.content.Context r6, android.util.AttributeSet r7) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.MessageItemView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @SuppressLint({"UnknownNullness"})
    public int[] onCreateDrawableState(int i2) {
        if (!this.j) {
            return super.onCreateDrawableState(i2);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        FrameLayout.mergeDrawableStates(onCreateDrawableState, l);
        return onCreateDrawableState;
    }

    public void setActivated(boolean z) {
        super.setActivated(z);
        CheckBox checkBox = this.i;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }

    public void setHighlighted(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
        }
    }

    public void setSelectionListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }
}
