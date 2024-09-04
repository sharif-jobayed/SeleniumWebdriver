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

/*================================= User starts =================================*/

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

    public void setUsers(Map<String, User> users) {
        this.Users = users;
    }

    public Map<String, User> getUsers() {
        return Users;
    }

/*================================= User ends =================================*/

/*================================= Timeouts start =================================*/

    public static class Timeouts {
        private Integer Minimum;
        private Integer Medium;
        private Integer Maximum;

        public Integer getMinimum() {
            return this.Minimum;
        }

        public Integer getMedium() {
            return this.Medium;
        }

        public Integer getMaximum() {
            return this.Maximum;
        }
    }

/*================================= Timeouts end =================================*/
}
