package darazBD.framework.utils;

import java.util.Map;

public class ConvertedData {
    private String BaseURL;
    private Map<String, User> Users;

    public String getBaseURL() {
        return BaseURL;
    }

    public void setBaseURL(String baseURL) {
        this.BaseURL = baseURL;
    }

    public Map<String, User> getUsers() {
        return Users;
    }

    public void setUsers(Map<String, User> users) {
        this.Users = users;
    }

    public static class User {
        private String UserEmail;
        private String UserPassword;

        public String getUserEmail() {
            return UserEmail;
        }

        public void setUserEmail(String userEmail) {
            this.UserEmail = userEmail;
        }

        public String getUserPassword() {
            return UserPassword;
        }

        public void setUserPassword(String userPassword) {
            this.UserPassword = userPassword;
        }
    }
}
