package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.runtime.R;
import defpackage.km;
import defpackage.t;
import defpackage.zg;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends y4 implements fh, hi, mm, n, s {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    public final o mContextAwareHelper;
    private ci mDefaultFactory;
    private final gh mLifecycleRegistry;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    public final lm mSavedStateRegistryController;
    private gi mViewModelStore;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            }
        }
    }

    public class b extends ActivityResultRegistry {

        public class a implements Runnable {
            public final /* synthetic */ int f;
            public final /* synthetic */ t.a g;

            public a(int i, t.a aVar) {
                this.f = i;
                this.g = aVar;
            }

            public void run() {
                q<O> qVar;
                b bVar = b.this;
                int i = this.f;
                T t = this.g.f3284a;
                String str = bVar.b.get(Integer.valueOf(i));
                if (str != null) {
                    bVar.e.remove(str);
                    ActivityResultRegistry.c<?> cVar = bVar.f.get(str);
                    if (cVar == null || (qVar = cVar.f191a) == null) {
                        bVar.h.remove(str);
                        bVar.g.put(str, t);
                        return;
                    }
                    qVar.a(t);
                }
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b  reason: collision with other inner class name */
        public class RunnableC0000b implements Runnable {
            public final /* synthetic */ int f;
            public final /* synthetic */ IntentSender.SendIntentException g;

            public RunnableC0000b(int i, IntentSender.SendIntentException sendIntentException) {
                this.f = i;
                this.g = sendIntentException;
            }

            public void run() {
                b.this.a(this.f, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.g));
            }
        }

        public b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void b(int i2, t<I, O> tVar, I i3, v4 v4Var) {
            ComponentActivity componentActivity = ComponentActivity.this;
            t.a<O> b = tVar.b(componentActivity, i3);
            if (b != null) {
                new Handler(Looper.getMainLooper()).post(new a(i2, b));
                return;
            }
            Intent a2 = tVar.a(componentActivity, i3);
            Bundle bundle = null;
            if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                a2.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else if (v4Var != null) {
                bundle = v4Var.a();
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                t4.c(componentActivity, stringArrayExtra, i2);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    IntentSender intentSender = intentSenderRequest.f;
                    Intent intent = intentSenderRequest.g;
                    int i4 = intentSenderRequest.h;
                    int i5 = intentSenderRequest.i;
                    int i6 = t4.c;
                    componentActivity.startIntentSenderForResult(intentSender, i2, intent, i4, i5, 0, bundle);
                } catch (IntentSender.SendIntentException e) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0000b(i2, e));
                }
            } else {
                int i7 = t4.c;
                componentActivity.startActivityForResult(a2, i2, bundle);
            }
        }
    }

    public class c implements km.b {
        public c() {
        }

        @Override // defpackage.km.b
        @SuppressLint({"SyntheticAccessor"})
        public Bundle a() {
            Bundle bundle = new Bundle();
            ActivityResultRegistry activityResultRegistry = ComponentActivity.this.mActivityResultRegistry;
            Objects.requireNonNull(activityResultRegistry);
            bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(activityResultRegistry.c.values()));
            bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(activityResultRegistry.c.keySet()));
            bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(activityResultRegistry.e));
            bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) activityResultRegistry.h.clone());
            bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", activityResultRegistry.f188a);
            return bundle;
        }
    }

    public class d implements p {
        public d() {
        }

        @Override // defpackage.p
        @SuppressLint({"SyntheticAccessor"})
        public void a(Context context) {
            Bundle a2 = ComponentActivity.this.getSavedStateRegistry().a(ComponentActivity.ACTIVITY_RESULT_TAG);
            if (a2 != null) {
                ActivityResultRegistry activityResultRegistry = ComponentActivity.this.mActivityResultRegistry;
                Objects.requireNonNull(activityResultRegistry);
                ArrayList<Integer> integerArrayList = a2.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                ArrayList<String> stringArrayList = a2.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                if (!(stringArrayList == null || integerArrayList == null)) {
                    activityResultRegistry.e = a2.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    activityResultRegistry.f188a = (Random) a2.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                    activityResultRegistry.h.putAll(a2.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                    for (int i = 0; i < stringArrayList.size(); i++) {
                        String str = stringArrayList.get(i);
                        if (activityResultRegistry.c.containsKey(str)) {
                            Integer remove = activityResultRegistry.c.remove(str);
                            if (!activityResultRegistry.h.containsKey(str)) {
                                activityResultRegistry.b.remove(remove);
                            }
                        }
                        int intValue = integerArrayList.get(i).intValue();
                        String str2 = stringArrayList.get(i);
                        activityResultRegistry.b.put(Integer.valueOf(intValue), str2);
                        activityResultRegistry.c.put(str2, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public Object f186a;
        public gi b;
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new o();
        this.mLifecycleRegistry = new gh(this);
        this.mSavedStateRegistryController = new lm(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        if (getLifecycle() != null) {
            int i = Build.VERSION.SDK_INT;
            getLifecycle().a(new dh() {
                /* class androidx.activity.ComponentActivity.AnonymousClass3 */

                @Override // defpackage.dh
                public void c(fh fhVar, zg.a aVar) {
                    if (aVar == zg.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
            getLifecycle().a(new dh() {
                /* class androidx.activity.ComponentActivity.AnonymousClass4 */

                @Override // defpackage.dh
                public void c(fh fhVar, zg.a aVar) {
                    if (aVar == zg.a.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.b = null;
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                    }
                }
            });
            getLifecycle().a(new dh() {
                /* class androidx.activity.ComponentActivity.AnonymousClass5 */

                @Override // defpackage.dh
                public void c(fh fhVar, zg.a aVar) {
                    ComponentActivity.this.ensureViewModelStore();
                    gh ghVar = (gh) ComponentActivity.this.getLifecycle();
                    ghVar.d("removeObserver");
                    ghVar.b.n(this);
                }
            });
            if (i <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().b(ACTIVITY_RESULT_TAG, new c());
            addOnContextAvailableListener(new d());
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private void initViewTreeOwners() {
        getWindow().getDecorView().setTag(R.id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R.id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R.id.view_tree_saved_state_registry_owner, this);
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(p pVar) {
        o oVar = this.mContextAwareHelper;
        if (oVar.b != null) {
            pVar.a(oVar.b);
        }
        oVar.f2627a.add(pVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new gi();
            }
        }
    }

    @Override // defpackage.s
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public ci getDefaultViewModelProviderFactory() {
        if (getApplication() != null) {
            if (this.mDefaultFactory == null) {
                this.mDefaultFactory = new xh(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f186a;
        }
        return null;
    }

    @Override // defpackage.fh, defpackage.y4
    public zg getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // defpackage.n
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // defpackage.mm
    public final km getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b;
    }

    @Override // defpackage.hi
    public gi getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.mActivityResultRegistry.a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.b();
    }

    @Override // defpackage.y4
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.a(bundle);
        o oVar = this.mContextAwareHelper;
        oVar.b = this;
        for (p pVar : oVar.f2627a) {
            pVar.a(this);
        }
        super.onCreate(bundle);
        vh.c(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        gi giVar = this.mViewModelStore;
        if (giVar == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            giVar = eVar.b;
        }
        if (giVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f186a = onRetainCustomNonConfigurationInstance;
        eVar2.b = giVar;
        return eVar2;
    }

    @Override // defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        zg lifecycle = getLifecycle();
        if (lifecycle instanceof gh) {
            ((gh) lifecycle).i(zg.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.b;
    }

    public final <I, O> r<I> registerForActivityResult(t<I, O> tVar, ActivityResultRegistry activityResultRegistry, q<O> qVar) {
        StringBuilder i0 = hj1.i0("activity_rq#");
        i0.append(this.mNextLocalRequestCode.getAndIncrement());
        return activityResultRegistry.d(i0.toString(), this, tVar, qVar);
    }

    public final void removeOnContextAvailableListener(p pVar) {
        this.mContextAwareHelper.f2627a.remove(pVar);
    }

    public void reportFullyDrawn() {
        try {
            if (h.c0()) {
                Trace.beginSection("reportFullyDrawn() for " + getComponentName());
            }
            super.reportFullyDrawn();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        super.setContentView(i);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    public final <I, O> r<I> registerForActivityResult(t<I, O> tVar, q<O> qVar) {
        return registerForActivityResult(tVar, this.mActivityResultRegistry, qVar);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }
}
