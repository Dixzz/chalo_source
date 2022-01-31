package defpackage;

import defpackage.wd6;
import java.util.ArrayList;

/* renamed from: ge6  reason: default package */
/* compiled from: LinkedListChannel.kt */
public class ge6<E> extends ud6<E> {
    public ge6(s76<? super E, s56> s76) {
        super(s76);
    }

    @Override // defpackage.wd6
    public final boolean m() {
        return false;
    }

    @Override // defpackage.wd6
    public final boolean n() {
        return false;
    }

    @Override // defpackage.wd6
    public Object o(E e) {
        je6 je6;
        dg6 dg6 = vd6.b;
        do {
            Object o = super.o(e);
            if (o == dg6) {
                return dg6;
            }
            if (o == vd6.c) {
                uf6 uf6 = this.c;
                wd6.a aVar = new wd6.a(e);
                while (true) {
                    uf6 o2 = uf6.o();
                    if (!(o2 instanceof je6)) {
                        if (o2.j(aVar, uf6)) {
                            je6 = null;
                            break;
                        }
                    } else {
                        je6 = (je6) o2;
                        break;
                    }
                }
                if (je6 == null) {
                    return dg6;
                }
            } else if (o instanceof ce6) {
                return o;
            } else {
                throw new IllegalStateException(n86.j("Invalid offerInternal result ", o).toString());
            }
        } while (!(je6 instanceof ce6));
        return je6;
    }

    @Override // defpackage.ud6
    public final boolean t() {
        return true;
    }

    @Override // defpackage.ud6
    public final boolean u() {
        return true;
    }

    @Override // defpackage.ud6
    public void x(Object obj, ce6<?> ce6) {
        jg6 jg6 = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                le6 le6 = (le6) obj;
                if (le6 instanceof wd6.a) {
                    s76<E, s56> s76 = this.b;
                    if (s76 != null) {
                        jg6 = ec6.h(s76, ((wd6.a) le6).i, null);
                    }
                } else {
                    le6.x(ce6);
                }
            } else {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    jg6 jg62 = null;
                    while (true) {
                        int i = size - 1;
                        le6 le62 = (le6) arrayList.get(size);
                        if (le62 instanceof wd6.a) {
                            s76<E, s56> s762 = this.b;
                            jg62 = s762 == null ? null : ec6.h(s762, ((wd6.a) le62).i, jg62);
                        } else {
                            le62.x(ce6);
                        }
                        if (i < 0) {
                            break;
                        }
                        size = i;
                    }
                    jg6 = jg62;
                }
            }
        }
        if (jg6 != null) {
            throw jg6;
        }
    }
}
