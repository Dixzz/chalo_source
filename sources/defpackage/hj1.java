package defpackage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.models.City;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.activities.CheckoutActivity;
import app.zophop.ui.activities.ConfirmMagicPassActivity;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeSummaryActivity;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.gson.Gson;
import com.urbanairship.json.JsonValue;
import defpackage.ic2;
import defpackage.jm;
import defpackage.kb;
import defpackage.xt;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import server.zophop.models.Point;

/* renamed from: hj1  reason: default package */
/* compiled from: outline */
public class hj1 {
    public static String A(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.z());
        return sb.toString();
    }

    public static void A0(TextView textView, String str, ConfirmMagicPassActivity confirmMagicPassActivity, int i, int i2) {
        textView.setText(str);
        confirmMagicPassActivity.findViewById(i).setVisibility(i2);
    }

    public static String B(xt.t1 t1Var) {
        return t1Var.k().d().getName();
    }

    public static void B0(om omVar, String str, String str2, String str3, String str4) {
        omVar.y(str);
        omVar.y(str2);
        omVar.y(str3);
        omVar.y(str4);
    }

    public static String C(xt.t1 t1Var) {
        return t1Var.k().d().getName().toLowerCase();
    }

    public static long C0(Point point, long j, long j2) {
        return (j - point.getTime()) / j2;
    }

    public static String D(xt.t1 t1Var) {
        City d = t1Var.k().d();
        n86.c(d);
        return d.getName();
    }

    public static void D0(sm smVar, int i, int i2, int i3, int i4) {
        smVar.E0(i);
        smVar.E0(i2);
        smVar.E0(i3);
        smVar.E0(i4);
    }

    public static String E(DataSnapshot dataSnapshot, String str) {
        return dataSnapshot.child(str).getValue().toString();
    }

    public static void E0(SuperPass superPass, String str, hm0 hm0, String str2, hm0 hm02) {
        n86.e(superPass, str);
        n86.e(hm0, str2);
        hm02.dismiss();
    }

    public static String F(zt5 zt5, String str, StringBuilder sb) {
        sb.append(zt5.u(str));
        return sb.toString();
    }

    public static void F0(CheckoutActivity checkoutActivity, String str, ed1 ed1, String str2) {
        ed1.a(str2, checkoutActivity.getIntent().getStringExtra(str));
    }

    public static String G(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    public static void G0(OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity, int i, ImageView imageView) {
        imageView.setImageDrawable(onlineCardRechargeSummaryActivity.getResources().getDrawable(i));
    }

    public static String H(String str) {
        String uuid = UUID.randomUUID().toString();
        n86.d(uuid, str);
        return uuid;
    }

    public static void H0(OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity, int i, TextView textView) {
        textView.setText(onlineCardRechargeSummaryActivity.getResources().getString(i));
    }

    public static String I(String str, int i) {
        return str + i;
    }

    public static void I0(ed1 ed1, String str, Boolean bool, SuperPassSubType superPassSubType, String str2) {
        ed1.a(str, bool);
        ed1.a(str2, superPassSubType.name());
    }

    public static String J(String str, int i, String str2) {
        return str + i + str2;
    }

    public static void J0(ed1 ed1, String str, Boolean bool, ed1 ed12) {
        ed1.a(str, bool);
        jz5.b().g(ed12);
    }

    public static int K(LinearLayout linearLayout, String str, LinearLayout linearLayout2, String str2) {
        n86.d(linearLayout, str);
        n86.e(linearLayout2, str2);
        return linearLayout.getMeasuredHeight();
    }

    public static void K0(ed1 ed1, String str, String str2, ed1 ed12) {
        ed1.a(str, str2);
        jz5.b().g(ed12);
    }

    public static String L(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static void L0(String str, int i, int i2, String str2, StringBuilder sb, char c) {
        String substring = str.substring(i, i2);
        n86.d(substring, str2);
        sb.append(substring);
        sb.append(c);
    }

    public static String M(String str, long j) {
        return str + j;
    }

    public static void M0(String str, int i, int i2, StringBuilder sb, String str2) {
        sb.append(str.substring(i, i2));
        sb.append(str2);
    }

    public static String N(String str, Uri uri) {
        return str + uri;
    }

    public static Intent N0(Context context, Class cls, String str, String str2) {
        Intent intent = new Intent(context, cls);
        intent.putExtra(str, str2);
        return intent;
    }

    public static String O(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static void O0(String str, long j) {
        ui1.m0(new ed1(str, j));
    }

    public static String P(String str, jm jmVar, String str2, jm jmVar2) {
        return str + jmVar + str2 + jmVar2;
    }

    public static void P0(String str, long j, String str2, String str3) {
        ed1 ed1 = new ed1(str, j);
        ed1.a(str2, str3);
        ui1.m0(ed1);
    }

    public static String Q(String str, zt5 zt5) {
        return str + zt5;
    }

    public static void Q0(String str, c00 c00) {
        c00.b(new Throwable(str));
    }

    public static String R(String str, JsonValue jsonValue) {
        return str + jsonValue;
    }

    public static void R0(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        n86.e(str, str2);
        n86.e(str3, str4);
        ed1 ed1 = new ed1(str5, j);
        ed1.a(str6, str7);
        ui1.m0(ed1);
    }

    public static String S(String str, String str2) {
        return str + str2;
    }

    public static void S0(String str, JSONObject jSONObject) {
        String str2 = str + jSONObject;
    }

    public static String T(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static void T0(StringBuilder sb, int i, TextView textView) {
        sb.append(i);
        textView.setText(sb.toString());
    }

    public static String U(StringBuilder sb, double d, String str) {
        sb.append(d);
        sb.append(str);
        return sb.toString();
    }

    public static void U0(StringBuilder sb, String str, char c, String str2) {
        sb.append(str);
        sb.append(c);
        sb.append(str2);
    }

    public static int V(MPass mPass) {
        return mPass.getRouteStopsInfo().getRouteName().length();
    }

    public static void V0(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static String W(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static void W0(JSONException jSONException) {
        b00.a().b(jSONException);
        jSONException.printStackTrace();
    }

    public static String X(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static void X0(JSONException jSONException, c00 c00) {
        c00.b(new Throwable(jSONException));
    }

    public static String Y(StringBuilder sb, Fragment fragment, String str) {
        sb.append(fragment);
        sb.append(str);
        return sb.toString();
    }

    public static String Z(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static String a0(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static int b(int i, int i2, int i3, int i4) {
        return ((i + i2) * i3) + i4;
    }

    public static String b0(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static Bundle c(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        bundle.putString(str3, str4);
        return bundle;
    }

    public static String c0(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static void d(boolean z, ed1 ed1, String str, ed1 ed12) {
        ed1.a(str, Boolean.valueOf(z));
        jz5.b().g(ed12);
    }

    public static String d0(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static void e(Object[] objArr, int i, String str, String str2, TextView textView) {
        String format = String.format(str, Arrays.copyOf(objArr, i));
        n86.d(format, str2);
        textView.setText(format);
    }

    public static String e0(Object[] objArr, int i, String str, String str2) {
        String format = String.format(str, Arrays.copyOf(objArr, i));
        n86.d(format, str2);
        return format;
    }

    public static SpannableStringBuilder f(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }

    public static StringBuilder f0(ed1 ed1, String str, String str2) {
        ed1.a(str, str2);
        return new StringBuilder();
    }

    public static View g(ConfirmMagicPassActivity confirmMagicPassActivity, int i, int i2, int i3) {
        confirmMagicPassActivity.findViewById(i).setVisibility(i2);
        return confirmMagicPassActivity.findViewById(i3);
    }

    public static int g0(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    public static ViewParent h(LinearLayout linearLayout, String str, LinearLayout linearLayout2, String str2, String str3) {
        n86.d(linearLayout, str);
        n86.e(linearLayout2, str2);
        ViewParent parent = linearLayout.getParent();
        Objects.requireNonNull(parent, str3);
        return parent;
    }

    public static StringBuilder h0(gf3 gf3, a32 a32, pz1 pz1, String str) {
        gf3.a(a32, pz1);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static kb.a i(String str, String str2, String str3) {
        n86.e(str, str2);
        return new kb.a(str3);
    }

    public static StringBuilder i0(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static gi j(Fragment fragment, String str, String str2) {
        ve requireActivity = fragment.requireActivity();
        n86.d(requireActivity, str);
        gi viewModelStore = requireActivity.getViewModelStore();
        n86.d(viewModelStore, str2);
        return viewModelStore;
    }

    public static StringBuilder j0(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static s61 k(LinearLayout linearLayout, int i, LinearLayout linearLayout2, int i2) {
        linearLayout.setVisibility(i);
        return new s61(linearLayout2, i2);
    }

    public static StringBuilder k0(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static ed1 l(String str, long j, String str2, String str3) {
        ed1 ed1 = new ed1(str, j);
        ed1.a(str2, str3);
        return ed1;
    }

    public static StringBuilder l0(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static pz1 m(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        return pz1.a(str2, str3, Uri.parse(sb.toString()));
    }

    public static HashMap m0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static ic2 n(Parcel parcel) {
        ic2 F = ic2.a.F(parcel.readStrongBinder());
        parcel.recycle();
        return F;
    }

    public static HashMap n0(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        hashMap.put(str3, str4);
        return hashMap;
    }

    public static int o(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    public static HashSet o0(HashMap hashMap, String str, jm.a aVar, int i) {
        hashMap.put(str, aVar);
        return new HashSet(i);
    }

    public static jz5 p(ed1 ed1, String str, String str2, String str3, String str4) {
        ed1.a(str, str2);
        ed1.a(str3, str4);
        return jz5.b();
    }

    public static Iterator p0(MTicket mTicket) {
        return mTicket.getPassengerDetails().keySet().iterator();
    }

    public static Integer q(ed1 ed1, String str, String str2, String str3, String str4) {
        ed1.a(str, str2);
        ed1.a(str3, str4);
        return Integer.valueOf(jh1.j(ui1.Q()));
    }

    public static Iterator q0(DataSnapshot dataSnapshot, String str) {
        return dataSnapshot.child(str).getChildren().iterator();
    }

    public static Integer r(HashMap hashMap, String str, Integer num, Cursor cursor, String str2) {
        hashMap.put(str, num);
        return Integer.valueOf(cursor.getColumnIndex(str2));
    }

    public static int r0(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static Object s(String str, Class cls) {
        return new Gson().fromJson(str, cls);
    }

    public static m66 s0(CoroutineExceptionHandler.a aVar, kb6 kb6) {
        return kb6.plus(new lh1(aVar));
    }

    public static Object t(List list, int i) {
        return list.get(list.size() + i);
    }

    public static m66 t0(CoroutineExceptionHandler.a aVar, ad6 ad6) {
        return ad6.plus(new lh1(aVar));
    }

    public static Object u(List list, int i) {
        return list.get(list.size() - i);
    }

    public static void u0(int i, ed1 ed1, String str, ed1 ed12) {
        ed1.a(str, Integer.valueOf(i));
        ui1.m0(ed12);
    }

    public static String v(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static void v0(Context context, int i, TextView textView) {
        textView.setTextColor(context.getResources().getColor(i));
    }

    public static String w(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    public static void w0(Context context, int i, MaterialTextView materialTextView) {
        materialTextView.setText(context.getResources().getString(i));
    }

    public static String x(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void x0(View view, int i, int i2, int i3, int i4) {
        view.findViewById(i).setVisibility(i2);
        view.findViewById(i3).setVisibility(i4);
    }

    public static String y(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static void y0(ImageView imageView, String str, float[] fArr, String str2, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, str, fArr);
        n86.d(ofFloat, str2);
        ofFloat.setDuration(j);
        ofFloat.start();
    }

    public static int z(int i, int i2, LinearLayout linearLayout, int i3) {
        linearLayout.measure(i3, View.MeasureSpec.makeMeasureSpec(i, i2));
        return linearLayout.getMeasuredHeight();
    }

    public static void z0(LinearLayout linearLayout, int i, long j) {
        r61 r61 = new r61(linearLayout, i);
        r61.setDuration(j);
        linearLayout.startAnimation(r61);
    }
}
