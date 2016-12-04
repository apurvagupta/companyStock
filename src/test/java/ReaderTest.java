import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ReaderTest {
    @Test
    public void shouldReadCsv() {
        List<Stock> actual = new Reader().run("/Users/apurvagu/Projects/sahaj/src/main/resources/test.csv", ",");
        List expected = new ArrayList<LinkedHashMap<String, String>>();

        LinkedHashMap record1 = new LinkedHashMap<String, String>();
        record1.put("Quantity", "10");
        record1.put("Side", "Buy");
        record1.put("Stock_Id", "1");
        record1.put("Company", "ABC");

        LinkedHashMap<String, String> record2 = new LinkedHashMap<String, String>();
        record2.put("Quantity", "15");
        record2.put("Side", "Sell");
        record2.put("Stock_Id", "2");
        record2.put("Company", "XYZ");

        expected.add(record1);
        expected.add(record2);

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(2, actual.size());
    }
}
