package configurations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Config {
    private final String baseURL;

    private final Driver configDriver;
    private final User[] configUsers;


    public String getBaseURL() {
        return baseURL;
    }

    public Driver getConfigDriver() {
        return configDriver;
    }

    public User[] getConfigUsers() {
        return configUsers;
    }


    public Config() throws URISyntaxException, IOException {
        URL url = getClass().getClassLoader().getResource("config.json");
        assert url != null;
        URI uri = url.toURI();
        File src = Paths.get(uri).toFile();

        ObjectMapper objectMapper = new ObjectMapper();
        RootObject rootObject = objectMapper.readValue(src, RootObject.class);

        this.baseURL = rootObject.getBaseURL();
        this.configDriver = rootObject.getDriver();
        this.configUsers = rootObject.getUsers();
        applyTargetBrowser();

    }
    private void applyTargetBrowser(){
        boolean environmentRemoteParameter = System.getenv("REMOTE") != null;
        if (environmentRemoteParameter){
            configDriver.setRemote(true);
            configDriver.setBrowser("BROWSER");
            configDriver.setPlatform("PLATFORM");
        }

    }
    private static Config _instance;

    public static Config get_instance() throws URISyntaxException, IOException {
        if (_instance == null){
            _instance = new Config();
        }
        return _instance;
    }








}
