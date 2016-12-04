import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class StockTest {

    ContainerFactory containerFactory;
    Stock stock;

    @Before
    public void setUp() {
        stock = new Stock();
        containerFactory = new ContainerFactory() {
            public Stock createObjectContainer() {
                return new Stock();
            }

            public List creatArrayContainer() {
                return new ArrayList<LinkedHashMap<String, String>>();
            }
        };
    }


    @Test
    public void shouldCalculateBalanceAndStatus() {
        JSONParser parser = new JSONParser();
        List<Stock> input = null;
        List<Stock> expected = null;
        try {
            input = (List<Stock>) parser.parse(new FileReader("/Users/apurvagu/Projects/sahaj/src/main/resources/input1.json"), containerFactory);
            expected = (List<Stock>) parser.parse(new FileReader("/Users/apurvagu/Projects/sahaj/src/main/resources/output1.json"), containerFactory);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Stock> actual = stock.statusAndBalanceCalculator(input);

        Assert.assertThat(actual, is(expected));
        Assert.assertEquals(5, actual.size());
    }

    @Test
    public void shouldCalculateBalanceAndStatusForDifferentValues() {
        JSONParser parser = new JSONParser();
        List<Stock> input = null;
        List<Stock> expected = null;
        try {
            input = (List<Stock>) parser.parse(new FileReader("/Users/apurvagu/Projects/sahaj/src/main/resources/input2.json"), containerFactory);
            expected = (List<Stock>) parser.parse(new FileReader("/Users/apurvagu/Projects/sahaj/src/main/resources/output2.json"), containerFactory);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Stock> actual = stock.statusAndBalanceCalculator(input);

        Assert.assertThat(actual, is(expected));
        Assert.assertEquals(5, actual.size());
    }

}
