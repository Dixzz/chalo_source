package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.BookingItemType;

public class PassStatusActivity extends wt {

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(PassStatusActivity.this, HomeActivity.class);
            intent.setFlags(268468224);
            PassStatusActivity.this.startActivity(intent);
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.pass_submit_status);
        String stringExtra = getIntent().getStringExtra("src");
        Button button = (Button) findViewById(R.id.validation_success_ok_button);
        TextView textView = (TextView) findViewById(R.id.remind_later);
        TextView textView2 = (TextView) findViewById(R.id.status_detail);
        TextView textView3 = (TextView) findViewById(R.id.status_copy);
        Button button2 = (Button) findViewById(R.id.validation_success_ok_button);
        String D = xt.f3961a.c().D(BookingItemType.MAGIC_PASS);
        if (D == null) {
            D = getResources().getString(R.string.pass_verification_success);
        }
        textView2.setText(Html.fromHtml(D));
        textView.setVisibility(8);
        if (stringExtra != null && stringExtra.equals("referralActivity")) {
            button.setVisibility(8);
            textView2.setVisibility(8);
            button2.setVisibility(0);
            textView3.setText(R.string.referral_success_copy);
        }
        button.setOnClickListener(new a());
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        return true;
    }
}
