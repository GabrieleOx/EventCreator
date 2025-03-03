
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.time.Year;
import javax.swing.*;

public class Data {

    public static int getCurYear() {
        return curYear;
    }
    private int day, month, year;
    private static Integer [] months = new Integer[12], days31 = new Integer[31], days30 = new Integer[30], days28 = new Integer[28], years = new Integer[20];
    private final static int curYear = Year.now().getValue();

    public Data(String name, JFrame father) {
        fillArrays();
        this.initialize(name, father);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    private void initialize(String name, JFrame father){
        JDialog dateWindowDialog = new JDialog(father, name, true);
        JComboBox yearBox = new JComboBox<>(years), monthBox = new JComboBox<>(months), dayBox = new JComboBox<>(days31);
        JLabel dayJLabel = new JLabel("   Giorno:"), monthJLabel = new JLabel("    Mese:"), yearJLabel = new JLabel("    Anno:"), titleJLabel = new JLabel("Inserimento data:");
        JButton sendButton = new JButton("Send");
        JPanel dayJPanel = new JPanel(), monthJPanel = new JPanel(), yearJPanel = new JPanel();

        //Graphical part

        dateWindowDialog.setSize(395, 330);
        dateWindowDialog.setResizable(false);
        dateWindowDialog.setLayout(null);
        dateWindowDialog.getContentPane().setBackground(Color.red);
        dateWindowDialog.add(titleJLabel); dateWindowDialog.add(dayJPanel); dateWindowDialog.add(monthJPanel); dateWindowDialog.add(yearJPanel); dateWindowDialog.add(sendButton);

        titleJLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        titleJLabel.setBounds(80, 20, 250, 20);

        dayJPanel.setBounds(15, 50, 110, 140);
        dayJPanel.setLayout(new GridLayout(0, 1));
        dayJPanel.setBackground(null);
        dayJLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        dayBox.setFont(new Font("Verdana", Font.PLAIN, 16));
        dayJPanel.add(dayJLabel); dayJPanel.add(dayBox);

        monthJPanel.setBounds(135, 50, 110, 140);
        monthJPanel.setLayout(new GridLayout(0, 1));
        monthJPanel.setBackground(null);
        monthJLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        monthBox.setFont(new Font("Verdana", Font.PLAIN, 16));
        monthJPanel.add(monthJLabel); monthJPanel.add(monthBox);

        yearJPanel.setBounds(255, 50, 110, 140);
        yearJPanel.setLayout(new GridLayout(0, 1));
        yearJPanel.setBackground(null);
        yearJLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        yearBox.setFont(new Font("Verdana", Font.PLAIN, 16));
        yearJPanel.add(yearJLabel); yearJPanel.add(yearBox);

        sendButton.setBounds(140, 220, 100, 50);
        sendButton.setFont(new Font("Verdana", Font.BOLD, 16));

        //Action part

        monthBox.addActionListener((ActionEvent e) -> {
            int x = monthBox.getSelectedIndex();
            dayBox.removeAllItems();
            if (x == 10 || x == 3 || x == 5 || x == 8) {
                for (Integer day1 : days30) {
                    dayBox.addItem(day1);
                }
            } else if (x == 1) {
                for (Integer day2 : days28) {
                    dayBox.addItem(day2);
                }
            } else {
                for (Integer day3 : days31) {
                    dayBox.addItem(day3);
                }
            }
        });

        sendButton.addActionListener((ActionEvent e) -> {
            this.day = (int) dayBox.getSelectedItem();
            this.month = (int) monthBox.getSelectedItem();
            this.year = (int) yearBox.getSelectedItem();
            System.out.println(this.day);
            dateWindowDialog.dispose();
        });

        dateWindowDialog.setVisible(true);
    }

    private static void fillArrays(){
        int j;
        for(j = 0; j < 12; j++){
            months[j] = j+1;
            days28[j] = j+1;
            days30[j] = j+1;
            days31[j] = j+1;
        }
        
        for(;j < 28; j++){
            days28[j] = j+1;
            days30[j] = j+1;
            days31[j] = j+1;
        }

        for(;j < 30; j++){
            days30[j] = j+1;
            days31[j] = j+1;
        }

        days31[j] = j+1;

        for(int i = 0; i < 20; i++)
            years[i] = curYear + i;
    }
}
