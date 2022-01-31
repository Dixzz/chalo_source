package defpackage;

import android.view.View;
import com.urbanairship.messagecenter.MessageItemView;

/* renamed from: dv5  reason: default package */
/* compiled from: MessageItemView */
public class dv5 implements View.OnClickListener {
    public final /* synthetic */ MessageItemView f;

    public dv5(MessageItemView messageItemView) {
        this.f = messageItemView;
    }

    public void onClick(View view) {
        MessageItemView messageItemView = this.f;
        View.OnClickListener onClickListener = messageItemView.k;
        if (onClickListener != null) {
            onClickListener.onClick(messageItemView);
        }
    }
}
