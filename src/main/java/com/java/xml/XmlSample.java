package com.java.xml;

import java.util.ArrayList;

public class XmlSample {
    public static void main(String[] args) {
        //domParcerSample();
        // domModifySample();
      //  saxParcerSample();
       //examplesOnversion2();

    }
    public static void examplesOnversion2(){
        Module3_XmlVersion2 moduleVersion = new Module3_XmlVersion2();
        moduleVersion.domRead();







    }

    static void domParcerSample() {
        DomExample dpe = new DomExample();
        ArrayList<PersonModel> modelSample = dpe.domRead();

        System.out.println(modelSample.size());
        System.out.println(modelSample.get(0).getFirstName());
    }

    static void domModifySample() {
        DomExample dpe = new DomExample();
        dpe.modifyDom();
    }

    static void saxParcerSample() {
        SaxExample example = new SaxExample();
        //example.readSax();
        example.modifySax();
    }

}
