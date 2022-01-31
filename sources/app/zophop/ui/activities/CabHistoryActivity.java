package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.autoCabBooking.BookingDetails;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CabHistoryActivity extends wt {
    public static final /* synthetic */ int m = 0;
    public ui0 l;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (t00.d(CabHistoryActivity.this.l.g.get(i).getCode())) {
                CabHistoryActivity cabHistoryActivity = CabHistoryActivity.this;
                Objects.requireNonNull(cabHistoryActivity);
                Intent intent = new Intent(cabHistoryActivity, CabBookingActivity.class);
                intent.putExtra("extra:aggregatorName", "UBER");
                cabHistoryActivity.startActivity(intent);
                return;
            }
            CabHistoryActivity cabHistoryActivity2 = CabHistoryActivity.this;
            Toast.makeText(cabHistoryActivity2, cabHistoryActivity2.getString(R.string.ride_details_not_available_toast), 1).show();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            CabHistoryActivity cabHistoryActivity = CabHistoryActivity.this;
            int i = CabHistoryActivity.m;
            Objects.requireNonNull(cabHistoryActivity);
            Intent intent = new Intent(cabHistoryActivity, CabBookingActivity.class);
            intent.putExtra("extra:aggregatorName", "UBER");
            cabHistoryActivity.startActivity(intent);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public c(CabHistoryActivity cabHistoryActivity, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public d(lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            xt.t1 t1Var = xt.f3961a;
            t00 f2 = t1Var.f();
            String string = f2.f3289a.b.getString("live_booking", null);
            f2.f3289a.l();
            rf1 rf1 = f2.f3289a;
            rf1.f3075a.putString("live_booking", string);
            rf1.f3075a.commit();
            this.f.dismiss();
            List<BookingDetails> a2 = t1Var.f().a();
            ui0 ui0 = CabHistoryActivity.this.l;
            ui0.g = a2;
            ui0.notifyDataSetChanged();
            CabHistoryActivity.this.invalidateOptionsMenu();
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.cab_history_screen);
        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));
        getSupportActionBar().z(getString(R.string.cab_ride_history));
        getSupportActionBar().o(true);
        this.l = new ui0(this, xt.f3961a.f().a());
        ListView listView = (ListView) findViewById(R.id.cab_history_list);
        listView.setAdapter((ListAdapter) this.l);
        listView.setEmptyView(findViewById(R.id.cab_history_empty));
        listView.setOnItemClickListener(new a());
        findViewById(R.id.cab_book_button).setOnClickListener(new b());
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cab_history_menu, menu);
        return true;
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_settings) {
            return super.onOptionsItemSelected(menuItem);
        }
        lm0 a2 = lm0.a(getFragmentManager(), null, getString(R.string.delete_history_title), getString(R.string.delete), getString(R.string.cancel).toUpperCase());
        c cVar = new c(this, a2);
        TextView textView = a2.j;
        if (textView != null) {
            textView.setOnClickListener(cVar);
        } else {
            a2.r = cVar;
        }
        d dVar = new d(a2);
        TextView textView2 = a2.i;
        if (textView2 != null) {
            textView2.setOnClickListener(dVar);
            return true;
        }
        a2.q = dVar;
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (((ArrayList) xt.f3961a.f().a()).size() == 0) {
            menu.findItem(R.id.action_settings).setVisible(false);
        } else {
            menu.findItem(R.id.action_settings).setVisible(true);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
