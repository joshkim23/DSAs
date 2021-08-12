public class BasicRecursionProblems {
    public static void main(String[] args) {
        System.out.println();

        int n = 10;
        System.out.println("The " + n + "th triangular number is: ");
        System.out.println(findNthTriangularNumber(n));

        System.out.println();
        int num = 5;
        System.out.println("The factorial of " + num + " is :");
        System.out.println(calculateFactorialOfN(num));
    }

    //sum:  1,                      3,                       6, 10, 15, 21 .... 
    //      n=1, sum = 0 + n, n++   n=2, sum = sum + n, n++  n=3, sum += n, n++
    //      n=1, sum = 1            n=2 sum = (1) + 2        n=3, sum = (3) + 3
    // base case is n = 1. 

    // Formula: Triangular#ofN(int n) = Triangular#ofN(n-1) + n;

    public static int findNthTriangularNumber(int n) {
        if (n == 1) { // base case, once you reach n=1, return 1 as the sum
            return 1;
        } else {
            return findNthTriangularNumber(n-1) + n; 
        }
    }

    // Forumla: factorial(n) = factorial(n-1) * n
    //      ex: factorial(3) = factorial(2) * 3
    //          factorial(2) = factorial(1) * 2
    //          factorial(1) = 1  
    
    public static int calculateFactorialOfN(int n) {
        if (n == 0) { // by definition, 0 is the base case. factorial(0) = factorial(1) = 1
            return 1;
        } else {
            return calculateFactorialOfN(n-1) * n;
        }
    }
}
