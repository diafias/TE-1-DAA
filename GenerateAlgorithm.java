import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GenerateAlgorithm {

    // Function to generate n random numbers
    public static int[] generateRandomNumbers(int n) {
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(2048);
        }
        return numbers;
    }

    // Function to generate n sorted numbers
    public static int[] generateSortedNumbers(int n) {
        int[] numbers = generateRandomNumbers(n);
        Arrays.sort(numbers);
        return numbers;
    }

    // Function to generate n reverse sorted numbers
    public static int[] generateReverseSortedNumbers(int n) {
        int[] numbers = generateSortedNumbers(n);
        for (int i = 0; i < n / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[n - i - 1];
            numbers[n - i - 1] = temp;
        }
        return numbers;
    }

    // Function to save numbers to a text file
    public static void saveNumbersToFile(int[] numbers, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int number : numbers) {
                writer.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to read numbers from a text file and convert it into an array of numbers
    public static int[] readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }
}