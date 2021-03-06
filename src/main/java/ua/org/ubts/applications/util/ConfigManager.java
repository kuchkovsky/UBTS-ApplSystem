package ua.org.ubts.applications.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final String APP_FOLDER = System.getProperty("user.home") + File.separator + "ubts-applications";

    public static class DavProperties {

        private String login;
        private String password;
        private String url;

        public DavProperties(String login, String password, String url) {
            this.login = login;
            this.password = password;
            this.url = url;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getUrl() {
            return url;
        }
    }

    public static DavProperties getDavProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(APP_FOLDER + File.separator + "dav.properties")) {
            properties.load(inputStream);
            return new DavProperties(properties.getProperty("login"), properties.getProperty("password"),
                    properties.getProperty("url"));
        }
    }

}
