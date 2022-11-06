import java.util.Scanner;

public class QueueManager {
    private Scanner scanner;
    private Queue mainQueue;
    private Queue firstAuxiliaryQueue;
    private Queue secondAuxiliaryQueue;

    public QueueManager() {
        scanner = new Scanner(System.in);
        mainQueue = null;
        firstAuxiliaryQueue = null;
        secondAuxiliaryQueue = null;
    }

    public void run() {
        int option = 0;

        System.out.println("Welcome to QMA\nQueues Merge Application\n\nFirst, insert the main queue length:");
        mainQueue = new Queue(readQueueLength(0));

        System.out.println("\nSecond, insert the auxiliary queues's length");
        firstAuxiliaryQueue = new Queue(readQueueLength(1));
        secondAuxiliaryQueue = new Queue(readQueueLength(2));

        while (option != 5) {
            option = showOptions();
        }

        System.out.println("\n\nSee you soon.");
    }

    private int readQueueLength(int numberOfQueue) {
        int length = 0;

        if (numberOfQueue != 0) {
            System.out.println("Queue " + numberOfQueue + ":");
        }

        while (true) {
            try {
                length = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("Error: invalid input. Try again.\n\nQueue " + numberOfQueue + ":");

                continue;
            }

            if (length <= 0) {
                System.out.println("Error: invalid length. Try again.\n\nQueue " + numberOfQueue + ":");
            } else {
                break;
            }
        }

        return length;
    }

    private int showOptions() {
        int option = 0;

        System.out.println("\n\nChoise an action\n\n(1) Fill queue 1\n" +
            "(2) Fill queue 2\n(3) Merge queues\n(4) Clear main queue\n(5) Stop program\n\nOption:");

        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("Error: invalid input. Try again.\n\nOption:");

                continue;
            }

            switch (option) {
                case 1:
                    fillAuxiliaryQueue(1);
                    break;
                case 2:
                    fillAuxiliaryQueue(2);
                    break;
                case 3:
                    mainQueue.mergeQueues(firstAuxiliaryQueue, secondAuxiliaryQueue);
                    break;
                case 4:
                    printMainQueueElements();
                    break;
                case 5:
                    return option;

                default:
                    System.out.println("Error: invalid option. Try again.\n\nOption:");
                    continue;
            }

            return option;
        }
    }

    private void fillAuxiliaryQueue(int numberOfQueue) {
        Queue queue = numberOfQueue == 1 ? firstAuxiliaryQueue : secondAuxiliaryQueue;
        String input = null;
        int element = 0;

        if (queue.isFull()) {
            System.out.println("\nOops! the auxiliary queue is full.");

            return;
        }

        while (!queue.isFull()) {
            System.out.println("\nType an number or 'B' to back to main menu:");
            input = scanner.nextLine().toUpperCase();

            if (input.equals("B")) {
                break;
            }

            while (true) {
                try {
                    element = Integer.parseInt(input);
                } catch (NumberFormatException ignored) {
                    System.out.println("Error: invalid input. Try again.");
    
                    break;
                }

                queue.addElement(element);

                break;
            }
        }

        if (queue.isFull()) {
            System.out.println("\nALERT: the queue is full.");
        }
    }

    private void printMainQueueElements() {
        String output = "\n\nRESULT:\n\n";

        if (mainQueue.isEmpty()) {
            System.out.println("\nOops! The main queue is empty.");

            return;
        }

        for (int currentIndex = 0; !mainQueue.isEmpty(); currentIndex++) {
            if (currentIndex == 0) {
                output += "[ ";
            }

            output += mainQueue.removeElement();

            if (!mainQueue.isEmpty()) {
                output += ", ";
            } else {
                output += " ]";
            }
        }

        System.out.println(output);
    }
}
