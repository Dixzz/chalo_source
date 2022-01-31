package defpackage;

import com.google.firebase.appindexing.Indexable;
import com.razorpay.BaseConstants;
import com.truecaller.android.sdk.TrueException;
import java.util.Locale;

/* renamed from: xn6  reason: default package */
/* compiled from: GifError */
public enum xn6 {
    NO_ERROR(0, "No error"),
    OPEN_FAILED(101, "Failed to open given input"),
    READ_FAILED(102, "Failed to read from given input"),
    NOT_GIF_FILE(103, "Data is not in GIF format"),
    NO_SCRN_DSCR(104, "No screen descriptor detected"),
    NO_IMAG_DSCR(105, "No image descriptor detected"),
    NO_COLOR_MAP(106, "Neither global nor local color map found"),
    WRONG_RECORD(107, "Wrong record type detected"),
    DATA_TOO_BIG(108, "Number of pixels bigger than width * height"),
    NOT_ENOUGH_MEM(109, "Failed to allocate required memory"),
    CLOSE_FAILED(110, "Failed to close given input"),
    NOT_READABLE(111, "Given file was not opened for read"),
    IMAGE_DEFECT(112, "Image is defective, decoding aborted"),
    EOF_TOO_SOON(113, "Image EOF detected before image complete"),
    NO_FRAMES(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, "No frames found, at least one frame required"),
    INVALID_SCR_DIMS(BaseConstants.SMS_CONSENT_REQUEST, "Invalid screen size, dimensions must be positive"),
    INVALID_IMG_DIMS(1002, "Invalid image size, dimensions must be positive"),
    IMG_NOT_CONFINED(1003, "Image size exceeds screen size"),
    REWIND_FAILED(1004, "Input source rewind failed, animation stopped"),
    INVALID_BYTE_BUFFER(1005, "Invalid and/or indirect byte buffer specified"),
    UNKNOWN(-1, TrueException.TYPE_UNKNOWN_MESSAGE);
    
    public final String description;
    public int errorCode;

    private xn6(int i, String str) {
        this.errorCode = i;
        this.description = str;
    }

    public static xn6 fromCode(int i) {
        xn6[] values = values();
        for (int i2 = 0; i2 < 21; i2++) {
            xn6 xn6 = values[i2];
            if (xn6.errorCode == i) {
                return xn6;
            }
        }
        xn6 xn62 = UNKNOWN;
        xn62.errorCode = i;
        return xn62;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFormattedDescription() {
        return String.format(Locale.ENGLISH, "GifError %d: %s", Integer.valueOf(this.errorCode), this.description);
    }
}
