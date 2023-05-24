import java.util.List;
import java.util.Queue;


public class Consumer1 implements Runnable {
    private final List<Data> dataList;
    private final Object monitor;
    private final Queue<Data> queue;

    public Consumer1(Queue<Data> queue, List<Data> dataList, Object monitor) {
        this.queue = queue;
        this.dataList = dataList;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                Data data = queue.peek();
                if (data == null) {
                    continue;
                }
                if (data.getWord() == null) {
                    monitor.notify();
                    return;
                }
                if (data.getWord().length() >= 4) {
                    Data polled = queue.poll();
                    String s = polled.getWord();

//                    System.out.println(s);
                    dataList.add(new Data(polled.getPosition(), s+1));
                }




            }
        }
    }
}
