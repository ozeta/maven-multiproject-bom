package dev.oz.leafB;

import org.json.JSONObject;

/**
 * Hello world!
 */
public class App {

    public static String getNode() {
        return "node " + App.class.getCanonicalName();
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "OK");
        System.out.println("Node B main!");
        System.out.println(jsonObject);

    }
}
