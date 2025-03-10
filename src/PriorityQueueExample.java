import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.AbstractMap;
import java.util.Map;

public class PriorityQueueExample {

    public static void test() {
        // Define a comparator for the PriorityQueue to compare entries based on keys (integers)
        Comparator<Map.Entry<Integer, String>> comparator = Comparator.comparingInt(Map.Entry::getKey);

        // Create a PriorityQueue with the defined comparator
        PriorityQueue<Map.Entry<Integer, String>> priorityQueue = new PriorityQueue<>(comparator);

        // Add key-value pairs to the PriorityQueue
        priorityQueue.offer(new AbstractMap.SimpleEntry<>(3, "Value 3"));
        priorityQueue.offer(new AbstractMap.SimpleEntry<>(1, "Value 1"));
        priorityQueue.offer(new AbstractMap.SimpleEntry<>(2, "Value 2"));
        priorityQueue.offer(new AbstractMap.SimpleEntry<>(5, "Value 5"));
        priorityQueue.offer(new AbstractMap.SimpleEntry<>(4, "Value 4"));

        // Poll and print elements from the PriorityQueue (ordered by key)
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, String> entry = priorityQueue.poll();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        test();
    }
}
