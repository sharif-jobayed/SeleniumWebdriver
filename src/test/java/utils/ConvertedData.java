package utils;

public class ConvertedData {

    // AppData
    public static class AppData {
        private String BaseURL;

        public String getBaseURL() {
            return this.BaseURL;
        }
    }

    // TestData
    public static class TestData {
        private String SearchTitle;

        public String getSearchTitle() {
            return this.SearchTitle;
        }

        // Timeouts
        public static class Timeouts {
            private Integer Min;
            private Integer Med;
            private Integer Max;

            public Integer getMin() {
                return this.Min;
            }

            public Integer getMed() {
                return this.Med;
            }

            public Integer getMax() {
                return this.Max;
            }
        }
    }
}
