package defpackage;

import defpackage.ol1;

/* renamed from: ol1  reason: default package */
/* compiled from: TransitionOptions */
public abstract class ol1<CHILD extends ol1<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public final CHILD a() {
        try {
            return (CHILD) ((ol1) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        try {
            return (ol1) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
