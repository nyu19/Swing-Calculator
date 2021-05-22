package Swing;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyCalculator extends JFrame {

    private JPanel MainPanel;
    private JButton submitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton addition;
    private JRadioButton subtraction;
    private JRadioButton multiplication;
    private JRadioButton division;
    private static ButtonGroup calc;
    private static byte currentSelection = 69;

    public void iconHandler() throws MalformedURLException {
        Image image = Toolkit.getDefaultToolkit().getImage(new URL("https://img.icons8.com/doodle/2x/calculator.png"));
        setIconImage(image);
        setTitle("Swing Calculator");
    }
    public MyCalculator(){
        try{ this.iconHandler(); }catch (MalformedURLException ml){System.out.println(ml.getMessage());}
        buttonGroup();
        setSize(200,100);
        textField1.setColumns(4);
        textField2.setColumns(4);
        this.setContentPane(MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addition.addActionListener(e -> {
            System.out.println("Addition is Checked");
            currentSelection = 0;
        });
        subtraction.addActionListener(e -> {
            System.out.println("Subtraction is Checked");
            currentSelection = 1;
        });
        multiplication.addActionListener(e -> {
                System.out.println("Multiplication is Checked");
                currentSelection = 2;
        });
        division.addActionListener(e->{
                System.out.println("Division is Checked");
                currentSelection = 3;
        });
        submitButton.addActionListener(e ->{
//                System.out.println(textField1.getText());
            try{
                double inp1 = Double.parseDouble(textField1.getText());
                double inp2 = Double.parseDouble(textField2.getText());
                System.out.println(currentSelection);
                textField1.setText(handleCalc(inp1,inp2));
                textField2.setText("");
            }
            catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(new JFrame(),"Can't Perform actions with air.. Can I.");
                System.out.println(nfe.getMessage());
            }
        });
    }
    private void buttonGroup(){
        calc = new ButtonGroup();
        calc.add(addition);calc.add(subtraction);calc.add(multiplication);calc.add(division);
    }
    private String handleCalc(double inp1,double inp2){
        switch (currentSelection){
            case 0 -> {
                return String.valueOf(inp1 + inp2);
            }
            case 1 -> {
                return String.valueOf(inp1 - inp2);
            }
            case 2 -> {
                return String.valueOf(inp1 * inp2);
            }
            case 3 -> {
                return String.valueOf(inp1 / inp2);
            }
            default -> {
                JOptionPane.showMessageDialog(new JFrame(),"Please Select Some Option");
                return "";
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new MyCalculator();
        frame.setVisible(true);
        frame.pack();
    }
}
