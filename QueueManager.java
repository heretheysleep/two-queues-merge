import java.util.Scanner;

public class QueueManager extends Queue {
    private Scanner scanner;
    private Queue mainQueue;

    public QueueManager(int length) {
        super(length);
        scanner = new Scanner(System.in);
        mainQueue = new Queue(length);
    }

    public void mergeQueues(Queue firstQueue, Queue secondQueue) {
        Queue queue = secondQueue;
        int element = 0;

        while (true) {
            if (firstQueue.isEmpty() && secondQueue.isEmpty()) {
                break;
            }

            queue = !queue.equals(firstQueue) ? firstQueue : secondQueue;

            if (queue.isEmpty()) {
                queue = queue.equals(firstQueue) ? secondQueue : firstQueue;
            }

            element = queue.removeElement();
            mainQueue.addElement(element);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
