package defpackage;

import android.content.Context;
import android.widget.LinearLayout;
import app.zophop.models.mTicketing.AgencyProfileField;
import app.zophop.ui.views.ZophopFormInput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ja1  reason: default package */
/* compiled from: AgencyFieldsView */
public class ja1 extends LinearLayout {
    public List<AgencyProfileField> f;
    public boolean g = false;

    /* renamed from: ja1$a */
    /* compiled from: AgencyFieldsView */
    public class a implements ZophopFormInput.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AgencyProfileField f1896a;
        public final /* synthetic */ ZophopFormInput b;

        public a(AgencyProfileField agencyProfileField, ZophopFormInput zophopFormInput) {
            this.f1896a = agencyProfileField;
            this.b = zophopFormInput;
        }

        @Override // app.zophop.ui.views.ZophopFormInput.b
        public void a() {
            ja1.this.g = true;
            this.f1896a.setExistingValue(this.b.getText());
        }

        @Override // app.zophop.ui.views.ZophopFormInput.b
        public void b() {
        }

        @Override // app.zophop.ui.views.ZophopFormInput.b
        public void c() {
        }
    }

    public ja1(Context context, List<AgencyProfileField> list, boolean z) {
        super(context);
        this.f = list;
        a();
    }

    public final void a() {
        removeAllViews();
        setOrientation(1);
        for (int i = 0; i < this.f.size(); i++) {
            AgencyProfileField agencyProfileField = this.f.get(i);
            ZophopFormInput zophopFormInput = new ZophopFormInput(getContext(), null);
            zophopFormInput.setHint(agencyProfileField.getFieldName());
            zophopFormInput.setText(agencyProfileField.getExistingValue());
            if (!agencyProfileField.isEditable()) {
                zophopFormInput.a();
            }
            zophopFormInput.setInputChangeListener(new a(agencyProfileField, zophopFormInput));
            addView(zophopFormInput);
        }
    }

    public List<AgencyProfileField> getAgencyFields() {
        return this.f;
    }

    public Map<String, String> getFieldMaps() {
        HashMap hashMap = new HashMap();
        for (AgencyProfileField agencyProfileField : this.f) {
            hashMap.put(agencyProfileField.getFieldName(), agencyProfileField.getExistingValue());
        }
        return hashMap;
    }

    public void setEditable(boolean z) {
        for (int i = 0; i < this.f.size(); i++) {
            ((ZophopFormInput) getChildAt(i)).setEditable(z);
        }
    }
}
