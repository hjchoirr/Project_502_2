package org.choongang.global;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class AbstractController implements Controller{

    protected Scanner sc;
    public AbstractController() {
        sc = new Scanner(System.in);
    }

    /**
     * 상단 공통 출력부분
     */
    public void common() {
        System.out.println("학생관리 프로그램 Ver1.0");
        System.out.println(Templates.getInstance().doubleLine());
    }

    /**
    * 입력항목
     *  - 문자 q, exit, quit : 종료
     *  - 숫자 : 메뉴항목
     */
    public void prompt() {
        System.out.print("메뉴선택: ");
        String menu = sc.nextLine();
        if(menu.equals("q") || menu.equals("quit") ||menu.equals("exit") ) {
            System.out.println("종료합니다");
            System.exit(0); // 0 : 정상종료, 1: 비정상종료
        }
        try {
            int m = Integer.parseInt(menu);  // 숫자 아니면 예외로
            change(m);  // 메뉴 변경 -> Menu enum
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("메뉴는 숫자로 입력하세요.");
        }
    }
    /**
     *
     * @param message :항목 메시지
     * @param predicate : 판별식
     * @return
     */
    protected String promptWithValidation(String message, Predicate<String> predicate) {
        String str = null;
        do {
            System.out.print(message);
            str = sc.nextLine();
        } while(!predicate.test(str));
        return str;
    }
    /**
     * 템플릿메서드 패턴 : 특정 절차가 고정되어 있는 경우
     */
    @Override
    public final void run() {   // 템플릿메서드 패턴 - final : 재정의 못하게 run의 절차 고정시킴
        common();
        show();
        prompt();
    }
    private void change(int menuNo) {
        Menu menu = null;

        switch(menuNo) {
            case 1: menu = Menu.JOIN; break;
            case 2: menu = Menu.LOGIN; break;
            default : menu = Menu.MAIN;
        }
        // 메뉴 컨트롤러 변경 처리 - Router
        MainRouter.getInstance().change(menu);
    }

}
