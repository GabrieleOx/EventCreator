
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EventCreator {
    public static void main(String[] args) {
        JFrame baseWindow = new JFrame("EventCreator");
        JLabel nomeFileLabel = new JLabel("Nome file:"), titoloLabel = new JLabel("Quanti eventi vuoi inserire ?");
        JTextField nomeFileTextField = new JTextField("GenericEvent"), numberEventsTextField = new JTextField("2");
        JCheckBox singleEventCheckBox = new JCheckBox(":Evento Singolo"), multipleEventCheckBox = new JCheckBox(":Evento Multiplo");
        JButton insertButton = new JButton("Inserisci");

        //Graphical part

        baseWindow.setResizable(false);
        baseWindow.setSize(500, 500);
        baseWindow.getContentPane().setBackground(Color.gray);
        baseWindow.setLayout(null);
        baseWindow.add(nomeFileLabel);
        baseWindow.add(nomeFileTextField);
        baseWindow.add(titoloLabel);
        baseWindow.add(singleEventCheckBox);
        baseWindow.add(multipleEventCheckBox);
        baseWindow.add(numberEventsTextField);
        baseWindow.add(insertButton);

        nomeFileLabel.setBounds(60, 20, 110, 40);
        nomeFileLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        nomeFileTextField.setBounds(190, 20, 200, 40);
        nomeFileTextField.setFont(new Font("Verdana", Font.PLAIN, 20));
        nomeFileTextField.setBackground(new Color(180, 180, 180));

        titoloLabel.setBounds(40, 100, 410, 40);
        titoloLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        titoloLabel.setForeground(new Color(99, 45, 45));

        //First col:

        singleEventCheckBox.setBounds(30, 250, 200, 30);
        singleEventCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        singleEventCheckBox.setBackground(Color.gray);

        //Second col:

        multipleEventCheckBox.setBounds(260, 210, 200, 30);
        multipleEventCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        multipleEventCheckBox.setBackground(Color.gray);

        numberEventsTextField.setBounds(260, 300, 200, 30);
        numberEventsTextField.setFont(new Font("Verdana", Font.PLAIN, 20));
        numberEventsTextField.setBackground(new Color(180, 180, 180));

        //Bottom:

        insertButton.setBounds(140, 380, 200, 50);
        insertButton.setFont(new Font("Verdana", Font.BOLD, 20));
        insertButton.setBackground(new Color(186, 130, 130));

        baseWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        baseWindow.setVisible(true);
    }
}
