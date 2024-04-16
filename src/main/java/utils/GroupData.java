package utils;

import java.util.ArrayList;

public class GroupData {
    private ArrayList<Double> groupData;
    private int objectNumber;

    public GroupData() {
        this.groupData = new ArrayList<Double>();
    }

    public ArrayList<Double> getGroupData() {
        return groupData;
    }

    public void setGroupData(ArrayList<Double> groupData) {
        this.groupData = groupData;
    }

    public int getObjectNumber() {
        return objectNumber;
    }

    public void setObjectNumber(int objectNumber) {
        this.objectNumber = objectNumber;
    }
}
