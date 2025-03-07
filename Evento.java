import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Evento {
    private boolean allDay = false, singleDay = false, privateEvent = false;
    private Orario startOrario, endOrario;
    private Data startData, endData;
    private String subject, description, location;

    public Evento(String windowName){
        initialize(windowName);
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
        return this.subject + "," + this.startData + "," + this.startOrario + "," + this.endData + "," + this.endOrario + "," + this.isAllDay() + "," + this.description + "," + this.location + "," + this.isPrivateEvent();
    }

    private void initialize(String name){
        final String mod = "Modify", dat = "Data:", or = "Orario:", ye = "GG/MM/YYYY", tm = "hh:mm:ss";
        JFrame window = new JFrame(name);
        JLabel titleLabel = new JLabel("Event Creator:"), startLabel = new JLabel("Start:"), endLabel = new JLabel("End:"), startDateLabel = new JLabel(dat), startTimeLabel = new JLabel(or), endDateLabel = new JLabel(dat),
            endTimeLabel = new JLabel(or), subjectLabel = new JLabel("Soggetto:"), descriptionLabel = new JLabel("Descrizione:"), locationLabel = new JLabel("Location:");
        JTextField startDateTextField = new JTextField(ye), startTimeTextField = new JTextField(tm), endDateTextField = new JTextField(ye), endTimeTextField = new JTextField(tm), subjectTextField = new JTextField(), descriptionTextField = new JTextField(), locationTextField = new JTextField();
        JButton startDateButton = new JButton(mod), startTimeButton = new JButton(mod), endDateButton = new JButton(mod), endTimeButton = new JButton(mod), sendButton = new JButton("Crea");
        JCheckBox singleDayCheckBox = new JCheckBox("Single Day"), allDayCheckBox = new JCheckBox("All Day"), privateCheckBox = new JCheckBox("Private");
        JPanel startDatePanel = new JPanel(), startTimePanel = new JPanel(), endDatePanel = new JPanel(), endTimePanel = new JPanel(), subjectPanel = new JPanel(), descriptionPanel = new JPanel(), locationPanel = new JPanel();

        //Grafical part

        window.setSize(900, 900);
        window.getContentPane().setBackground(new Color(237, 220, 26));
        window.setResizable(false);
        window.setLayout(null);
        window.add(titleLabel);
        window.add(startLabel); window.add(startDatePanel); window.add(startDateButton); window.add(startTimePanel); window.add(startTimeButton); window.add(singleDayCheckBox);
        window.add(subjectPanel); window.add(descriptionPanel); window.add(locationPanel); window.add(allDayCheckBox);

        titleLabel.setBounds(320, 20, 220, 50);
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

        descriptionPanel.setBounds(280, 280, 180, 80);
        descriptionPanel.setLayout(new GridLayout(0, 1));
        descriptionPanel.setBackground(null);
        descriptionLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        descriptionTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        descriptionPanel.add(descriptionLabel); descriptionPanel.add(descriptionTextField);

        locationPanel.setBounds(280, 380, 180, 80);
        locationPanel.setLayout(new GridLayout(0, 1));
        locationPanel.setBackground(null);
        locationLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        locationTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        locationPanel.add(locationLabel); locationPanel.add(locationTextField);

        allDayCheckBox.setBounds(280, 540, 180, 50);
        allDayCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        allDayCheckBox.setBackground(null);

        //Third col:
        endLabel.setBounds(50, 90, 100, 40);
        endLabel.setFont(new Font("Verdana", Font.BOLD, 20));

        endDatePanel.setBounds(20, 180, 140, 80);
        endDatePanel.setLayout(new GridLayout(0, 1));
        endDatePanel.setBackground(null);
        endDateLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        endDateTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        endDateTextField.setEditable(false);
        endDatePanel.add(endDateLabel); endDatePanel.add(endDateTextField);

        endDateButton.setBounds(35, 280, 100, 40);
        endDateButton.setFont(new Font("Verdana", Font.BOLD, 15));
        endDateButton.setBackground(new Color(198, 131, 230));

        endTimePanel.setBounds(20, 360, 140, 80);
        endTimePanel.setLayout(new GridLayout(0, 1));
        endTimePanel.setBackground(null);
        endTimeLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        endTimeTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
        endTimeTextField.setEditable(false);
        endTimePanel.add(endTimeLabel); endTimePanel.add(endTimeTextField);

        endTimeButton.setBounds(35, 460, 100, 40);
        endTimeButton.setFont(new Font("Verdana", Font.BOLD, 15));
        endTimeButton.setBackground(new Color(198, 131, 230));

        privateCheckBox.setBounds(20, 540, 180, 50);
        privateCheckBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        privateCheckBox.setBackground(null);

        //Action part

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
