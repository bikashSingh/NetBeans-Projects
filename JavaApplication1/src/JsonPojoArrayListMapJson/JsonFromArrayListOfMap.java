package JsonPojoArrayListMapJson;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonFromArrayListOfMap {

    public void createJSONfileUsingArrayListOfMap(List<Map> listOfMap) {
//        ArrayListOfMap arrayListOfMap = new ArrayListOfMap();
//        listOfMap = arrayListOfMap.getArrayListOfMap();
        JSONArray jsonArray = new JSONArray();
        String fileName = "newSample.json";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Map m : listOfMap) {
                Set set = m.entrySet();
                Iterator<Map.Entry> itr = set.iterator();
                JSONObject jsonObject = new JSONObject();
                while (itr.hasNext()) {
                    Map.Entry entry = itr.next();
                    jsonObject.put(entry.getKey(), entry.getValue());
                    //System.out.println(entry.getKey() + " " + entry.getValue());
                }
                jsonArray.add(jsonObject);
            }
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
            System.out.println(fileName + " file created\n");
        } catch (Exception e) {
            System.out.print(e);
        }
//        System.out.println(jsonObject);
    }

    public static void main(String[] args) throws Exception {
        ArrayListOfMap arrayListOfMap = new ArrayListOfMap();
        List<Map> listOfMap = new ArrayList<Map>();
        listOfMap = arrayListOfMap.getArrayListOfMap();
        JsonFromArrayListOfMap jsonFromArrayListOfMap = new JsonFromArrayListOfMap();
        jsonFromArrayListOfMap.createJSONfileUsingArrayListOfMap(listOfMap);
    }

}
