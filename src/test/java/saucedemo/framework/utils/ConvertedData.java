package saucedemo.framework.utils;

public class ConvertedData {
    // appData
    public static class AppData {
        private String BaseURL;

        public String getBaseURL() {
            return BaseURL;
        }
    }

    // userCreds
    public static class UserCreds {
        public static class User {
            private String UserName;
            private String Password;

            public String getUserName() {
                return UserName;
            }

            public String getPassword() {
                return Password;
            }
        }

        private User StandardUser = new User();
        private User LockedOutUser = new User();
        private User ProblemUser = new User();
        private User PerformanceGlitchUser = new User();
        private User ErrorUser = new User();
        private User VisualUser = new User();

        public User getStandardUser() {
            return StandardUser;
        }

        public User getLockedOutUser() {
            return LockedOutUser;
        }

        public User getProblemUser() {
            return ProblemUser;
        }

        public User getPerformanceGlitchUser() {
            return PerformanceGlitchUser;
        }

        public User getErrorUser() {
            return ErrorUser;
        }

        public User getVisualUser() {
            return VisualUser;
        }
    }

    // timeOuts
    public static class TimeOuts {
        private Integer MIN;
        private Integer MED;
        private Integer MAX;

        public Integer getMINTimeout() {
            return MIN;
        }

        public Integer getMEDTimeout() {
            return MED;
        }

        public Integer getMAXTimeout() {
            return MAX;
        }
    }
}
