package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.navigation.R;
import defpackage.mj;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@mj.b("activity")
/* renamed from: ti  reason: default package */
/* compiled from: ActivityNavigator */
public class ti extends mj<a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f3359a;
    public Activity b;

    /* renamed from: ti$a */
    /* compiled from: ActivityNavigator */
    public static class a extends ej {
        public Intent n;
        public String o;

        public a(mj<? extends a> mjVar) {
            super(mjVar);
        }

        @Override // defpackage.ej
        public void s(Context context, AttributeSet attributeSet) {
            super.s(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            if (this.n == null) {
                this.n = new Intent();
            }
            this.n.setPackage(string);
            String string2 = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                ComponentName componentName = new ComponentName(context, string2);
                if (this.n == null) {
                    this.n = new Intent();
                }
                this.n.setComponent(componentName);
            }
            String string3 = obtainAttributes.getString(R.styleable.ActivityNavigator_action);
            if (this.n == null) {
                this.n = new Intent();
            }
            this.n.setAction(string3);
            String string4 = obtainAttributes.getString(R.styleable.ActivityNavigator_data);
            if (string4 != null) {
                Uri parse = Uri.parse(string4);
                if (this.n == null) {
                    this.n = new Intent();
                }
                this.n.setData(parse);
            }
            this.o = obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern);
            obtainAttributes.recycle();
        }

        @Override // defpackage.ej
        public String toString() {
            ComponentName componentName;
            Intent intent = this.n;
            String str = null;
            if (intent == null) {
                componentName = null;
            } else {
                componentName = intent.getComponent();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (componentName != null) {
                sb.append(" class=");
                sb.append(componentName.getClassName());
            } else {
                Intent intent2 = this.n;
                if (intent2 != null) {
                    str = intent2.getAction();
                }
                if (str != null) {
                    sb.append(" action=");
                    sb.append(str);
                }
            }
            return sb.toString();
        }

        @Override // defpackage.ej
        public boolean u() {
            return false;
        }
    }

    /* renamed from: ti$b */
    /* compiled from: ActivityNavigator */
    public static final class b implements mj.a {
    }

    public ti(Context context) {
        this.f3359a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    /* Return type fixed from 'ej' to match base method */
    @Override // defpackage.mj
    public a a() {
        return new a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [ej, android.os.Bundle, kj, mj$a] */
    @Override // defpackage.mj
    public ej b(a aVar, Bundle bundle, kj kjVar, mj.a aVar2) {
        Intent intent;
        int intExtra;
        a aVar3 = aVar;
        if (aVar3.n != null) {
            Intent intent2 = new Intent(aVar3.n);
            if (bundle != null) {
                intent2.putExtras(bundle);
                String str = aVar3.o;
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + str);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z = aVar2 instanceof b;
            if (z) {
                Objects.requireNonNull((b) aVar2);
                intent2.addFlags(0);
            }
            if (!(this.f3359a instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (kjVar != null && kjVar.f2067a) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.b;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", aVar3.h);
            Resources resources = this.f3359a.getResources();
            if (kjVar != null) {
                int i = kjVar.f;
                int i2 = kjVar.g;
                if ((i <= 0 || !resources.getResourceTypeName(i).equals("animator")) && (i2 <= 0 || !resources.getResourceTypeName(i2).equals("animator"))) {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", i);
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", i2);
                } else {
                    StringBuilder i0 = hj1.i0("Activity destinations do not support Animator resource. Ignoring popEnter resource ");
                    i0.append(resources.getResourceName(i));
                    i0.append(" and popExit resource ");
                    i0.append(resources.getResourceName(i2));
                    i0.append("when launching ");
                    i0.append(aVar3);
                    i0.toString();
                }
            }
            if (z) {
                Objects.requireNonNull((b) aVar2);
                this.f3359a.startActivity(intent2);
            } else {
                this.f3359a.startActivity(intent2);
            }
            if (kjVar == null || this.b == null) {
                return null;
            }
            int i3 = kjVar.d;
            int i4 = kjVar.e;
            if ((i3 > 0 && resources.getResourceTypeName(i3).equals("animator")) || (i4 > 0 && resources.getResourceTypeName(i4).equals("animator"))) {
                StringBuilder i02 = hj1.i0("Activity destinations do not support Animator resource. Ignoring enter resource ");
                i02.append(resources.getResourceName(i3));
                i02.append(" and exit resource ");
                i02.append(resources.getResourceName(i4));
                i02.append("when launching ");
                i02.append(aVar3);
                i02.toString();
                return null;
            } else if (i3 < 0 && i4 < 0) {
                return null;
            } else {
                this.b.overridePendingTransition(Math.max(i3, 0), Math.max(i4, 0));
                return null;
            }
        } else {
            throw new IllegalStateException(hj1.X(hj1.i0("Destination "), aVar3.h, " does not have an Intent set."));
        }
    }

    @Override // defpackage.mj
    public boolean e() {
        Activity activity = this.b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
