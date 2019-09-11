package com.vee.navgraptoiler.controller.utils;

import com.vee.navgraptoiler.model.ListYourPropertyFormData;

public class CommonUtils {
    public static ListYourPropertyFormData plotFormData;

    public static ListYourPropertyFormData getFormData() {

        if (plotFormData == null) {
            plotFormData = new ListYourPropertyFormData();
        }

        return plotFormData;
    }
}
