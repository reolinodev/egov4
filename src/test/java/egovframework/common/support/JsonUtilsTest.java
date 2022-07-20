package egovframework.common.support;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

@SpringBootTest
class JsonUtilsTest {

    @Test
    void getJsonMenu() throws IOException, ParseException {
        ModelAndView mav = new ModelAndView();
        mav = JsonUtils.getJsonMenu();
        System.out.println("<<<"+mav);
    }

    @Test
    void getJsonSeoul() throws IOException, ParseException {
        System.out.println("<<<"+JsonUtils.getJsonSeoulLv1());
    }
}