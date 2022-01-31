package app.zophop.ui.activities;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.SosContact;
import butterknife.ButterKnife;
import butterknife.InjectView;
import java.util.Objects;

public class ZophopSosActivity extends au {
    public static final /* synthetic */ int l = 0;
    @InjectView(R.id.add_contacts)
    public View _addContactButton;
    @InjectView(R.id.contacts_list)
    public LinearLayout _contactsLayout;
    @InjectView(R.id.edit_message)
    public TextView _editMessageButton;
    @InjectView(R.id.send_alerts)
    public TextView _sendAlertsView;
    @InjectView(R.id.sos_message)
    public TextView _sosMessageView;
    @InjectView(R.id.toolbar)
    public Toolbar _toolbar;
    public a30 k;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            ZophopSosActivity zophopSosActivity = ZophopSosActivity.this;
            int i = ZophopSosActivity.l;
            Objects.requireNonNull(zophopSosActivity);
            Intent intent = new Intent("android.intent.action.PICK", Uri.parse("content://contacts"));
            intent.setType("vnd.android.cursor.dir/phone_v2");
            zophopSosActivity.startActivityForResult(intent, 102);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            ZophopSosActivity.this.startActivity(new Intent(view.getContext(), EditMessageActivity.class));
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            ZophopSosActivity zophopSosActivity = ZophopSosActivity.this;
            int i = ZophopSosActivity.l;
            FragmentManager fragmentManager = zophopSosActivity.getFragmentManager();
            String name = ZophopSosActivity.class.getName();
            xn0 xn0 = new xn0();
            Bundle bundle = new Bundle();
            bundle.putString("source", name);
            xn0.setArguments(bundle);
            xn0.show(fragmentManager, "zophop_sos");
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ ImageView f;
        public final /* synthetic */ SosContact g;

        public d(ImageView imageView, SosContact sosContact) {
            this.f = imageView;
            this.g = sosContact;
        }

        public void onClick(View view) {
            ZophopSosActivity zophopSosActivity = ZophopSosActivity.this;
            Context context = view.getContext();
            ImageView imageView = this.f;
            SosContact sosContact = this.g;
            int i = ZophopSosActivity.l;
            int dimensionPixelSize = zophopSosActivity.getResources().getDimensionPixelSize(R.dimen.favorite_edit_pop_up_width);
            View inflate = LayoutInflater.from(context).inflate(R.layout.fav_pop_up, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(context);
            popupWindow.setContentView(inflate);
            popupWindow.setWidth(dimensionPixelSize);
            popupWindow.setHeight(-2);
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.showAsDropDown(imageView, 0, 0);
            inflate.setOnClickListener(new th0(zophopSosActivity, sosContact, popupWindow));
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.sos_activity);
        ButterKnife.inject(this);
        this._addContactButton.setOnClickListener(new a());
        this._editMessageButton.setOnClickListener(new b());
        this.k = xt.f3961a.a0();
        i0();
        j0();
        setSupportActionBar(this._toolbar);
        getSupportActionBar().z(getString(R.string.add_contact));
        getSupportActionBar().o(true);
    }

    public final void h0(SosContact sosContact) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.sos_contact_layout, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.phoneNumber)).setText(sosContact.getPhoneNumber());
        ((TextView) inflate.findViewById(R.id.contactName)).setText(sosContact.getContactName());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.remove_menu);
        imageView.setOnClickListener(new d(imageView, sosContact));
        this._contactsLayout.addView(inflate);
    }

    public final void i0() {
        this._contactsLayout.removeAllViews();
        for (SosContact sosContact : this.k.e()) {
            h0(sosContact);
        }
    }

    public final void j0() {
        this._sendAlertsView.setOnClickListener(new c());
        if (this.k.d()) {
            this._sendAlertsView.setAlpha(0.6f);
            this._sendAlertsView.setClickable(false);
            return;
        }
        this._sendAlertsView.setAlpha(1.0f);
        this._sendAlertsView.setClickable(true);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 102 && i2 == -1) {
            Cursor query = getContentResolver().query(intent.getData(), null, null, null, null);
            if (query != null) {
                query.moveToFirst();
                SosContact sosContact = new SosContact(query.getString(query.getColumnIndex("_id")), query.getString(query.getColumnIndex("display_name")), query.getString(query.getColumnIndex("data1")));
                this.k.f(sosContact);
                h0(sosContact);
                j0();
                return;
            }
            b00 b00 = b00.f358a;
            b00.a().a("SOS ERROR", "contact not found");
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        this._sosMessageView.setText(xt.f3961a.a0().g());
    }
}
