public class MonthData {
    int[] month;

    MonthData() {
        month = new int[30];
    }

    void addSteps(int day, int steps) {
        month[day - 1] = steps;
    }

    String returnSteps(int i) {
        return Integer.toString(month[i]);
    }
}