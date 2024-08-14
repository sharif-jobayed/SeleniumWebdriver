package framework.utils;

import java.util.Map;

public class ProcessedData {

    // URLs
    public static class URLs {
        private Map<String, String> URLs;

        public String getBaseURL() {
            return URLs.get("BaseURL");
        }

        public String getDescription() {
            return URLs.get("Description");
        }
    }

    // Users
    public static class Users {
        private Map<String, User> Users;

        public User getUser01() {
            return Users.get("User01");
        }

        public User getUser02() {
            return Users.get("User02");
        }

        public static class User {
            private String UserName;
            private String UserPassword;

            public String getUserName() {
                return UserName;
            }

            public String getUserPassword() {
                return UserPassword;
            }
        }
    }

    // Timeouts
    public static class Timeouts {
        private Map<String, Integer> Timeouts;

        public Integer getMinimum() {
            return Timeouts.get("Minimum");
        }

        public Integer getMedium() {
            return Timeouts.get("Medium");
        }

        public Integer getMaximum() {
            return Timeouts.get("Maximum");
        }
    }
}
