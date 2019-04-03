package enumStudy;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by cchen on 1/29/2019.
 */
public enum GmoCache {
    INSTANCE(new ConcurrentHashMap(),new ConcurrentLinkedQueue<String>(), 2000);

    private Map<String, String> map;
    private Queue<String> queue;
    private int maxSize;

    GmoCache(Map<String, String> map, Queue<String> queue, int maxSize){
        this.map = map;
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public synchronized void add(String bin, String cardDetail) {

        if (map.size() >=maxSize) {
            String removedBin = queue.poll();
            map.remove(removedBin);
        }

        map.put(bin, cardDetail);
        queue.add(bin);
    }

    public String findCardDetail(String bin) {

        return map.get(bin);

    }

    public synchronized void remove(String bin) {

        map.remove(bin);
        queue.remove(bin);
    }
}
