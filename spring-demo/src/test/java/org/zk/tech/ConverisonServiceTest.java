package org.zk.tech;

import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.zk.domain.StringUserConvert;
import org.zk.domain.User;

/**
 * Created by Administrator on 6/12/2018.
 */
public class ConverisonServiceTest {

    @Test
    public void test1(){
        DefaultConversionService serivce = new DefaultConversionService();
        boolean actual = serivce.canConvert(String.class, Boolean.class);
        Boolean acc = serivce.convert("true", Boolean.class);
    }

    @Test
    public void test2() {
        StringUserConvert convert = new StringUserConvert();
        User user = convert.convert("1,zk");
    }
}
