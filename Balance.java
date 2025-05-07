import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Balance extends JFrame implements ActionListener {
    JLabel balance, balanceText;
    JButton back;
    String pin;
    public Balance(String pinnumber)
    {
        pin=pinnumber;
        // Text Balance
        balance = new JLabel("Balance");
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("Osward",Font.BOLD,30));
        balance.setBounds(160,50,150,40);
        add(balance);

        // Balance Label
        balanceText= new JLabel();
        balanceText.setBounds(180,100,400,25);
        balanceText.setFont(new Font("Arial",Font.BOLD,20));
        balanceText.setForeground(Color.WHITE);
        balanceText.setBackground(null);
        add(balanceText);

        // Back Button
        back = new JButton("Back");
        back.setBounds(40,160,90,25);
        back.setBackground(new Color(29,100,128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        add(back);
        back.addActionListener(this);
        int balance =0;

        try{
            connect1 c = new connect1();
            ResultSet resultSet = c.s.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        balanceText.setText(""+balance);
        // For Balance BackGround Photo

        ImageIcon i1 = new ImageIcon("final/result/balance.jpg");
        Image i2 = i1.getImage().getScaledInstance(450,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,450,250);
        add(label);

        setTitle("View Balance");
        setLayout(null);
        setSize(450,250);
        setLocation(500,200);
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
    public static void main(String[] args)
    {
        new Balance("");
    }
}
