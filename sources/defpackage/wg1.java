package defpackage;

/* renamed from: wg1  reason: default package */
/* compiled from: FontUtils */
public enum wg1 {
    NOTOSANS_MEDIUM("fonts/NotoSans-SemiBold.ttf"),
    NOTOSANS_REGULAR("fonts/NotoSans-Regular.ttf"),
    NOTOSANS_BOLD("fonts/NotoSans-Bold.ttf");
    
    private String _fontPath;

    private wg1(String str) {
        this._fontPath = str;
    }

    public String toString() {
        return this._fontPath;
    }
}
