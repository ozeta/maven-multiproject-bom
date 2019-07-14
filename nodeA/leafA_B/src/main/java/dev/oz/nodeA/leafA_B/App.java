package dev.oz.nodeA.leafA_B;

import org.json.JSONObject;

public class App
{
    public static String getNode()
    {
        return "node " + App.class.getCanonicalName();
    }

    public static void main(String[] args)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "OK");
        System.out.println("Node " + getNode());
        System.out.println(jsonObject);
    }

}
