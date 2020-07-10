package chapter2;

import java.util.HashMap;
import java.util.Map;

public class Profile {
	private Map<String, Answer> answers = new HashMap<>();
	private int score;
	private String name;

	public Profile (String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void add(Answer answer) {
		answers.put(answer.getQuestionText(), answer);
	}
	
	// 매칭 확인
	// 원하는 대로 작동하는지 테스트
	public boolean matches(Criteria criteria) { 
		score = 0;
		
		boolean kill = false;
		boolean anyMatches = false; 
		// ↓Criteria 인스턴스가 Criterion객체를 포함하지 않을 경우 / Criteria 인스턴스가 다수의 Criterion 객체를 포함할때
		for (Criterion criterion: criteria) {
			// ↓answer.get()에서 반환된 Answer객체가 null 일때 / criterion.getAnswer()혹은 criterion.getAnswer().getQuestionText()의 반환 값이 null일
			Answer answer = answers.get(criterion.getAnswer().getQuestionText()); 
			
			// criterion.getWeight()의 반환값이 Weight.DontCare여서 match 변수가 true일때
			boolean match = 
					criterion.getWeight() == Weight.DontCare || 
					answer.match(criterion.getAnswer());

			if (!match && criterion.getWeight() == Weight.MustMatch) {  
				kill = true;
			}
			if (match) {         
				score += criterion.getWeight().getValue();
			}
			anyMatches |= match;  
		}
		if (kill)       
			return false;
		return anyMatches; 
	}

	public int score() {
		return score;
	}
}
