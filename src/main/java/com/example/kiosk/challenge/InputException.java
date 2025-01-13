package com.example.kiosk.challenge;

public class InputException extends Exception {

    public InputException() {
        super("잘못된 메뉴 입력입니다. 초기화면으로 돌아갑니다.");
    }

    public InputException(String message) {
        super(message);
    }
}
