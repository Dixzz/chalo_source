package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.navigation.common.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: jj  reason: default package */
/* compiled from: NavInflater */
public final class jj {
    public static final ThreadLocal<TypedValue> c = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    public Context f1932a;
    public nj b;

    public jj(Context context, nj njVar) {
        this.f1932a = context;
        this.b = njVar;
    }

    public static lj a(TypedValue typedValue, lj ljVar, lj ljVar2, String str, String str2) throws XmlPullParserException {
        if (ljVar == null || ljVar == ljVar2) {
            return ljVar != null ? ljVar : ljVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    public final ej b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        int i2;
        String str;
        ej a2 = this.b.c(xmlResourceParser.getName()).a();
        a2.s(this.f1932a, attributeSet);
        int i3 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == i3 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return a2;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
                    String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
                    if (string != null) {
                        zi d = d(obtainAttributes, resources, i);
                        if (a2.m == null) {
                            a2.m = new HashMap<>();
                        }
                        a2.m.put(string, d);
                        obtainAttributes.recycle();
                    } else {
                        throw new XmlPullParserException("Arguments must have a name");
                    }
                } else if ("deepLink".equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R.styleable.NavDeepLink);
                    String string2 = obtainAttributes2.getString(R.styleable.NavDeepLink_uri);
                    String string3 = obtainAttributes2.getString(R.styleable.NavDeepLink_action);
                    String string4 = obtainAttributes2.getString(R.styleable.NavDeepLink_mimeType);
                    if (!TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3) || !TextUtils.isEmpty(string4)) {
                        String str2 = null;
                        String replace = string2 != null ? string2.replace("${applicationId}", this.f1932a.getPackageName()) : null;
                        if (!TextUtils.isEmpty(string3)) {
                            str = string3.replace("${applicationId}", this.f1932a.getPackageName());
                            if (str.isEmpty()) {
                                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
                            }
                        } else {
                            str = null;
                        }
                        if (string4 != null) {
                            str2 = string4.replace("${applicationId}", this.f1932a.getPackageName());
                        }
                        cj cjVar = new cj(replace, str, str2);
                        if (a2.k == null) {
                            a2.k = new ArrayList<>();
                        }
                        a2.k.add(cjVar);
                        obtainAttributes2.recycle();
                    } else {
                        throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
                    }
                } else {
                    if ("action".equals(name)) {
                        TypedArray obtainAttributes3 = resources.obtainAttributes(attributeSet, R.styleable.NavAction);
                        int resourceId = obtainAttributes3.getResourceId(R.styleable.NavAction_android_id, 0);
                        vi viVar = new vi(obtainAttributes3.getResourceId(R.styleable.NavAction_destination, 0));
                        viVar.b = new kj(obtainAttributes3.getBoolean(R.styleable.NavAction_launchSingleTop, false), obtainAttributes3.getResourceId(R.styleable.NavAction_popUpTo, -1), obtainAttributes3.getBoolean(R.styleable.NavAction_popUpToInclusive, false), obtainAttributes3.getResourceId(R.styleable.NavAction_enterAnim, -1), obtainAttributes3.getResourceId(R.styleable.NavAction_exitAnim, -1), obtainAttributes3.getResourceId(R.styleable.NavAction_popEnterAnim, -1), obtainAttributes3.getResourceId(R.styleable.NavAction_popExitAnim, -1));
                        Bundle bundle = new Bundle();
                        int depth3 = xmlResourceParser.getDepth() + i3;
                        int i4 = i;
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == i3) {
                                i2 = depth2;
                                break;
                            }
                            int depth4 = xmlResourceParser.getDepth();
                            i2 = depth2;
                            if (depth4 < depth3 && next2 == 3) {
                                break;
                            }
                            if (next2 == 2 && depth4 <= depth3) {
                                if ("argument".equals(xmlResourceParser.getName())) {
                                    TypedArray obtainAttributes4 = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
                                    String string5 = obtainAttributes4.getString(R.styleable.NavArgument_android_name);
                                    if (string5 != null) {
                                        zi d2 = d(obtainAttributes4, resources, i4);
                                        boolean z = d2.c;
                                        if (z && z) {
                                            d2.f4177a.d(bundle, string5, d2.d);
                                        }
                                        obtainAttributes4.recycle();
                                    } else {
                                        throw new XmlPullParserException("Arguments must have a name");
                                    }
                                }
                                i4 = i;
                            }
                            depth2 = i2;
                            i3 = 1;
                        }
                        if (!bundle.isEmpty()) {
                            viVar.c = bundle;
                        }
                        if (!a2.u()) {
                            throw new UnsupportedOperationException("Cannot add action " + resourceId + " to " + a2 + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
                        } else if (resourceId != 0) {
                            if (a2.l == null) {
                                a2.l = new v2<>();
                            }
                            a2.l.g(resourceId, viVar);
                            obtainAttributes3.recycle();
                        } else {
                            throw new IllegalArgumentException("Cannot have an action with actionId 0");
                        }
                    } else {
                        i2 = depth2;
                        if ("include".equals(name) && (a2 instanceof gj)) {
                            TypedArray obtainAttributes5 = resources.obtainAttributes(attributeSet, androidx.navigation.R.styleable.NavInclude);
                            ((gj) a2).v(c(obtainAttributes5.getResourceId(androidx.navigation.R.styleable.NavInclude_graph, 0)));
                            obtainAttributes5.recycle();
                        } else if (a2 instanceof gj) {
                            ((gj) a2).v(b(resources, xmlResourceParser, attributeSet, i));
                        }
                    }
                    depth2 = i2;
                    i3 = 1;
                }
                i2 = depth2;
                depth2 = i2;
                i3 = 1;
            }
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b A[Catch:{ Exception -> 0x0053, all -> 0x0051 }] */
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.gj c(int r7) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj.c(int):gj");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: lj<float[]> */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:130|131|132) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:133|134|135) */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        r10.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0296, code lost:
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        r9.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x029b, code lost:
        r5 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x029d, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:130:0x0293 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x0298 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.zi d(android.content.res.TypedArray r26, android.content.res.Resources r27, int r28) throws org.xmlpull.v1.XmlPullParserException {
        /*
        // Method dump skipped, instructions count: 936
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj.d(android.content.res.TypedArray, android.content.res.Resources, int):zi");
    }
}
