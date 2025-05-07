import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class login extends JFrame implements ActionListener
{
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    login()
    {

        ImageIcon i1 = new ImageIcon("final/result/logo1.jpg");
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("WISDOM WEALTH BANK");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Berlin Sans FB",Font.ROMAN_BASELINE,40));
        text.setBounds(200,40,500,40);
        add(text);

        JLabel cardno = new JLabel("Card No. : ");
        cardno.setForeground(Color.WHITE);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN : ");
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,18));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

         clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

         signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup  .addActionListener(this);
        add(signup);

        // BackGround Image
        ImageIcon icon = new ImageIcon("final/result/Login.png");
        Image icon2= icon.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,700,500);
        add(label1);

        setTitle("WISDOM WEALTH BANK");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(700,500);
        setLocation(350,170);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == login)
        {
            connect1 c1 = new connect1();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber +"'";
            try
            {
              ResultSet rs = c1.s.executeQuery(query);
              if (rs.next())
              {
                  setVisible(false);
                    new MainAccount(pinnumber).setVisible(true);
              }
              else
              {
                  cardTextField.setText("");
                  pinTextField.setText("");
                  JOptionPane.showMessageDialog(null,"Invalid cardnumber or pin");

              }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == signup)
        {
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}
