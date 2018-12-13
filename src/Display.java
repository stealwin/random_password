import javax.swing.*;
import java.awt.*;

/**
 * Created by Viacheslav on 02.12.2018.
 */
public class Display extends JFrame {
    static TextArea textArea;
    static JTextField manySymbols;
    static JButton generateButton;
    static JButton clearButton;

    public  Display() throws HeadlessException {
        JPanel panel = new JPanel();

        GridLayout b1 = new GridLayout(1,2);
        panel.setLayout(b1);

        textArea = new TextArea();


        manySymbols = new JTextField("введите кол-во символов для пароля");

        //JTable table = new JTable();
        generateButton = new JButton("Generate");
        clearButton = new JButton("Clear");


        //panel.add(table);

        JPanel panel2 = new JPanel();
        BorderLayout b2 = new BorderLayout();
        panel2.setLayout(b2);
        panel2.add(manySymbols,"North");
        panel2.add(generateButton,"South");
        panel.add(panel2);

        JPanel panel3 = new JPanel();
        BorderLayout b3 = new BorderLayout();
        panel3.setLayout(b3);
        panel3.add(clearButton,"South");
        panel3.add(textArea,"Center");
        panel2.add(panel3);

        JFrame frame = new JFrame("Password generator");
        frame.setContentPane(panel);
        frame.pack();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DisplayActions action = new DisplayActions(this);
        generateButton.addActionListener(action);
        clearButton.addActionListener(action);
        manySymbols.addFocusListener(action);


    }
}
