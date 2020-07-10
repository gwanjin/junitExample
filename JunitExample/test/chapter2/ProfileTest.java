package chapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfileTest {

	@Test
	void test() {
		Profile profile = new Profile("Bull Hockey");
		Question question = new BooleanQuestion(1, "Got bonuses?");
		
		// Profile객체에 적절한 Answer객체 넣어두기
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);
		
		Criteria criteria = new Criteria();
		Answer answer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(answer, Weight.MustMatch);
		
		criteria.add(criterion);
	}
	
	
	@Test
	public void matchAnswersFalseWhenMushMathCriteriaNotMet() { // 테스트 의도를 알수있도록 적절한 이름을 지정
		Profile profile = new Profile("Bull Hockey");
		Question question = new BooleanQuestion(1, "Got bonuses?");
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);
		Criteria criteria = new Criteria();
		Answer answer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(answer, Weight.MustMatch);
		
		criteria.add(criterion);
		
		boolean matches = profile.matches(criteria);
		// assertFalse(matches);
		assertTrue(matches); // expected: <true> but was: <false>
		
	}
}
