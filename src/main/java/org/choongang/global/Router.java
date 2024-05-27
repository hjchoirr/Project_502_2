package org.choongang.global;

import org.choongang.global.constants.Menu;

/**
 * 사용자가 입력한 메뉴번호, 문구 -> 해당하는 컨트로러로 연결
 */
public interface Router {
    void change(Menu menu);
    void start();
}
