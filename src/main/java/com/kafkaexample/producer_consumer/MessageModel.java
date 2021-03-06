package com.kafkaexample.producer_consumer;

import java.io.Serializable;


public class MessageModel implements Serializable {
    private String field1;
    private String field2;

    public MessageModel(){ }

    public MessageModel(String f1, String f2){
        field1 = f1;
        field2 = f2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                " field1='" + field1 +
                ", field2='" + field2 +
                " }";
    }
}
