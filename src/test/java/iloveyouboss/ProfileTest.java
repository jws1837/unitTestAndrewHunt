package iloveyouboss;

import org.junit.Test;

public class ProfileTest {

  @Test
  public void test() {
    // 지원자의답안
    Profile profile = new Profile("카카오");
    Question question = new BooleanQuestion(1, "보너스 받고 싶니? ");
    Answer profileAnswer = new Answer(question, Bool.FALSE);
    profile.add(profileAnswer);

    // 모범답안
    Criteria criteria = new Criteria();
    Answer criteriaAnswer = new Answer(question, Bool.TRUE);
    Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
    criteria.add(criterion);
  }
}
