package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.lifecycle.runtime.R;
import defpackage.b1;
import defpackage.km;
import defpackage.p5;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* renamed from: f0  reason: default package */
/* compiled from: AppCompatActivity */
public class f0 extends ve implements g0, p5.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private h0 mDelegate;
    private Resources mResources;

    /* renamed from: f0$a */
    /* compiled from: AppCompatActivity */
    public class a implements km.b {
        public a() {
        }

        @Override // defpackage.km.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            f0.this.getDelegate().o(bundle);
            return bundle;
        }
    }

    /* renamed from: f0$b */
    /* compiled from: AppCompatActivity */
    public class b implements p {
        public b() {
        }

        @Override // defpackage.p
        public void a(Context context) {
            h0 delegate = f0.this.getDelegate();
            delegate.h();
            delegate.k(f0.this.getSavedStateRegistry().a(f0.DELEGATE_TAG));
        }
    }

    public f0() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().b(DELEGATE_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private void initViewTreeOwners() {
        getWindow().getDecorView().setTag(R.id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R.id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R.id.view_tree_saved_state_registry_owner, this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // androidx.activity.ComponentActivity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().a(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().b(context));
    }

    public void closeOptionsMenu() {
        x supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.a()) {
            super.closeOptionsMenu();
        }
    }

    @Override // defpackage.y4
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        x supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.k(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) getDelegate().c(i);
    }

    public h0 getDelegate() {
        if (this.mDelegate == null) {
            p2<WeakReference<h0>> p2Var = h0.f;
            this.mDelegate = new i0(this, null, this, this);
        }
        return this.mDelegate;
    }

    public y getDrawerToggleDelegate() {
        return getDelegate().d();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().f();
    }

    public Resources getResources() {
        if (this.mResources == null && VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public x getSupportActionBar() {
        return getDelegate().g();
    }

    @Override // defpackage.p5.a
    public Intent getSupportParentActivityIntent() {
        return h.R(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().i();
    }

    @Override // defpackage.ve
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().j(configuration);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(p5 p5Var) {
        Objects.requireNonNull(p5Var);
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = h.R(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(p5Var.g.getPackageManager());
            }
            p5Var.d(component);
            p5Var.f.add(supportParentActivityIntent);
        }
    }

    @Override // defpackage.ve
    public void onDestroy() {
        super.onDestroy();
        getDelegate().l();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // defpackage.ve
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        x supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.d() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // defpackage.ve
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().m(bundle);
    }

    @Override // defpackage.ve
    public void onPostResume() {
        super.onPostResume();
        getDelegate().n();
    }

    public void onPrepareSupportNavigateUpTaskStack(p5 p5Var) {
    }

    @Override // defpackage.ve
    public void onStart() {
        super.onStart();
        getDelegate().p();
    }

    @Override // defpackage.ve
    public void onStop() {
        super.onStop();
        getDelegate().q();
    }

    @Override // defpackage.g0
    public void onSupportActionModeFinished(b1 b1Var) {
    }

    @Override // defpackage.g0
    public void onSupportActionModeStarted(b1 b1Var) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            p5 p5Var = new p5(this);
            onCreateSupportNavigateUpTaskStack(p5Var);
            onPrepareSupportNavigateUpTaskStack(p5Var);
            p5Var.e();
            try {
                int i = t4.c;
                finishAffinity();
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().y(charSequence);
    }

    @Override // defpackage.g0
    public b1 onWindowStartingSupportActionMode(b1.a aVar) {
        return null;
    }

    public void openOptionsMenu() {
        x supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.l()) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        getDelegate().t(i);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().w(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i) {
        super.setTheme(i);
        getDelegate().x(i);
    }

    public b1 startSupportActionMode(b1.a aVar) {
        return getDelegate().z(aVar);
    }

    @Override // defpackage.ve
    public void supportInvalidateOptionsMenu() {
        getDelegate().i();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().s(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    public f0(int i) {
        super(i);
        initDelegate();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().u(view);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().v(view, layoutParams);
    }
}
