package defpackage;

import java.util.ArrayList;

/* renamed from: v3  reason: default package */
/* compiled from: WidgetContainer */
public class v3 extends n3 {
    public ArrayList<n3> e0 = new ArrayList<>();

    public void J() {
        ArrayList<n3> arrayList = this.e0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                n3 n3Var = this.e0.get(i);
                if (n3Var instanceof v3) {
                    ((v3) n3Var).J();
                }
            }
        }
    }

    @Override // defpackage.n3
    public void x() {
        this.e0.clear();
        super.x();
    }

    @Override // defpackage.n3
    public void z(e3 e3Var) {
        super.z(e3Var);
        int size = this.e0.size();
        for (int i = 0; i < size; i++) {
            this.e0.get(i).z(e3Var);
        }
    }
}
