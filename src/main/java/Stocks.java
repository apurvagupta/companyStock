import java.util.ArrayList;
import java.util.List;


public class Stocks {

    List<Stock> stocks;

    public Stocks(List<Stock> stocks) {
        this.stocks = stocks;
    }


    public List<Stock> statusAndBalanceCalculator() {
        List<Stock> openStocks = new ArrayList<Stock>();

        for (Stock currentStock : this.stocks) {
                currentStock.initialize();

            for (Stock resultRecord : openStocks) {
                if (resultRecord.isEligibleForProcessing(currentStock) ) {

                    if (resultRecord.shouldClose(currentStock)) {
                        resultRecord.close();
                        currentStock.changeBalance(resultRecord);
                    } else {
                        resultRecord.changeBalance(currentStock);
                        currentStock.close();
                    }
                }
            }
            if (currentStock.isOpen())
                openStocks.add(currentStock);
        }
        return this.stocks;
    }
}
