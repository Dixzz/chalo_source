package defpackage;

/* renamed from: ns  reason: default package */
/* compiled from: WorkNameDao_Impl */
public final class ns implements ms {

    /* renamed from: a  reason: collision with root package name */
    public final wl f2598a;
    public final ql<ls> b;

    /* renamed from: ns$a */
    /* compiled from: WorkNameDao_Impl */
    public class a extends ql<ls> {
        public a(ns nsVar, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, ls lsVar) {
            ls lsVar2 = lsVar;
            String str = lsVar2.f2261a;
            if (str == null) {
                smVar.E0(1);
            } else {
                smVar.z(1, str);
            }
            String str2 = lsVar2.b;
            if (str2 == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str2);
            }
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public ns(wl wlVar) {
        this.f2598a = wlVar;
        this.b = new a(this, wlVar);
    }
}
