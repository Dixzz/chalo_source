package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

public final class AutoValue_InstallationResponse extends InstallationResponse {
    private final TokenResult authToken;
    private final String fid;
    private final String refreshToken;
    private final InstallationResponse.ResponseCode responseCode;
    private final String uri;

    public static final class Builder extends InstallationResponse.Builder {
        private TokenResult authToken;
        private String fid;
        private String refreshToken;
        private InstallationResponse.ResponseCode responseCode;
        private String uri;

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse build() {
            return new AutoValue_InstallationResponse(this.uri, this.fid, this.refreshToken, this.authToken, this.responseCode);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
            this.authToken = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setFid(String str) {
            this.fid = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setRefreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode2) {
            this.responseCode = responseCode2;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setUri(String str) {
            this.uri = str;
            return this;
        }

        public Builder() {
        }

        private Builder(InstallationResponse installationResponse) {
            this.uri = installationResponse.getUri();
            this.fid = installationResponse.getFid();
            this.refreshToken = installationResponse.getRefreshToken();
            this.authToken = installationResponse.getAuthToken();
            this.responseCode = installationResponse.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.uri;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.fid;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.refreshToken;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.authToken;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode2 = this.responseCode;
                        if (responseCode2 == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode2.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public TokenResult getAuthToken() {
        return this.authToken;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getFid() {
        return this.fid;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public InstallationResponse.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getUri() {
        return this.uri;
    }

    public int hashCode() {
        String str = this.uri;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.fid;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.refreshToken;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.authToken;
        int hashCode4 = (hashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode2 = this.responseCode;
        if (responseCode2 != null) {
            i = responseCode2.hashCode();
        }
        return hashCode4 ^ i;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public InstallationResponse.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("InstallationResponse{uri=");
        i0.append(this.uri);
        i0.append(", fid=");
        i0.append(this.fid);
        i0.append(", refreshToken=");
        i0.append(this.refreshToken);
        i0.append(", authToken=");
        i0.append(this.authToken);
        i0.append(", responseCode=");
        i0.append(this.responseCode);
        i0.append("}");
        return i0.toString();
    }

    private AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode2) {
        this.uri = str;
        this.fid = str2;
        this.refreshToken = str3;
        this.authToken = tokenResult;
        this.responseCode = responseCode2;
    }
}
