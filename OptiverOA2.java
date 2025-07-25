// https://leetcode.com/discuss/post/2768659/optiver-oa-q1-by-onurerkinsucu-iddq/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Elephant {
    private final String name; 
    private final int height;

    public Elephant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getElephantName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }
}

class Event {
    private final String name; 
    private final int enterTime;
    private final int exitTime;

    public Event(String name, int enterTime, int exitTime) {
        this.name = name;
        this.enterTime = enterTime;
        this.exitTime = exitTime;
    }
    public String getElephantName() {
        return this.name;
    }
    public int getEnterTime() {
        return this.enterTime;
    }
    public int getExitTime() {
        return this.exitTime;
    }
}

public class OptiverOA2 {
    TreeMap<Integer, List<Elephant>> myElephantsByHeight;
    Map<String, Elephant> myElephantsByName;
    Map<Integer, List<Elephant>> myElephantsByTime;

    // this is the showfloor heights
    PriorityQueue<Integer> showfloor;

    // this the height of my elephants on the showfloor
    PriorityQueue<Integer> mine;

    public OptiverOA2(List<Elephant> elephants, List<Event> schedule) {
        myElephantsByName = new HashMap<>();
        myElephantsByHeight = new TreeMap<>();
        myElephantsByTime = new HashMap<>();
        showfloor = new PriorityQueue<>(Collections.reverseOrder());
        mine = new PriorityQueue<>(Collections.reverseOrder());

        for (Elephant e : elephants)
            myElephantsByName.put(e.getElephantName(), e);

        for (Event ev : schedule) {
            Elephant elephant = myElephantsByName.get(ev.getElephantName());

            if (!myElephantsByHeight.containsKey(elephant.getHeight()))
                myElephantsByHeight.put(elephant.getHeight(), new ArrayList<>());
            myElephantsByHeight.get(elephant.getHeight()).add(elephant);

            if (!myElephantsByTime.containsKey(ev.getEnterTime()))
                myElephantsByTime.put(ev.getEnterTime(), new ArrayList<>());
            if (!myElephantsByTime.containsKey(ev.getExitTime()))
                myElephantsByTime.put(ev.getExitTime(), new ArrayList<>());

            myElephantsByTime.get(ev.getEnterTime()).add(elephant);
            myElephantsByTime.get(ev.getExitTime()).add(elephant);
        }
    }

    public void elephantEntered(int currentTime, int height) {
        if (isThisMyElephant(currentTime, height))
            mine.add(height);
        else 
            showfloor.add(height);
    }

    public void elephantLeft(int currentTime, int height) {
        if (isThisMyElephant(currentTime, height)) 
            mine.remove(height);
        else 
            showfloor.remove(height);
    }

    public List<Elephant> getBiggestElephants() {
        if (this.mine.isEmpty() || this.mine.peek() < this.showfloor.peek()) {
            return new ArrayList<>();
        }
    
        int threshold = this.showfloor.peek();
        List<Elephant> res = new ArrayList<>();
    
        for (Map.Entry<Integer, List<Elephant>> entry : this.myElephantsByHeight.tailMap(threshold).entrySet()) {
            int height = entry.getKey();
            if (this.mine.contains(height))
                res.addAll(entry.getValue());
            
        }
    
        return res;
    }    

    private boolean isThisMyElephant(int currentTime, int height) {
        // it is my elephant if the time and height are the same

        if (this.myElephantsByTime.containsKey(currentTime)) {
            List<Elephant> e = this.myElephantsByTime.get(currentTime);

            for (Elephant i : e)
                if (i.getHeight() == height)
                    return true;
        }

        return false;
    }
}