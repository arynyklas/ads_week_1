public class Main {
    // Problem 1. Complexity: O(n)
    public static int findMin(int[] arr) {
        int minVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }

        return minVal;
    }

    // Problem 2. Complexity: O(n)
    public static double findAverage(int[] arr) {
        long sum = 0;

        for (int value : arr) {
            sum += value;
        }

        return (double) sum / arr.length;
    }

    // Problem 3. Complexity: O(sqrt(n)) in the worst case
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        };

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Problem 4. Complexity: O(n)
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // Problem 5. Complexity: O(2^n)
    public static long fibonacci(int n) {
        if (n < 2) {
            return n;  // F0 = 0, F1 = 1
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Problem 6. Complexity: O(log(n))
    public static long power(long a, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return a;
        } else if (n % 2 == 0) {
            long half = power(a, n / 2);
            return half * half;
        } else {
            return a * power(a, n - 1);
        }
    }

    // Problem 7. Complexity: O(M * M!)
    public static void printPermutations(String s) {
        char[] chars = s.toCharArray();
        permuteHelper(chars, 0);
    }

    private static void permuteHelper(char[] chars, int start) {
        if (start == chars.length) {
            System.out.println(String.valueOf(chars));

            return;
        }

        for (int i = start; i < chars.length; i++) {
            swap(chars, i, start);
            permuteHelper(chars, start + 1);
            swap(chars, i, start);  // backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Problem 8. Complexity: O(M)
    public static boolean isAllDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }

    // Problem 9. Complexity: O(2^n)
    public static long binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    // Problem 10. Complexity: O(log(min(a, b)))
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("Problem 1: " + findMin(new int[] {10, 1, 32, 3, 45}));
        System.out.println("Problem 2: " + findAverage(new int[] {3, 2, 4, 1}));
        System.out.println("Problem 3 (input: 7): " + (isPrime(7) ? "Prime" : "Composite"));
        System.out.println("Problem 3 (input: 10): " + (isPrime(10) ? "Prime" : "Composite"));
        System.out.println("Problem 4: " + factorial(5));
        System.out.println("Problem 5 (input: 5: " + fibonacci(5));
        System.out.println("Problem 5 (input: 17): " + fibonacci(17));
        System.out.println("Problem 6: " + power(2, 10));
        System.out.println("Problem 7:"); printPermutations("IOX");
        System.out.println("Problem 8 (input: \"123a12\"): " + isAllDigits("123a12"));
        System.out.println("Problem 8 (input: \"123456\"): " + isAllDigits("123456"));
        System.out.println("Problem 9 (input: 2, 1): " + binomialCoefficient(2, 1));
        System.out.println("Problem 9 (input: 7, 3): " + binomialCoefficient(7, 3));
        System.out.println("Problem 10 (input: 32, 48): " + gcd(32, 48));
        System.out.println("Problem 10 (input: 10, 7): " + gcd(10, 7));
    }
}
