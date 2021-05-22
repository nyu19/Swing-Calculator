package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

class Abc extends JFrame{
    public void iconHandler() throws MalformedURLException{
        Image image = Toolkit.getDefaultToolkit().getImage(new URL("https://img.icons8.com/doodle/2x/calculator.png"));
        setIconImage(image);
        setTitle("Swing Calculator");
        setVisible(true);
        setSize(400,400);
        setLayout(new GridLayout());
    }
    public float calculationHandler(){
        JTextField inp1 = new JTextField();
        inp1.setBounds(200,200,100,40);

        JButton b1 = new JButton("console log");
        b1.setSize(100,100);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(inp1.getText());
            }
        });
        add(inp1);add(b1);
        return 0f;
    }
    public Abc(){
        try {iconHandler();} catch (Exception e){System.out.println("Error in icon Handler"+e);}
        getContentPane().setBackground(Color.DARK_GRAY);
        calculationHandler();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
public class MainSwing {
    public static void main(String[] args) {
        try {
            new Abc();
        }
        catch (Exception e){
            System.out.println("Error in Main class "+e);
        }
    }
}
