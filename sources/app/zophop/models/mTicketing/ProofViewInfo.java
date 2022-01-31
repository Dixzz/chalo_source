package app.zophop.models.mTicketing;

import android.graphics.Bitmap;

public class ProofViewInfo {
    private boolean _edited = false;
    private Bitmap _image;
    private String _imageUrl;
    private final String _name;
    private String _url;

    public ProofViewInfo(String str) {
        this._name = str;
    }

    public Bitmap getImage() {
        return this._image;
    }

    public String getImageUrl() {
        return this._imageUrl;
    }

    public String getName() {
        return this._name;
    }

    public String getUrl() {
        return this._url;
    }

    public boolean isEdited() {
        return this._edited;
    }

    public void setEdited() {
        this._edited = true;
    }

    public void setImage(Bitmap bitmap) {
        this._image = bitmap;
    }

    public void setImageUrl(String str) {
        this._imageUrl = str;
    }

    public void setUrl(String str) {
        this._url = str;
    }

    public ProofViewInfo(String str, String str2) {
        this._name = str;
        setUrl(str2);
    }
}
