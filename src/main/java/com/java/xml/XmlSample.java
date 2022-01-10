package com.java.xml;

import java.util.ArrayList;

public class XmlSample {
    public static void main(String[] args) {
         domParcerSample();
        // domModifySample();
      //  saxParcerSample();
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
