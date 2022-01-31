package app.zophop.models;

public class OAuthDetails {
    private final long _absoluteExpiryTimeMillis;
    private final String _accessToken;
    private final String _refreshToken;
    private final long _validityDurationMillis;

    public OAuthDetails(String str, String str2, long j, long j2) {
        this._accessToken = str;
        this._refreshToken = str2;
        this._absoluteExpiryTimeMillis = j;
        this._validityDurationMillis = j2;
    }

    public long getAbsoluteExpiryTimeMillis() {
        return this._absoluteExpiryTimeMillis;
    }

    public String getAccessToken() {
        return this._accessToken;
    }

    public String getRefreshToken() {
        return this._refreshToken;
    }

    public long getValidityDurationMillis() {
        return this._validityDurationMillis;
    }
}
