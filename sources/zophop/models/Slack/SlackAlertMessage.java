package zophop.models.Slack;

public class SlackAlertMessage {
    private String _channelName;
    private String _color = "#ff0000";
    private String _iconEmoji = "slack";
    private long _timeStamp;
    private String _title;
    private String _userName;

    public SlackAlertMessage(String str, String str2, String str3, Long l) {
        this._channelName = hj1.S("#", str);
        this._userName = str2;
        this._title = str3;
        this._timeStamp = l.longValue();
    }

    public String getChannelName() {
        return this._channelName;
    }

    public String getColor() {
        return this._color;
    }

    public String getIconEmoji() {
        return this._iconEmoji;
    }

    public long getTimeStamp() {
        return this._timeStamp;
    }

    public String getTitle() {
        return this._title;
    }

    public String getUserName() {
        return this._userName;
    }
}
