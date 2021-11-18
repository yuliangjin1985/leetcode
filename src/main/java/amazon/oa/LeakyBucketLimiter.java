package amazon.oa;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LeakyBucketLimiter {

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
    public int capacity = 10;
    public int current = 0;
    public int rate = 4;
    public long lastTime = System.currentTimeMillis();

    public void acquire() {
        executorService.scheduleWithFixedDelay(() -> {
            long curTime = System.currentTimeMillis();
            current = Math.max(0, current - (int)((curTime- lastTime) * rate / 1000));
            int request = (int)(Math.random() * 8) + 1;
            System.out.println("New request: " + request + ", available: " + (capacity - current));
            lastTime = curTime;
            if(capacity - current < request) {
                System.out.println("The current request is throttled");
            } else {
                current += request;
                System.out.println("Available: " + (capacity - current));
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        new LeakyBucketLimiter().acquire();
    }
}
