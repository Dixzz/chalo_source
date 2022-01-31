package app.zophop.ui.activities;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;

public class MTicketingInfoActivity extends wt {

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MTicketingInfoActivity.this.finish();
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.activity_mticketing_info);
        setSupportActionBar((Toolbar) findViewById(R.id.mticketing_info_action_tool_bar));
        getSupportActionBar().o(true);
        getSupportActionBar().t(R.drawable.close_nearby);
        getSupportActionBar().z(getString(R.string.mticketing_info_title));
        findViewById(R.id.mticket_info_got_it).setOnClickListener(new a());
        ((TextView) findViewById(R.id.order_text_last)).setMovementMethod(LinkMovementMethod.getInstance());
        xt.f3961a.l().put("mticket_info_shown", String.valueOf(true));
    }
}
