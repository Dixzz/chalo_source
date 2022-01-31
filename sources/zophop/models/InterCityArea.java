package zophop.models;

public enum InterCityArea {
    UP,
    UTTARPRADESH;

    public static boolean isIntercity(String str) {
        InterCityArea[] values = values();
        for (int i = 0; i < 2; i++) {
            if (values[i].toString().toLowerCase().equals(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
