package com.aditya;


public class ProfileDTO {

    private int level;
    private String method;
    private long time;


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    public ProfileDTO(int level, String method, long time) {
        this.level = level;
        this.method = method;
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<this.level;i++){
            sb.append(" ");
        }
        sb.append(this.method);
        sb.append(" ");
        sb.append(this.time);
        sb.append("\n");
        return sb.toString();
    }
}
