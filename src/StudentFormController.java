import com.sun.jndi.cosnaming.CNCtx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.datatransfer.FlavorListener;
import java.io.Serializable;
import java.util.List;

public class StudentFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtSearch;
    public TableView tblStudents;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;

    public void initialize(){

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        loadAllStudents();
    }

    private void loadAllStudents() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Student");
        List <Student> list= query.list();
        ObservableList<StudentTM> observableList= FXCollections.observableArrayList();


        for (:Student student:list
             ) {
                observableList.add(new StudentTM(
                        student.getId(), student.getName(), student.getContact(), student.getAddress()
                ));
        }

        tblStudents.setItems(observableList);
        
        System.out.println();
    }

    public void btnSaveStudentOnAction(ActionEvent actionEvent) {
        Student s1=new Student(
                txtId.getText(),
                txtName.getText(),
                txtContact.getText(),
                txtAddress.getText()
        );
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(s1);
        System.out.println(save);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
        Student s1=new Student(
                txtId.getText(),
                txtName.getText(),
                txtContact.getText(),
                txtAddress.getText()
        );
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(s1);
        transaction.commit();
        loadAllStudents();
        session.close();
        sessionFactory.close();
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {

        Student s1=new Student(
                txtId.getText(),
                txtName.getText(),
                txtContact.getText(),
                txtAddress.getText()
        );
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(s1);
        transaction.commit();
        loadAllStudents();
        session.close();
        sessionFactory.close();
    }
}
