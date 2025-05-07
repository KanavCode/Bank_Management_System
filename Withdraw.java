import com.mysql.cj.xdevapi.DeleteStatement;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.sql.*;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JButton submit, back;
    JLabel Withdraw;
    JTextField money;
    String pin;

    public Withdraw(String pinnumber) {
        pin = pinnumber;
        setLayout(null);
        Withdraw = new JLabel("WITHDRAW");
        Withdraw.setForeground(Color.white);
        Withdraw.setFont(new Font("Raleway", Font.BOLD, 40));
        Withdraw.setBounds(239, 40, 400, 30);
        add(Withdraw);

        JLabel amount = new JLabel("Enter Amount");
        amount.setForeground(Color.white);
        amount.setFont(new Font("Raleway", Font.BOLD, 24));
        amount.setBounds(65, 215, 200, 36);
        add(amount);

        money = new JTextField();
        money.setBounds(240, 220, 200, 25);
        money.setFont(new Font("Arial", Font.BOLD, 14));
        add(money);


        submit = new JButton("Submit");
        submit.setBounds(290, 280, 100, 30);
        submit.setFont(new Font("Ralway", Font.BOLD, 16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);

        //back
        back = new JButton("Back");
        back.setBounds(60, 400, 100, 30);
        back.setBackground(new Color(29, 100, 128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Osward", Font.BOLD, 18));
        add(back);
        back.addActionListener(this);

        // For Deposit BackGround Photo
        ImageIcon i1 = new ImageIcon("final/result/dwicon.jpg");
        Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 700, 500);
        add(label);

        setSize(700, 500);
        setLocation(350, 170);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit) {
            try {
                String amount = money.getText();
                Date date = new Date();
                if (money.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else if (amount.matches("[0.0-9.0]*"))
                {
                    connect1 c = new connect1();
                    ResultSet resultSet = c.s.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withrawal Successfully");
                    setVisible(false);
                    new MainAccount(pin).setVisible(true);

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Entry");
                }
            } catch (Exception E) {

            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new MainAccount(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}



