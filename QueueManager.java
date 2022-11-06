import java.util.Scanner;

public class QueueManager extends Queue {
    private Scanner scanner;

    public QueueManager(int length) {
        super(length);
        scanner = new Scanner(System.in);
    }

    public void run() {
        int option = 0;
        int firstQueueLength = 0;
        int secondQueueLength = 0;

        System.out.println("Merge Queues Application\nFirst, type the queues's length");

        firstQueueLength = readQueueLength(1);
        secondQueueLength = readQueueLength(2);

        while (true) {
            System.out.println("\n(1) Add process\n(2) Execute process\n(3) Turn off\n\nOption:");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("\nError: invalid input\nTry again");

                continue;
            }

            switch (option) {
                case 1:
                case 2:
                    break;

                case 3:
                    System.out.println("\nSee you soon.");
                    return;

                default:
                    System.out.println("\nError: invalid option\nTry again");
                    break;
            }
        }
    }

    private int readQueueLength(int numberOfQueue) {
        int input = 0;

        System.out.println("\nQueue " + numberOfQueue + ":");

        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("Error: invalid input\n\nTry again:");

                continue;
            }

            if (input <= 0) {
                System.out.println("Error: invalid length\n\nTry again:");
            } else {
                break;
            }
        }

        return input;
    }
    
    private void printMainQueueElements() {
        String output = "";

        for (int currentIndex = 0; !isEmpty(); currentIndex++) {
            if (currentIndex == 0) {
                output += "[ ";
            }

            output += removeElement();

            if (!isEmpty()) {
                output += ", ";
            } else {
                output += " ]";
            }
        }

        System.out.println(output);
    }
}
