import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Cashier extends JFrame{

    public Cashier(){
        setTitle("Cashier");
        setSize(450, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        setVisible(true);

        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane);
        tabbedPane.addTab("MENU", new Menu() );
        tabbedPane.addTab("PESAN", new semua() );

    }


}


class Pembelian extends JPanel {

    static JTextField text = new JTextField();
    static JTextField text1 = new JTextField();
    static JTextField text2 = new JTextField();
    JButton btn1 = new JButton("Total");
    static JTextField text3 = new JTextField();
    static JTextField text4 = new JTextField();


    static JComboBox<String> Pilihan = new JComboBox<>(new String[]{"Red Velvet Cake", "Pumpkin Cake", "Peanut Butter Chocolate"});
    static JComboBox<String> Pengantaran = new JComboBox<>(new String[]{"Take Away", "Delivery"});
    static JComboBox<String> Pembayaran = new JComboBox<>(new String[]{"Cash", "kredit", "Debit", "OVO", "Gopay", "Dana"});

    public Pembelian() {
        setLayout(new GridLayout(8, 2));
        add(new JLabel("Nama"));
        add(text);

        add(new JLabel("Alamat"));
        add(text1);

        add(new JLabel("Pilihan"));
        add(Pilihan);

        add(new JLabel("Harga"));
        add(text4);

        add(new JLabel("Quantity"));
        add(text2);

        add(new JLabel("Pengantaran"));
        add(Pengantaran);

        add(new JLabel("Pembayaran"));
        add(Pembayaran);

        add(btn1);
        add(text3);
        btn1.addActionListener(new TotalListener());
        Pilihan.addActionListener(new CakeListener());

        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, ("Pemesanan Cake"));
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20), titledBorder));

    }

    class CakeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String pil = Pilihan.getSelectedItem().toString();
            if (pil.equals("Red Velvet Cake")) {
                text4.setText("150000");
            } else if (pil.equals("Pumpkin Cake")) {
                text4.setText("250000");
            } else if (pil.equals("Peanut Butter Chocolate")) {
                text4.setText("300000");
            }
        }

    }


    class TotalListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int t = Integer.parseInt(text4.getText());
            int j = Integer.parseInt(text2.getText());
            int btn1 = t * j;
            text3.setText(String.valueOf(btn1));
        }
    }
}

class Total extends JPanel{

    JButton btn2 = new JButton("Pesan");
    JButton btn3 = new JButton("Cancel");

    public Total(){
        setLayout(new GridLayout(1,2));
        setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        add(Box.createHorizontalGlue());
        add(btn3);
        btn3.addActionListener(new Buttoncancel());
        add(btn2);
        btn2.addActionListener(new Buttoninsert());
    }

    class Buttoncancel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int exit = JOptionPane.showConfirmDialog(null, "Are you sure?" , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (exit == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }
    }

    class Buttoninsert implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Database db = new Database();
                db.insert(Pembelian.text.getText(),
                        Pembelian.text1.getText(),
                        Pembelian.Pilihan.getSelectedItem().toString(),
                        Pembelian.text2.getText(),
                        Pembelian.Pengantaran.getSelectedItem().toString(),
                        Pembelian.Pembayaran.getSelectedItem().toString(),
                        Pembelian.text3.getText());

                JOptionPane.showMessageDialog(null, "Pesanan akan segera diantar");

            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}