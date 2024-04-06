package org.Testcases;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonpractice {



public static void createjson()
{

    JSONArray jsonArray= new JSONArray();
    jsonArray.add("asdasd");
    jsonArray.add("kets");

    JSONObject jsonobject= new JSONObject();
    jsonobject.put("keys",jsonArray);
    jsonobject.put("first","test");
    jsonobject.put("ls","ing");

    System.out.println(jsonobject.toJSONString());
}
public static void readjson() throws ParseException {
    String read="{\"keys\":[\"asdasd\",\"kets\"],\"ls\":\"ing\",\"first\":\"test\"}";

    JSONParser parser=new JSONParser();
    Object obj= parser.parse(read);

    JSONObject jsonObject=(JSONObject) obj;
    System.out.println(jsonObject.get("ls").toString());
    System.out.println(jsonObject.get("keys").toString());

    JSONArray jsonArray = (JSONArray) (jsonObject.get("keys"));
     System.out.println(jsonArray.get(0));

}



public static void readingjson() throws ParseException {
    String bogy= "{\"keys\":[\"asdasd\",\"kets\"],\"ls\":\"ing\",\"first\":\"test\"}";


    JSONParser jp = new JSONParser();
     JSONObject obj= (JSONObject) jp.parse(bogy);

     JSONArray ja = (JSONArray) obj.get("keys");
    System.out.println( ja.get(1));
     System.out.println( obj.get("keys"));
}

    public static void main(String[] args) throws ParseException {

      //  createjson();
    //    readjson();
        readingjson();
    }







}
