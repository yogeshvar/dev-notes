public class URLify {
    /**
     * Chapter 1: Array and Strings
     * Interview Questions: 1.3
     */
    public static void main(String[] args) {
        String url = "Mr John Smith    ";
        int count = 13;
        url = url.substring(0, count);
        url = url.replace(" ", "%20");
        System.out.println(url);
    }
}
