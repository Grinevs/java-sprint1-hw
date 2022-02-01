import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                print("Введите номер месяца или его название");
                String month = scanner.next();
                print("Введите число месяца");
                int dayOfMonth = scanner.nextInt();
                print("ВВедите количество шагов");
                int stepsByDay = scanner.nextInt();
                print(stepTracker.saveSteps(month, dayOfMonth, stepsByDay)); // возвращаем текст ошибки
            } else if (command == 2) {
                print("Введите месяц ");
                String month = scanner.next();
                int numberMonth = stepTracker.validationMonth(month) - 1;
                if (numberMonth >= 0) {
                    print("Статистика за " + stepTracker.monthList[numberMonth]);
                    stepTracker.printMonthStat(month);
                } else {
                    print("Неправильно введен месяц!" + month);
                }
            } else if (command == 3) {
                print("Введите вашу цель по количеству шагов в день");
                int goalSteps = scanner.nextInt();
                print("Текущая цель " + stepTracker.changeGoal(goalSteps) + " шагов");
            } else if (command == 0) {
                print("Хорошего дня!");
                break;
            } else {
                print("Извините, такой команды пока нет.");
            }
        }
    }



    public static void print(String message) {
        System.out.println(message);
    }

    private static void printMenu() {
        print("Что вы хотите сделать? ");
        print("1 - Ввести количество шагов за определённый день");
        print("2 - Напечатать статистику за определённый месяц");
        print("3 - Изменить цель по количеству шагов в день");
        print("0 - Выйти из приложения.");
    }
}


