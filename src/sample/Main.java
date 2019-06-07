package sample;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;


import javax.annotation.processing.Messager;
import javax.lang.model.element.Name;
import javax.sound.midi.MetaMessage;
import java.util.EventListener;


public  class Main extends Application {

   int count=1;
   int a=0;
   TextField  name;
    TextField  phone;
    TextField  address;

    RadioButton small;
    RadioButton medium;
    RadioButton large;

    RadioButton thin;
    RadioButton thick;

    CheckBox papperoni;
    CheckBox olive;
    CheckBox tomato;
    CheckBox nuts;
    CheckBox mushrooms;
    CheckBox brochili;





    @Override

    public void start(Stage primaryStage) throws Exception{
      //  Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setTitle("Hello World");
        //heading
        Text textheading=new Text("Order your Pizza");
        textheading.setFont(new Font(20));
        textheading.setLineSpacing(10);
        //field for name
        HBox hBox1=new HBox(textheading);
        hBox1.setPadding(new Insets(20,20,20,20));
        Label lbName=new Label("Name:");
        lbName.setPrefWidth(100);
        name=new TextField();
        name.setPrefColumnCount(20);
        name.setPromptText("Enter your name");
        name.setMaxWidth(300);
        HBox hBox2=new HBox(lbName,name);
        hBox2.setPadding(new Insets(10));

        //field for phone number

        Label lbphone=new Label("Phone Number:");
        lbphone.setPrefWidth(100);
        phone=new TextField();
        phone.setPrefColumnCount(10);
        phone.setPromptText("Enter your no.");
        phone.setPrefWidth(100);

        HBox hbox3=new HBox(lbphone,phone);
        hbox3.setPadding(new Insets(10));

        // for address
        Label lbaddress=new Label("Address:");
        lbaddress.setPrefWidth(100);
        address =new TextField();
        address.setPrefColumnCount(45);
        address.setPromptText("Enter your Address");
        address.setMaxWidth(300);
        HBox hBox4=new HBox(lbaddress,address);
        hBox4.setPadding(new Insets(10));

        //pizza size

        Label labelsize=new Label("choose the size");
        small=new RadioButton("small");
        medium=new RadioButton("medium");
        large=new RadioButton("large");
        ToggleGroup grp=new ToggleGroup();
        small.setToggleGroup(grp);
        medium.setToggleGroup(grp);
        large.setToggleGroup(grp);
       medium.setSelected(true);

        VBox vBox2=new VBox(10,labelsize,small,medium,large);
        vBox2.setPadding(new Insets(20,20,20,20));


        //crisp

        Label  lbCrisp=new Label("Select Crust");
        thin=new RadioButton("thin");
        thin.setPadding(new Insets(10));

        thick=new RadioButton("thick");
        thick.setPadding(new Insets(10));


        ToggleGroup grp2=new ToggleGroup();
        thin.setToggleGroup(grp2);
        thick.setToggleGroup(grp2);
        thin.setSelected(true);
        VBox vBox3=new VBox(lbCrisp,thin,thick);
        vBox3.setPadding(new Insets(22,40,40,100));
        HBox hBox5=new HBox(vBox2,vBox3);

        //selecting toppings

        Label lbtoppings=new Label("Select toppings");
        papperoni=new CheckBox("Papperoni");
        papperoni.setPadding(new Insets(10,0,0,0));
        olive=new CheckBox("Olive");
        olive.setPadding(new Insets(10,0,0,0));
        tomato=new CheckBox("Tomato");
        tomato.setPadding(new Insets(10,0,0,0));
        brochili=new CheckBox("Brochilli");
        brochili.setPadding(new Insets(10,0,0,0));
        mushrooms=new CheckBox("Mushroom");
        mushrooms.setPadding(new Insets(10,0,0,0));
        VBox vBox4=new VBox(lbtoppings,papperoni,olive,tomato,brochili,mushrooms);
        vBox4.setPadding(new Insets(30));

        Button btn=new Button("Place Order");
        btn.setAlignment(Pos.BOTTOM_LEFT);
        btn.setPrefWidth(80);
        btn.setLineSpacing(20);
        //btn.setOnAction(e-> onclick() );



           btn.setOnAction(e->onclick(primaryStage));

           VBox vBox1=new VBox(textheading,hBox2,hbox3,hBox4,hBox5,vBox4,btn);
        BorderPane  pane=new BorderPane(vBox1);
        BorderPane pane1=new BorderPane();


        Scene scene=new Scene(pane,500,600);

        Scene order=new Scene(pane1,300,500);







        primaryStage.setScene(scene);

        primaryStage.setTitle("Order Pizza");
        primaryStage.show();
    }
    public void onclick(Stage primaryStage){

        String str="";

        str+=name.getText()+ " \n";
        str+=phone.getText()+ " \n";
        str+=address.getText()+ " \n";
        str+="Your order is: \n";

        if(small.isSelected()){
            str+="small,";
        }
        if(medium.isSelected()){
            str+="medium,";
        }
        if(large.isSelected()){
            str+="large,";
        }


        if(thin.isSelected()){
            str+="thin crust";
        }
        if(thick.isSelected()){
            str+="thick crust";
        }
        str+="pizza with\n";

        if(!name.getText().isEmpty()&&!phone.getText().isEmpty()&&!address.getText().isEmpty() ){
            Label lb=new Label(str);
            BorderPane pane1=new BorderPane(lb);




            Scene order=new Scene(pane1,300,500);
            primaryStage.setScene(order);

            primaryStage.setTitle("Order details");
            primaryStage.show();

        }


        // alert.setHeaderText(null);

    }
    private void string1(){
        System.out.println(1);
    }
    public static void main(String[] args) {
        launch(args);
    }

}
