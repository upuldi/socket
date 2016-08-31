package com.message;

import com.enums.*;
import com.util.MessageCounter;

/**
 * Created by udoluweera on 2/14/15.
 */
public class HumpListCarDetailMessageBuilder extends MessageBuilder {

    private String carId="";
    private CarLoadedStatus carLoadedStatus;
    private String carDestination="";
    private String bowlArea="";
    private String bowlTrack="";
    private String commodity="";
    private String specialRest1="";
    private String specialRest2="";
    private String specialRest3="";
    private String specialRest4="";
    private String specialRest5="";
    private char doNotHumpCode=' ';
    private String assignLeaseCode="";
    private String aarCarType="";
    private int carLenght;
    private int carWeight;
    private String carBodyType="";
    private int numberOfAxles;
    private RSB_STATUS rsb_status;
    private BEARING_CODE bearing_code;
    private char specialHandlingCode=' ';
    private ARTICULATED_STATUS articulated_status;
    private int assignedTrackNumber;
    private int maxToleranceWeight;
    private int minToleranceWeight;

    @Override
    protected void createDataPotion() {

        getMessage().setMessageId(MessageType.HUMP_LIST_CAR_DETAIL);
        getMessage().setSequenceNo(MessageCounter.getMessageCount());

        StringBuilder dataPotion = new StringBuilder();
        dataPotion.append(String.format("%-10s", carId));
        dataPotion.append(carLoadedStatus.getCode());
        dataPotion.append(String.format("%-10s", carDestination));
        dataPotion.append(String.format("%-2s", bowlArea));
        dataPotion.append(String.format("%-6s", bowlTrack));
        dataPotion.append(String.format("%-15s", commodity));
        dataPotion.append(String.format("%-3s", specialRest1));
        dataPotion.append(String.format("%-3s", specialRest2));
        dataPotion.append(String.format("%-3s", specialRest3));
        dataPotion.append(String.format("%-3s", specialRest4));
        dataPotion.append(String.format("%-3s", specialRest5));
        dataPotion.append(String.format("%-1s", doNotHumpCode));
        dataPotion.append(String.format("%-6s", assignLeaseCode));
        dataPotion.append(String.format("%-4s", aarCarType));
        dataPotion.append(String.format("%03d", carLenght));
        dataPotion.append(String.format("%04d", carWeight));
        dataPotion.append(String.format("%-4s",carBodyType));
        dataPotion.append(String.format("%02d", numberOfAxles));
        dataPotion.append(rsb_status.getCode());
        dataPotion.append(bearing_code.getCode());
        dataPotion.append(String.format("%-1s", specialHandlingCode));
        dataPotion.append(articulated_status.getCode());
        dataPotion.append(String.format("%03d", assignedTrackNumber));
        dataPotion.append(String.format("%04d", maxToleranceWeight));
        dataPotion.append(String.format("%04d", minToleranceWeight));
        
        getMessage().setCrc("00000");

        getMessage().setDataPotion(dataPotion.toString());
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setCarLoadedStatus(CarLoadedStatus carLoadedStatus) {
        this.carLoadedStatus = carLoadedStatus;
    }

    public void setCarDestination(String carDestination) {
        this.carDestination = carDestination;
    }

    public void setBowlArea(String bowlArea) {
        this.bowlArea = bowlArea;
    }

    public void setBowlTrack(String bowlTrack) {
        this.bowlTrack = bowlTrack;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public void setSpecialRest1(String specialRest1) {
        this.specialRest1 = specialRest1;
    }

    public void setSpecialRest2(String specialRest2) {
        this.specialRest2 = specialRest2;
    }

    public void setSpecialRest3(String specialRest3) {
        this.specialRest3 = specialRest3;
    }

    public void setSpecialRest4(String specialRest4) {
        this.specialRest4 = specialRest4;
    }

    public void setSpecialRest5(String specialRest5) {
        this.specialRest5 = specialRest5;
    }

    public void setDoNotHumpCode(char doNotHumpCode) {
        this.doNotHumpCode = doNotHumpCode;
    }

    public void setAssignLeaseCode(String assignLeaseCode) {
        this.assignLeaseCode = assignLeaseCode;
    }

    public void setAarCarType(String aarCarType) {
        this.aarCarType = aarCarType;
    }

    public void setCarLenght(int carLenght) {
        this.carLenght = carLenght;
    }

    public void setCarWeight(int carWeight) {
        this.carWeight = carWeight;
    }

    public void setCarBodyType(String carBodyType) {
        this.carBodyType = carBodyType;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public void setRsb_status(RSB_STATUS rsb_status) {
        this.rsb_status = rsb_status;
    }

    public void setBearing_code(BEARING_CODE bearing_code) {
        this.bearing_code = bearing_code;
    }

    public void setSpecialHandlingCode(char specialHandlingCode) {
        this.specialHandlingCode = specialHandlingCode;
    }

    public void setArticulated_status(ARTICULATED_STATUS articulated_status) {
        this.articulated_status = articulated_status;
    }

    public void setAssignedTrackNumber(int assignedTrackNumber) {
        this.assignedTrackNumber = assignedTrackNumber;
    }

    public void setMaxToleranceWeight(int maxToleranceWeight) {
        this.maxToleranceWeight = maxToleranceWeight;
    }

    public void setMinToleranceWeight(int minToleranceWeight) {
        this.minToleranceWeight = minToleranceWeight;
    }
}
