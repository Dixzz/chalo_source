package defpackage;

import java.util.List;

/* renamed from: s25  reason: default package */
/* compiled from: DecodeHintType */
public enum s25 {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(h35.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);
    
    private final Class<?> valueType;

    private s25(Class cls) {
        this.valueType = cls;
    }

    public Class<?> getValueType() {
        return this.valueType;
    }
}
