import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Viacheslav on 06.12.2018.
 */
public class DisplayActions implements ActionListener, FocusListener {

    JTextField cntCharacters = Display.manySymbols;
    //static String pass2;

    public DisplayActions(Display display) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        //получаем событие нажатия кнопки Generate
        if (src==Display.generateButton ){
            // получаем данные с окна ввода кол-ва символов
            // и проверяем на ввод числового значения
            try {
                    String sSymbols = cntCharacters.getText();
                    Password2.cntChars = Integer.parseInt(sSymbols);
            } catch (NumberFormatException e1){
                JOptionPane.showConfirmDialog(null,
                        "Введите число символов пароля",
                        "Ошибка",
                        JOptionPane.PLAIN_MESSAGE);
                Password2.cntChars= 0;

            }
            //если поле пустое, то не генерировать пароль
            if ( Password2.isFieldNotEmpty()){
            Password2.generate();

                Display.textArea.append(Password2.pass + "\n ");
                Password2.pass = "";
            }
        }
        // Очищаем экран нажатием кнопки Clear
        if (src==Display.clearButton ){
            Display.textArea.setText("");
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (cntCharacters.getText().equals("введите кол-во символов для пароля")) cntCharacters.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (cntCharacters.getText().equals("")) cntCharacters.setText("введите кол-во символов для пароля");
    }
}
