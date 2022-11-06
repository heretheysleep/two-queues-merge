public class Queue {
    private int length;
    private int[] elements;
    private int numberOfElements;
    private int nextElementIndex;

    public Queue(int length) {
        this.length = length;
        elements = new int[length];
        numberOfElements = 0;
        nextElementIndex = 0;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean isFull() {
        return numberOfElements == length;
    }

    public boolean addElement(int element) {
        int endOfQueue = (numberOfElements + nextElementIndex) % length;

        if (isFull()) {
            return false;
        }

        elements[endOfQueue] = element;
        numberOfElements++;

        return true;
    }

    public int removeElement() {
        int element = 0;

        if (isEmpty()) {
            return element;
        }

        element = elements[nextElementIndex];

        nextElementIndex = (nextElementIndex + 1) % length;
        numberOfElements--;

        return element;
    }

    public void mergeQueues(Queue firstQueue, Queue secondQueue) {
        Queue queue = secondQueue;
        int element = 0;

        if (isFull()) {
            System.out.println("\nOops! The main queue is full.");

            return;
        }

        if (firstQueue.isEmpty() && secondQueue.isEmpty()) {
            System.out.println("\nOops! The QMA didn't find any element in auxiliary queues.");

            return;
        }

        while (true) {
            if (isFull() || (firstQueue.isEmpty() && secondQueue.isEmpty())) {
                break;
            }

            queue = !queue.equals(firstQueue) ? firstQueue : secondQueue;

            if (queue.isEmpty()) {
                queue = queue.equals(firstQueue) ? secondQueue : firstQueue;
            }

            element = queue.removeElement();
            addElement(element);
        }

        System.out.println("\nMerging the queues...\nSuccessful.");
    }
}
