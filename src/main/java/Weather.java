import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Weather {


    public static String getWeather(String message,Model model) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+message+"&units=metric&appid=233f834360153ec5cedbfd865fa67987");

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";

        while(in.hasNext())
        {
            result+=in.nextLine();
        }

        JSONObject jsonObject = new JSONObject(result);
        model.setName(jsonObject.getString("name"));

        JSONObject main = jsonObject.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));
        model.setHumidity(main.getDouble("humidity"));

        JSONArray getArray = jsonObject.getJSONArray("weather");
        for(int i =0;i<getArray.length();i++)
        {
            JSONObject object = getArray.getJSONObject(i);
            model.setIcon((String) object.get("icon"));
            model.setMain((String) object.get("main"));
        }

        return "City"+model.getName()+"\n"+
                "Temperature"+model.getTemp()+"\n"+
                "Humidity"+model.getHumidity();
    }
}
