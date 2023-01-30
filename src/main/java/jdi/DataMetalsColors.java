package jdi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import jdi.objects.MetalsColors;
import org.testng.annotations.DataProvider;

public class DataMetalsColors {

    @DataProvider()
    public static Object[][] dataMetalsColors() throws FileNotFoundException {
        Object[][] object;
        String json = "src/test/resources/JDiData.json";
        FileInputStream fileInputStream = new FileInputStream(json);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, MetalsColors> jsonMap = objectMapper.readValue(fileInputStream,
                    new TypeReference<Map<String, MetalsColors>>() {});
            int i = 0;
            object = new Object[jsonMap.size()][1];
            for (Map.Entry<String, MetalsColors> entry : jsonMap.entrySet()) {
                object[i][0] = entry.getValue();
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();

            } catch (IOException e) {
                System.out.println("Failed to close streams");
            }
        }
        return object;
    }
}
