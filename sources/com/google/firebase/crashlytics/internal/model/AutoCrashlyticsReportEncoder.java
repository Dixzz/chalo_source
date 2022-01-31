package com.google.firebase.crashlytics.internal.model;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.crashlytics.android.answers.SessionEventTransform;
import com.crashlytics.android.beta.CheckForUpdatesResponseTransform;
import com.freshchat.consumer.sdk.beans.User;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import server.zophop.logging.LoggingConstants;

public final class AutoCrashlyticsReportEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 1;
    public static final Configurator CONFIG = new AutoCrashlyticsReportEncoder();

    public static final class CrashlyticsReportCustomAttributeEncoder implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {
        public static final CrashlyticsReportCustomAttributeEncoder INSTANCE = new CrashlyticsReportCustomAttributeEncoder();

        private CrashlyticsReportCustomAttributeEncoder() {
        }

        public void encode(CrashlyticsReport.CustomAttribute customAttribute, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(AnalyticsConstants.KEY, customAttribute.getKey());
            objectEncoderContext.add(FirebaseAnalytics.Param.VALUE, customAttribute.getValue());
        }
    }

    public static final class CrashlyticsReportEncoder implements ObjectEncoder<CrashlyticsReport> {
        public static final CrashlyticsReportEncoder INSTANCE = new CrashlyticsReportEncoder();

        private CrashlyticsReportEncoder() {
        }

        public void encode(CrashlyticsReport crashlyticsReport, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, crashlyticsReport.getSdkVersion());
            objectEncoderContext.add("gmpAppId", crashlyticsReport.getGmpAppId());
            objectEncoderContext.add("platform", crashlyticsReport.getPlatform());
            objectEncoderContext.add("installationUuid", crashlyticsReport.getInstallationUuid());
            objectEncoderContext.add("buildVersion", crashlyticsReport.getBuildVersion());
            objectEncoderContext.add("displayVersion", crashlyticsReport.getDisplayVersion());
            objectEncoderContext.add(SettingsJsonConstants.SESSION_KEY, crashlyticsReport.getSession());
            objectEncoderContext.add("ndkPayload", crashlyticsReport.getNdkPayload());
        }
    }

    public static final class CrashlyticsReportFilesPayloadEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload> {
        public static final CrashlyticsReportFilesPayloadEncoder INSTANCE = new CrashlyticsReportFilesPayloadEncoder();

        private CrashlyticsReportFilesPayloadEncoder() {
        }

        public void encode(CrashlyticsReport.FilesPayload filesPayload, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("files", filesPayload.getFiles());
            objectEncoderContext.add("orgId", filesPayload.getOrgId());
        }
    }

    public static final class CrashlyticsReportFilesPayloadFileEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {
        public static final CrashlyticsReportFilesPayloadFileEncoder INSTANCE = new CrashlyticsReportFilesPayloadFileEncoder();

        private CrashlyticsReportFilesPayloadFileEncoder() {
        }

        public void encode(CrashlyticsReport.FilesPayload.File file, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("filename", file.getFilename());
            objectEncoderContext.add("contents", file.getContents());
        }
    }

    public static final class CrashlyticsReportSessionApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application> {
        public static final CrashlyticsReportSessionApplicationEncoder INSTANCE = new CrashlyticsReportSessionApplicationEncoder();

        private CrashlyticsReportSessionApplicationEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Application application, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(CheckForUpdatesResponseTransform.IDENTIFIER, application.getIdentifier());
            objectEncoderContext.add("version", application.getVersion());
            objectEncoderContext.add("displayVersion", application.getDisplayVersion());
            objectEncoderContext.add("organization", application.getOrganization());
            objectEncoderContext.add("installationUuid", application.getInstallationUuid());
            objectEncoderContext.add("developmentPlatform", application.getDevelopmentPlatform());
            objectEncoderContext.add("developmentPlatformVersion", application.getDevelopmentPlatformVersion());
        }
    }

    public static final class CrashlyticsReportSessionApplicationOrganizationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {
        public static final CrashlyticsReportSessionApplicationOrganizationEncoder INSTANCE = new CrashlyticsReportSessionApplicationOrganizationEncoder();

        private CrashlyticsReportSessionApplicationOrganizationEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Application.Organization organization, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("clsId", organization.getClsId());
        }
    }

    public static final class CrashlyticsReportSessionDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Device> {
        public static final CrashlyticsReportSessionDeviceEncoder INSTANCE = new CrashlyticsReportSessionDeviceEncoder();

        private CrashlyticsReportSessionDeviceEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Device device, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("arch", device.getArch());
            objectEncoderContext.add("model", device.getModel());
            objectEncoderContext.add("cores", device.getCores());
            objectEncoderContext.add("ram", device.getRam());
            objectEncoderContext.add("diskSpace", device.getDiskSpace());
            objectEncoderContext.add("simulator", device.isSimulator());
            objectEncoderContext.add(RemoteConfigConstants.ResponseFieldKey.STATE, device.getState());
            objectEncoderContext.add("manufacturer", device.getManufacturer());
            objectEncoderContext.add("modelClass", device.getModelClass());
        }
    }

    public static final class CrashlyticsReportSessionEncoder implements ObjectEncoder<CrashlyticsReport.Session> {
        public static final CrashlyticsReportSessionEncoder INSTANCE = new CrashlyticsReportSessionEncoder();

        private CrashlyticsReportSessionEncoder() {
        }

        public void encode(CrashlyticsReport.Session session, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("generator", session.getGenerator());
            objectEncoderContext.add(CheckForUpdatesResponseTransform.IDENTIFIER, session.getIdentifierUtf8Bytes());
            objectEncoderContext.add("startedAt", session.getStartedAt());
            objectEncoderContext.add("endedAt", session.getEndedAt());
            objectEncoderContext.add("crashed", session.isCrashed());
            objectEncoderContext.add(SettingsJsonConstants.APP_KEY, session.getApp());
            objectEncoderContext.add(LoggingConstants.USER, session.getUser());
            objectEncoderContext.add(User.DEVICE_META_OS_NAME, session.getOs());
            objectEncoderContext.add(AnalyticsConstants.DEVICE, session.getDevice());
            objectEncoderContext.add(AnalyticsConstants.EVENTS, session.getEvents());
            objectEncoderContext.add("generatorType", session.getGeneratorType());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {
        public static final CrashlyticsReportSessionEventApplicationEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationEncoder();

        private CrashlyticsReportSessionEventApplicationEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Application application, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("execution", application.getExecution());
            objectEncoderContext.add(SessionEventTransform.CUSTOM_ATTRIBUTES, application.getCustomAttributes());
            objectEncoderContext.add(ProductPromotionsObject.KEY_BACKGROUND, application.getBackground());
            objectEncoderContext.add("uiOrientation", application.getUiOrientation());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {
        public static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();

        private CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("baseAddress", binaryImage.getBaseAddress());
            objectEncoderContext.add("size", binaryImage.getSize());
            objectEncoderContext.add("name", binaryImage.getName());
            objectEncoderContext.add("uuid", binaryImage.getUuidUtf8Bytes());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {
        public static final CrashlyticsReportSessionEventApplicationExecutionEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionEncoder();

        private CrashlyticsReportSessionEventApplicationExecutionEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Application.Execution execution, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("threads", execution.getThreads());
            objectEncoderContext.add("exception", execution.getException());
            objectEncoderContext.add("signal", execution.getSignal());
            objectEncoderContext.add("binaries", execution.getBinaries());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {
        public static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();

        private CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Exception exception, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("type", exception.getType());
            objectEncoderContext.add("reason", exception.getReason());
            objectEncoderContext.add("frames", exception.getFrames());
            objectEncoderContext.add("causedBy", exception.getCausedBy());
            objectEncoderContext.add("overflowCount", exception.getOverflowCount());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {
        public static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();

        private CrashlyticsReportSessionEventApplicationExecutionSignalEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("name", signal.getName());
            objectEncoderContext.add("code", signal.getCode());
            objectEncoderContext.add("address", signal.getAddress());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {
        public static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();

        private CrashlyticsReportSessionEventApplicationExecutionThreadEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread thread, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("name", thread.getName());
            objectEncoderContext.add("importance", thread.getImportance());
            objectEncoderContext.add("frames", thread.getFrames());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {
        public static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();

        private CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("pc", frame.getPc());
            objectEncoderContext.add("symbol", frame.getSymbol());
            objectEncoderContext.add("file", frame.getFile());
            objectEncoderContext.add("offset", frame.getOffset());
            objectEncoderContext.add("importance", frame.getImportance());
        }
    }

    public static final class CrashlyticsReportSessionEventDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {
        public static final CrashlyticsReportSessionEventDeviceEncoder INSTANCE = new CrashlyticsReportSessionEventDeviceEncoder();

        private CrashlyticsReportSessionEventDeviceEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Device device, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("batteryLevel", device.getBatteryLevel());
            objectEncoderContext.add("batteryVelocity", device.getBatteryVelocity());
            objectEncoderContext.add("proximityOn", device.isProximityOn());
            objectEncoderContext.add("orientation", device.getOrientation());
            objectEncoderContext.add("ramUsed", device.getRamUsed());
            objectEncoderContext.add("diskUsed", device.getDiskUsed());
        }
    }

    public static final class CrashlyticsReportSessionEventEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event> {
        public static final CrashlyticsReportSessionEventEncoder INSTANCE = new CrashlyticsReportSessionEventEncoder();

        private CrashlyticsReportSessionEventEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event event, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("timestamp", event.getTimestamp());
            objectEncoderContext.add("type", event.getType());
            objectEncoderContext.add(SettingsJsonConstants.APP_KEY, event.getApp());
            objectEncoderContext.add(AnalyticsConstants.DEVICE, event.getDevice());
            objectEncoderContext.add(AnalyticsConstants.LOG, event.getLog());
        }
    }

    public static final class CrashlyticsReportSessionEventLogEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {
        public static final CrashlyticsReportSessionEventLogEncoder INSTANCE = new CrashlyticsReportSessionEventLogEncoder();

        private CrashlyticsReportSessionEventLogEncoder() {
        }

        public void encode(CrashlyticsReport.Session.Event.Log log, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("content", log.getContent());
        }
    }

    public static final class CrashlyticsReportSessionOperatingSystemEncoder implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {
        public static final CrashlyticsReportSessionOperatingSystemEncoder INSTANCE = new CrashlyticsReportSessionOperatingSystemEncoder();

        private CrashlyticsReportSessionOperatingSystemEncoder() {
        }

        public void encode(CrashlyticsReport.Session.OperatingSystem operatingSystem, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("platform", operatingSystem.getPlatform());
            objectEncoderContext.add("version", operatingSystem.getVersion());
            objectEncoderContext.add("buildVersion", operatingSystem.getBuildVersion());
            objectEncoderContext.add("jailbroken", operatingSystem.isJailbroken());
        }
    }

    public static final class CrashlyticsReportSessionUserEncoder implements ObjectEncoder<CrashlyticsReport.Session.User> {
        public static final CrashlyticsReportSessionUserEncoder INSTANCE = new CrashlyticsReportSessionUserEncoder();

        private CrashlyticsReportSessionUserEncoder() {
        }

        public void encode(CrashlyticsReport.Session.User user, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(CheckForUpdatesResponseTransform.IDENTIFIER, user.getIdentifier());
        }
    }

    private AutoCrashlyticsReportEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        CrashlyticsReportEncoder crashlyticsReportEncoder = CrashlyticsReportEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.class, crashlyticsReportEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport.class, crashlyticsReportEncoder);
        CrashlyticsReportSessionEncoder crashlyticsReportSessionEncoder = CrashlyticsReportSessionEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.class, crashlyticsReportSessionEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session.class, crashlyticsReportSessionEncoder);
        CrashlyticsReportSessionApplicationEncoder crashlyticsReportSessionApplicationEncoder = CrashlyticsReportSessionApplicationEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Application.class, crashlyticsReportSessionApplicationEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application.class, crashlyticsReportSessionApplicationEncoder);
        CrashlyticsReportSessionApplicationOrganizationEncoder crashlyticsReportSessionApplicationOrganizationEncoder = CrashlyticsReportSessionApplicationOrganizationEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Application.Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application_Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        CrashlyticsReportSessionUserEncoder crashlyticsReportSessionUserEncoder = CrashlyticsReportSessionUserEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.User.class, crashlyticsReportSessionUserEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_User.class, crashlyticsReportSessionUserEncoder);
        CrashlyticsReportSessionOperatingSystemEncoder crashlyticsReportSessionOperatingSystemEncoder = CrashlyticsReportSessionOperatingSystemEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        CrashlyticsReportSessionDeviceEncoder crashlyticsReportSessionDeviceEncoder = CrashlyticsReportSessionDeviceEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Device.class, crashlyticsReportSessionDeviceEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Device.class, crashlyticsReportSessionDeviceEncoder);
        CrashlyticsReportSessionEventEncoder crashlyticsReportSessionEventEncoder = CrashlyticsReportSessionEventEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.class, crashlyticsReportSessionEventEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event.class, crashlyticsReportSessionEventEncoder);
        CrashlyticsReportSessionEventApplicationEncoder crashlyticsReportSessionEventApplicationEncoder = CrashlyticsReportSessionEventApplicationEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.class, crashlyticsReportSessionEventApplicationEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application.class, crashlyticsReportSessionEventApplicationEncoder);
        CrashlyticsReportSessionEventApplicationExecutionEncoder crashlyticsReportSessionEventApplicationExecutionEncoder = CrashlyticsReportSessionEventApplicationExecutionEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadEncoder crashlyticsReportSessionEventApplicationExecutionThreadEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder crashlyticsReportSessionEventApplicationExecutionExceptionEncoder = CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        CrashlyticsReportSessionEventApplicationExecutionSignalEncoder crashlyticsReportSessionEventApplicationExecutionSignalEncoder = CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        CrashlyticsReportCustomAttributeEncoder crashlyticsReportCustomAttributeEncoder = CrashlyticsReportCustomAttributeEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        CrashlyticsReportSessionEventDeviceEncoder crashlyticsReportSessionEventDeviceEncoder = CrashlyticsReportSessionEventDeviceEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Device.class, crashlyticsReportSessionEventDeviceEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Device.class, crashlyticsReportSessionEventDeviceEncoder);
        CrashlyticsReportSessionEventLogEncoder crashlyticsReportSessionEventLogEncoder = CrashlyticsReportSessionEventLogEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Log.class, crashlyticsReportSessionEventLogEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Log.class, crashlyticsReportSessionEventLogEncoder);
        CrashlyticsReportFilesPayloadEncoder crashlyticsReportFilesPayloadEncoder = CrashlyticsReportFilesPayloadEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        CrashlyticsReportFilesPayloadFileEncoder crashlyticsReportFilesPayloadFileEncoder = CrashlyticsReportFilesPayloadFileEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.File.class, crashlyticsReportFilesPayloadFileEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload_File.class, crashlyticsReportFilesPayloadFileEncoder);
    }
}
