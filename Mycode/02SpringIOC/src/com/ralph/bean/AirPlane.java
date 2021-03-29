package com.ralph.bean;


public class AirPlane {
    private String fdj;
    private String yc;
    private Integer persomNum;
    private String jzName;
    private String fjsName;

    public AirPlane(String fdj, String yc, Integer persomNum, String jzName, String fjsName) {
        this.fdj = fdj;
        this.yc = yc;
        this.persomNum = persomNum;
        this.jzName = jzName;
        this.fjsName = fjsName;
    }

    public AirPlane() {
    }

    public String getFdj() {
        return fdj;
    }

    public void setFdj(String fdj) {
        this.fdj = fdj;
    }

    public String getYc() {
        return yc;
    }

    public void setYc(String yc) {
        this.yc = yc;
    }

    public Integer getPersomNum() {
        return persomNum;
    }

    public void setPersomNum(Integer persomNum) {
        this.persomNum = persomNum;
    }

    public String getJzName() {
        return jzName;
    }

    public void setJzName(String jzName) {
        this.jzName = jzName;
    }

    public String getFjsName() {
        return fjsName;
    }

    public void setFjsName(String fjsName) {
        this.fjsName = fjsName;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "fdj='" + fdj + '\'' +
                ", yc='" + yc + '\'' +
                ", persomNum=" + persomNum +
                ", jzName='" + jzName + '\'' +
                ", fjsName='" + fjsName + '\'' +
                '}';
    }
}
