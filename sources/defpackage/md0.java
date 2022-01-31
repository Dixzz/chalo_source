package defpackage;

import app.zophop.R;
import app.zophop.ui.activities.CardActivity;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: md0  reason: default package */
/* compiled from: CardActivity */
public class md0 implements ZophopFormInput.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ZophopFormInput f2355a;
    public final /* synthetic */ CardActivity b;

    public md0(CardActivity cardActivity, ZophopFormInput zophopFormInput) {
        this.b = cardActivity;
        this.f2355a = zophopFormInput;
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void a() {
        if (this.f2355a.getText().length() == 1) {
            this.b.findViewById(R.id.card_name_error).setVisibility(8);
        }
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void b() {
    }

    @Override // app.zophop.ui.views.ZophopFormInput.b
    public void c() {
    }
}
