import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Test {
    public static List<DungeonData> dungeonsList = new ArrayList<>();
    public static List<QuestData> questsList = new ArrayList<>();
    public static Date date = new Date();
    public static SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String dateOut = simpleDate.format(date);

    public static void main(String[] args) throws IOException, ParseException {
        new Frame().frame();
        dungeonsList.add(new DungeonData(1, "akra", dateOut));
        dungeonsList.add(new DungeonData(2, "akra", dateOut));
        dungeonsList.add(new DungeonData(3, "akra", dateOut));
        dungeonsList.add(new DungeonData(4, "akra", dateOut));
        dungeonsList.add(new DungeonData(5, "akra", dateOut));

        questsList.add(new QuestData(1, "bt", dateOut));
        questsList.add(new QuestData(2, "bt", dateOut));
        questsList.add(new QuestData(3, "bt", dateOut));
        questsList.add(new QuestData(4, "bt", dateOut));
        questsList.add(new QuestData(5, "bt", dateOut));

        JsonArray jsonArray = new JsonArray(dungeonsList, questsList);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("timings.json");
        writer.write(gson.toJson(jsonArray));
        writer.close();



        Object obj = new JSONParser().parse(new FileReader("timings.json"));

            JSONObject jsonObject =  (JSONObject) obj;

            JSONArray cars = (JSONArray) jsonObject.get("dungeonsList");
            JSONObject test = (JSONObject) cars.get(0);
            long id = (long) test.get("id");
            String nameT = (String) test.get("name");
            String rollback = (String) test.get("rollback");
            System.out.println(id);
            System.out.println(nameT);
            System.out.println(rollback);
    }
}


    //        public static void test2(){
//
//            List<DungeonData> dungeonDataList = new ArrayList<>();
//            List<QuestData> questDataList = new ArrayList<>();
//
//            for(DungeonData dungeon : dungeonsList) {
//                dungeonDataList.add(dungeon);
//
//            }
//
//            for(QuestData quest : questsList) {
//                questDataList.add(quest);
//
//            }
//            System.out.println(dungeonDataList);
//            System.out.println(questDataList);
//
//            System.out.println(dungeonDataList.get(2));
//            System.out.println(questDataList.get(3));
//
//            String tstStr = dungeonDataList.toString();
//            String[] tst = tstStr.split("==");
//            for (String tst2 : tst){
//                System.out.println(tst2);
//            }
//        }

//        for (int i = 0; i < 5; i++) {
//            System.out.println(dungeonsList.get(i));
//        }
//        for(QuestData quest : questsList) {
//            System.out.println(quest);
//        }

