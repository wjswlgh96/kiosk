### Lv 4. 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기

- [x]  **`Menu` 클래스 생성하기**
    - [x]  설명 : MenuItem 클래스를 관리하는 클래스입니다.
      예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 `MenuItem`을 포함합니다.
    - [x]  `List<MenuItem>` 은 `Kiosk` 클래스가 관리하기에 적절하지 않으므로 Menu 클래스가 관리하도록 변경합니다.
    - [x]  여러 버거들을 포함하는 상위 개념 ‘버거’ 같은 `카테고리 이름` 필드를 갖습니다.
    - [x]  메뉴 카테고리 이름을 반환하는 메서드가 구현되어야 합니다.
- [x]  구조 예시
```
public static void main(String[] args) {
		// Menu 객체 생성하면서 카테고리 이름 설정
		// Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
		
		// Kiosk 객체 생성
		// Kiosk 내 시작하는 함수 호출
}

public class Kiosk {

		start() {
			// 스캐너 선언
			// 반복문 시작
			
			// List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
			
			// 숫자 입력 받기
			
			// 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
			// List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
			
			// Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
			
			// 숫자 입력 받기
			// 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
			// menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
		}

}

public class Menu {
		// MenuItem 클래스를 List로 관리
		
		// List에 들어있는 MenuItem을 순차적으로 보여주는 함수
		// List를 리턴하는 함수
		
		// 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
}

public class MenuItem {
		// 이름, 가격, 설명 필드 선언하여 관리
		
		// 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
}
```

### 검토

- 의도한 대로 구조가 잘 짜여졌는지 튜터님께 확인한 결과 잘했다고 하셨습니다.