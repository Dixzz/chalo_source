package server.zophop.models;

public class HTTPResponse {
    private int _code;
    private String _message;

    public HTTPResponse(int i, String str) {
        this._code = i;
        this._message = str;
    }

    public int code() {
        return this._code;
    }

    public String responseBody() {
        return this._message;
    }
}
