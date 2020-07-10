package chapter2;

public class Criterion implements Scoreable {
	private Weight weight; // 중요도
	private Answer answer; // 질문
	private int score;
	
	public Criterion(Answer answer, Weight weight) {
		this.answer = answer;
		this.weight = weight;
	}

	public Answer getAnswer() { return answer; }
	public Weight getWeight() { return weight; }

	public void setScore(int score) { this.score = score; }
	public int getScore() { return score; }
}
