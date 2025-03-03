public class Evento {
    private boolean allDay = false, singleDay = false;
    private Orario startOrario, endOrario;
    private Data startData, endData;
    private String subject, description, location;

    public String isAllDay() {
        if(this.allDay)
            return "TRUE";
        else return "FALSE";
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public boolean isSingleDay() {
        return singleDay;
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
        return this.subject + "," + this.startData + "," + this.startOrario + "," + this.endData + "," + this.endOrario + "," + this.isAllDay() + "," + this.description + "," + this.location;
    }
}
