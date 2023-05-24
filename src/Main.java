import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting app...");
        List<Data> dataList = new ArrayList<>();
        String paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tristique tortor vitae nulla egestas, a vestibulum sapien pharetra. Vivamus hendrerit mattis tortor, nec faucibus tellus pellentesque vel. Proin a dolor dui. Fusce vel elementum ex. Suspendisse congue, enim in blandit ornare, mi erat tristique augue, et lobortis neque enim non dui. Nulla euismod gravida ex at vulputate. Aliquam eget ex vel tortor finibus elementum. Integer non leo rhoncus, porta lacus non, interdum lorem. Sed non condimentum ante, id ullamcorper magna. Phasellus elementum felis placerat sem tempus, et tincidunt justo interdum. Curabitur mauris massa, imperdiet sed neque sit amet, aliquet feugiat.";
        Queue<Data> queue = new PriorityQueue<>(paragraph.split("\\s+").length);
        Object monitor = new Object();
        Thread t1 = new Thread(new Producer(paragraph, queue, monitor));
        Thread t2 = new Thread(new Consumer1(queue, dataList, monitor));
        Thread t3 = new Thread(new Consumer2(queue, dataList, monitor));
        Thread t4 = new Thread(new ConsumerFinal(dataList, monitor));

        t4.start();
        t1.start();
        t2.start();
        t3.start();

    }
}
