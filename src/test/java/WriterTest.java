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

public class WriterTest {
    public static final String SEPARATOR = ",";
    Writer writer;
    private ContainerFactory containerFactory;

    @Before
    public void setUp() {
        writer = new Writer();
        containerFactory = new ContainerFactory() {
            public LinkedHashMap createObjectContainer() {
                return new LinkedHashMap();
            }

            public List creatArrayContainer() {
                return new ArrayList<LinkedHashMap<String, String>>();
            }
        };
    }

    @Test
    public void shouldWriteToCsv() {
        JSONParser parser = new JSONParser();
        List<Stock> input = null;
        try {
            input = (List<Stock>) parser.parse(new FileReader("/Users/apurvagu/Projects/sahaj/src/main/resources/output1.json"), containerFactory);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String outputFile = "/Users/apurvagu/Projects/sahaj/src/main/resources/output.csv";
        writer.run(input, outputFile, SEPARATOR);
        List<Stock> actual = new Reader().run(outputFile, SEPARATOR);
        Assert.assertThat(actual, is(input));
    }
}
