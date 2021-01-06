import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsCrawler {
    public static final String NEWS_REGEX = "<a data-utm=\"(.+?)\" class=\"news-item__avatar\" href=\"(.+?)\" title=\"(.+?)\">";
    public static final Pattern newsPattern = Pattern.compile(NEWS_REGEX);

    public static void main(String[] args) {
        try {
            URL newsURL = new URL("https://dantri.com.vn/the-gioi.htm");

            Scanner scanner = new Scanner(new InputStreamReader(newsURL.openStream()));
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
            scanner.close();

            String formatted = content
                    .toString()
                    .replaceAll("[\\n\\s]+", " ")
                    .replaceAll("&quot;", "");
            Matcher matcher = newsPattern.matcher(formatted);
            while (matcher.find()) {
                System.out.println(matcher.group(3));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}