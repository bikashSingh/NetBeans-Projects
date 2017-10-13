package JsonPojoArrayListMapJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListOfMap {

    List<SamplePOJO> arrListOfObj = new ArrayList<SamplePOJO>();
    List<Map> listOfMap = new ArrayList<Map>();

    public List getArrayListOfMap() {
        JsonObjectToArrayList arrayListOfObj = new JsonObjectToArrayList();
        arrListOfObj = arrayListOfObj.getArrayListOfObj();
        for (SamplePOJO s : arrListOfObj) {
            Map map = new HashMap();
            map.put("Name", s.getName());
            map.put("Age", s.getAge());
            map.put("City", s.getCity());
            listOfMap.add(map);
            //System.out.println(s.getName() + " " + s.getAge() + " " + s.getCity());
        }
//        for (Map m : listOfMap) {
//            Set set = m.entrySet();
//            Iterator<Map.Entry> itr = set.iterator();
//            while (itr.hasNext()) {
//                Map.Entry entry = itr.next();
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }

//            for (Map.Entry en : m.entrySet()) {
//                System.out.println(en.getKey() + " " + en.getValue());
//            }
//            System.out.println(m.entrySet());
        return listOfMap;
    }

}
