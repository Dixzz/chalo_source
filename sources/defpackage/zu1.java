package defpackage;

import android.util.SparseArray;

/* renamed from: zu1  reason: default package */
/* compiled from: QosTier */
public enum zu1 {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);
    
    private static final SparseArray<zu1> valueMap;
    private final int value;

    /* access modifiers changed from: public */
    static {
        zu1 zu1;
        zu1 zu12;
        zu1 zu13;
        zu1 zu14;
        zu1 zu15;
        zu1 zu16;
        SparseArray<zu1> sparseArray = new SparseArray<>();
        valueMap = sparseArray;
        sparseArray.put(0, zu1);
        sparseArray.put(1, zu12);
        sparseArray.put(2, zu13);
        sparseArray.put(3, zu14);
        sparseArray.put(4, zu15);
        sparseArray.put(-1, zu16);
    }

    private zu1(int i) {
        this.value = i;
    }

    public static zu1 forNumber(int i) {
        if (i == 0) {
            return DEFAULT;
        }
        if (i == 1) {
            return UNMETERED_ONLY;
        }
        if (i == 2) {
            return UNMETERED_OR_DAILY;
        }
        if (i == 3) {
            return FAST_IF_RADIO_AWAKE;
        }
        if (i != 4) {
            return null;
        }
        return NEVER;
    }

    public final int getNumber() {
        return this.value;
    }
}
