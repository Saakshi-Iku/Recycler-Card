package com.example.recyclercard;

public class Ex_item_java {
    int image;
    String line1;
    String line2;
    public Ex_item_java(int image,String line1,String line2)
    {
        this.image=image;
        this.line1=line1;
        this.line2=line2;

    }

    public void chageText(String text)
    {
        line1=text;
    }
    public int getimage()
    {
        return image;
    }
    public String getLine1()
    {
        return line1;
    }
    public String getLine2()
    {
        return line2;
    }
}
