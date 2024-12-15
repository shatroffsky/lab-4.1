# Опис програми
Ця програма демонструє використання методів класу `CompletableFuture` у Java для виконання асинхронних задач. Завданням було:
1. Генерувати одновимірний масив із 10 випадкових цілих чисел асинхронно.
2. Модифікувати масив:
   - Додати +10 до кожного елемента.
   - Поділити кожен елемент на 2.
3. Вивести всі результати та час, витрачений на виконання кожної задачі.

## Використані методи `CompletableFuture`
1. **`supplyAsync()`**: Для асинхронної генерації початкового масиву чисел.
2. **`thenApplyAsync()`**: Для обробки масиву:
   - Додавання +10 до кожного елемента.
   - Ділення кожного елемента на 2.
3. **`thenAcceptAsync()`**: Для асинхронного виведення результатів на екран.
4. **`thenRunAsync()`**: Для виконання фінальної дії після завершення всіх задач.

## Інструкція з використання
1. **Середовище виконання**:
   - Java Development Kit (JDK) 11 або новішої версії.
2. **Компиляція**:
   ```bash
   javac CompletableFutureDemo.java
   ```
3. **Запуск**:
   ```bash
   java CompletableFutureDemo
   ```

## Очікуваний результат
Після запуску програми в консолі буде виведено:
1. Початковий згенерований масив.
2. Модифікований масив після додавання +10.
3. Модифікований масив після ділення на 2.
4. Інформаційний текст із фінальним результатом.
5. Час виконання кожної задачі.
6. Загальний час виконання програми.

## Приклад виводу
```
Generated array: [43, 12, 98, 34, 56, 29, 80, 71, 15, 62]
Time for array generation: 5ms
Array after adding 10: [53, 22, 108, 44, 66, 39, 90, 81, 25, 72]
Time for addition task: 2ms
Array after division: [26.5, 11.0, 54.0, 22.0, 33.0, 19.5, 45.0, 40.5, 12.5, 36.0]
Time for division task: 3ms
Final result (after division): [26.5, 11.0, 54.0, 22.0, 33.0, 19.5, 45.0, 40.5, 12.5, 36.0]
Time for displaying results: 1ms
All tasks completed in: 12ms
```

## Особливості
- Масив генерується за допомогою `ThreadLocalRandom`.
- Використовуються стріми для роботи з масивами (`IntStream`, `DoubleStream`).
- Кожен етап виконується асинхронно та паралельно.
- Час виконання кожної задачі обчислюється для зручності аналізу.


