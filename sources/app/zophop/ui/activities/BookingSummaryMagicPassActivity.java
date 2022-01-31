package app.zophop.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.fragments.ProductHistoryFragment;
import butterknife.InjectView;
import defpackage.xm0;
import java.util.HashMap;
import java.util.Map;

public class BookingSummaryMagicPassActivity extends wt {
    public static MPass o;
    public static String p;
    @InjectView(R.id.passBookingId)
    public TextView _bookingIdView;
    @InjectView(R.id.dob)
    public TextView _dobView;
    @InjectView(R.id.durationDetails)
    public TextView _durationDetails;
    @InjectView(R.id.max_ride_price)
    public TextView _maxRidePrice;
    @InjectView(R.id.passBookingDate)
    public TextView _passBookingDate;
    @InjectView(R.id.passBookingDetails)
    public TextView _passBookingDetails;
    @InjectView(R.id.passExpiryDetails)
    public TextView _passExpiryDetails;
    @InjectView(R.id.passFare)
    public TextView _passFare;
    @InjectView(R.id.pass_type)
    public TextView _passTypeView;
    @InjectView(R.id.user_name)
    public TextView _passUserName;
    @InjectView(R.id.userProfilePic)
    public ImageView _profilePicView;
    @InjectView(R.id.profile_pic_progressbar)
    public ProgressBar _progressBar;
    @InjectView(R.id.route_card_view)
    public CardView _routeCardView;
    @InjectView(R.id.route_container)
    public LinearLayout _routeContainer;
    @InjectView(R.id.user_details)
    public TextView _userDetails;
    public rf1 l;
    public int m = 0;
    public boolean n = false;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), RenewMagicPassActivity.class);
            intent.putExtra("magic_pass_info", BookingSummaryMagicPassActivity.o);
            intent.putExtra("src", "booking details");
            BookingSummaryMagicPassActivity.this.startActivity(intent);
        }
    }

    public class b implements qs1<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f291a;
        public final /* synthetic */ ProgressBar b;

        public b(BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity, ImageView imageView, ProgressBar progressBar) {
            this.f291a = imageView;
            this.b = progressBar;
        }

        @Override // defpackage.qs1
        public boolean a(nn1 nn1, Object obj, ct1<Bitmap> ct1, boolean z) {
            return false;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, ct1, xl1, boolean] */
        @Override // defpackage.qs1
        public boolean b(Bitmap bitmap, Object obj, ct1<Bitmap> ct1, xl1 xl1, boolean z) {
            this.f291a.setImageBitmap(bitmap);
            this.b.setVisibility(8);
            return true;
        }
    }

    public class c implements xm0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f292a;

        public c(String str) {
            this.f292a = str;
        }

        @Override // defpackage.xm0.a
        public void a() {
            HashMap hashMap = new HashMap();
            hashMap.put("reason for disabled product dialog popup", this.f292a);
            hashMap.put("renew disabled product source", ProductHistoryFragment.class.getSimpleName());
            MPass mPass = BookingSummaryMagicPassActivity.o;
            ed1 ed1 = new ed1("renew disabled product error dialog rendered", Long.MIN_VALUE);
            for (Map.Entry entry : hashMap.entrySet()) {
                ed1.a((String) entry.getKey(), entry.getValue());
            }
            jz5.b().g(ed1);
        }

        @Override // defpackage.xm0.a
        public void b() {
            if (this.f292a.equals(BookingSummaryMagicPassActivity.this.getString(R.string.recent_products_fare_changed_dialog_copy))) {
                Intent intent = new Intent(BookingSummaryMagicPassActivity.this.getApplicationContext(), ProductSelectionActivity.class);
                intent.putExtra("magic_pass_info", BookingSummaryMagicPassActivity.o);
                intent.putExtra("src", BookingSummaryMagicPassActivity.p);
                BookingSummaryMagicPassActivity.this.startActivity(intent);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean h0(app.zophop.ui.activities.BookingSummaryMagicPassActivity r7) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.BookingSummaryMagicPassActivity.h0(app.zophop.ui.activities.BookingSummaryMagicPassActivity):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x04c9  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0624  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x08fd  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0910  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0973  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0ae8  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0b00  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0b02  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x042a  */
    @Override // defpackage.tf1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.os.Bundle r25) {
        /*
        // Method dump skipped, instructions count: 2836
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.BookingSummaryMagicPassActivity.e(android.os.Bundle):void");
    }

    public final void i0(String str, String str2) {
        StringBuilder k0 = hj1.k0("invalid notification ", str2);
        k0.append(xt.f3961a.L().getUserId());
        String sb = k0.toString();
        if (str != null) {
            sb = hj1.S(sb, str);
        }
        b00 b00 = b00.f358a;
        b00.a().b(new Throwable(sb));
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    public final void j0(String str, ImageView imageView, ProgressBar progressBar) {
        if (str.startsWith("/9j/")) {
            byte[] decode = Base64.decode(str, 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            progressBar.setVisibility(8);
            return;
        }
        ml1<Bitmap> j = gl1.g(this).j();
        j.m = str;
        j.p = true;
        j.n = new b(this, imageView, progressBar);
        j.j(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
    }

    public final void k0(String str, String str2) {
        xm0.a(getFragmentManager(), this, new c(str2), BookingSummaryMagicPassActivity.class.getSimpleName(), str2, str, false);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        if (isTaskRoot()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
            return;
        }
        super.onBackPressed();
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.report_problem_menu) {
            return false;
        } else {
            y20 R = xt.f3961a.R();
            HashMap hashMap = new HashMap();
            MPass mPass = o;
            if (mPass != null) {
                if (mPass.get_cityName() != null) {
                    hashMap.put("userPropertyCity", o.get_cityName());
                }
                if (o.getUserProfile() != null) {
                    UserProfile userProfile = o.getUserProfile();
                    String firstName = userProfile.getFirstName();
                    String lastName = userProfile.getLastName();
                    if (firstName != null) {
                        if (lastName != null) {
                            firstName = hj1.T(firstName, " ", lastName);
                        }
                        hashMap.put("userPropertyUserName", firstName);
                    } else if (lastName != null) {
                        hashMap.put("userPropertyUserName", lastName);
                    }
                    if (userProfile.getPhone() != null) {
                        hashMap.put("userPropertyPhoneNo", userProfile.getPhone());
                    }
                    if (userProfile.getUserId() != null) {
                        hashMap.put("userPropertyUserID", userProfile.getUserId());
                    }
                }
                if (o.getAgency() != null) {
                    hashMap.put("userPropertyAgencyName", o.getAgency());
                }
                if (o.getRouteStopsInfo() != null) {
                    if (o.getRouteStopsInfo().getRouteId() != null) {
                        hashMap.put("userPropertyRouteId", o.getRouteStopsInfo().getRouteId());
                    }
                    if (o.getRouteStopsInfo().getRouteName() != null) {
                        hashMap.put("userPropertyRouteName", o.getRouteStopsInfo().getRouteName());
                    }
                }
                if (o.getBookingPassId() != null) {
                    hashMap.put("userPropertyMPassId", o.getBookingPassId());
                }
                if (o.getOrderId() != null) {
                    hashMap.put("userPropertyOrderId", o.getOrderId());
                }
            }
            R.b(this, "historyScreen", "mpassBookingSummaryScreen", hashMap, false);
            ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "otherTicketingProblemsV2");
            hj1.K0(l2, "problemSource", "mpassBookingSummaryScreen", l2);
            return true;
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            o = (MPass) bundle.getParcelable("magic_pass_info");
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        MPass mPass = o;
        if (mPass != null) {
            bundle.putParcelable("magic_pass_info", mPass);
        }
        super.onSaveInstanceState(bundle);
    }
}
