package iloveyouboss;

import org.junit.Assert;
import org.junit.Test;

public class ProfileTest {

  @Test
  public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
    // 지원자가 제출한 답안
    Profile profile = new Profile("카카오");
    Question question = new BooleanQuestion(1, "보너스 받고 싶니? ");
    Answer profileAnswer = new Answer(question, Bool.FALSE);
    profile.add(profileAnswer);

    // 회사가 추구하는 답안
    Criteria criteria = new Criteria();
    Answer criteriaAnswer = new Answer(question, Bool.TRUE);
    Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
    criteria.add(criterion);

    boolean matches = profile.matches(criteria);

    Assert.assertFalse(matches);
  }
}
