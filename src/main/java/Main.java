import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputFile = "/Users/apurvagu/Projects/sahaj/src/main/resources/SOES-Input.csv";
        String outputFile = "/Users/apurvagu/Projects/sahaj/src/main/resources/SOES-Output.csv";
        String separator = ",";
        List<Stock> stocks = new Reader().run(inputFile, separator);

        List<Stock> stocksWithStatusAndBalance = new Stocks(stocks).statusAndBalanceCalculator();

        new Writer().run(stocksWithStatusAndBalance, outputFile, separator);
    }
}
