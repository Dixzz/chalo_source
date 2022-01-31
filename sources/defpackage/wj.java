package defpackage;

/* renamed from: wj  reason: default package */
/* compiled from: BatchingListUpdateCallback */
public class wj implements pk {

    /* renamed from: a  reason: collision with root package name */
    public final pk f3789a;
    public int b = 0;
    public int c = -1;
    public int d = -1;
    public Object e = null;

    public wj(pk pkVar) {
        this.f3789a = pkVar;
    }

    public void a() {
        int i = this.b;
        if (i != 0) {
            if (i == 1) {
                this.f3789a.onInserted(this.c, this.d);
            } else if (i == 2) {
                this.f3789a.onRemoved(this.c, this.d);
            } else if (i == 3) {
                this.f3789a.onChanged(this.c, this.d, this.e);
            }
            this.e = null;
            this.b = 0;
        }
    }

    @Override // defpackage.pk
    public void onChanged(int i, int i2, Object obj) {
        int i3;
        if (this.b == 3) {
            int i4 = this.c;
            int i5 = this.d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.e == obj) {
                this.c = Math.min(i, i4);
                this.d = Math.max(i5 + i4, i3) - this.c;
                return;
            }
        }
        a();
        this.c = i;
        this.d = i2;
        this.e = obj;
        this.b = 3;
    }

    @Override // defpackage.pk
    public void onInserted(int i, int i2) {
        int i3;
        if (this.b == 1 && i >= (i3 = this.c)) {
            int i4 = this.d;
            if (i <= i3 + i4) {
                this.d = i4 + i2;
                this.c = Math.min(i, i3);
                return;
            }
        }
        a();
        this.c = i;
        this.d = i2;
        this.b = 1;
    }

    @Override // defpackage.pk
    public void onMoved(int i, int i2) {
        a();
        this.f3789a.onMoved(i, i2);
    }

    @Override // defpackage.pk
    public void onRemoved(int i, int i2) {
        int i3;
        if (this.b != 2 || (i3 = this.c) < i || i3 > i + i2) {
            a();
            this.c = i;
            this.d = i2;
            this.b = 2;
            return;
        }
        this.d += i2;
        this.c = i;
    }
}
