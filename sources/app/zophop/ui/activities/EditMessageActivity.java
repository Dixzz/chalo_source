package app.zophop.ui.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;

public class EditMessageActivity extends au {
    public Toolbar k;
    public EditText l;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.edit_message_activity);
        this.k = (Toolbar) findViewById(R.id.toolbar);
        this.l = (EditText) findViewById(R.id.edit_sos_message);
        String g = xt.f3961a.a0().g();
        this.l.setText(g);
        this.l.setSelection(g.length());
        setSupportActionBar(this.k);
        getSupportActionBar().o(true);
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_message_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String obj;
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            super.onBackPressed();
            return false;
        }
        if (itemId == R.id.save_message && (obj = this.l.getText().toString()) != null) {
            if (obj.length() < 5) {
                Toast.makeText(this, "Emergency message cannot be too short", 0).show();
            } else {
                xt.f3961a.a0().a(obj);
                super.onBackPressed();
                return false;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
