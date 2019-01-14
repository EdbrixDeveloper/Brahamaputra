package com.brahamaputra.mahindra.brahamaputra.Data;

public class TypeOfFault {
    public String typeOfFaultValue = "";
    public boolean isChecked = false;

    public TypeOfFault()
    {

    }

    public TypeOfFault(String typeOfFaultValue,boolean isChecked)
    {
        this.typeOfFaultValue = typeOfFaultValue;
        this.isChecked = isChecked;
    }

    public String getTypeOfFault()
    {
        return typeOfFaultValue;
    }

    public void setTypeOfFault(String typeOfFaultValue)
    {
        this.typeOfFaultValue = typeOfFaultValue;
    }

    public boolean getIsItemChecked()
    {
        return isChecked;
    }

    public void setIsItemChecked(boolean isChecked)
    {
        this.isChecked = isChecked;
    }

}
