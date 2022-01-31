package defpackage;

import app.zophop.R;
import app.zophop.ui.activities.CardActivity;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: nd0  reason: default package */
/* compiled from: CardActivity */
public class nd0 implements ZophopFormInput.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ZophopFormInput f2539a;
    public final /* synthetic */ CardActivity b;

    public nd0(CardActivity cardActivity, ZophopFormInput zophopFormInput) {
        this.b = cardActivity;
        this.f2539a = zophopFormInput;
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void a() {
        if (this.f2539a.getText().length() == 1) {
            this.b.findViewById(R.id.cvv_error).setVisibility(8);
        }
        if (this.f2539a.getText().length() > 4) {
            ZophopFormInput zophopFormInput = this.f2539a;
            zophopFormInput.setText(zophopFormInput.getText().substring(0, 4));
        }
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void b() {
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void c() {
    }
}
