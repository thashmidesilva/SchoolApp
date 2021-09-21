import javafx.scene.web.WebView;

public class BmwProfileController {
    public WebView bmwWebContext;

    public void initialize(){
        bmwWebContext.getEngine().load("https://www.bing.com/search?q=bmw+m6+coupe&cvid=acdf75295ddd4420b0e03f5cfa4de3c7&aqs=edge.0.0l9.24383j0j4&FORM=ANAB01&PC=U531");
    }
}
