package org.zk.tech;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Administrator on 8/19/2018.
 */
public class LocalTest {

    @Test
    public void testLocal() {
        // language + country
        Locale zhCn = new Locale("zh", "CN");
        Locale zh = new Locale("zh");
        System.out.println(Locale.CHINA.equals(zhCn));
        System.out.println(Locale.CHINESE.equals(zh));
        System.out.println(Locale.getDefault());
    }

    @Test
    public void testMessageFormat() {
        String pattern1 = "{0}，你好！你与{1}在工商银行存入{2}元。";
        String pattern2 = "At {1, time, short}, On {1, date, long}, {0} paid {2, number, currency}";
        Object[] param = {"John", new GregorianCalendar().getTime(), 1.0E3 };

        String msg1 = MessageFormat.format(pattern1, param);
        System.out.println(msg1);

        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(param);
        System.out.println(msg2);
    }
}
