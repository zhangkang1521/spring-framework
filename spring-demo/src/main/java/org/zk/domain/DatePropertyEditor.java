package org.zk.domain;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 8/5/2018.
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    public void setAsText(String args0) throws java.lang.IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(args0);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        this.setValue(date);
    }
}
