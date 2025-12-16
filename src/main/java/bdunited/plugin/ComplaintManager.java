package bdunited.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class ComplaintManager {

    private final File file;

    public ComplaintManager(JavaPlugin plugin) {
        file = new File(plugin.getDataFolder(), "complaints.json");

        if (!file.exists()) {
            try {
                plugin.getDataFolder().mkdirs();
                file.createNewFile();
                try (FileWriter w = new FileWriter(file)) {
                    w.write("[]");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void save(String by, String against, String reason) {
        try {
            JSONArray arr = (JSONArray) new JSONParser().parse(new FileReader(file));

            JSONObject obj = new JSONObject();
            obj.put("by", by);
            obj.put("against", against);
            obj.put("reason", reason);
            obj.put("time", System.currentTimeMillis());

            arr.add(obj);

            try (FileWriter w = new FileWriter(file)) {
                w.write(arr.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }
}
