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
                System.out.println("In the Min Timeout");
                return this.Min;
            }

            public Integer getMed() {
                System.out.println("In the Med Timeout");
                return this.Med;
            }

            public Integer getMax() {
                System.out.println("In the Max Timeout");
                return this.Max;
            }
        }
    }
}
