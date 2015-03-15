package apps.aemproject.components.content.sightlytest;
import com.adobe.cq.sightly.WCMUse;
public class ExtraHelper extends WCMUse {
    private String reverseText;
    @Override
    public void activate() throws Exception {
        String text = get("text", String.class);
        System.out.println("Value is :::::: "+text);
        reverseText = new StringBuffer(text).reverse().toString();

    }
    public String getReverseText() {
        return reverseText;

    }
}