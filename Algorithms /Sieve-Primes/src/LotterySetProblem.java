import java.util.*;

public class LotterySetProblem {
    public static final int NUMBERS = 6;
    public static final int MAX_NUMBER = 40;
    public static final int PRIZE = 100;

    public static void main(String[] args) {
        // get winning number and ticket sets
        Set<Integer> winning = createWinningNumbers();
        Set<Integer> ticket = getTicket();

        // make a new set called  matches that takes in the ticket and compares the two using retainAll to find the intersection (if any) between the sets
        Set<Integer> matches = new TreeSet<Integer>(ticket); //TreeSet can take a set as a parameter to make a new Treeset
        matches.retainAll(winning); // compare the matches set to winning set

        System.out.println();
        System.out.println("Your ticket was: " + ticket);
        System.out.println("Wininng numbers: " + winning);
        System.out.println("Matched Numbers: " + matches);
        System.out.println();

        // if there are any matches, calculate and display the prize money
        if (matches.size() > 0) {
            double prize = 100 * Math.pow(2, matches.size());
            System.out.println("Your prize is $" + prize);
            System.out.println();
        }
    }

    // create the set of winning lotto numbers
        // TreeSet Key Points:
        // 1. No duplicate values allowed (set)
        // 2. Objects are stored in a sorted and ascending order
        // 3. It does not preserve the insertion order of elements, but the elements are sorted.
    public static Set<Integer> createWinningNumbers() {
        Set<Integer> winning = new TreeSet<Integer>();
        Random r = new Random(); 
        while (winning.size() < NUMBERS) {
            int number = r.nextInt(MAX_NUMBER);
            winning.add(number); // will only add unique numbers since it's a set!! if the same number is generated twice, it runs through the loop again. 
        }
        return winning;
    }

    // reads the players lottery ticket from the console
    public static Set<Integer> getTicket() {
        Set<Integer> ticket = new TreeSet<Integer>();

        Scanner console = new Scanner(System.in);
        System.out.print("Type " + NUMBERS + " lotto numbers: ");
        while (ticket.size() < NUMBERS) {
            ticket.add(console.nextInt());
        }
        console.close();
        return ticket;
    }
}
