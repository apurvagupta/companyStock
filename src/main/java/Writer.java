import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class Writer {
    private static final String NEW_LINE_SEPARATOR = "\n";

    public void run(List<Stock> result, String outputFile, String separator) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(outputFile);
            Boolean isHeader= true;

            for (LinkedHashMap<String, String> record : result) {
                String recordRaw = "";
                String headers = "";
                for (String key : record.keySet()) {
                    if(isHeader) {
                        headers += key;
                        headers += separator;
                    }
                    recordRaw += String.valueOf(record.get(key));
                    recordRaw += separator;
                }
                if(isHeader){
                    fileWriter.append(headers.substring(0, headers.length() - 1));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
                isHeader= false;

                fileWriter.append(recordRaw.substring(0, recordRaw.length() - 1));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
