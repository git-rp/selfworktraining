package apps.aemproject.components.content.sightlytest;
import com.adobe.cq.sightly.WCMUse;
public class SightlyOp extends WCMUse {
    private String reverseText;
    private String lowerCaseTitle;
    private String lowerCaseDescription;

    @Override
    public void activate() throws Exception {

        lowerCaseTitle = getProperties().get("title", "").toLowerCase();
        lowerCaseDescription = getProperties().get("description", "").toLowerCase();
        String text = get("text", String.class);
        reverseText = new StringBuffer(text).reverse().toString();

    }

    public String getLowerCaseTitle() {
        return lowerCaseTitle;
    }

    public String getLowerCaseDescription() {
        return lowerCaseDescription;
    }

    public String getReverseText() {
        return reverseText;

    }
}