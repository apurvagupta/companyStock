import java.util.LinkedHashMap;

public class Stock extends LinkedHashMap<String, String> {


    public static final String OPEN ="open";
    public static final String CLOSED = "closed";
    private final String COMPANY_NAME = "Company";
    private final String SIDE = "Side";
    private final String QUANTITY = "Quantity";
    private final String BALANCE = "Balance";
    private final String STATUS = "Status";
    private final String PRICE = "Status";

    public Stock() {
    }

    public void initialize(){
        this.putBalance(this.getQuantity());
        this.putStatus(OPEN);
    }

    private void putBalance(String balance) {
        put(BALANCE, balance);
    }

    private void putStatus(String status) {
        put(STATUS, status);
    }

    private String getCompanyName() {
        return get(COMPANY_NAME);
    }

    private String getSide() {
        return get(SIDE);
    }

    private String getBalance() {
        return get(BALANCE);
    }

    private String getQuantity() {
        return get(QUANTITY);
    }


    public void close() {
        this.putStatus(CLOSED);
        this.putBalance(String.valueOf(0));
    }

    public void changeBalance(Stock resultRecord) {
        this.putBalance(String.valueOf(Integer.parseInt(this.getBalance()) - (Integer.parseInt(resultRecord.getBalance()))));
    }

    public boolean isEligibleForProcessing(Stock currentStock) {
        return this.getCompanyName().equals(currentStock.getCompanyName())
                && !(this.getSide()).equals(currentStock.getSide()) && getSellerStock(currentStock).isLessPricedThan(getBuyerStock(currentStock));
    }

    private boolean isLessPricedThan(Stock buyerStock) {
        return (Integer.parseInt(buyerStock.get(PRICE)) >= Integer.parseInt(this.get(PRICE)));
    }

    private Stock getBuyerStock(Stock currentStock) {
        if(currentStock.getSide().equals("Buy"))
                return currentStock;
        return this;
    }

    private Stock getSellerStock(Stock currentStock) {
        if(currentStock.getSide().equals("Sell"))
                return currentStock;
        return this;
    }

    public boolean shouldClose(Stock currentStock) {
        return Integer.parseInt(this.getBalance()) - Integer.parseInt(currentStock.getBalance()) <= 0;
    }

    public boolean isOpen() {
        return get(STATUS).equals(OPEN);
    }
}
