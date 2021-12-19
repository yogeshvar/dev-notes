public class URLify {

    public static void main(String[] args) {
        String url = "Mr John Smith    ";
        int count = 13;
        url = url.substring(0, count);
        url = url.replace(" ", "%20");
        System.out.println(url);
    }
}
    