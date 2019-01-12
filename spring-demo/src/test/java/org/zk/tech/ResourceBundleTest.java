package org.zk.tech;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 8/19/2018.
 */
public class ResourceBundleTest {

    @Test
    public void test1() {
        ResourceBundle chinaResource = ResourceBundle.getBundle("messages", Locale.CHINA);
        ResourceBundle usResource = ResourceBundle.getBundle("messages", Locale.US);
        System.out.println(chinaResource.getString("test"));
        System.out.println(usResource.getString("test"));
    }
}
