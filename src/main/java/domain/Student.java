package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    JsonObject mainObj;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        mainObj = new JsonObject(new JsonPair("name", new JsonString(name)), new JsonPair("surnamename", new JsonString(surname)),
                new JsonPair("year", new JsonNumber(year)));

    }

    @Override
    public JsonObject toJsonObject() {
        // ToDo
        return null;
    }
}