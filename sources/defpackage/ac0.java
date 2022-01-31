package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.R;
import app.zophop.ui.activities.ActiveMTicketScreen;

/* renamed from: ac0  reason: default package */
/* compiled from: ActiveMTicketScreen */
public class ac0 implements View.OnClickListener {
    public final ImageView f;
    public final /* synthetic */ ImageView g;
    public final /* synthetic */ ActiveMTicketScreen h;

    public ac0(ActiveMTicketScreen activeMTicketScreen, ImageView imageView) {
        this.h = activeMTicketScreen;
        this.g = imageView;
        this.f = imageView;
    }

    public void onClick(View view) {
        ActiveMTicketScreen activeMTicketScreen = this.h;
        activeMTicketScreen.setContentView(activeMTicketScreen.F);
        ImageView imageView = (ImageView) this.h.F.findViewById(R.id.mticket_qr_code_zoomed);
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView.setImageDrawable(imageView2.getDrawable());
        } else {
            imageView.setImageDrawable(((ImageView) view).getDrawable());
        }
        imageView.startAnimation(this.h.w);
        this.h.h0(imageView, true);
        this.h.j0();
        this.h.l0(1.0f);
        ActiveMTicketScreen activeMTicketScreen2 = this.h;
        activeMTicketScreen2.y = true;
        ed1 ed1 = new ed1("mticket qr code zoomed", Long.MIN_VALUE);
        ed1.a("date", jh1.c(System.currentTimeMillis()));
        ed1.a("time", jh1.g(System.currentTimeMillis()));
        ed1.a("bookingId", activeMTicketScreen2.k.getMTicketId());
        jz5.b().g(ed1);
    }
}
