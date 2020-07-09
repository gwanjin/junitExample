package chapter1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// @Test anotationdmsorg.juni패키지에 있음.

class ScoreCollectionTest {
	// Junit은 @Test 애너테이션이 붙은 test메서드를 테스트로 실행한다.
	// 테스트 클래스에는 테스트 메서드가 아닌 다른 메서드 포함할 수 있으며 junit은 그것들을 알아서 제외한다.
	
	@Test
	void test() {
		// 실패한 경우 적색 막대가 표시되고 적색 막대 옆에 있는 요약된 수치를 확인한다.
		// Failures: 1이 표시되어 1개가 실패했다고 표시
		// 적색 막대 아래에는 junit의 테스트 실행결과에 대한 정보를 알려준다.
		//explorer창에서 선택하면 Failure Trace에서 예외 메시지를 표시해줌
		// fail("Not yet implemented");
		
		// 성공시에는 초록색 막대로 표시됨.
		System.out.println("success");
	}

}
