package jdi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdi.objects.MetalsColors;

import java.lang.reflect.Type;
import java.util.Map;

public class DataMetalsColors {

    Object[][] object;

    public Object[][] dataMetalsColors() {
        String json = "src/test/resources/JDiData.json";
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, MetalsColors> jsonMap = objectMapper.readValue(json,
                        new TypeReference<Map<String, MetalsColors>>() {
//                            @Override
//                            public Type getType() {
//                                return super.getType();
//                            }
                        });
                int i = 0;
                for (Map.Entry<String, MetalsColors> entry : jsonMap.entrySet()){
                    object[i][0] = entry.getValue();
                    i++;
                }
            }
                catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return object;
        }
    }
