package app.zophop.models.mTicketing;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

public class UserImages {
    private final Bitmap _profilePic;
    private List<ProofImageInfo> _proofImageInfos = new ArrayList();

    public UserImages(Bitmap bitmap, List<ProofImageInfo> list) {
        this._profilePic = bitmap;
        this._proofImageInfos = list;
    }

    public Bitmap getProfilePic() {
        return this._profilePic;
    }

    public List<ProofImageInfo> getProofImages() {
        return this._proofImageInfos;
    }
}
