import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.util.Duration;
import sun.util.resources.cldr.af.CalendarData_af_NA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class TableFormController {
    public Label lblDate;
    public Label lblTime;
    public TextField txtId;
    public TextField txtName;
    public TextField txtContact;
    public TextArea txtAddress;
    //------------------------
    public TableView<StudentTM>tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colOption;
    //--------------------------

    public void initialize(){
        // set date and time
        setDateAndTime();
    }

    private void setDateAndTime() {
        /*Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.format(date);
        String dateNow = dateFormat.format(date);
        lblDate.setText(dateNow);*/
        //Method 2--------------------------
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(dateFormat.format(new Date()));


        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, e->{
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + " : " + currentTime.getMinute() + " : " + currentTime.getSecond());
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();



    }

    public void saveStudentOnAction(ActionEvent actionEvent) {
        Student student= new Student(
                txtId.getText(),
                txtName.getText(),
                txtContact.getText(),
                txtAddress.getText()
        );


        if( Database.studentDatabaseTable.add(student)){
            new Alert(Alert.AlertType.CONFIRMATION, "Saved...").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Try gain...").show();
        }

    }
}
