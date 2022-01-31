package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProofDocumentProps;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: d61  reason: default package */
/* compiled from: SuperPassUserProofUploadFragmentArgs */
public class d61 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f796a = new HashMap();

    public static d61 fromBundle(Bundle bundle) {
        d61 d61 = new d61();
        bundle.setClassLoader(d61.class.getClassLoader());
        if (!bundle.containsKey("arg_proof_document_props")) {
            throw new IllegalArgumentException("Required argument \"arg_proof_document_props\" is missing and does not have an android:defaultValue");
        } else if (Parcelable.class.isAssignableFrom(ProofDocumentProps.class) || Serializable.class.isAssignableFrom(ProofDocumentProps.class)) {
            ProofDocumentProps proofDocumentProps = (ProofDocumentProps) bundle.get("arg_proof_document_props");
            if (proofDocumentProps != null) {
                d61.f796a.put("arg_proof_document_props", proofDocumentProps);
                return d61;
            }
            throw new IllegalArgumentException("Argument \"arg_proof_document_props\" is marked as non-null but was passed a null value.");
        } else {
            throw new UnsupportedOperationException(hj1.G(ProofDocumentProps.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
        }
    }

    public ProofDocumentProps a() {
        return (ProofDocumentProps) this.f796a.get("arg_proof_document_props");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d61.class != obj.getClass()) {
            return false;
        }
        d61 d61 = (d61) obj;
        if (this.f796a.containsKey("arg_proof_document_props") != d61.f796a.containsKey("arg_proof_document_props")) {
            return false;
        }
        return a() == null ? d61.a() == null : a().equals(d61.a());
    }

    public int hashCode() {
        return 31 + (a() != null ? a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassUserProofUploadFragmentArgs{argProofDocumentProps=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
