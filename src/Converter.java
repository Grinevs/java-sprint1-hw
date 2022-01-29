import java.text.DecimalFormat;

public class Converter {

    String stepToDistance(int steps) {
        return new DecimalFormat("#0.000").format((steps*0.75)/1000);
    }

    String stepToKilocalories(int steps) {
        return new DecimalFormat("#0.0").format((steps*50)/1000);

    }
}
