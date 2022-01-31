package defpackage;

import app.zophop.R;
import app.zophop.ui.activities.CardActivity;
import app.zophop.ui.views.ZophopFormInput;
import com.rabbitmq.client.ConnectionFactory;

/* renamed from: od0  reason: default package */
/* compiled from: CardActivity */
public class od0 implements ZophopFormInput.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ZophopFormInput f2677a;
    public final /* synthetic */ boolean[] b;
    public final /* synthetic */ CardActivity c;

    public od0(CardActivity cardActivity, ZophopFormInput zophopFormInput, boolean[] zArr) {
        this.c = cardActivity;
        this.f2677a = zophopFormInput;
        this.b = zArr;
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void a() {
        if (this.f2677a.getText().length() == 1) {
            this.c.findViewById(R.id.expiry_error).setVisibility(8);
        }
        int length = this.f2677a.getText().length();
        if (this.f2677a.getText().length() == 1 && Integer.parseInt(this.f2677a.getText()) > 1) {
            ZophopFormInput zophopFormInput = this.f2677a;
            StringBuilder i0 = hj1.i0("0");
            i0.append(this.f2677a.getText());
            zophopFormInput.setText(i0.toString());
        }
        if (length == 2 && !this.b[0]) {
            ZophopFormInput zophopFormInput2 = this.f2677a;
            zophopFormInput2.setText(this.f2677a.getText() + ConnectionFactory.DEFAULT_VHOST);
            this.b[0] = false;
        } else if (length == 2 && this.b[0]) {
            ZophopFormInput zophopFormInput3 = this.f2677a;
            zophopFormInput3.setText(zophopFormInput3.getText().substring(0, 1));
            this.b[0] = false;
        }
        if (this.f2677a.getText().length() > 5) {
            ZophopFormInput zophopFormInput4 = this.f2677a;
            zophopFormInput4.setText(zophopFormInput4.getText().substring(0, 5));
        }
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void b() {
        if (this.f2677a.getText() != null && this.f2677a.getText().length() == 3) {
            this.b[0] = true;
        }
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void c() {
    }
}
