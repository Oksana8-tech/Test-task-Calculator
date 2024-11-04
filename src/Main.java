import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию (например: 2 + 2)");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    static String calc(String input) {
        String[] parts = input.split(" ");


        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат математической операции, ожидается 'число оператор число'");
        }

        int a = Integer.parseInt(parts[0]);
        String operation = parts[1];
        int b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Введите числа от 1 до 10");
            }

            int result;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        throw new IllegalArgumentException("Ошибка (деление на ноль)");
                    }
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Несуществующая операция " + operation);
            }

            return String.valueOf(result);
    }
}
