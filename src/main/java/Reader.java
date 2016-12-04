import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<Stock> run(String inputFile, String separator) {
        List<Stock> stocks = new ArrayList<Stock>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line = bufferedReader.readLine();

            String[] headers = line.split(separator);

            while ((line = bufferedReader.readLine()) != null) {
                String[] record = line.split(separator);
                Stock stock = new Stock();

                for (int i = 0; i < record.length; i++)
                    stock.put(headers[i], record[i]);
                stocks.add(stock);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return stocks;
    }
}
