package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import app.zophop.models.SosContact;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: g50  reason: default package */
/* compiled from: SosContactsFeature */
public class g50 implements a30 {

    /* renamed from: a  reason: collision with root package name */
    public final rf1 f1215a;
    public final Context b;

    public g50(Context context) {
        this.b = context;
        this.f1215a = new rf1(context, "sos_store_key");
    }

    @Override // defpackage.a30
    public void a(String str) {
        xt.f3961a.l().put("sos_message", str);
    }

    @Override // defpackage.a30
    public void b(SosContact sosContact) {
        this.f1215a.k(sosContact.getContactId());
    }

    @Override // defpackage.a30
    public void c() {
        StringBuilder sb = new StringBuilder("smsto:");
        List<SosContact> e = e();
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) e;
            if (i >= arrayList.size()) {
                break;
            }
            sb.append(((SosContact) arrayList.get(i)).getPhoneNumber());
            if (i != arrayList.size() - 1) {
                sb.append(", ");
            }
            i++;
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(sb.toString()));
        intent.putExtra("sms_body", g());
        intent.addFlags(268435456);
        if (intent.resolveActivity(this.b.getPackageManager()) != null) {
            this.b.startActivity(intent);
        } else {
            Toast.makeText(this.b, "No sms app available", 0).show();
        }
    }

    @Override // defpackage.a30
    public boolean d() {
        return this.f1215a.b().isEmpty();
    }

    @Override // defpackage.a30
    public List<SosContact> e() {
        Map<String, ?> b2 = this.f1215a.b();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : b2.entrySet()) {
            try {
                JSONObject jSONObject = new JSONObject((String) entry.getValue());
                arrayList.add(new SosContact(jSONObject.getString("contactId"), jSONObject.getString("contactName"), jSONObject.getString("phoneNumber")));
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
        return arrayList;
    }

    @Override // defpackage.a30
    public void f(SosContact sosContact) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("contactId", sosContact.getContactId());
            jSONObject.put("contactName", sosContact.getContactName());
            jSONObject.put("phoneNumber", sosContact.getPhoneNumber());
            this.f1215a.j(sosContact.getContactId(), jSONObject.toString());
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }

    @Override // defpackage.a30
    public String g() {
        xt.t1 t1Var = xt.f3961a;
        if (!t1Var.l().h.has("sos_message")) {
            t1Var.l().put("sos_message", " I am in danger. Please help me out.");
        }
        return t1Var.l().h.optString("sos_message", null);
    }
}
