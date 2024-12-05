/**************
 * Product And Sum
 * Author: Christian Duncan
 *
 * Reads in a list of test cases.
 * Each test case is a list of numbers and for each test case it outputs if there are two values
 * such that their product equals the sums of the other values in the list.
 * This code uses a simple brute-force algorithm so the running time
 * is Theta(????) -- PLEASE ANALYZE YOUR CODE'S PERFORMANCE!
 **************/
import java.util.Scanner;
import java.util.ArrayList;

public class ProductAndSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = Integer.parseInt(in.nextLine());  // Number of test cases
        for (int i = 0; i < numCases; i++) {
            // Process a single case
            String[] elements = in.nextLine().split(" ");
            ArrayList<Integer> list = new ArrayList<>(elements.length);
            for (int j = 0; j < elements.length; j++) {
                list.add(Integer.parseInt(elements[j]));
            }
            if (hasProductAndSum(list)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }

    /**
     * Determines if there are any two values whose product equals the sum of the rest of the elements
     **/
    public static boolean hasProductAndSum(ArrayList<Integer> list) {
        // Iterate over all possible pairs of elements in the list
              for (int i = 0; i < list.size(); i++) {
                  for (int j = i + 1; j < list.size(); j++) {
                      // Calculate the product of the two selected elements
                      int product = list.get(i) * list.get(j);
          
                      // Calculate the sum of the remaining elements
                      int remainingSum = 0;
                      for (int k = 0; k < list.size(); k++) {
                          if (k != i && k != j) {
                              remainingSum += list.get(k);
                          }
                      }
          
                      // Check if the product equals the sum of the remaining elements
                      if (product == remainingSum) {
                          return true;
                      }
                  }
              }
              // If no such pair is found, return false
              return false;
          }
      }
  