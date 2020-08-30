package org.zk.core;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 8/5/2018.
 */
public class MyDatePropertyEditorRegistrar implements PropertyEditorRegistrar{

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // initBeanWrapper调用，这里的registry一般是BeanWrapper
        registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy年MM月dd日"), true));
    }
}
