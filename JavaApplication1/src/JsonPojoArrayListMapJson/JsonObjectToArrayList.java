package JsonPojoArrayListMapJson;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonObjectToArrayList {

    List<SamplePOJO> arrList = new ArrayList<SamplePOJO>();

    public List getArrayListOfObj() {
        JSONParser parser = new JSONParser();
        try {
            Object routeObj = parser.parse(new FileReader("sample.json"));
            JSONArray list = (JSONArray) routeObj;
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {
                JSONObject obj2 = (JSONObject) iterator.next();
                SamplePOJO samplePOJO = new SamplePOJO();
                String name = (String) obj2.get("name");
                //int age =((Long)obj2.get("age")).intValue();
                int age =(int) obj2.get("age");
               // int age = (Integer) obj2.get("age");
                String city = (String) obj2.get("city");
                //System.out.println(name + " " + age + " " + city);
                samplePOJO.setAge(age);
                samplePOJO.setCity(city);
                samplePOJO.setName(name);
                arrList.add(samplePOJO);
            }
//            for (SamplePOJO s : arrList) {
//                System.out.println(s.getName() + " " + s.getAge() + " " + s.getCity());
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arrList;
    }
}