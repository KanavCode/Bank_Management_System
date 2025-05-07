import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Loan extends JFrame implements ActionListener {
    JButton back, homeLoan, personalLoan, CarLoan, GoldLoan;
    String pinnumber;
    public Loan(String pinnumber)
    {
        this.pinnumber=pinnumber;
        // Label of All Loans Heading
        JLabel personal = new JLabel("Personal Loan    Home Loan       Car Loan         Gold Loan");
        personal.setForeground(Color.BLACK);
        personal.setFont(new Font("Osward",Font.BOLD,18));
        personal.setBounds(95,170,800,26);
        add(personal);

        // Back Button
        back = new JButton("Back");
        back.setBounds(50,410,90,25);
        back.setBackground(new Color(29,100,128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Osward", Font.BOLD, 18));
        add(back);
       back.addActionListener(this);

        // Personal Loan BackGround Image
        ImageIcon iconp = new ImageIcon("final/result/personalLoanIcon.jpg");
        Image iconpp= iconp.getImage().getScaledInstance(127,190,Image.SCALE_DEFAULT);
        ImageIcon iconppp = new ImageIcon(iconpp);

        // Personal Loan Button
        personalLoan = new JButton("");
        personalLoan.setBounds(93,200,132,190);
        personalLoan.setIcon(iconppp);
        personalLoan.setFont(new Font("Osward", Font.BOLD, 0));
        add(personalLoan);
       personalLoan.addActionListener(this);

        // Home Loan BackGround Image
        ImageIcon iconh = new ImageIcon("final/result/homeLoanicon.jpg");
        Image iconhh= iconh.getImage().getScaledInstance(127,190,Image.SCALE_DEFAULT);
        ImageIcon iconhhh = new ImageIcon(iconhh);

        // Home Loan Button
        homeLoan = new JButton("");
        homeLoan.setBounds(222,200,127,190);
        homeLoan.setIcon(iconhhh);
        homeLoan.setFont(new Font("Osward", Font.BOLD, 0));
        add(homeLoan);
        homeLoan.addActionListener(this);

        // Car Loan BackGround Image
        ImageIcon iconc = new ImageIcon("final/result/CarLoanicon.jpg");
        Image iconcc= iconc.getImage().getScaledInstance(127,190,Image.SCALE_DEFAULT);
        ImageIcon iconccc = new ImageIcon(iconcc);

        // Car Loan Button
        CarLoan = new JButton("");
        CarLoan.setBounds(348,200,127,190);
        CarLoan.setIcon(iconccc);
        CarLoan.setFont(new Font("Osward", Font.BOLD, 0));
        add(CarLoan);
       CarLoan.addActionListener(this);

        // Gold Loan BackGround Image
        ImageIcon icong = new ImageIcon("final/result/GoldLoanicon.jpg");
        Image icongg= icong.getImage().getScaledInstance(127,190,Image.SCALE_DEFAULT);
        ImageIcon iconggg = new ImageIcon(icongg);

        // Gold Loan Button
        GoldLoan = new JButton("");
        GoldLoan.setBounds(474,200,127,190);
        GoldLoan.setIcon(iconggg);
        GoldLoan.setFont(new Font("Osward", Font.BOLD, 0));
        add(GoldLoan);
        GoldLoan.addActionListener(this);

        // Loan BackGround Image
        ImageIcon icon = new ImageIcon("final/result/Loan.jpg");
        Image icon2= icon.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,700,500);
        add(label1);

        setTitle("Loan : ");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(700,500);
        setLocation(350,170);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back) {
            setVisible(false);
            new MainAccount("").setVisible(true);
        }
        else if (e.getSource()==homeLoan)
        {
            setVisible(false);
            new HomeLoan(pinnumber).setVisible(true);
        }
        else if(e.getSource()==CarLoan)
        {
            setVisible(false);
            new CarLoan(pinnumber).setVisible(true);
        }
        else if(e.getSource()==GoldLoan)
        {
            setVisible(false);
            new GoldLoan(pinnumber).setVisible(true);
        }
        else if(e.getSource()==personalLoan)
        {
            setVisible(false);
            new PersonalLoan(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new Loan("");
    }

}
