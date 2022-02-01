import java.util.LinkedHashMap;

public class StepTracker {
    LinkedHashMap<Integer, MonthData> dataForYear;
    String[] monthList = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
    int goalSteps = 10000;
    Converter converter = new Converter(); // правильно что я создаю экземляр класса в другом классе?
    // как то по другому надо их свзять вроде?

    StepTracker() {
        dataForYear = new LinkedHashMap<>();
        for (int i = 1; i <= 12; i++) {
            dataForYear.put(i, new MonthData());
        }
    }

    Integer validationMonth(String month) {
        int numberMonth = -1;
        if (month.matches("[-+]?\\d+")) {  // регуляркой проверям на строку или число
            numberMonth = Integer.parseInt(month);
            if (numberMonth < 1 || numberMonth > 12) {
                return -1;
            }
        } else {
            for (int i = 0; i < monthList.length; i++) {
                if (monthList[i].equalsIgnoreCase(month)) {
                    numberMonth = i + 1;
                    break;
                }
            }
        }
        return numberMonth;
    }

    String saveSteps(String month, int day, int steps) {
        int numberMonth = validationMonth(month);
        if (numberMonth == -1) {
            return "Такого месяца не существует";
        }
        int validDay = -1;
        int validSteps = -1;

        if (day > 0 && day < 31) {
            validDay = day;
        } else {
            return "Несуществующая дата";
        }

        if (steps >= 0) {
            validSteps = steps;
        } else {
            return "Неверное кол-во шагов";
        }

        for (int i : dataForYear.keySet()) {
            if (i == numberMonth) {
                dataForYear.get(i).addSteps(validDay, validSteps);
                break;
            }
        }
        return "Значение сохранено";
    }


    void printMonthStat(String month) {
        String stats = "";
        int numberMonth = validationMonth(month);
        if (dataForYear.containsKey(numberMonth)) {
            for (int i = 0; i < dataForYear.get(numberMonth).month.length; i++) {
                stats = stats + (i + 1) + " день : " + dataForYear.get(numberMonth).returnSteps(i) + ", ";
            }
            System.out.println("Количество пройденных шагов по дням " + stats);
            System.out.println("Общее количество шагов за месяц; " + commonStepsByMonth(numberMonth));
            System.out.println("Среднее количество шагов; " + String.valueOf(commonStepsByMonth(numberMonth) / 30));
            System.out.println("Лучшая серия: " + bestStrictOfDays(numberMonth) + " дней");
            String distance = converter.stepToDistance(commonStepsByMonth(numberMonth));
            System.out.println("Пройденная дистанция: " + distance + " км");
            String kiloCal = converter.stepToKilocalories(commonStepsByMonth(numberMonth));
            System.out.println("Количество сожжённых килокалорий: " + kiloCal);
        }
    }

    Integer commonStepsByMonth(int numberMonth) {
        int stats = 0;
        for (int i = 0; i < dataForYear.get(numberMonth).month.length; i++) {
            stats += Integer.parseInt(dataForYear.get(numberMonth).returnSteps(i));
        }
        return stats;
    }

    Integer bestStrictOfDays(int numberMonth) {
        int dayStrict = 0;
        int days = 0;
        for (int i = 0; i < dataForYear.get(numberMonth).month.length; i++) {
            if (Integer.parseInt(dataForYear.get(numberMonth).returnSteps(i)) > goalSteps) {
                days += 1;
            } else {
                days = 0;
            }

            if (dayStrict < days) {
                dayStrict = days;
            }
        }

        return dayStrict;
    }

    Integer changeGoal(int goal) {
        if (goal > 0) {
            goalSteps = goal;
        }
        return goalSteps;
    }
}

