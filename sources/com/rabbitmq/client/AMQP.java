package com.rabbitmq.client;

import com.rabbitmq.client.impl.AMQBasicProperties;
import com.rabbitmq.client.impl.AMQImpl;
import com.rabbitmq.client.impl.ContentHeaderPropertyReader;
import com.rabbitmq.client.impl.ContentHeaderPropertyWriter;
import com.rabbitmq.client.impl.LongStringHelper;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface AMQP {
    public static final int ACCESS_REFUSED = 403;
    public static final int CHANNEL_ERROR = 504;
    public static final int COMMAND_INVALID = 503;
    public static final int CONNECTION_FORCED = 320;
    public static final int CONTENT_TOO_LARGE = 311;
    public static final int FRAME_BODY = 3;
    public static final int FRAME_END = 206;
    public static final int FRAME_ERROR = 501;
    public static final int FRAME_HEADER = 2;
    public static final int FRAME_HEARTBEAT = 8;
    public static final int FRAME_METHOD = 1;
    public static final int FRAME_MIN_SIZE = 4096;
    public static final int INTERNAL_ERROR = 541;
    public static final int INVALID_PATH = 402;
    public static final int NOT_ALLOWED = 530;
    public static final int NOT_FOUND = 404;
    public static final int NOT_IMPLEMENTED = 540;
    public static final int NO_CONSUMERS = 313;
    public static final int NO_ROUTE = 312;
    public static final int PRECONDITION_FAILED = 406;
    public static final int REPLY_SUCCESS = 200;
    public static final int RESOURCE_ERROR = 506;
    public static final int RESOURCE_LOCKED = 405;
    public static final int SYNTAX_ERROR = 502;
    public static final int UNEXPECTED_FRAME = 505;

    public static class Access {

        public interface Request extends Method {

            public static final class Builder {
                private boolean active = true;
                private boolean exclusive = false;
                private boolean passive = true;
                private boolean read = true;
                private String realm = "/data";
                private boolean write = true;

                public Builder active(boolean z) {
                    this.active = z;
                    return this;
                }

                public Request build() {
                    return new AMQImpl.Access.Request(this.realm, this.exclusive, this.passive, this.active, this.write, this.read);
                }

                public Builder exclusive(boolean z) {
                    this.exclusive = z;
                    return this;
                }

                public Builder passive(boolean z) {
                    this.passive = z;
                    return this;
                }

                public Builder read(boolean z) {
                    this.read = z;
                    return this;
                }

                public Builder realm(String str) {
                    this.realm = str;
                    return this;
                }

                public Builder write(boolean z) {
                    this.write = z;
                    return this;
                }

                public Builder active() {
                    return active(true);
                }

                public Builder exclusive() {
                    return exclusive(true);
                }

                public Builder passive() {
                    return passive(true);
                }

                public Builder read() {
                    return read(true);
                }

                public Builder write() {
                    return write(true);
                }
            }

            boolean getActive();

            boolean getExclusive();

            boolean getPassive();

            boolean getRead();

            String getRealm();

            boolean getWrite();
        }

        public interface RequestOk extends Method {

            public static final class Builder {
                private int ticket = 1;

                public RequestOk build() {
                    return new AMQImpl.Access.RequestOk(this.ticket);
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }
            }

            int getTicket();
        }
    }

    public static class Basic {

        public interface Ack extends Method {

            public static final class Builder {
                private long deliveryTag = 0;
                private boolean multiple = false;

                public Ack build() {
                    return new AMQImpl.Basic.Ack(this.deliveryTag, this.multiple);
                }

                public Builder deliveryTag(long j) {
                    this.deliveryTag = j;
                    return this;
                }

                public Builder multiple(boolean z) {
                    this.multiple = z;
                    return this;
                }

                public Builder multiple() {
                    return multiple(true);
                }
            }

            long getDeliveryTag();

            boolean getMultiple();
        }

        public interface Cancel extends Method {

            public static final class Builder {
                private String consumerTag;
                private boolean nowait = false;

                public Cancel build() {
                    return new AMQImpl.Basic.Cancel(this.consumerTag, this.nowait);
                }

                public Builder consumerTag(String str) {
                    this.consumerTag = str;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            String getConsumerTag();

            boolean getNowait();
        }

        public interface CancelOk extends Method {

            public static final class Builder {
                private String consumerTag;

                public CancelOk build() {
                    return new AMQImpl.Basic.CancelOk(this.consumerTag);
                }

                public Builder consumerTag(String str) {
                    this.consumerTag = str;
                    return this;
                }
            }

            String getConsumerTag();
        }

        public interface Consume extends Method {

            public static final class Builder {
                private Map<String, Object> arguments = null;
                private String consumerTag = "";
                private boolean exclusive = false;
                private boolean noAck = false;
                private boolean noLocal = false;
                private boolean nowait = false;
                private String queue = "";
                private int ticket = 0;

                public Builder arguments(Map<String, Object> map) {
                    this.arguments = map;
                    return this;
                }

                public Consume build() {
                    return new AMQImpl.Basic.Consume(this.ticket, this.queue, this.consumerTag, this.noLocal, this.noAck, this.exclusive, this.nowait, this.arguments);
                }

                public Builder consumerTag(String str) {
                    this.consumerTag = str;
                    return this;
                }

                public Builder exclusive(boolean z) {
                    this.exclusive = z;
                    return this;
                }

                public Builder noAck(boolean z) {
                    this.noAck = z;
                    return this;
                }

                public Builder noLocal(boolean z) {
                    this.noLocal = z;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder queue(String str) {
                    this.queue = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder exclusive() {
                    return exclusive(true);
                }

                public Builder noAck() {
                    return noAck(true);
                }

                public Builder noLocal() {
                    return noLocal(true);
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            Map<String, Object> getArguments();

            String getConsumerTag();

            boolean getExclusive();

            boolean getNoAck();

            boolean getNoLocal();

            boolean getNowait();

            String getQueue();

            int getTicket();
        }

        public interface ConsumeOk extends Method {

            public static final class Builder {
                private String consumerTag;

                public ConsumeOk build() {
                    return new AMQImpl.Basic.ConsumeOk(this.consumerTag);
                }

                public Builder consumerTag(String str) {
                    this.consumerTag = str;
                    return this;
                }
            }

            String getConsumerTag();
        }

        public interface Deliver extends Method {

            public static final class Builder {
                private String consumerTag;
                private long deliveryTag;
                private String exchange;
                private boolean redelivered = false;
                private String routingKey;

                public Deliver build() {
                    return new AMQImpl.Basic.Deliver(this.consumerTag, this.deliveryTag, this.redelivered, this.exchange, this.routingKey);
                }

                public Builder consumerTag(String str) {
                    this.consumerTag = str;
                    return this;
                }

                public Builder deliveryTag(long j) {
                    this.deliveryTag = j;
                    return this;
                }

                public Builder exchange(String str) {
                    this.exchange = str;
                    return this;
                }

                public Builder redelivered(boolean z) {
                    this.redelivered = z;
                    return this;
                }

                public Builder routingKey(String str) {
                    this.routingKey = str;
                    return this;
                }

                public Builder redelivered() {
                    return redelivered(true);
                }
            }

            String getConsumerTag();

            long getDeliveryTag();

            String getExchange();

            boolean getRedelivered();

            String getRoutingKey();
        }

        public interface Get extends Method {

            public static final class Builder {
                private boolean noAck = false;
                private String queue = "";
                private int ticket = 0;

                public Get build() {
                    return new AMQImpl.Basic.Get(this.ticket, this.queue, this.noAck);
                }

                public Builder noAck(boolean z) {
                    this.noAck = z;
                    return this;
                }

                public Builder queue(String str) {
                    this.queue = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder noAck() {
                    return noAck(true);
                }
            }

            boolean getNoAck();

            String getQueue();

            int getTicket();
        }

        public interface GetEmpty extends Method {

            public static final class Builder {
                private String clusterId = "";

                public GetEmpty build() {
                    return new AMQImpl.Basic.GetEmpty(this.clusterId);
                }

                public Builder clusterId(String str) {
                    this.clusterId = str;
                    return this;
                }
            }

            String getClusterId();
        }

        public interface GetOk extends Method {

            public static final class Builder {
                private long deliveryTag;
                private String exchange;
                private int messageCount;
                private boolean redelivered = false;
                private String routingKey;

                public GetOk build() {
                    return new AMQImpl.Basic.GetOk(this.deliveryTag, this.redelivered, this.exchange, this.routingKey, this.messageCount);
                }

                public Builder deliveryTag(long j) {
                    this.deliveryTag = j;
                    return this;
                }

                public Builder exchange(String str) {
                    this.exchange = str;
                    return this;
                }

                public Builder messageCount(int i) {
                    this.messageCount = i;
                    return this;
                }

                public Builder redelivered(boolean z) {
                    this.redelivered = z;
                    return this;
                }

                public Builder routingKey(String str) {
                    this.routingKey = str;
                    return this;
                }

                public Builder redelivered() {
                    return redelivered(true);
                }
            }

            long getDeliveryTag();

            String getExchange();

            int getMessageCount();

            boolean getRedelivered();

            String getRoutingKey();
        }

        public interface Nack extends Method {

            public static final class Builder {
                private long deliveryTag = 0;
                private boolean multiple = false;
                private boolean requeue = true;

                public Nack build() {
                    return new AMQImpl.Basic.Nack(this.deliveryTag, this.multiple, this.requeue);
                }

                public Builder deliveryTag(long j) {
                    this.deliveryTag = j;
                    return this;
                }

                public Builder multiple(boolean z) {
                    this.multiple = z;
                    return this;
                }

                public Builder requeue(boolean z) {
                    this.requeue = z;
                    return this;
                }

                public Builder multiple() {
                    return multiple(true);
                }

                public Builder requeue() {
                    return requeue(true);
                }
            }

            long getDeliveryTag();

            boolean getMultiple();

            boolean getRequeue();
        }

        public interface Publish extends Method {

            public static final class Builder {
                private String exchange = "";
                private boolean immediate = false;
                private boolean mandatory = false;
                private String routingKey = "";
                private int ticket = 0;

                public Publish build() {
                    return new AMQImpl.Basic.Publish(this.ticket, this.exchange, this.routingKey, this.mandatory, this.immediate);
                }

                public Builder exchange(String str) {
                    this.exchange = str;
                    return this;
                }

                public Builder immediate(boolean z) {
                    this.immediate = z;
                    return this;
                }

                public Builder mandatory(boolean z) {
                    this.mandatory = z;
                    return this;
                }

                public Builder routingKey(String str) {
                    this.routingKey = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder immediate() {
                    return immediate(true);
                }

                public Builder mandatory() {
                    return mandatory(true);
                }
            }

            String getExchange();

            boolean getImmediate();

            boolean getMandatory();

            String getRoutingKey();

            int getTicket();
        }

        public interface Qos extends Method {

            public static final class Builder {
                private boolean global = false;
                private int prefetchCount = 0;
                private int prefetchSize = 0;

                public Qos build() {
                    return new AMQImpl.Basic.Qos(this.prefetchSize, this.prefetchCount, this.global);
                }

                public Builder global(boolean z) {
                    this.global = z;
                    return this;
                }

                public Builder prefetchCount(int i) {
                    this.prefetchCount = i;
                    return this;
                }

                public Builder prefetchSize(int i) {
                    this.prefetchSize = i;
                    return this;
                }

                public Builder global() {
                    return global(true);
                }
            }

            boolean getGlobal();

            int getPrefetchCount();

            int getPrefetchSize();
        }

        public interface QosOk extends Method {

            public static final class Builder {
                public QosOk build() {
                    return new AMQImpl.Basic.QosOk();
                }
            }
        }

        public interface Recover extends Method {

            public static final class Builder {
                private boolean requeue = false;

                public Recover build() {
                    return new AMQImpl.Basic.Recover(this.requeue);
                }

                public Builder requeue(boolean z) {
                    this.requeue = z;
                    return this;
                }

                public Builder requeue() {
                    return requeue(true);
                }
            }

            boolean getRequeue();
        }

        public interface RecoverAsync extends Method {

            public static final class Builder {
                private boolean requeue = false;

                public RecoverAsync build() {
                    return new AMQImpl.Basic.RecoverAsync(this.requeue);
                }

                public Builder requeue(boolean z) {
                    this.requeue = z;
                    return this;
                }

                public Builder requeue() {
                    return requeue(true);
                }
            }

            boolean getRequeue();
        }

        public interface RecoverOk extends Method {

            public static final class Builder {
                public RecoverOk build() {
                    return new AMQImpl.Basic.RecoverOk();
                }
            }
        }

        public interface Reject extends Method {

            public static final class Builder {
                private long deliveryTag;
                private boolean requeue = true;

                public Reject build() {
                    return new AMQImpl.Basic.Reject(this.deliveryTag, this.requeue);
                }

                public Builder deliveryTag(long j) {
                    this.deliveryTag = j;
                    return this;
                }

                public Builder requeue(boolean z) {
                    this.requeue = z;
                    return this;
                }

                public Builder requeue() {
                    return requeue(true);
                }
            }

            long getDeliveryTag();

            boolean getRequeue();
        }

        public interface Return extends Method {

            public static final class Builder {
                private String exchange;
                private int replyCode;
                private String replyText = "";
                private String routingKey;

                public Return build() {
                    return new AMQImpl.Basic.Return(this.replyCode, this.replyText, this.exchange, this.routingKey);
                }

                public Builder exchange(String str) {
                    this.exchange = str;
                    return this;
                }

                public Builder replyCode(int i) {
                    this.replyCode = i;
                    return this;
                }

                public Builder replyText(String str) {
                    this.replyText = str;
                    return this;
                }

                public Builder routingKey(String str) {
                    this.routingKey = str;
                    return this;
                }
            }

            String getExchange();

            int getReplyCode();

            String getReplyText();

            String getRoutingKey();
        }
    }

    public static class Channel {

        public interface Close extends Method {

            public static final class Builder {
                private int classId;
                private int methodId;
                private int replyCode;
                private String replyText = "";

                public Close build() {
                    return new AMQImpl.Channel.Close(this.replyCode, this.replyText, this.classId, this.methodId);
                }

                public Builder classId(int i) {
                    this.classId = i;
                    return this;
                }

                public Builder methodId(int i) {
                    this.methodId = i;
                    return this;
                }

                public Builder replyCode(int i) {
                    this.replyCode = i;
                    return this;
                }

                public Builder replyText(String str) {
                    this.replyText = str;
                    return this;
                }
            }

            int getClassId();

            int getMethodId();

            int getReplyCode();

            String getReplyText();
        }

        public interface CloseOk extends Method {

            public static final class Builder {
                public CloseOk build() {
                    return new AMQImpl.Channel.CloseOk();
                }
            }
        }

        public interface Flow extends Method {

            public static final class Builder {
                private boolean active;

                public Builder active(boolean z) {
                    this.active = z;
                    return this;
                }

                public Flow build() {
                    return new AMQImpl.Channel.Flow(this.active);
                }

                public Builder active() {
                    return active(true);
                }
            }

            boolean getActive();
        }

        public interface FlowOk extends Method {

            public static final class Builder {
                private boolean active;

                public Builder active(boolean z) {
                    this.active = z;
                    return this;
                }

                public FlowOk build() {
                    return new AMQImpl.Channel.FlowOk(this.active);
                }

                public Builder active() {
                    return active(true);
                }
            }

            boolean getActive();
        }

        public interface Open extends Method {

            public static final class Builder {
                private String outOfBand = "";

                public Open build() {
                    return new AMQImpl.Channel.Open(this.outOfBand);
                }

                public Builder outOfBand(String str) {
                    this.outOfBand = str;
                    return this;
                }
            }

            String getOutOfBand();
        }

        public interface OpenOk extends Method {

            public static final class Builder {
                private LongString channelId = LongStringHelper.asLongString("");

                public OpenOk build() {
                    return new AMQImpl.Channel.OpenOk(this.channelId);
                }

                public Builder channelId(LongString longString) {
                    this.channelId = longString;
                    return this;
                }

                public Builder channelId(String str) {
                    return channelId(LongStringHelper.asLongString(str));
                }
            }

            LongString getChannelId();
        }
    }

    public static class Confirm {

        public interface Select extends Method {

            public static final class Builder {
                private boolean nowait = false;

                public Select build() {
                    return new AMQImpl.Confirm.Select(this.nowait);
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            boolean getNowait();
        }

        public interface SelectOk extends Method {

            public static final class Builder {
                public SelectOk build() {
                    return new AMQImpl.Confirm.SelectOk();
                }
            }
        }
    }

    public static class Connection {

        public interface Blocked extends Method {

            public static final class Builder {
                private String reason = "";

                public Blocked build() {
                    return new AMQImpl.Connection.Blocked(this.reason);
                }

                public Builder reason(String str) {
                    this.reason = str;
                    return this;
                }
            }

            String getReason();
        }

        public interface Close extends Method {

            public static final class Builder {
                private int classId;
                private int methodId;
                private int replyCode;
                private String replyText = "";

                public Close build() {
                    return new AMQImpl.Connection.Close(this.replyCode, this.replyText, this.classId, this.methodId);
                }

                public Builder classId(int i) {
                    this.classId = i;
                    return this;
                }

                public Builder methodId(int i) {
                    this.methodId = i;
                    return this;
                }

                public Builder replyCode(int i) {
                    this.replyCode = i;
                    return this;
                }

                public Builder replyText(String str) {
                    this.replyText = str;
                    return this;
                }
            }

            int getClassId();

            int getMethodId();

            int getReplyCode();

            String getReplyText();
        }

        public interface CloseOk extends Method {

            public static final class Builder {
                public CloseOk build() {
                    return new AMQImpl.Connection.CloseOk();
                }
            }
        }

        public interface Open extends Method {

            public static final class Builder {
                private String capabilities = "";
                private boolean insist = false;
                private String virtualHost = ConnectionFactory.DEFAULT_VHOST;

                public Open build() {
                    return new AMQImpl.Connection.Open(this.virtualHost, this.capabilities, this.insist);
                }

                public Builder capabilities(String str) {
                    this.capabilities = str;
                    return this;
                }

                public Builder insist(boolean z) {
                    this.insist = z;
                    return this;
                }

                public Builder virtualHost(String str) {
                    this.virtualHost = str;
                    return this;
                }

                public Builder insist() {
                    return insist(true);
                }
            }

            String getCapabilities();

            boolean getInsist();

            String getVirtualHost();
        }

        public interface OpenOk extends Method {

            public static final class Builder {
                private String knownHosts = "";

                public OpenOk build() {
                    return new AMQImpl.Connection.OpenOk(this.knownHosts);
                }

                public Builder knownHosts(String str) {
                    this.knownHosts = str;
                    return this;
                }
            }

            String getKnownHosts();
        }

        public interface Secure extends Method {

            public static final class Builder {
                private LongString challenge;

                public Secure build() {
                    return new AMQImpl.Connection.Secure(this.challenge);
                }

                public Builder challenge(LongString longString) {
                    this.challenge = longString;
                    return this;
                }

                public Builder challenge(String str) {
                    return challenge(LongStringHelper.asLongString(str));
                }
            }

            LongString getChallenge();
        }

        public interface SecureOk extends Method {

            public static final class Builder {
                private LongString response;

                public SecureOk build() {
                    return new AMQImpl.Connection.SecureOk(this.response);
                }

                public Builder response(LongString longString) {
                    this.response = longString;
                    return this;
                }

                public Builder response(String str) {
                    return response(LongStringHelper.asLongString(str));
                }
            }

            LongString getResponse();
        }

        public interface Start extends Method {

            public static final class Builder {
                private LongString locales = LongStringHelper.asLongString("en_US");
                private LongString mechanisms = LongStringHelper.asLongString("PLAIN");
                private Map<String, Object> serverProperties;
                private int versionMajor = 0;
                private int versionMinor = 9;

                public Start build() {
                    return new AMQImpl.Connection.Start(this.versionMajor, this.versionMinor, this.serverProperties, this.mechanisms, this.locales);
                }

                public Builder locales(LongString longString) {
                    this.locales = longString;
                    return this;
                }

                public Builder mechanisms(LongString longString) {
                    this.mechanisms = longString;
                    return this;
                }

                public Builder serverProperties(Map<String, Object> map) {
                    this.serverProperties = map;
                    return this;
                }

                public Builder versionMajor(int i) {
                    this.versionMajor = i;
                    return this;
                }

                public Builder versionMinor(int i) {
                    this.versionMinor = i;
                    return this;
                }

                public Builder locales(String str) {
                    return locales(LongStringHelper.asLongString(str));
                }

                public Builder mechanisms(String str) {
                    return mechanisms(LongStringHelper.asLongString(str));
                }
            }

            LongString getLocales();

            LongString getMechanisms();

            Map<String, Object> getServerProperties();

            int getVersionMajor();

            int getVersionMinor();
        }

        public interface StartOk extends Method {

            public static final class Builder {
                private Map<String, Object> clientProperties;
                private String locale = "en_US";
                private String mechanism = "PLAIN";
                private LongString response;

                public StartOk build() {
                    return new AMQImpl.Connection.StartOk(this.clientProperties, this.mechanism, this.response, this.locale);
                }

                public Builder clientProperties(Map<String, Object> map) {
                    this.clientProperties = map;
                    return this;
                }

                public Builder locale(String str) {
                    this.locale = str;
                    return this;
                }

                public Builder mechanism(String str) {
                    this.mechanism = str;
                    return this;
                }

                public Builder response(LongString longString) {
                    this.response = longString;
                    return this;
                }

                public Builder response(String str) {
                    return response(LongStringHelper.asLongString(str));
                }
            }

            Map<String, Object> getClientProperties();

            String getLocale();

            String getMechanism();

            LongString getResponse();
        }

        public interface Tune extends Method {

            public static final class Builder {
                private int channelMax = 0;
                private int frameMax = 0;
                private int heartbeat = 0;

                public Tune build() {
                    return new AMQImpl.Connection.Tune(this.channelMax, this.frameMax, this.heartbeat);
                }

                public Builder channelMax(int i) {
                    this.channelMax = i;
                    return this;
                }

                public Builder frameMax(int i) {
                    this.frameMax = i;
                    return this;
                }

                public Builder heartbeat(int i) {
                    this.heartbeat = i;
                    return this;
                }
            }

            int getChannelMax();

            int getFrameMax();

            int getHeartbeat();
        }

        public interface TuneOk extends Method {

            public static final class Builder {
                private int channelMax = 0;
                private int frameMax = 0;
                private int heartbeat = 0;

                public TuneOk build() {
                    return new AMQImpl.Connection.TuneOk(this.channelMax, this.frameMax, this.heartbeat);
                }

                public Builder channelMax(int i) {
                    this.channelMax = i;
                    return this;
                }

                public Builder frameMax(int i) {
                    this.frameMax = i;
                    return this;
                }

                public Builder heartbeat(int i) {
                    this.heartbeat = i;
                    return this;
                }
            }

            int getChannelMax();

            int getFrameMax();

            int getHeartbeat();
        }

        public interface Unblocked extends Method {

            public static final class Builder {
                public Unblocked build() {
                    return new AMQImpl.Connection.Unblocked();
                }
            }
        }
    }

    public static class Exchange {

        public interface Bind extends Method {

            public static final class Builder {
                private Map<String, Object> arguments = null;
                private String destination;
                private boolean nowait = false;
                private String routingKey = "";
                private String source;
                private int ticket = 0;

                public Builder arguments(Map<String, Object> map) {
                    this.arguments = map;
                    return this;
                }

                public Bind build() {
                    return new AMQImpl.Exchange.Bind(this.ticket, this.destination, this.source, this.routingKey, this.nowait, this.arguments);
                }

                public Builder destination(String str) {
                    this.destination = str;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder routingKey(String str) {
                    this.routingKey = str;
                    return this;
                }

                public Builder source(String str) {
                    this.source = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            Map<String, Object> getArguments();

            String getDestination();

            boolean getNowait();

            String getRoutingKey();

            String getSource();

            int getTicket();
        }

        public interface BindOk extends Method {

            public static final class Builder {
                public BindOk build() {
                    return new AMQImpl.Exchange.BindOk();
                }
            }
        }

        public interface Declare extends Method {

            public static final class Builder {
                private Map<String, Object> arguments = null;
                private boolean autoDelete = false;
                private boolean durable = false;
                private String exchange;
                private boolean internal = false;
                private boolean nowait = false;
                private boolean passive = false;
                private int ticket = 0;
                private String type = "direct";

                public Builder arguments(Map<String, Object> map) {
                    this.arguments = map;
                    return this;
                }

                public Builder autoDelete(boolean z) {
                    this.autoDelete = z;
                    return this;
                }

                public Declare build() {
                    return new AMQImpl.Exchange.Declare(this.ticket, this.exchange, this.type, this.passive, this.durable, this.autoDelete, this.internal, this.nowait, this.arguments);
                }

                public Builder durable(boolean z) {
                    this.durable = z;
                    return this;
                }

                public Builder exchange(String str) {
                    this.exchange = str;
                    return this;
                }

                public Builder internal(boolean z) {
                    this.internal = z;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder passive(boolean z) {
                    this.passive = z;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder type(String str) {
                    this.type = str;
                    return this;
                }

                public Builder autoDelete() {
                    return autoDelete(true);
                }

                public Builder durable() {
                    return durable(true);
                }

                public Builder internal() {
                    return internal(true);
                }

                public Builder nowait() {
                    return nowait(true);
                }

                public Builder passive() {
                    return passive(true);
                }
            }

            Map<String, Object> getArguments();

            boolean getAutoDelete();

            boolean getDurable();

            String getExchange();

            boolean getInternal();

            boolean getNowait();

            boolean getPassive();

            int getTicket();

            String getType();
        }

        public interface DeclareOk extends Method {

            public static final class Builder {
                public DeclareOk build() {
                    return new AMQImpl.Exchange.DeclareOk();
                }
            }
        }

        public interface Delete extends Method {

            public static final class Builder {
                private String exchange;
                private boolean ifUnused = false;
                private boolean nowait = false;
                private int ticket = 0;

                public Delete build() {
                    return new AMQImpl.Exchange.Delete(this.ticket, this.exchange, this.ifUnused, this.nowait);
                }

                public Builder exchange(String str) {
                    this.exchange = str;
                    return this;
                }

                public Builder ifUnused(boolean z) {
                    this.ifUnused = z;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder ifUnused() {
                    return ifUnused(true);
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            String getExchange();

            boolean getIfUnused();

            boolean getNowait();

            int getTicket();
        }

        public interface DeleteOk extends Method {

            public static final class Builder {
                public DeleteOk build() {
                    return new AMQImpl.Exchange.DeleteOk();
                }
            }
        }

        public interface Unbind extends Method {

            public static final class Builder {
                private Map<String, Object> arguments = null;
                private String destination;
                private boolean nowait = false;
                private String routingKey = "";
                private String source;
                private int ticket = 0;

                public Builder arguments(Map<String, Object> map) {
                    this.arguments = map;
                    return this;
                }

                public Unbind build() {
                    return new AMQImpl.Exchange.Unbind(this.ticket, this.destination, this.source, this.routingKey, this.nowait, this.arguments);
                }

                public Builder destination(String str) {
                    this.destination = str;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder routingKey(String str) {
                    this.routingKey = str;
                    return this;
                }

                public Builder source(String str) {
                    this.source = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            Map<String, Object> getArguments();

            String getDestination();

            boolean getNowait();

            String getRoutingKey();

            String getSource();

            int getTicket();
        }

        public interface UnbindOk extends Method {

            public static final class Builder {
                public UnbindOk build() {
                    return new AMQImpl.Exchange.UnbindOk();
                }
            }
        }
    }

    public static class PROTOCOL {
        public static final int MAJOR = 0;
        public static final int MINOR = 9;
        public static final int PORT = 5672;
        public static final int REVISION = 1;
    }

    public static class Queue {

        public interface Bind extends Method {

            public static final class Builder {
                private Map<String, Object> arguments = null;
                private String exchange;
                private boolean nowait = false;
                private String queue = "";
                private String routingKey = "";
                private int ticket = 0;

                public Builder arguments(Map<String, Object> map) {
                    this.arguments = map;
                    return this;
                }

                public Bind build() {
                    return new AMQImpl.Queue.Bind(this.ticket, this.queue, this.exchange, this.routingKey, this.nowait, this.arguments);
                }

                public Builder exchange(String str) {
                    this.exchange = str;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder queue(String str) {
                    this.queue = str;
                    return this;
                }

                public Builder routingKey(String str) {
                    this.routingKey = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            Map<String, Object> getArguments();

            String getExchange();

            boolean getNowait();

            String getQueue();

            String getRoutingKey();

            int getTicket();
        }

        public interface BindOk extends Method {

            public static final class Builder {
                public BindOk build() {
                    return new AMQImpl.Queue.BindOk();
                }
            }
        }

        public interface Declare extends Method {

            public static final class Builder {
                private Map<String, Object> arguments = null;
                private boolean autoDelete = false;
                private boolean durable = false;
                private boolean exclusive = false;
                private boolean nowait = false;
                private boolean passive = false;
                private String queue = "";
                private int ticket = 0;

                public Builder arguments(Map<String, Object> map) {
                    this.arguments = map;
                    return this;
                }

                public Builder autoDelete(boolean z) {
                    this.autoDelete = z;
                    return this;
                }

                public Declare build() {
                    return new AMQImpl.Queue.Declare(this.ticket, this.queue, this.passive, this.durable, this.exclusive, this.autoDelete, this.nowait, this.arguments);
                }

                public Builder durable(boolean z) {
                    this.durable = z;
                    return this;
                }

                public Builder exclusive(boolean z) {
                    this.exclusive = z;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder passive(boolean z) {
                    this.passive = z;
                    return this;
                }

                public Builder queue(String str) {
                    this.queue = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder autoDelete() {
                    return autoDelete(true);
                }

                public Builder durable() {
                    return durable(true);
                }

                public Builder exclusive() {
                    return exclusive(true);
                }

                public Builder nowait() {
                    return nowait(true);
                }

                public Builder passive() {
                    return passive(true);
                }
            }

            Map<String, Object> getArguments();

            boolean getAutoDelete();

            boolean getDurable();

            boolean getExclusive();

            boolean getNowait();

            boolean getPassive();

            String getQueue();

            int getTicket();
        }

        public interface DeclareOk extends Method {

            public static final class Builder {
                private int consumerCount;
                private int messageCount;
                private String queue;

                public DeclareOk build() {
                    return new AMQImpl.Queue.DeclareOk(this.queue, this.messageCount, this.consumerCount);
                }

                public Builder consumerCount(int i) {
                    this.consumerCount = i;
                    return this;
                }

                public Builder messageCount(int i) {
                    this.messageCount = i;
                    return this;
                }

                public Builder queue(String str) {
                    this.queue = str;
                    return this;
                }
            }

            int getConsumerCount();

            int getMessageCount();

            String getQueue();
        }

        public interface Delete extends Method {

            public static final class Builder {
                private boolean ifEmpty = false;
                private boolean ifUnused = false;
                private boolean nowait = false;
                private String queue = "";
                private int ticket = 0;

                public Delete build() {
                    return new AMQImpl.Queue.Delete(this.ticket, this.queue, this.ifUnused, this.ifEmpty, this.nowait);
                }

                public Builder ifEmpty(boolean z) {
                    this.ifEmpty = z;
                    return this;
                }

                public Builder ifUnused(boolean z) {
                    this.ifUnused = z;
                    return this;
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder queue(String str) {
                    this.queue = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder ifEmpty() {
                    return ifEmpty(true);
                }

                public Builder ifUnused() {
                    return ifUnused(true);
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            boolean getIfEmpty();

            boolean getIfUnused();

            boolean getNowait();

            String getQueue();

            int getTicket();
        }

        public interface DeleteOk extends Method {

            public static final class Builder {
                private int messageCount;

                public DeleteOk build() {
                    return new AMQImpl.Queue.DeleteOk(this.messageCount);
                }

                public Builder messageCount(int i) {
                    this.messageCount = i;
                    return this;
                }
            }

            int getMessageCount();
        }

        public interface Purge extends Method {

            public static final class Builder {
                private boolean nowait = false;
                private String queue = "";
                private int ticket = 0;

                public Purge build() {
                    return new AMQImpl.Queue.Purge(this.ticket, this.queue, this.nowait);
                }

                public Builder nowait(boolean z) {
                    this.nowait = z;
                    return this;
                }

                public Builder queue(String str) {
                    this.queue = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }

                public Builder nowait() {
                    return nowait(true);
                }
            }

            boolean getNowait();

            String getQueue();

            int getTicket();
        }

        public interface PurgeOk extends Method {

            public static final class Builder {
                private int messageCount;

                public PurgeOk build() {
                    return new AMQImpl.Queue.PurgeOk(this.messageCount);
                }

                public Builder messageCount(int i) {
                    this.messageCount = i;
                    return this;
                }
            }

            int getMessageCount();
        }

        public interface Unbind extends Method {

            public static final class Builder {
                private Map<String, Object> arguments = null;
                private String exchange;
                private String queue = "";
                private String routingKey = "";
                private int ticket = 0;

                public Builder arguments(Map<String, Object> map) {
                    this.arguments = map;
                    return this;
                }

                public Unbind build() {
                    return new AMQImpl.Queue.Unbind(this.ticket, this.queue, this.exchange, this.routingKey, this.arguments);
                }

                public Builder exchange(String str) {
                    this.exchange = str;
                    return this;
                }

                public Builder queue(String str) {
                    this.queue = str;
                    return this;
                }

                public Builder routingKey(String str) {
                    this.routingKey = str;
                    return this;
                }

                public Builder ticket(int i) {
                    this.ticket = i;
                    return this;
                }
            }

            Map<String, Object> getArguments();

            String getExchange();

            String getQueue();

            String getRoutingKey();

            int getTicket();
        }

        public interface UnbindOk extends Method {

            public static final class Builder {
                public UnbindOk build() {
                    return new AMQImpl.Queue.UnbindOk();
                }
            }
        }
    }

    public static class Tx {

        public interface Commit extends Method {

            public static final class Builder {
                public Commit build() {
                    return new AMQImpl.Tx.Commit();
                }
            }
        }

        public interface CommitOk extends Method {

            public static final class Builder {
                public CommitOk build() {
                    return new AMQImpl.Tx.CommitOk();
                }
            }
        }

        public interface Rollback extends Method {

            public static final class Builder {
                public Rollback build() {
                    return new AMQImpl.Tx.Rollback();
                }
            }
        }

        public interface RollbackOk extends Method {

            public static final class Builder {
                public RollbackOk build() {
                    return new AMQImpl.Tx.RollbackOk();
                }
            }
        }

        public interface Select extends Method {

            public static final class Builder {
                public Select build() {
                    return new AMQImpl.Tx.Select();
                }
            }
        }

        public interface SelectOk extends Method {

            public static final class Builder {
                public SelectOk build() {
                    return new AMQImpl.Tx.SelectOk();
                }
            }
        }
    }

    public static class BasicProperties extends AMQBasicProperties {
        private String appId;
        private String clusterId;
        private String contentEncoding;
        private String contentType;
        private String correlationId;
        private Integer deliveryMode;
        private String expiration;
        private Map<String, Object> headers;
        private String messageId;
        private Integer priority;
        private String replyTo;
        private Date timestamp;
        private String type;
        private String userId;

        public static final class Builder {
            private String appId;
            private String clusterId;
            private String contentEncoding;
            private String contentType;
            private String correlationId;
            private Integer deliveryMode;
            private String expiration;
            private Map<String, Object> headers;
            private String messageId;
            private Integer priority;
            private String replyTo;
            private Date timestamp;
            private String type;
            private String userId;

            public Builder appId(String str) {
                this.appId = str;
                return this;
            }

            public BasicProperties build() {
                return new BasicProperties(this.contentType, this.contentEncoding, this.headers, this.deliveryMode, this.priority, this.correlationId, this.replyTo, this.expiration, this.messageId, this.timestamp, this.type, this.userId, this.appId, this.clusterId);
            }

            public Builder clusterId(String str) {
                this.clusterId = str;
                return this;
            }

            public Builder contentEncoding(String str) {
                this.contentEncoding = str;
                return this;
            }

            public Builder contentType(String str) {
                this.contentType = str;
                return this;
            }

            public Builder correlationId(String str) {
                this.correlationId = str;
                return this;
            }

            public Builder deliveryMode(Integer num) {
                this.deliveryMode = num;
                return this;
            }

            public Builder expiration(String str) {
                this.expiration = str;
                return this;
            }

            public Builder headers(Map<String, Object> map) {
                this.headers = map;
                return this;
            }

            public Builder messageId(String str) {
                this.messageId = str;
                return this;
            }

            public Builder priority(Integer num) {
                this.priority = num;
                return this;
            }

            public Builder replyTo(String str) {
                this.replyTo = str;
                return this;
            }

            public Builder timestamp(Date date) {
                this.timestamp = date;
                return this;
            }

            public Builder type(String str) {
                this.type = str;
                return this;
            }

            public Builder userId(String str) {
                this.userId = str;
                return this;
            }
        }

        public BasicProperties(String str, String str2, Map<String, Object> map, Integer num, Integer num2, String str3, String str4, String str5, String str6, Date date, String str7, String str8, String str9, String str10) {
            Map<String, Object> map2;
            this.contentType = str;
            this.contentEncoding = str2;
            if (map == null) {
                map2 = null;
            } else {
                map2 = Collections.unmodifiableMap(new HashMap(map));
            }
            this.headers = map2;
            this.deliveryMode = num;
            this.priority = num2;
            this.correlationId = str3;
            this.replyTo = str4;
            this.expiration = str5;
            this.messageId = str6;
            this.timestamp = date;
            this.type = str7;
            this.userId = str8;
            this.appId = str9;
            this.clusterId = str10;
        }

        @Override // com.rabbitmq.client.ContentHeader, com.rabbitmq.client.impl.AMQContentHeader
        public void appendPropertyDebugStringTo(StringBuilder sb) {
            sb.append("(content-type=");
            sb.append(this.contentType);
            sb.append(", content-encoding=");
            sb.append(this.contentEncoding);
            sb.append(", headers=");
            sb.append(this.headers);
            sb.append(", delivery-mode=");
            sb.append(this.deliveryMode);
            sb.append(", priority=");
            sb.append(this.priority);
            sb.append(", correlation-id=");
            sb.append(this.correlationId);
            sb.append(", reply-to=");
            sb.append(this.replyTo);
            sb.append(", expiration=");
            sb.append(this.expiration);
            sb.append(", message-id=");
            sb.append(this.messageId);
            sb.append(", timestamp=");
            sb.append(this.timestamp);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", user-id=");
            sb.append(this.userId);
            sb.append(", app-id=");
            sb.append(this.appId);
            sb.append(", cluster-id=");
            sb.append(this.clusterId);
            sb.append(")");
        }

        public Builder builder() {
            return new Builder().contentType(this.contentType).contentEncoding(this.contentEncoding).headers(this.headers).deliveryMode(this.deliveryMode).priority(this.priority).correlationId(this.correlationId).replyTo(this.replyTo).expiration(this.expiration).messageId(this.messageId).timestamp(this.timestamp).type(this.type).userId(this.userId).appId(this.appId).clusterId(this.clusterId);
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getAppId() {
            return this.appId;
        }

        @Override // com.rabbitmq.client.ContentHeader
        public int getClassId() {
            return 60;
        }

        @Override // com.rabbitmq.client.ContentHeader
        public String getClassName() {
            return "basic";
        }

        public String getClusterId() {
            return this.clusterId;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getContentEncoding() {
            return this.contentEncoding;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getContentType() {
            return this.contentType;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public Integer getDeliveryMode() {
            return this.deliveryMode;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getExpiration() {
            return this.expiration;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public Map<String, Object> getHeaders() {
            return this.headers;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getMessageId() {
            return this.messageId;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public Integer getPriority() {
            return this.priority;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getReplyTo() {
            return this.replyTo;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public Date getTimestamp() {
            return this.timestamp;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getType() {
            return this.type;
        }

        @Override // com.rabbitmq.client.BasicProperties
        public String getUserId() {
            return this.userId;
        }

        @Override // com.rabbitmq.client.impl.AMQContentHeader
        public void writePropertiesTo(ContentHeaderPropertyWriter contentHeaderPropertyWriter) throws IOException {
            boolean z = true;
            contentHeaderPropertyWriter.writePresence(this.contentType != null);
            contentHeaderPropertyWriter.writePresence(this.contentEncoding != null);
            contentHeaderPropertyWriter.writePresence(this.headers != null);
            contentHeaderPropertyWriter.writePresence(this.deliveryMode != null);
            contentHeaderPropertyWriter.writePresence(this.priority != null);
            contentHeaderPropertyWriter.writePresence(this.correlationId != null);
            contentHeaderPropertyWriter.writePresence(this.replyTo != null);
            contentHeaderPropertyWriter.writePresence(this.expiration != null);
            contentHeaderPropertyWriter.writePresence(this.messageId != null);
            contentHeaderPropertyWriter.writePresence(this.timestamp != null);
            contentHeaderPropertyWriter.writePresence(this.type != null);
            contentHeaderPropertyWriter.writePresence(this.userId != null);
            contentHeaderPropertyWriter.writePresence(this.appId != null);
            if (this.clusterId == null) {
                z = false;
            }
            contentHeaderPropertyWriter.writePresence(z);
            contentHeaderPropertyWriter.finishPresence();
            String str = this.contentType;
            if (str != null) {
                contentHeaderPropertyWriter.writeShortstr(str);
            }
            String str2 = this.contentEncoding;
            if (str2 != null) {
                contentHeaderPropertyWriter.writeShortstr(str2);
            }
            Map<String, Object> map = this.headers;
            if (map != null) {
                contentHeaderPropertyWriter.writeTable(map);
            }
            Integer num = this.deliveryMode;
            if (num != null) {
                contentHeaderPropertyWriter.writeOctet(num);
            }
            Integer num2 = this.priority;
            if (num2 != null) {
                contentHeaderPropertyWriter.writeOctet(num2);
            }
            String str3 = this.correlationId;
            if (str3 != null) {
                contentHeaderPropertyWriter.writeShortstr(str3);
            }
            String str4 = this.replyTo;
            if (str4 != null) {
                contentHeaderPropertyWriter.writeShortstr(str4);
            }
            String str5 = this.expiration;
            if (str5 != null) {
                contentHeaderPropertyWriter.writeShortstr(str5);
            }
            String str6 = this.messageId;
            if (str6 != null) {
                contentHeaderPropertyWriter.writeShortstr(str6);
            }
            Date date = this.timestamp;
            if (date != null) {
                contentHeaderPropertyWriter.writeTimestamp(date);
            }
            String str7 = this.type;
            if (str7 != null) {
                contentHeaderPropertyWriter.writeShortstr(str7);
            }
            String str8 = this.userId;
            if (str8 != null) {
                contentHeaderPropertyWriter.writeShortstr(str8);
            }
            String str9 = this.appId;
            if (str9 != null) {
                contentHeaderPropertyWriter.writeShortstr(str9);
            }
            String str10 = this.clusterId;
            if (str10 != null) {
                contentHeaderPropertyWriter.writeShortstr(str10);
            }
        }

        public BasicProperties(DataInputStream dataInputStream) throws IOException {
            super(dataInputStream);
            ContentHeaderPropertyReader contentHeaderPropertyReader = new ContentHeaderPropertyReader(dataInputStream);
            boolean readPresence = contentHeaderPropertyReader.readPresence();
            boolean readPresence2 = contentHeaderPropertyReader.readPresence();
            boolean readPresence3 = contentHeaderPropertyReader.readPresence();
            boolean readPresence4 = contentHeaderPropertyReader.readPresence();
            boolean readPresence5 = contentHeaderPropertyReader.readPresence();
            boolean readPresence6 = contentHeaderPropertyReader.readPresence();
            boolean readPresence7 = contentHeaderPropertyReader.readPresence();
            boolean readPresence8 = contentHeaderPropertyReader.readPresence();
            boolean readPresence9 = contentHeaderPropertyReader.readPresence();
            boolean readPresence10 = contentHeaderPropertyReader.readPresence();
            boolean readPresence11 = contentHeaderPropertyReader.readPresence();
            boolean readPresence12 = contentHeaderPropertyReader.readPresence();
            boolean readPresence13 = contentHeaderPropertyReader.readPresence();
            boolean readPresence14 = contentHeaderPropertyReader.readPresence();
            contentHeaderPropertyReader.finishPresence();
            String str = null;
            this.contentType = readPresence ? contentHeaderPropertyReader.readShortstr() : null;
            this.contentEncoding = readPresence2 ? contentHeaderPropertyReader.readShortstr() : null;
            this.headers = readPresence3 ? contentHeaderPropertyReader.readTable() : null;
            this.deliveryMode = readPresence4 ? Integer.valueOf(contentHeaderPropertyReader.readOctet()) : null;
            this.priority = readPresence5 ? Integer.valueOf(contentHeaderPropertyReader.readOctet()) : null;
            this.correlationId = readPresence6 ? contentHeaderPropertyReader.readShortstr() : null;
            this.replyTo = readPresence7 ? contentHeaderPropertyReader.readShortstr() : null;
            this.expiration = readPresence8 ? contentHeaderPropertyReader.readShortstr() : null;
            this.messageId = readPresence9 ? contentHeaderPropertyReader.readShortstr() : null;
            this.timestamp = readPresence10 ? contentHeaderPropertyReader.readTimestamp() : null;
            this.type = readPresence11 ? contentHeaderPropertyReader.readShortstr() : null;
            this.userId = readPresence12 ? contentHeaderPropertyReader.readShortstr() : null;
            this.appId = readPresence13 ? contentHeaderPropertyReader.readShortstr() : null;
            this.clusterId = readPresence14 ? contentHeaderPropertyReader.readShortstr() : str;
        }

        public BasicProperties() {
        }
    }
}
