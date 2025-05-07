import com.mysql.cj.jdbc.admin.MiniAdmin;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Statement extends JFrame implements ActionListener {
    JLabel statement;
    JButton back;
    String pin;
    JScrollBar  a;
    public Statement(String pinnumber)
    {
        pin=pinnumber;
        setLayout(null);

        statement = new JLabel("Statement");
        statement.setFont(new Font("Engravers MT",Font.BOLD,25));
        statement.setBounds(100,50,400,30);
        add(statement);

        JLabel card = new JLabel();
        card.setBounds(30,120,300,20);
        add(card);

        JLabel mini = new JLabel();
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        try{
            connect1 c = new connect1();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){}

        try {

            connect1 c1 = new connect1();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
            int bal=0;
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current account balance is Rs " + bal);
        }
        catch (Exception e){}
        mini.setBounds(20,160,400,200);

        back = new JButton("Back");
        back.setBounds(35,480,100,30);
        back.setBackground(new Color(29,100,128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Osward", Font.BOLD, 18));
        add(back);
        back.addActionListener(this);

        mini.setBounds(20,140,400,200);
          a = new JScrollBar();
        a.setSize(400,600);
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back)
        {
            setVisible(false);
            new MainAccount(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Statement("").setVisible(true);
    }
}
