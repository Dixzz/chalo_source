package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.pubsub.eventbus.events.FavoriteAddedEvent;

public class FavoriteListActivity extends wt {
    public bj0 l;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.favourite_list_activity);
        bj0 bj0 = new bj0(this, null, new ae0(this), new be0(this), null, null, RouteStoreType.FAVORITE, "favorite screen");
        this.l = bj0;
        ((ListView) findViewById(R.id.fav_list)).setAdapter((ListAdapter) bj0);
        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));
        getSupportActionBar().z(getString(R.string.home_screen_fav));
        getSupportActionBar().o(true);
        jz5.b().g(new ed1("favorite screen displayed", Long.MAX_VALUE));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        if (i2 == -1) {
            super.onActivityResult(i, i2, intent);
            if (intent != null && (stringExtra = intent.getStringExtra("result:picked_location")) != null) {
                mf1 a2 = mf1.a(stringExtra);
                if (i == 0) {
                    if (xt.f3961a.Y().m(a2, "Home", "home")) {
                        bj0 bj0 = this.l;
                        bj0.l();
                        bj0.notifyDataSetChanged();
                    }
                } else if (i == 1 && xt.f3961a.Y().m(a2, "Work", "work")) {
                    bj0 bj02 = this.l;
                    bj02.l();
                    bj02.notifyDataSetChanged();
                }
            }
        }
    }

    public void onEvent(nd1 nd1) {
        if (nd1.f2540a.equals(ad1.SUCCESS)) {
            Toast.makeText(this, getString(R.string.favorite_updated_toast), 1).show();
        } else {
            Toast.makeText(this, getString(R.string.favorite_network_error_toast), 1).show();
        }
        bj0 bj0 = this.l;
        bj0.l();
        bj0.notifyDataSetChanged();
        jz5.b().m(nd1);
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        bj0 bj0 = this.l;
        bj0.l();
        bj0.notifyDataSetChanged();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public void onEvent(FavoriteAddedEvent favoriteAddedEvent) {
        if (favoriteAddedEvent.getIsFavoriteAdded()) {
            Toast.makeText(this, getString(R.string.favorite_added_toast), 0).show();
        } else {
            Toast.makeText(this, getString(R.string.favorite_not_added_toast), 0).show();
        }
        bj0 bj0 = this.l;
        bj0.l();
        bj0.notifyDataSetChanged();
        jz5.b().m(favoriteAddedEvent);
    }
}
