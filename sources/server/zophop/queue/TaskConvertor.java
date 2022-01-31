package server.zophop.queue;

import com.firebase.client.DataSnapshot;
import com.firebase.client.MutableData;
import java.util.HashMap;
import java.util.Map;
import server.zophop.TaskType;
import server.zophop.queue.exceptions.TaskMalformedException;

public class TaskConvertor {
    public static Task fromSnapshot(MutableData mutableData) {
        long longValue = ((Number) mutableData.child(TaskKeys.RECEIVED_AT).getValue()).longValue();
        long longValue2 = ((Number) mutableData.child("timeStamp").getValue()).longValue();
        long longValue3 = ((Number) mutableData.child(TaskKeys.LOCKED_AT).getValue()).longValue();
        String str = (String) mutableData.child("userId").getValue();
        TaskType valueOf = TaskType.valueOf((String) mutableData.child("event").getValue());
        Map map = (Map) mutableData.child("data").getValue();
        long longValue4 = mutableData.hasChild(TaskKeys.RETRIES) ? ((Long) mutableData.child(TaskKeys.RETRIES).getValue()).longValue() : 0;
        Task task = new Task(str, longValue, longValue3, longValue2, valueOf, map);
        task.setRetries(longValue4);
        return task;
    }

    public static Map toSnapshot(Task task) {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", task.getUserId());
        hashMap.put(TaskKeys.RECEIVED_AT, Long.valueOf(task.getReceivedAt()));
        hashMap.put(TaskKeys.LOCKED_AT, Long.valueOf(task.getLockedAt()));
        hashMap.put("timeStamp", Long.valueOf(task.getTimeStamp()));
        hashMap.put("event", task.getType().name());
        hashMap.put("data", task.getData());
        if (task.getEventType() != null) {
            hashMap.put(TaskKeys.TASK_TYPE, task.getEventType().name());
        }
        if (task.getRetries() > 0) {
            hashMap.put(TaskKeys.RETRIES, Long.valueOf(task.getRetries()));
        }
        return hashMap;
    }

    public static Task fromSnapshot(DataSnapshot dataSnapshot) throws TaskMalformedException {
        try {
            long longValue = ((Number) dataSnapshot.child(TaskKeys.RECEIVED_AT).getValue()).longValue();
            long longValue2 = ((Number) dataSnapshot.child("timeStamp").getValue()).longValue();
            long longValue3 = ((Number) dataSnapshot.child(TaskKeys.LOCKED_AT).getValue()).longValue();
            String str = (String) dataSnapshot.child("userId").getValue();
            TaskType valueOf = TaskType.valueOf((String) dataSnapshot.child("event").getValue());
            Map map = (Map) dataSnapshot.child("data").getValue();
            long j = 0;
            if (dataSnapshot.hasChild(TaskKeys.RETRIES)) {
                j = ((Long) dataSnapshot.child(TaskKeys.RETRIES).getValue()).longValue();
            }
            Task task = new Task(str, longValue, longValue3, longValue2, valueOf, map);
            task.setRetries(j);
            return task;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TaskMalformedException();
        }
    }
}
