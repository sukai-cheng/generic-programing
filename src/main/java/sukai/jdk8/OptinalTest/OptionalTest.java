package sukai.jdk8.OptinalTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author chengsukai
 **/
public class OptionalTest {
    public static void main(String[] args) {

        Map<String, Object> addressMap = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> infoMap = new HashMap<>();

        addressMap.put("address", "hz");
        infoMap.put("info", addressMap);
        resultMap.put("user", infoMap);

        // jdk5
        if (resultMap.get("user") != null) {
            Map<String, Object> user = (Map<String, Object>) resultMap.get("user");
            if (user.get("info") != null) {
                Map<String, Object> info = (Map<String, Object>) infoMap.get("info");
                if (info.get("address") != null) {
                    Map<String, Object> address = (Map<String, Object>) addressMap.get("address");
                    System.out.println(address);
                }
            }
        }

        // jdk8 functional programming
        String address = Optional.ofNullable(resultMap)
                .map(m -> (Map<String, Object>) m.get("user"))
                .map(user -> (Map<String, Object>) user.get("info"))
                .map(info -> (String) info.get("address"))
                .orElse(null);

    }

}