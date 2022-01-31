package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

/* renamed from: ff  reason: default package */
/* compiled from: FragmentLayoutInflaterFactory */
public class ff implements LayoutInflater.Factory2 {
    public final FragmentManager f;

    /* renamed from: ff$a */
    /* compiled from: FragmentLayoutInflaterFactory */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ kf f;

        public a(kf kfVar) {
            this.f = kfVar;
        }

        public void onViewAttachedToWindow(View view) {
            kf kfVar = this.f;
            Fragment fragment = kfVar.c;
            kfVar.k();
            bg.f((ViewGroup) fragment.mView.getParent(), ff.this.f).e();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public ff(FragmentManager fragmentManager) {
        this.f = fragmentManager;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        kf kfVar;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue != null) {
            ClassLoader classLoader = context.getClassLoader();
            u2<ClassLoader, u2<String, Class<?>>> u2Var = df.f827a;
            int i = 0;
            try {
                z = Fragment.class.isAssignableFrom(df.b(classLoader, attributeValue));
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (z) {
                if (view != null) {
                    i = view.getId();
                }
                if (i == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                if (resourceId != -1) {
                    fragment = this.f.H(resourceId);
                }
                if (fragment == null && string != null) {
                    fragment = this.f.I(string);
                }
                if (fragment == null && i != -1) {
                    fragment = this.f.H(i);
                }
                if (fragment == null) {
                    fragment = this.f.K().a(context.getClassLoader(), attributeValue);
                    fragment.mFromLayout = true;
                    fragment.mFragmentId = resourceId != 0 ? resourceId : i;
                    fragment.mContainerId = i;
                    fragment.mTag = string;
                    fragment.mInLayout = true;
                    FragmentManager fragmentManager = this.f;
                    fragment.mFragmentManager = fragmentManager;
                    ef<?> efVar = fragmentManager.q;
                    fragment.mHost = efVar;
                    fragment.onInflate(efVar.g, attributeSet, fragment.mSavedFragmentState);
                    kfVar = this.f.a(fragment);
                    if (FragmentManager.O(2)) {
                        String str2 = "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId);
                    }
                } else if (!fragment.mInLayout) {
                    fragment.mInLayout = true;
                    FragmentManager fragmentManager2 = this.f;
                    fragment.mFragmentManager = fragmentManager2;
                    ef<?> efVar2 = fragmentManager2.q;
                    fragment.mHost = efVar2;
                    fragment.onInflate(efVar2.g, attributeSet, fragment.mSavedFragmentState);
                    kfVar = this.f.h(fragment);
                    if (FragmentManager.O(2)) {
                        String str3 = "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId);
                    }
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + attributeValue);
                }
                fragment.mContainer = (ViewGroup) view;
                kfVar.k();
                kfVar.j();
                View view2 = fragment.mView;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragment.mView.getTag() == null) {
                        fragment.mView.setTag(string);
                    }
                    fragment.mView.addOnAttachStateChangeListener(new a(kfVar));
                    return fragment.mView;
                }
                throw new IllegalStateException(hj1.T("Fragment ", attributeValue, " did not create a view."));
            }
        }
        return null;
    }
}
