package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProofDocumentProps;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: lx0  reason: default package */
/* compiled from: UserProofUploadFragmentArgs */
public class lx0 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2287a = new HashMap();

    public static lx0 fromBundle(Bundle bundle) {
        lx0 lx0 = new lx0();
        bundle.setClassLoader(lx0.class.getClassLoader());
        if (!bundle.containsKey("arg_proof_document_props")) {
            throw new IllegalArgumentException("Required argument \"arg_proof_document_props\" is missing and does not have an android:defaultValue");
        } else if (Parcelable.class.isAssignableFrom(ProofDocumentProps.class) || Serializable.class.isAssignableFrom(ProofDocumentProps.class)) {
            ProofDocumentProps proofDocumentProps = (ProofDocumentProps) bundle.get("arg_proof_document_props");
            if (proofDocumentProps != null) {
                lx0.f2287a.put("arg_proof_document_props", proofDocumentProps);
                return lx0;
            }
            throw new IllegalArgumentException("Argument \"arg_proof_document_props\" is marked as non-null but was passed a null value.");
        } else {
            throw new UnsupportedOperationException(hj1.G(ProofDocumentProps.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
        }
    }

    public ProofDocumentProps a() {
        return (ProofDocumentProps) this.f2287a.get("arg_proof_document_props");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lx0.class != obj.getClass()) {
            return false;
        }
        lx0 lx0 = (lx0) obj;
        if (this.f2287a.containsKey("arg_proof_document_props") != lx0.f2287a.containsKey("arg_proof_document_props")) {
            return false;
        }
        return a() == null ? lx0.a() == null : a().equals(lx0.a());
    }

    public int hashCode() {
        return 31 + (a() != null ? a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("UserProofUploadFragmentArgs{argProofDocumentProps=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
