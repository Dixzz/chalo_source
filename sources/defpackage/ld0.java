package defpackage;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import app.zophop.R;
import app.zophop.models.CardDetails;
import app.zophop.ui.activities.CardActivity;
import app.zophop.ui.views.ZophopFormInput;
import com.razorpay.AnalyticsConstants;
import java.util.Objects;

/* renamed from: ld0  reason: default package */
/* compiled from: CardActivity */
public class ld0 implements View.OnClickListener {
    public final /* synthetic */ LinearLayout f;
    public final /* synthetic */ EditText g;
    public final /* synthetic */ LinearLayout h;
    public final /* synthetic */ ZophopFormInput i;
    public final /* synthetic */ ZophopFormInput j;
    public final /* synthetic */ ZophopFormInput k;
    public final /* synthetic */ ZophopFormInput l;
    public final /* synthetic */ CheckBox m;
    public final /* synthetic */ CardActivity n;

    public ld0(CardActivity cardActivity, LinearLayout linearLayout, EditText editText, LinearLayout linearLayout2, ZophopFormInput zophopFormInput, ZophopFormInput zophopFormInput2, ZophopFormInput zophopFormInput3, ZophopFormInput zophopFormInput4, CheckBox checkBox) {
        this.n = cardActivity;
        this.f = linearLayout;
        this.g = editText;
        this.h = linearLayout2;
        this.i = zophopFormInput;
        this.j = zophopFormInput2;
        this.k = zophopFormInput3;
        this.l = zophopFormInput4;
        this.m = checkBox;
    }

    public void onClick(View view) {
        int parseInt;
        if (this.f.getVisibility() != 0 || !TextUtils.isEmpty(this.g.getText())) {
            if (this.h.getVisibility() == 0) {
                if (TextUtils.isEmpty(this.i.getText()) || this.i.getText().length() < 16 || CardActivity.h0(this.n, this.i.getText())) {
                    this.n.findViewById(R.id.card_number_error).setVisibility(0);
                    return;
                }
                if (!TextUtils.isEmpty(this.j.getText()) && this.j.getText().length() >= 5) {
                    CardActivity cardActivity = this.n;
                    String text = this.j.getText();
                    Objects.requireNonNull(cardActivity);
                    if (!(text.length() <= 2 || (parseInt = Integer.parseInt(text.substring(0, 2))) < 1 || parseInt > 12)) {
                        if (TextUtils.isEmpty(this.k.getText()) || this.k.getText().length() < 3 || CardActivity.h0(this.n, this.k.getText())) {
                            this.n.findViewById(R.id.cvv_error).setVisibility(0);
                            return;
                        } else if (TextUtils.isEmpty(this.l.getText())) {
                            this.n.findViewById(R.id.card_name_error).setVisibility(0);
                            return;
                        }
                    }
                }
                this.n.findViewById(R.id.expiry_error).setVisibility(0);
                return;
            }
            String text2 = this.j.getText();
            Intent intent = new Intent();
            if (this.n.getIntent() == null || this.n.getIntent().getParcelableExtra("cardDetails") == null) {
                CardActivity cardActivity2 = this.n;
                String text3 = this.i.getText();
                int i2 = CardActivity.l;
                Objects.requireNonNull(cardActivity2);
                intent.putExtra("card[number]", text3.trim().replace(" ", ""));
                intent.putExtra("card[name]", this.l.getText());
                intent.putExtra("card[cvv]", this.k.getText());
                intent.putExtra("card[expiry_month]", text2.substring(0, 2));
                intent.putExtra("card[expiry_year]", text2.substring(3));
                intent.putExtra("method", AnalyticsConstants.CARD);
                if (this.m.isChecked()) {
                    intent.putExtra("save", 1);
                }
            } else {
                intent.putExtra("method", AnalyticsConstants.CARD);
                intent.putExtra(AnalyticsConstants.TOKEN, ((CardDetails) this.n.getIntent().getParcelableExtra("cardDetails")).getTokenId());
                intent.putExtra("card[cvv]", this.g.getText().toString());
            }
            ed1 ed1 = new ed1("card details submitted", Long.MIN_VALUE);
            ed1.a("save card details", String.valueOf(this.m.isChecked()));
            jz5.b().g(ed1);
            this.n.setResult(-1, intent);
            this.n.finish();
            return;
        }
        this.n.findViewById(R.id.saved_cvv_error).setVisibility(0);
    }
}
