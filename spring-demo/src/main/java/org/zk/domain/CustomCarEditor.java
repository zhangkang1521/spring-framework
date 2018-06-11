package org.zk.domain;

import java.beans.PropertyEditorSupport;

/**
 * Created by Administrator on 6/5/2018.
 */
public class CustomCarEditor extends PropertyEditorSupport {
    public void setAsText(String text){
        if(text == null || text.indexOf(",") == -1){
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setSpeed(Long.parseLong(infos[1]));
        setValue(car);
    }
}
