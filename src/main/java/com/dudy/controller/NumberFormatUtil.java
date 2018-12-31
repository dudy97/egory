package com.dudy.controller;

import org.springframework.web.bind.WebDataBinder;

import java.beans.PropertyEditorSupport;

/**
 * Created by admin on 31.12.2018.
 */
public class NumberFormatUtil {
    public static void registerDoubleFormat (WebDataBinder binder) {
        binder.registerCustomEditor(Double.TYPE, new CustomerDoubleEditor());
    }

    private static class CustomerDoubleEditor extends PropertyEditorSupport {
        public String getAsText() {
            Double d = (Double) getValue();
            return d.toString();
        }

        public void setAsText(String str) {
            if(str == null || str.trim().equals("")) {
                setValue(0d); // you want to return double
            } else {
                setValue(Double.parseDouble(str));
            }
        }
    }
}
