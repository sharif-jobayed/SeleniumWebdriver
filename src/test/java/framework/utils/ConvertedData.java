package framework.utils;

public class ConvertedData {
    // AppData
    public static class AppData {

        public static class AppDataBody {
            private String BaseURL;
            private Browsers Browsers;

            public String getBaseURL() {
                return this.BaseURL;
            }

            public Browsers getBrowsers() {
                return this.Browsers;
            }
        }

        // Browsers
        public static class Browsers {
            private String Firefox;
            private String Edge;
            private String Chrome;

            public String getFirefox() {
                return this.Firefox;
            }

            public String getEdge() {
                return this.Edge;
            }

            public String getChrome() {
                return this.Chrome;
            }
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
