package model;

import java.util.Calendar;

public class Stage {
    //INICIO,ANALISIS,DISENO,EJECUCION,CIERRE,SEGUIMIENTO_Y_CONTROL
    private String stageType;
    private int duration;
    private boolean active;
    private Calendar realStartDate;
    private Calendar realEndDate;

    public Stage(String stageType,int duration,boolean active,Calendar realStartDate,Calendar realEndDate){
        this.stageType=stageType;
        this.duration=duration;
        this.active=active;
        this.realStartDate=realStartDate;
        this.realEndDate=realEndDate;
    }
//||||||||||||||||||||GETTER Y SETTERS||||||||||||||||||||||||||||||||
    public String getStageType() {
       return stageType;
    }

    public Calendar getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Calendar realStartDate){
        this.realStartDate=realStartDate;
    }
    
    public Calendar getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(Calendar realEndDate){
        this.realEndDate=realEndDate;
    }

    public boolean getActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active=active;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
}
