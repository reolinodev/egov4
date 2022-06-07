package egovframework.common.support;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CryptUtilsTest {

    @Test
    void encrypt() throws IOException {
        //when
        String str = "reolino";
        //given
        String ecnryptStr = CryptUtils.encrypt(str);
        System.out.println("=="+ecnryptStr);
    }

    @Test
    void decrypt() throws IOException {
        //when
        String str = "Asm82KnrOBk6EawMf8dHzCPQFFacicNN";
        //given
        String ecnryptStr = CryptUtils.decrypt(str);
        System.out.println("=="+ecnryptStr);
    }

}