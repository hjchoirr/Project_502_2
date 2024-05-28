package exam01;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.junit.jupiter.api.Test;

public class Ex01 {
    @Test
    void test() {
        SqlSession session = DBConn.getSession();
    }
}
