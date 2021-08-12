import java.util.*;

public class Sieve {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("This program will tell you all the prime");
        System.out.println("numbers up to a given maximum.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        System.out.print("Maximum number? ");
        int max = console.nextInt();

        List<Integer> primes = sieve(max);
        System.out.println("Prime numbers up to " + max + ":");
        System.out.println(primes);
        System.out.println();
        console.close();
    }

    // Returns a list of all prime numbers up to a given max using the sieve of Eratosthenes algorithm
    public static List<Integer> sieve(int max) {
        // create two lists, one for the prime numbers and one for all the numbers from 2 to the max value specified
        List<Integer> primes = new LinkedList<Integer>(); //List is a java collection, LinkedList is an implementation of a list
        List<Integer> numbers = new LinkedList<Integer>();

        //add all numbers from 2 and all odd numbers after to the max value to numbers list
        for (int i = 2; i<= max; i++) {
            if (i ==2) numbers.add(i);
            if (i % 2 != 0 && i != 2) numbers.add(i); 
        }

        int count = 1;
        while (!numbers.isEmpty()) {
            //remove a prime number from the  front of the list
            int front = numbers.remove(0); //removes and returns value at index
            primes.add(front); //add the number at the front of the numbers list to the primes list. guaranteed to be prime by function below
            count++;

            Iterator<Integer> itr = numbers.iterator(); //used to keep track of location within a linkedList

            // removes all multiples of the prime number that was just added to the primes list from the numbers list         
            while (itr.hasNext() && count < Math.sqrt(max)) {
                int current = itr.next();
                if (current % front == 0) {
                    itr.remove(); //remove the node from the LinkedList (all multiples of the number that was added which is always prime)
                }
            }

            // add all the remaining values in numbers list to the primes list once the square root of the max value is reached, all guaranteed to be prime at this point mathematically
            if (count == (int) Math.sqrt(max)) {
                while (itr.hasNext()) {
                    primes.add(itr.next());
                    itr.remove();
                }
            }
        }

        

        return primes;
    }
}
