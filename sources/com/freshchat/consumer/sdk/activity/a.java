package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatActionListener;
import com.freshchat.consumer.sdk.FreshchatUserInteractionListener;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.f;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.ao;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.j.q;

public class a extends f0 {
    private long ly;

    private String a(View view) {
        if (view == null || view.getId() == -1) {
            return "";
        }
        return view.getClass() + " with id '" + view.getContext().getResources().getResourceEntryName(view.getId()) + "'";
    }

    private static boolean a(Context context) {
        try {
            String b = b(context);
            int identifier = context.getResources().getIdentifier("freshchatDisableFrame", "string", context.getPackageName());
            return identifier == 0 || !b.equalsIgnoreCase(context.getResources().getString(identifier));
        } catch (Exception unused) {
            return true;
        }
    }

    private static String b(Context context) {
        e i = e.i(context);
        StringBuilder sb = new StringBuilder();
        sb.append(i.getAppId() + "73463f9d-70de-41f8-857a-58590bdd5903" + i.getAppKey());
        sb.reverse();
        return aa.aA(sb.toString());
    }

    private boolean f(long j, long j2) {
        return j2 > 0 && j > 0 && j < j2;
    }

    private FreshchatUserInteractionListener getFreshchatUserInteractionListener() {
        return Freshchat.getInstance(getContext()).getFreshchatUserInteractionListener();
    }

    public void C() {
        if (a(getContext())) {
            TextView textView = new TextView(this);
            textView.setBackgroundColor(-16777216);
            textView.setTextColor(-1);
            textView.setTextSize(10.0f);
            textView.setText("Powered by Freshchat");
            textView.setGravity(17);
            int h = af.h(this, 2);
            textView.setPadding(0, h, 0, h);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 81);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            View findViewById = findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) findViewById;
                frameLayout.addView(textView);
                int h2 = af.h(this, 16);
                View childAt = frameLayout.getChildAt(0);
                if (childAt != null) {
                    int paddingLeft = childAt.getPaddingLeft();
                    int paddingRight = childAt.getPaddingRight();
                    i.a(getContext(), childAt, paddingLeft, childAt.getPaddingTop(), paddingRight, childAt.getPaddingBottom() + h2);
                }
            }
        }
    }

    public void al() {
        i.a(getContext(), R.string.freshchat_error_message_token_failed);
        gs();
    }

    public boolean bM() {
        return (this instanceof CategoryListActivity) || (this instanceof ArticleListActivity) || (this instanceof ArticleDetailActivity) || (this instanceof ah);
    }

    public boolean dH() {
        return getFreshchatUserInteractionListener() != null;
    }

    public void e(String str) {
        x supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            supportActionBar = f.j(this);
        }
        if (supportActionBar != null) {
            supportActionBar.o(true);
            if (!TextUtils.isEmpty(str)) {
                supportActionBar.z(str);
                return;
            }
            return;
        }
        StringBuilder i0 = hj1.i0("Failed to set ActionBar for ");
        i0.append(getClass().getSimpleName());
        ai.e("FRESHCHAT_WARNING", i0.toString());
    }

    public void freshchatOnClickProxy(View view) {
        String str = view.getTag() != null ? (String) view.getTag() : null;
        try {
            Class u = ao.u(view.getContext(), str);
            if (u == null) {
                if (!as.isEmpty(str)) {
                    str.startsWith(getPackageName());
                }
                a(view);
            }
            Object newInstance = u.newInstance();
            if (newInstance instanceof FreshchatActionListener) {
                ((FreshchatActionListener) newInstance).onClick(view);
            } else {
                a(view);
            }
        } catch (Exception unused) {
        }
    }

    public Context getContext() {
        return this;
    }

    public void gs() {
        e.i(this).gu();
        finish();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            q.a(e);
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    public void onCreate(Bundle bundle) {
        long j;
        super.onCreate(bundle);
        if (bundle == null) {
            j = n.fP();
        } else if (bundle.containsKey("EXTRA_CREATED_AT")) {
            j = bundle.getLong("EXTRA_CREATED_AT");
        } else {
            return;
        }
        this.ly = j;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (h.T(this) == null) {
            onBackPressed();
            return true;
        }
        Intent R = h.R(this);
        if (R != null) {
            navigateUpTo(R);
            return true;
        }
        StringBuilder i0 = hj1.i0("Activity ");
        i0.append(getClass().getSimpleName());
        i0.append(" does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
        throw new IllegalArgumentException(i0.toString());
    }

    @Override // defpackage.ve
    public void onResume() {
        super.onResume();
        if (f(this.ly, e.i(this).gt())) {
            finish();
            return;
        }
        long iN = e.i(this).iN();
        if (!bM() || !f(this.ly, iN)) {
            e i = e.i(getApplicationContext());
            if (i != null && !i.isAccountActive()) {
                finish();
                return;
            }
            return;
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putLong("EXTRA_CREATED_AT", this.ly);
        super.onSaveInstanceState(bundle);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        try {
            if (dH() && getFreshchatUserInteractionListener() != null) {
                getFreshchatUserInteractionListener().onUserInteraction();
            }
        } catch (Exception unused) {
        }
    }

    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            if (dH() && getFreshchatUserInteractionListener() != null) {
                getFreshchatUserInteractionListener().onUserLeaveHint();
            }
        } catch (Exception unused) {
        }
    }
}
