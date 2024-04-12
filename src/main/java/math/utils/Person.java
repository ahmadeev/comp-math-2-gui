package math.utils;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Person{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*    private SimpleStringProperty name;
    private SimpleIntegerProperty age;

    public Person(String name, int age){
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
    }

    public String getName(){ return name.get();}
    public void setName(String value){ name.set(value);}

    public int getAge(){ return age.get();}
    public void setAge(int value){ age.set(value);}*/

/*    public static TableColumn<Person, String> getNameCol(){
        TableColumn<Person, String> name = new TableColumn<>("name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        return name;
    }
    public static TableColumn<Person, Integer> getAgeCol(){
        TableColumn<Person, Integer> age = new TableColumn<>("age");
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        return age;
    }*/
}