import java.util.List;

public class ConsumerFinal implements Runnable {
    final Object monitor;
    private final List<Data> dataList;

    public ConsumerFinal(List<Data> dataList, Object monitor) {
        this.dataList = dataList;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            synchronized (monitor) {
                monitor.wait();
                for (Data data : dataList) {
                    System.out.println(data.getWord());
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
