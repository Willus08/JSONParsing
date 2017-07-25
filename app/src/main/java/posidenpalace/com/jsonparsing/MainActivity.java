package posidenpalace.com.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String responce =
                "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";
        try {
            parseJson(responce);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void parseJson(String string) throws JSONException {
        JSONObject jsonObject = new JSONObject(string);
        System.out.println(jsonObject);
        JSONObject jsonMenu = jsonObject.getJSONObject("menu");
        System.out.println(jsonMenu);
        JSONObject jsonObjectPopup = jsonMenu.getJSONObject("popup");
        System.out.println(jsonObjectPopup);
        JSONArray jsonMenuItem = jsonObjectPopup.optJSONArray("menuitem");
        System.out.println(jsonMenuItem);
        for (int i = 0; i <jsonMenuItem.length() ; i++) {
            JSONObject jsonObjectItems= (JSONObject) jsonMenuItem.get(i);
            System.out.println(jsonObjectItems.get("onclick"));
        }

    }
}
