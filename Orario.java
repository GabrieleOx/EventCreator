public class Orario {
    private int hou = 0, min = 0, sec = 0;
    private boolean am = true;
    
    public Orario(int hou, int min, int sec, boolean am) {
        this.hou = hou;
        this.min = min;
        this.sec = sec;
        this.am = am;
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
}
