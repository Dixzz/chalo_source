package zophop.models.Slack;

public class SlackMessage {
    private String _channelName;
    private String _iconEmoji = "slack";
    private String _text;
    private String _userName;

    public SlackMessage(String str, String str2, String str3) {
        this._channelName = hj1.S("#", str);
        this._userName = str2;
        this._text = str3;
    }

    public String getChannelName() {
        return this._channelName;
    }

    public String getIconEmoji() {
        return this._iconEmoji;
    }

    public String getText() {
        return this._text;
    }

    public String getUserName() {
        return this._userName;
    }
}
