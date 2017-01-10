package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject answer = new JsonObject();
        answer.add(new JsonPair("name", new JsonString(name)));
        answer.add(new JsonPair("surname", new JsonString(surname)));
        answer.add(new JsonPair("year", new JsonNumber(year)));
        return answer;
    }
}
