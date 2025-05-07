import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Account extends JFrame implements ActionListener {
    JButton back;
    public Account()
    {

        JLabel account = new JLabel("ACCOUNT DETAILS");
        account.setForeground(Color.WHITE);
        account.setFont(new Font("Osward",Font.BOLD,38));
        account.setBounds(170,50,500,40);
        add(account);

        // For Account BackGround Photo
        ImageIcon i1 = new ImageIcon("final/result/AccountBack.jpg");
        Image i2 = i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,700,500);
        add(label);

        // Back Button
        back = new JButton("Back");
        back.setBounds(50,400,90,25);
        back.setBackground(new Color(29,100,128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Osward", Font.BOLD, 18));
        add(back);
        back.addActionListener(this);

        setTitle("Account Details : ");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(700,500);
        setLocation(350,170);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back)
        {
            setVisible(false);
            new MainAccount("").setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new Account();
    }
}
