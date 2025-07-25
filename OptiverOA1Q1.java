// https://leetcode.com/discuss/post/3821560/optiver-oa-by-test99393-lqdu/
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

class Log{
    private String logId;
    private int timestamp;
    
    public Log(String logId, int timestamp){
        this.logId = logId;
        this.timestamp = timestamp;
    }

    public String getLogId(){
        return logId;
    }
    public int getTimeStamp() {
        return timestamp;
    }
}

public class OptiverOA1Q1 {
    private int m;
    private int latestTimestamp;

    Deque<Log> logs;

    public OptiverOA1Q1(int m) {
        this.m = m; 
        latestTimestamp = -1;
        logs = new LinkedList<>();
    }

    public void recordLog(String logId, int timestamp) {
        if (latestTimestamp == -1) {
            this.logs.add(new Log(logId, timestamp));
            latestTimestamp = timestamp;
            return;
        } 
        
        if (timestamp < this.latestTimestamp)
            return; 

        this.latestTimestamp = Math.max(this.latestTimestamp, timestamp);
        this.logs.add(new Log(logId, timestamp));        
    }

    public String getLogs() {
        Iterator<Log> itr = this.logs.descendingIterator();
        
        int count = 0; 

        List<String> tmpRes = new LinkedList<>();

        while (count < this.m && itr.hasNext()) {
            Log currentLog = itr.next();
            
            if (this.latestTimestamp - currentLog.getTimeStamp() < 3600) {
                tmpRes.addFirst(currentLog.getLogId());
                count++;
            }
        }

        return String.join(",", tmpRes);
    }

    public int getLogCount() {
        int count = 0;
        Iterator<Log> itr = this.logs.descendingIterator();
        
        while (itr.hasNext() && count <= this.m) {
            Log currentLog = itr.next();
            if (this.latestTimestamp - currentLog.getTimeStamp() < 3600)
                count++;
        }

        if (count >= this.m)
            return this.logs.size();

        return count;
    }
}