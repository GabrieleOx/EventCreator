
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EventCreator {
    public static void main(String[] args) {
        final String fileHeader = "Subject,Start Date,Start Time,End Date,End Time,All Day Event,Description,Location,Private\n";
        ArrayList<Evento> events = new ArrayList<>();
        final Integer [] nEvents = new Integer[20];

        for (int i = 0; i < 19; i++) nEvents[i] = i+2;

        JFrame baseWindow = new JFrame("EventCreator");
        JLabel nomeFileLabel = new JLabel("Nome file:"), titoloLabel = new JLabel("Quanti eventi vuoi inserire ?");
        JTextField nomeFileTextField = new JTextField("GenericEvent");
        JComboBox numberEventsTextField = new JComboBox<>(nEvents);
        JCheckBox singleEventCheckBox = new JCheckBox(":Evento Singolo"), multipleEventCheckBox = new JCheckBox(":Evento Multiplo");
        JButton insertButton = new JButton("Inserisci"), endButton = new JButton("Fine Inserimento");

        //Graphical part

        baseWindow.setResizable(false);
        baseWindow.setSize(500, 600);
        baseWindow.getContentPane().setBackground(Color.gray);
        baseWindow.setLayout(null);
        baseWindow.add(nomeFileLabel);
        baseWindow.add(nomeFileTextField);
        baseWindow.add(titoloLabel);
        baseWindow.add(singleEventCheckBox);
        baseWindow.add(multipleEventCheckBox);
        baseWindow.add(numberEventsTextField);
        baseWindow.add(insertButton);
        baseWindow.add(endButton);

        nomeFileLabel.setBounds(60, 20, 110, 40);
        nomeFileLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        nomeFileTextField.setBounds(190, 20, 200, 40);
        nomeFileTextField.setFont(new Font("Verdana", Font.PLAIN, 20));
        nomeFileTextField.setBackground(new Color(180, 180, 180));

        titoloLabel.setBounds(60, 100, 410, 40);
        titoloLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        titoloLabel.setForeground(new Color(99, 45, 45));

        //First col

        singleEventCheckBox.setBounds(30, 250, 200, 30);
        singleEventCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        singleEventCheckBox.setBackground(Color.gray);
        singleEventCheckBox.setSelected(true);

        //Second col

        multipleEventCheckBox.setBounds(260, 210, 200, 30);
        multipleEventCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        multipleEventCheckBox.setBackground(Color.gray);

        numberEventsTextField.setBounds(260, 300, 200, 30);
        numberEventsTextField.setFont(new Font("Verdana", Font.PLAIN, 20));
        numberEventsTextField.setBackground(new Color(180, 180, 180));
        numberEventsTextField.setEnabled(false);

        //Bottom

        insertButton.setBounds(140, 380, 200, 50);
        insertButton.setFont(new Font("Verdana", Font.BOLD, 20));
        insertButton.setBackground(new Color(186, 130, 130));

        endButton.setBounds(120, 480, 240, 50);
        endButton.setFont(new Font("Verdana", Font.BOLD, 20));
        endButton.setBackground(Color.red);

        //Action part

        insertButton.addActionListener(ActionListener ->{
            if(nomeFileTextField.getText().equals(""))
                nomeFileTextField.setText("GenericEvent");

            if(singleEventCheckBox.isSelected())
                events.add(new Evento("Nuovo Evento", baseWindow));
            else{
                int nEventi = (int) numberEventsTextField.getSelectedItem();
                for(int i = 0; i < nEventi; i++)
                    events.add(new Evento("Nuovo Evento " + (i+1), baseWindow));
            }
        });

        singleEventCheckBox.addActionListener(ActionListener ->{
            if(singleEventCheckBox.isSelected()){
                multipleEventCheckBox.setSelected(false);
                numberEventsTextField.setEnabled(false);
            }else {
                multipleEventCheckBox.setSelected(true);
                numberEventsTextField.setEnabled(true);
            }
        });

        multipleEventCheckBox.addActionListener(ActionLister ->{
            if(multipleEventCheckBox.isSelected()){
                singleEventCheckBox.setSelected(false);
                numberEventsTextField.setEnabled(true);
            }else {
                singleEventCheckBox.setSelected(true);
                numberEventsTextField.setEnabled(false);
            }   
        });

        endButton.addActionListener(ActionListener -> {
            if(events.isEmpty())
                JOptionPane.showMessageDialog(baseWindow, "Inserisci almeno un evento!!!");
            else{
                File fileStampato = new File(nomeFileTextField.getText() + ".csv");
                try {
                    if(!fileStampato.createNewFile())
                        JOptionPane.showMessageDialog(baseWindow, "Unable to create new file...");
                    else{
                        FileWriter print = new FileWriter(fileStampato);
                        print.write(fileHeader);
                        print.flush();
                        for(Evento e : events){
                            print.write(e.toString());
                            print.flush();
                        }
                        print.close();
                            
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                baseWindow.dispose();
            }
        });

        baseWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        baseWindow.setVisible(true);
    }
}
