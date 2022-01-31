package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class OfflinePaymentActivity extends wt {
    @InjectView(R.id.change_payment_mode)
    public TextView _changePaymentMode;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.offline_payment_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().y(R.string.offline_payment_instructions);
        ButterKnife.inject(this);
        this._changePaymentMode.setOnClickListener(new af0(this));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        startActivity(new Intent(this, HomeActivity.class));
        finish();
        return true;
    }
}
