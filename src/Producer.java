import java.util.Queue;

public class Producer implements Runnable {
    private final Object monitor;
    private final Queue<Data> queue;
    private final String[] words;

    public Producer(String paragraph, Queue<Data> queue, Object monitor) {
        this.words = paragraph.split("\\s+");
        this.queue = queue;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for (int i = 0; i < words.length; i++) {
                queue.add(new Data(i, words[i]));
            }
            queue.add(new Data(words.length + 1, null));
        }
    }
}
