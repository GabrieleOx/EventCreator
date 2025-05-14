import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Evento {
    private boolean allDay = false, singleDay = false, privateEvent = false;
    private Orario startOrario, endOrario;
    private Data startData, endData;
    private String subject, description, location;

    public Evento(String windowName, JFrame father){
        initialize(windowName, father);
    }

    public String isPrivateEvent() {
        if(this.privateEvent)
            return "TRUE";
        else return "FALSE";
    }

    public void setPrivateEvent(boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public String isAllDay() {
        if(this.allDay)
            return "TRUE";
        else return "FALSE";
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public String isSingleDay() {
        if(this.singleDay)
            return "TRUE";
        else return "FALSE";
    }

    public void setSingleDay(boolean singleDay) {
        this.singleDay = singleDay;
    }

    public Orario getStartOrario() {
        return startOrario;
    }

    public void setStartOrario(Orario startOrario) {
        this.startOrario = startOrario;
    }

    public Orario getEndOrario() {
        return endOrario;
    }

    public void setEndOrario(Orario endOrario) {
        this.endOrario = endOrario;
    }

    public Data getStartData() {
        return startData;
    }

    public void setStartData(Data startData) {
        this.startData = startData;
    }

    public Data getEndData() {
        return endData;
    }

    public void setEndData(Data endData) {
        this.endData = endData;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Evento(boolean allDay, boolean singleDay, Orario startOrario, Orario endOrario, Data startData, Data endData, String subject, String description, String location) {
        this.allDay = allDay;
        this.singleDay = singleDay;
        this.startOrario = startOrario;
        this.endOrario = endOrario;
        this.startData = startData;
        this.endData = endData;
        this.subject = subject;
        this.description = description;
        this.location = location;
    }

    @Override
    public String toString() {
        return this.subject + "," + this.startData + "," + this.startOrario + "," + this.endData + "," + this.endOrario + "," + this.isAllDay() + "," + this.description + "," + this.location + "," + this.isPrivateEvent() + "\n";
    }

    private void initialize(String name, JFrame padre){
        final String mod = "Modify", dat = "Data:", or = "Orario:", ye = "GG/MM/YYYY", tm = "hh:mm:ss";
        JDialog window = new JDialog(padre, name, true);
        JLabel titleLabel = new JLabel("Event Creator:"), startLabel = new JLabel("Start:"), endLabel = new JLabel("End:"), startDateLabel = new JLabel(dat), startTimeLabel = new JLabel(or), endDateLabel = new JLabel(dat),
            endTimeLabel = new JLabel(or), subjectLabel = new JLabel("Soggetto:"), descriptionLabel = new JLabel("Descrizione:"), locationLabel = new JLabel("Location:"),
            startDateErrorLabel = new JLabel("Devi inserire una data valida!!"), startTimeErrorLabel = new JLabel("Devi inserire un'orario valido!!"), endDateErrorLabel = new JLabel("Devi inserire una data valida!!"),
            endTimeErrorLabel = new JLabel("Devi inserire un'orario valido!!"), subjectErrorLabel = new JLabel("Devi inserire un soggetto!!"), descriptionErrorLabel = new JLabel("Devi inserire una descrizione!!"), locationErrorLabel = new JLabel("Devi inserire una location!!");
        JTextField startDateTextField = new JTextField(ye), startTimeTextField = new JTextField(tm), endDateTextField = new JTextField(ye), endTimeTextField = new JTextField(tm), subjectTextField = new JTextField(), descriptionTextField = new JTextField(), locationTextField = new JTextField();
        JButton startDateButton = new JButton(mod), startTimeButton = new JButton(mod), endDateButton = new JButton(mod), endTimeButton = new JButton(mod), sendButton = new JButton("Crea");
        JCheckBox singleDayCheckBox = new JCheckBox("Single Day"), allDayCheckBox = new JCheckBox("All Day"), privateCheckBox = new JCheckBox("Private");
        JPanel startDatePanel = new JPanel(), startTimePanel = new JPanel(), endDatePanel = new JPanel(), endTimePanel = new JPanel(), subjectPanel = new JPanel(), descriptionPanel = new JPanel(), locationPanel = new JPanel();

        //Grafical part

        window.setSize(760, 760);
        window.getContentPane().setBackground(new Color(237, 220, 26));
        window.setResizable(false);
        window.setLayout(null);
        window.add(titleLabel);
        window.add(startLabel); window.add(startDatePanel); window.add(startDateButton); window.add(startDateErrorLabel); window.add(startTimePanel); window.add(startTimeButton); window.add(startTimeErrorLabel); window.add(singleDayCheckBox);
        window.add(subjectPanel); window.add(subjectErrorLabel); window.add(descriptionPanel); window.add(descriptionErrorLabel); window.add(locationPanel); window.add(locationErrorLabel); window.add(allDayCheckBox);
        window.add(endLabel); window.add(endDatePanel); window.add(endDateButton); window.add(endDateErrorLabel); window.add(endTimePanel); window.add(endTimeButton); window.add(endTimeErrorLabel); window.add(privateCheckBox);
        window.add(sendButton);

        titleLabel.setBounds(270, 20, 220, 50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 25));

        //First col:
        startLabel.setBounds(50, 90, 100, 40);
        startLabel.setFont(new Font("Verdana", Font.BOLD, 20));

        startDatePanel.setBounds(20, 180, 140, 80);
        startDatePanel.setLayout(new GridLayout(0, 1));
        startDatePanel.setBackground(null);
        startDateLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        startDateTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        startDateTextField.setEditable(false);
        startDatePanel.add(startDateLabel); startDatePanel.add(startDateTextField);

        startDateButton.setBounds(35, 280, 100, 40);
        startDateButton.setFont(new Font("Verdana", Font.BOLD, 15));
        startDateButton.setBackground(new Color(198, 131, 230));

        startDateErrorLabel.setBounds(15, 335, 220, 20);
        startDateErrorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        startDateErrorLabel.setForeground(Color.RED);
        startDateErrorLabel.setVisible(false);

        startTimePanel.setBounds(20, 360, 140, 80);
        startTimePanel.setLayout(new GridLayout(0, 1));
        startTimePanel.setBackground(null);
        startTimeLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        startTimeTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        startTimeTextField.setEditable(false);
        startTimePanel.add(startTimeLabel); startTimePanel.add(startTimeTextField);

        startTimeButton.setBounds(35, 460, 100, 40);
        startTimeButton.setFont(new Font("Verdana", Font.BOLD, 15));
        startTimeButton.setBackground(new Color(198, 131, 230));

        startTimeErrorLabel.setBounds(15, 515, 220, 20);
        startTimeErrorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        startTimeErrorLabel.setForeground(Color.RED);
        startTimeErrorLabel.setVisible(false);

        singleDayCheckBox.setBounds(20, 540, 180, 50);
        singleDayCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        singleDayCheckBox.setBackground(null);

        //Second col:
        subjectPanel.setBounds(280, 180, 180, 80);
        subjectPanel.setLayout(new GridLayout(0, 1));
        subjectPanel.setBackground(null);
        subjectLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        subjectTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        subjectPanel.add(subjectLabel); subjectPanel.add(subjectTextField);

        subjectErrorLabel.setBounds(280, 275, 220, 20);
        subjectErrorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        subjectErrorLabel.setForeground(Color.red);
        subjectErrorLabel.setVisible(false);

        descriptionPanel.setBounds(280, 300, 180, 80);
        descriptionPanel.setLayout(new GridLayout(0, 1));
        descriptionPanel.setBackground(null);
        descriptionLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        descriptionTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        descriptionPanel.add(descriptionLabel); descriptionPanel.add(descriptionTextField);

        descriptionErrorLabel.setBounds(280, 395, 220, 20);
        descriptionErrorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        descriptionErrorLabel.setForeground(Color.red);
        descriptionErrorLabel.setVisible(false);

        locationPanel.setBounds(280, 420, 180, 80);
        locationPanel.setLayout(new GridLayout(0, 1));
        locationPanel.setBackground(null);
        locationLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        locationTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        locationPanel.add(locationLabel); locationPanel.add(locationTextField);

        locationErrorLabel.setBounds(280, 515, 220, 20);
        locationErrorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        locationErrorLabel.setForeground(Color.red);
        locationErrorLabel.setVisible(false);

        allDayCheckBox.setBounds(310, 540, 180, 50);
        allDayCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        allDayCheckBox.setBackground(null);

        //Third col:
        endLabel.setBounds(620, 90, 100, 40);
        endLabel.setFont(new Font("Verdana", Font.BOLD, 20));

        endDatePanel.setBounds(580, 180, 140, 80);
        endDatePanel.setLayout(new GridLayout(0, 1));
        endDatePanel.setBackground(null);
        endDateLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        endDateTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        endDateTextField.setEditable(false);
        endDatePanel.add(endDateLabel); endDatePanel.add(endDateTextField);

        endDateButton.setBounds(595, 280, 100, 40);
        endDateButton.setFont(new Font("Verdana", Font.BOLD, 15));
        endDateButton.setBackground(new Color(198, 131, 230));

        endDateErrorLabel.setBounds(520, 335, 220, 20);
        endDateErrorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        endDateErrorLabel.setForeground(Color.RED);
        endDateErrorLabel.setVisible(false);

        endTimePanel.setBounds(580, 360, 140, 80);
        endTimePanel.setLayout(new GridLayout(0, 1));
        endTimePanel.setBackground(null);
        endTimeLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        endTimeTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        endTimeTextField.setEditable(false);
        endTimePanel.add(endTimeLabel); endTimePanel.add(endTimeTextField);

        endTimeButton.setBounds(595, 460, 100, 40);
        endTimeButton.setFont(new Font("Verdana", Font.BOLD, 15));
        endTimeButton.setBackground(new Color(198, 131, 230));

        endTimeErrorLabel.setBounds(520, 515, 220, 20);
        endTimeErrorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        endTimeErrorLabel.setForeground(Color.RED);
        endTimeErrorLabel.setVisible(false);

        privateCheckBox.setBounds(600, 540, 180, 50);
        privateCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        privateCheckBox.setBackground(null);

        sendButton.setBounds(260, 650, 220, 50);
        sendButton.setFont(new Font("Verdana", Font.BOLD, 25));
        sendButton.setBackground(Color.red);

        //Action part

        startDateButton.addActionListener(ActionListener -> {
            this.startData = new Data("Data_d'inizio", window);
            startDateTextField.setText(this.startData.toString());
        });

        endDateButton.addActionListener(ActionListener -> {
            this.endData = new Data("Data_di_fine", window);
            endDateTextField.setText(this.endData.toString());
        });

        startTimeButton.addActionListener(ActionListener -> {
            this.startOrario = new Orario("Ora_d'inizio", window);
            startTimeTextField.setText(this.startOrario.toString());
        });

        endTimeButton.addActionListener(ActionListener -> {
            this.endOrario = new Orario("Ora_di_fine", window);
            endTimeTextField.setText(this.endOrario.toString());
        });

        singleDayCheckBox.addActionListener(ActionListener -> {
            if(singleDayCheckBox.isSelected()){
                endDateButton.setEnabled(false);
                endDateTextField.setText(startDateTextField.getText());
            }else {
                endDateButton.setEnabled(true);
                endDateTextField.setText(ye);
            }
        });

        allDayCheckBox.addActionListener(ActionListener -> {
            if(allDayCheckBox.isSelected()){
                endTimeButton.setEnabled(false);
                endTimeTextField.setText(startTimeTextField.getText());
            }else {
                endTimeButton.setEnabled(true);
                endTimeTextField.setText(tm);
            }
        });

        sendButton.addActionListener(ActionListener -> {
            boolean go = true;
            if(startDateTextField.getText().equals(ye)){
                go = false;
                startDateErrorLabel.setVisible(true);
            }

            if(startTimeTextField.getText().equals(tm)){
                go = false;
                startTimeErrorLabel.setVisible(true);
            }

            if(subjectTextField.getText().isBlank()){
                go = false;
                subjectErrorLabel.setVisible(true);
            }else {
                String txt = subjectTextField.getText().trim(), nw = "";
                int len = txt.length();
                for(int i = 0; i < len; i++)
                    if(txt.charAt(i) != ',')
                        nw += txt.charAt(i);
                subjectTextField.setText(nw);
            }

            if(descriptionTextField.getText().isBlank()){
                go = false;
                descriptionErrorLabel.setVisible(true);
            }else {
                String txt = descriptionTextField.getText().trim(), nw = "";
                int len = txt.length();
                for(int i = 0; i < len; i++)
                    if(txt.charAt(i) != ',')
                        nw += txt.charAt(i);
                descriptionTextField.setText(nw);
            }

            if(locationTextField.getText().isBlank()){
                go = false;
                locationErrorLabel.setVisible(true);
            }else {
                String txt = locationTextField.getText().trim(), nw = "";
                int len = txt.length();
                for(int i = 0; i < len; i++)
                    if(txt.charAt(i) != ',')
                        nw += txt.charAt(i);
                locationTextField.setText(nw);
            }

            if(endDateTextField.getText().equals(ye)){
                go = false;
                endDateErrorLabel.setVisible(true);
            }

            if(endTimeTextField.getText().equals(tm)){
                go = false;
                endTimeErrorLabel.setVisible(true);
            }

            if(go){
                this.allDay = allDayCheckBox.isSelected();
                if(this.allDay)
                    this.endOrario = this.startOrario;
                this.singleDay = singleDayCheckBox.isSelected();
                if(this.singleDay)
                    this.endData = this.startData;
                this.privateEvent = privateCheckBox.isSelected();
                this.subject = subjectTextField.getText();
                this.description = descriptionTextField.getText();
                this.location = locationTextField.getText();
                window.dispose();
            }
        });

        window.setVisible(true);
    }
}
