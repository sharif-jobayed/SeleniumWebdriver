package saucedemo.framework.utils;

import com.google.gson.annotations.SerializedName;

public class ConvertedData {
    // Users
    @SerializedName("Users")
    private Users users = new Users();

    public static class Users {
        // StandardUser
        @SerializedName("StandardUser")
        private StandardUser standardUser = new StandardUser();

        public static class StandardUser {
            @SerializedName("UserName")
            private String userName;

            @SerializedName("Password")
            private String password;

            public String getUserName() {
                return this.userName;
            }

            public String getPassword() {
                return this.password;
            }
        }

        public StandardUser getStandardUser() {
            return standardUser;
        }

        // LockedOutUser
        @SerializedName("LockedOutUser")
        private LockedOutUser lockedOutUser = new LockedOutUser();

        public static class LockedOutUser {
            @SerializedName("UserName")
            private String userName;

            @SerializedName("Password")
            private String password;

            public String getUserName() {
                return this.userName;
            }

            public String getPassword() {
                return this.password;
            }
        }

        public LockedOutUser getLockedOutUser() {
            return lockedOutUser;
        }
    }

    public Users getUsers() {
        return users;
    }
}
