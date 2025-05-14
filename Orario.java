import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Orario {
    private int hou = 0, min = 0, sec = 0;
    private boolean am = true;
    private static boolean filled = false;
    private static Integer [] hours = new Integer[12], minsSecs = new Integer[60];
    
    public Orario(String windowName, JDialog father) {
        if(!filled) fillArrays();
        initialize(windowName, father);
    }
    public int getHou() {
        return hou;
    }
    public void setHou(int hou) {
        this.hou = hou;
    }
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getSec() {
        return sec;
    }
    public void setSec(int sec) {
        this.sec = sec;
    }
    public String isAm() {
        if(this.am)
            return "AM";
        else return "PM";
    }
    public void setAm(boolean am) {
        this.am = am;
    }

    @Override
    public String toString() {
        return this.hou + ":" + this.min + ":" + this.sec + " " + this.isAm();
    }

    private void initialize(String name, JDialog father){
        JDialog timeWindowDialog = new JDialog(father, name, true);
        JComboBox hourBox = new JComboBox<>(hours), minuteBox = new JComboBox<>(minsSecs), secondBox = new JComboBox<>(minsSecs);
        JLabel secondJLabel = new JLabel(" Secondo:"), minuteJLabel = new JLabel("   Minuto:"), hourJLabel = new JLabel("     Ora:"), titleJLabel = new JLabel("Inserimento orario:");
        JButton sendButton = new JButton("Send");
        JPanel secondJPanel = new JPanel(), minuteJPanel = new JPanel(), hourJPanel = new JPanel();
        JCheckBox amCheckBox = new JCheckBox("AM");

        //Graphical part

        timeWindowDialog.setSize(395, 330);
        timeWindowDialog.setResizable(false);
        timeWindowDialog.setLayout(null);
        timeWindowDialog.getContentPane().setBackground(Color.green);
        timeWindowDialog.add(titleJLabel); timeWindowDialog.add(secondJPanel); timeWindowDialog.add(minuteJPanel); timeWindowDialog.add(hourJPanel); timeWindowDialog.add(amCheckBox); timeWindowDialog.add(sendButton);

        titleJLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        titleJLabel.setBounds(80, 20, 250, 20);

        secondJPanel.setBounds(15, 50, 110, 140);
        secondJPanel.setLayout(new GridLayout(0, 1));
        secondJPanel.setBackground(null);
        secondJLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        secondBox.setFont(new Font("Verdana", Font.PLAIN, 16));
        secondJPanel.add(secondJLabel); secondJPanel.add(secondBox);

        minuteJPanel.setBounds(135, 50, 110, 140);
        minuteJPanel.setLayout(new GridLayout(0, 1));
        minuteJPanel.setBackground(null);
        minuteJLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        minuteBox.setFont(new Font("Verdana", Font.PLAIN, 16));
        minuteJPanel.add(minuteJLabel); minuteJPanel.add(minuteBox);

        hourJPanel.setBounds(255, 50, 110, 140);
        hourJPanel.setLayout(new GridLayout(0, 1));
        hourJPanel.setBackground(null);
        hourJLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        hourBox.setFont(new Font("Verdana", Font.PLAIN, 16));
        hourJPanel.add(hourJLabel); hourJPanel.add(hourBox);

        amCheckBox.setBounds(165, 205, 80, 30);
        amCheckBox.setFont(new Font("Verdana", Font.BOLD, 16));
        amCheckBox.setBackground(null);

        sendButton.setBounds(150, 240, 80, 40);
        sendButton.setFont(new Font("Verdana", Font.BOLD, 16));

        //Action part

        sendButton.addActionListener((ActionEvent e) -> {
            this.sec = (int) secondBox.getSelectedItem();
            this.min = (int) minuteBox.getSelectedItem();
            this.hou = (int) hourBox.getSelectedItem();
            this.am = amCheckBox.isSelected();
            timeWindowDialog.dispose();
        });

        timeWindowDialog.setVisible(true);
    }

    private static void fillArrays(){
        filled = true;
        int i = 0;
        for(;i < 12; i++){
            hours[i] = i+1;
            minsSecs[i] = i;
        }

        for(;i < 60; i++)
            minsSecs[i] = i;
    }
}
