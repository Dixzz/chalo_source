package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

public final class AutoValue_TokenResult extends TokenResult {
    private final TokenResult.ResponseCode responseCode;
    private final String token;
    private final long tokenExpirationTimestamp;

    public static final class Builder extends TokenResult.Builder {
        private TokenResult.ResponseCode responseCode;
        private String token;
        private Long tokenExpirationTimestamp;

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult build() {
            String str = this.tokenExpirationTimestamp == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode);
            }
            throw new IllegalStateException(hj1.S("Missing required properties:", str));
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode2) {
            this.responseCode = responseCode2;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setToken(String str) {
            this.token = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.tokenExpirationTimestamp = Long.valueOf(j);
            return this;
        }

        public Builder() {
        }

        private Builder(TokenResult tokenResult) {
            this.token = tokenResult.getToken();
            this.tokenExpirationTimestamp = Long.valueOf(tokenResult.getTokenExpirationTimestamp());
            this.responseCode = tokenResult.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.token;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.tokenExpirationTimestamp == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode2 = this.responseCode;
                if (responseCode2 == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode2.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public int hashCode() {
        String str = this.token;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode2 = this.responseCode;
        if (responseCode2 != null) {
            i = responseCode2.hashCode();
        }
        return i2 ^ i;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TokenResult{token=");
        i0.append(this.token);
        i0.append(", tokenExpirationTimestamp=");
        i0.append(this.tokenExpirationTimestamp);
        i0.append(", responseCode=");
        i0.append(this.responseCode);
        i0.append("}");
        return i0.toString();
    }

    private AutoValue_TokenResult(String str, long j, TokenResult.ResponseCode responseCode2) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = responseCode2;
    }
}
