import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Генерація одновимірного масиву асинхронно
        CompletableFuture<int[]> generateArrayFuture = CompletableFuture.supplyAsync(() -> {
            long taskStartTime = System.currentTimeMillis();
            int[] array = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 101))
                    .limit(10).toArray();
            System.out.println("Generated array: " + Arrays.toString(array));
            System.out.println("Time for array generation: " + (System.currentTimeMillis() - taskStartTime) + "ms");
            return array;
        });

        // Додавання +10 до кожного елементу
        CompletableFuture<double[]> addTenFuture = generateArrayFuture.thenApplyAsync(array -> {
            long taskStartTime = System.currentTimeMillis();
            int[] modifiedArray = Arrays.stream(array).map(value -> value + 10).toArray();
            System.out.println("Array after adding 10: " + Arrays.toString(modifiedArray));
            System.out.println("Time for addition task: " + (System.currentTimeMillis() - taskStartTime) + "ms");
            return Arrays.stream(modifiedArray).asDoubleStream().toArray();
        });

        // Ділення кожного елементу на 2
        CompletableFuture<double[]> divideByTwoFuture = addTenFuture.thenApplyAsync(array -> {
            long taskStartTime = System.currentTimeMillis();
            double[] dividedArray = Arrays.stream(array).map(value -> value / 2).toArray();
            System.out.println("Array after division: " + Arrays.toString(dividedArray));
            System.out.println("Time for division task: " + (System.currentTimeMillis() - taskStartTime) + "ms");
            return dividedArray;
        });

        // Виведення результату на екран
        CompletableFuture<Void> displayResultFuture = divideByTwoFuture.thenAcceptAsync(array -> {
            long taskStartTime = System.currentTimeMillis();
            System.out.println("Final result (after division): " + Arrays.toString(array));
            System.out.println("Time for displaying results: " + (System.currentTimeMillis() - taskStartTime) + "ms");
        });

        // Остання дія після завершення всіх задач
        displayResultFuture.thenRunAsync(() -> {
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("All tasks completed in: " + totalTime + "ms");
        }).join(); // Очікуємо завершення всіх задач
    }
}
