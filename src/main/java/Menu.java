
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Menu extends JPanel {
    public Menu() {

        setSize(700,400);
        setVisible(true);

        add(new Daftar());

    }
}

class Daftar extends JPanel {
    JLabel judul = new JLabel();
    public ImageIcon image;
    public JLabel label1;
    public ImageIcon image2;
    public JLabel label2;
    public ImageIcon image3;
    public JLabel label3;

    public Daftar() {
        setLayout(new GridLayout(3,2));


        image = new ImageIcon(getClass().getResource("peanut2.jpg"));
        label1 = new JLabel(image);
        add(label1);


        class red extends JPanel{

            public red() {
                setLayout(new GridLayout(2,1));
                add(new JLabel("Peanut Butter Chocolate"));
                add(new JLabel("Rp 300.000"));
            }
        }

        add(new red());


        image2 = new ImageIcon(getClass().getResource("pumpkin2.jpg"));
        label2 = new JLabel(image2);
        add(label2);

        class no2 extends JPanel{

            public no2() {
                setLayout(new GridLayout(2,1));
                add(new JLabel("Pumpkin Cake"));
                add(new JLabel("Rp 250.000"));
            }
        }

        add(new no2());


        image3 = new ImageIcon(getClass().getResource("redvelvet2.jpg"));
        label3 = new JLabel(image3);
        add(label3);


        class no3 extends JPanel{

            public no3() {
                setLayout(new GridLayout(2,1));
                add(new JLabel("Red Velvet Cake"));
                add(new JLabel("Rp 150.000"));
            }
        }

        add(new no3());

        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, ("ATHELIE CAKE"));
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), titledBorder));

    }

}

