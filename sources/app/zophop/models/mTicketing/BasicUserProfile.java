package app.zophop.models.mTicketing;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class BasicUserProfile implements Parcelable {
    public static final Parcelable.Creator<BasicUserProfile> CREATOR = new Parcelable.Creator<BasicUserProfile>() {
        /* class app.zophop.models.mTicketing.BasicUserProfile.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public BasicUserProfile createFromParcel(Parcel parcel) {
            return new BasicUserProfile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BasicUserProfile[] newArray(int i) {
            return new BasicUserProfile[i];
        }
    };
    private final BasicProfileFields _fields;
    private Bitmap _profilePic;
    private String _profilePicUrl;

    public BasicUserProfile(BasicProfileFields basicProfileFields) {
        this._fields = basicProfileFields;
    }

    public int describeContents() {
        return 0;
    }

    public String fetchProfilePicUrl() {
        return this._profilePicUrl;
    }

    public BasicProfileFields getFields() {
        return this._fields;
    }

    public Bitmap getProfilePic() {
        return this._profilePic;
    }

    public String getProfileUrl(Context context) {
        String str = this._profilePicUrl;
        if (str != null && str.startsWith("https://s3")) {
            return this._profilePicUrl;
        }
        Bitmap bitmap = this._profilePic;
        return bitmap != null ? vn.q(bitmap) : "";
    }

    public String getRawProfilePic(Context context) {
        return vn.q(this._profilePic);
    }

    public boolean hasProfilePic() {
        return this._profilePic != null;
    }

    public boolean hasProfilePicUrl() {
        return this._profilePicUrl != null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this._fields);
        parcel.writeValue(this._profilePic);
        parcel.writeString(this._profilePicUrl);
    }

    public BasicUserProfile(BasicProfileFields basicProfileFields, Bitmap bitmap) {
        this._profilePic = bitmap;
        this._fields = basicProfileFields;
    }

    public BasicUserProfile(BasicProfileFields basicProfileFields, Bitmap bitmap, String str) {
        this._profilePic = bitmap;
        this._fields = basicProfileFields;
        this._profilePicUrl = str;
    }

    public BasicUserProfile(BasicProfileFields basicProfileFields, String str) {
        this._profilePicUrl = str;
        this._fields = basicProfileFields;
    }

    public BasicUserProfile(Parcel parcel) {
        this._fields = (BasicProfileFields) parcel.readValue(BasicProfileFields.class.getClassLoader());
        this._profilePic = (Bitmap) parcel.readValue(Bitmap.class.getClassLoader());
        this._profilePicUrl = parcel.readString();
    }
}
