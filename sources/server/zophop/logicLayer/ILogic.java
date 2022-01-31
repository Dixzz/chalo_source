package server.zophop.logicLayer;

import server.zophop.models.Point;
import server.zophop.models.Stream;
import server.zophop.models.StreamMeta;
import server.zophop.models.StreamStatus;

public interface ILogic {
    Stream addMeta(String str, Point point, StreamMeta streamMeta, String str2, String str3);

    void addPoint(String str, Point point, String str2);

    void addStream(Stream stream);

    void changeStreamStatus(String str, StreamStatus streamStatus, String str2);

    void removeStream(String str, String str2);
}
