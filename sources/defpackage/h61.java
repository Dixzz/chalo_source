package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.R;
import app.zophop.models.mTicketing.ProofDocumentProps;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: h61  reason: default package */
/* compiled from: SuperPassUserProofsOverviewFragmentDirections */
public class h61 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1342a;

    public h61(ProofDocumentProps proofDocumentProps, g61 g61) {
        HashMap hashMap = new HashMap();
        this.f1342a = hashMap;
        if (proofDocumentProps != null) {
            hashMap.put("arg_proof_document_props", proofDocumentProps);
            return;
        }
        throw new IllegalArgumentException("Argument \"arg_proof_document_props\" is marked as non-null but was passed a null value.");
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_superPassUserProofsOverviewFragment_to_superPassUserProofUploadFragment;
    }

    public ProofDocumentProps b() {
        return (ProofDocumentProps) this.f1342a.get("arg_proof_document_props");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h61.class != obj.getClass()) {
            return false;
        }
        h61 h61 = (h61) obj;
        if (this.f1342a.containsKey("arg_proof_document_props") != h61.f1342a.containsKey("arg_proof_document_props")) {
            return false;
        }
        return b() == null ? h61.b() == null : b().equals(h61.b());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f1342a.containsKey("arg_proof_document_props")) {
            ProofDocumentProps proofDocumentProps = (ProofDocumentProps) this.f1342a.get("arg_proof_document_props");
            if (Parcelable.class.isAssignableFrom(ProofDocumentProps.class) || proofDocumentProps == null) {
                bundle.putParcelable("arg_proof_document_props", (Parcelable) Parcelable.class.cast(proofDocumentProps));
            } else if (Serializable.class.isAssignableFrom(ProofDocumentProps.class)) {
                bundle.putSerializable("arg_proof_document_props", (Serializable) Serializable.class.cast(proofDocumentProps));
            } else {
                throw new UnsupportedOperationException(hj1.G(ProofDocumentProps.class, new StringBuilder(), " must implement Parcelable or Serializable or must be an Enum."));
            }
        }
        return bundle;
    }

    public int hashCode() {
        return hj1.b(b() != null ? b().hashCode() : 0, 31, 31, R.id.action_superPassUserProofsOverviewFragment_to_superPassUserProofUploadFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionSuperPassUserProofsOverviewFragmentToSuperPassUserProofUploadFragment(actionId=", R.id.action_superPassUserProofsOverviewFragment_to_superPassUserProofUploadFragment, "){argProofDocumentProps=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }
}
