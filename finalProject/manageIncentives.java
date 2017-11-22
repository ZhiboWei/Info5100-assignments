package finalProject;

import javax.swing.*;
import java.awt.*;

public class manageIncentives {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(2000,1000);
        frame.setLocation(100,100);
        frame.setTitle("Manage Incentives");

        Container pane = frame.getContentPane();
        //pane.setLayout(new FlowLayout());
        pane.setLayout(null);


        Font f = new Font("Arial",Font.BOLD,24);
        JLabel firstlabel = new JLabel("Manage Incentives",JLabel.CENTER);
        firstlabel.setFont(f);
        firstlabel.setBounds(800,10,300,40);
        pane.add(firstlabel);

        JTextField search = new JTextField(20);
        JButton button1 = new JButton("search");
        search.setBounds(700,100,480,35);
        button1.setBounds(1200,100,100,35);
        pane.add(search);
        pane.add(button1);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Car");
        comboBox.addItem("Van");
        comboBox.setBounds(1400,200,35,20);
        pane.add(comboBox);

        JButton button2 = new JButton("price");
        JButton button3 = new JButton("date");
        JButton button4 = new JButton("discount");
        button2.setBounds(1450,200,70,20);
        button3.setBounds(1530,200,70,20);
        button4.setBounds(1610,200,85,20);
        pane.add(button2);
        pane.add(button3);
        pane.add(button4);

        JComboBox filter1 = new JComboBox();
        filter1.addItem("make");
        filter1.addItem("Nissan");
        JComboBox filter2 = new JComboBox();
        filter2.addItem("year");
        filter2.addItem("2015");
        filter2.addItem("2014");
        JComboBox filter3 = new JComboBox();
        filter3.addItem("color");
        filter3.addItem("red");
        filter1.setBounds(100,200,70,20);
        filter2.setBounds(100,250,70,20);
        filter3.setBounds(100,300,70,20);
        pane.add(filter1);
        pane.add(filter2);
        pane.add(filter3);

        JButton add = new JButton("add");
        JButton delete = new JButton("delete");
        JButton edit = new JButton("edit");
        add.setBounds(700,800,150,40);
        delete.setBounds(870,800,150,40);
        edit.setBounds(1040,800,150,40);
        pane.add(add);
        pane.add(delete);
        pane.add(edit);
        frame.setVisible(true);

    }


}
