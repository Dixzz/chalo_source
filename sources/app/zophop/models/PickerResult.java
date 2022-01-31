package app.zophop.models;

import com.google.gson.Gson;

public class PickerResult {
    public final Object data;
    public final PickerResultType resultType;

    public PickerResult(PickerResultType pickerResultType, Object obj) {
        this.resultType = pickerResultType;
        this.data = obj;
    }

    public static PickerResult fromJson(String str) {
        return (PickerResult) hj1.s(str, PickerResult.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
