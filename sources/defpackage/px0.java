package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.R;
import app.zophop.models.mTicketing.ProofDocumentProps;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: px0  reason: default package */
/* compiled from: UserProofsOverviewFragmentDirections */
public class px0 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2865a;

    public px0(ProofDocumentProps proofDocumentProps, ox0 ox0) {
        HashMap hashMap = new HashMap();
        this.f2865a = hashMap;
        if (proofDocumentProps != null) {
            hashMap.put("arg_proof_document_props", proofDocumentProps);
            return;
        }
        throw new IllegalArgumentException("Argument \"arg_proof_document_props\" is marked as non-null but was passed a null value.");
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_userProofsOverviewFragment_to_userProofUploadFragment;
    }

    public ProofDocumentProps b() {
        return (ProofDocumentProps) this.f2865a.get("arg_proof_document_props");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || px0.class != obj.getClass()) {
            return false;
        }
        px0 px0 = (px0) obj;
        if (this.f2865a.containsKey("arg_proof_document_props") != px0.f2865a.containsKey("arg_proof_document_props")) {
            return false;
        }
        return b() == null ? px0.b() == null : b().equals(px0.b());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f2865a.containsKey("arg_proof_document_props")) {
            ProofDocumentProps proofDocumentProps = (ProofDocumentProps) this.f2865a.get("arg_proof_document_props");
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
        return hj1.b(b() != null ? b().hashCode() : 0, 31, 31, R.id.action_userProofsOverviewFragment_to_userProofUploadFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionUserProofsOverviewFragmentToUserProofUploadFragment(actionId=", R.id.action_userProofsOverviewFragment_to_userProofUploadFragment, "){argProofDocumentProps=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }
}
