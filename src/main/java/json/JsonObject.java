package json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    HashMap<String, Json> jsonPairsHash;
    String answer;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairsHash = new HashMap<>();
        for (JsonPair pair : jsonPairs) {
            add(pair);
        }
    }

    @Override
    public String toJson() {
        this.answer = "{";
        if (jsonPairsHash.size() == 0) {
            return answer += '}';
        }
        Set set = jsonPairsHash.entrySet();
        for (Object aSet : set) {
            Map.Entry pair_1 = (Map.Entry) aSet;
            answer += '\'' + pair_1.getKey().toString() + '\'' + ": ";
            if (pair_1.getValue() instanceof Json) {
                answer += ((Json) pair_1.getValue()).toJson() + ',';
            }
        }
        return answer.substring(0, answer.length() - 1) + '}';
    }

    public void add(JsonPair jsonPair) {
        jsonPairsHash.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        if (contains(name)) {
            return jsonPairsHash.get(name);
        }
        return null;

    }

    boolean contains(String name) {
        return jsonPairsHash.containsKey(name);
    }

    public JsonObject projection(String... names) {
        JsonObject answ = new JsonObject();
        for (String name : names) {
            if (contains(name)) {
                answ.add(new JsonPair(name, find(name)));
            }
        }
        return answ;
    }
}
