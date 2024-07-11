package Utils;

import java.util.HashMap;
import java.util.Map;

public class ObjectUtils {

    public static Map<String , Object> buildModelBody(String key, Object object){

        Map <String , Object> createUser = new HashMap<>();
        createUser.put(key, object);
        return createUser;

    }

}
