import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Введите номер месяца илм его название");
                String month = scanner.next();
                System.out.println("Введите число месяца");
                int dayOfMonth = scanner.nextInt();
                System.out.println("ВВедите количество шагов");
                int stepsByDay = scanner.nextInt();

                System.out.println(stepTracker.saveSteps(month, dayOfMonth, stepsByDay)); // возвращаем текст ошибки

            } else if (command == 2) {
                System.out.println("Введите месяц ");
                String month = scanner.next();
                System.out.println("Статистика за " + stepTracker.monthList[stepTracker.validationMonth(month)-1]);
                stepTracker.printMonthStat(month);

            } else if (command == 3) {
                System.out.println("Введите вашу цель по количеству шагов в день");
                stepTracker.goalSteps= scanner.nextInt();
            } else if (command == 0) {
                System.out.println("Хорошего дня!");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения.");
    }
}


