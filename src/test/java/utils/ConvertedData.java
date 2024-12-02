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

        // TestDataBody
        public static class TestDataBody {
            private Timeouts Timeouts;
            private String SearchTitle;

            public Timeouts getTimeouts() {
                return this.Timeouts;
            }

            public String getSearchTitle() {
                return this.SearchTitle;
            }
        }

        // Timeouts
        public static class Timeouts {
            private int Min;
            private int Med;
            private int Max;

            public int getMin() {
                return this.Min;
            }

            public int getMed() {
                return this.Med;
            }

            public int getMax() {
                return this.Max;
            }
        }
    }
}
