import javafx.scene.web.WebView;

public class AudiProfileController {
    public WebView audiWebContext;

    public void initialize(){

        audiWebContext.getEngine().load("https://www.audi-mediacenter.com/en/press-releases/audi-a6-e-tron-concept-the-next-e-volution-13918");
    }




}
