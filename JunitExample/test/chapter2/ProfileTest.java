package chapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfileTest {
	private Profile mProfile;
	private BooleanQuestion mQuestion;
	private Criteria mCriteria;
	
	/**
	 * 공통적인 초기화 코드를 작성하기 위한 메소드
	 * @BeforeEach 어노에티션을 이용하면 JUnit테스트를 실행할 때마다 먼저 실행 
	 * @BeforeEach 는 각 테스트를 실행하기 전에 한번씩 호출
	 * @BeforeAll 은 테스트를 실행하기 전에 한번만 호
	 */
	@BeforeEach
	public void create() {
		mProfile = new Profile("Bull Hockey");
		mQuestion = new BooleanQuestion(1, "Got bonuses?");
		mCriteria = new Criteria();
	}

	@Test
	void test() {
		// Profile객체에 적절한 Answer객체 넣어두기
		Answer profileAnswer = new Answer(mQuestion, Bool.FALSE);
		mProfile.add(profileAnswer);
		
		Answer answer = new Answer(mQuestion, Bool.TRUE);
		Criterion criterion = new Criterion(answer, Weight.MustMatch);
		
		mCriteria.add(criterion);
	}
	
	
	@Test
	public void matchAnswersFalseWhenMushMathCriteriaNotMet() { // 테스트 의도를 알수있도록 적절한 이름을 지정
		mProfile.add(new Answer(mQuestion, Bool.FALSE)); //지원자의 대답
		mCriteria.add(new Criterion(new Answer(mQuestion, Bool.TRUE), Weight.MustMatch)); // 기대하는 대답
		
		boolean matches = mProfile.matches(mCriteria);
		// assertFalse(matches);
		assertTrue(matches); // expected: <true> but was: <false>
	}
	
	@Test
	public void mathchAnswersTrueForAnyDontCareCriteria() {
		mProfile.add(new Answer(mQuestion, Bool.FALSE)); //지원자의 대답
		mCriteria.add(new Criterion(new Answer(mQuestion, Bool.TRUE), Weight.DontCare)); // 기대하는 대답
		
		boolean matches = mProfile.matches(mCriteria);
		assertTrue(matches);
	}
}
