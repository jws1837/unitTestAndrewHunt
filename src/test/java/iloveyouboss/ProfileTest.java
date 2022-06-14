package iloveyouboss;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfileTest {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    /***
     * iloveyouboss_13(책에서제공하는예제) 테스트코드 7개 포함된 버전수록되어있음.
     * */

    @Before
    public void create() {
        Profile profile = new Profile("카카오");
        Question question = new BooleanQuestion(1, "보너스 받고 싶니? ");
        Criteria criteria = new Criteria();
    }

    @Test
    public void matches() {
        Profile profile = new Profile("Bull Hockey, Inc.");
        Question question = new BooleanQuestion(1, "Got milk?");

        // answers false when must-match criteria not met
        profile.add(new Answer(question, Bool.FALSE));
        Criteria criteria = new Criteria();
        criteria.add(
                new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        Assert.assertFalse(profile.matches(criteria));

        // answers true for any don't care criteria
        profile.add(new Answer(question, Bool.FALSE));
        criteria = new Criteria();
        criteria.add(
                new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        Assert.assertTrue(profile.matches(criteria));
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        // 지원자가 제출한 답안
        profile.add(new Answer(question, Bool.FALSE));
        // 회사가 추구하는 답안
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        boolean matches = profile.matches(criteria);

        Assert.assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        // 지원자가 제출한 답안
        profile.add(new Answer(question, Bool.FALSE));
        // 회사가 추구하는 답안
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        boolean matches = profile.matches(criteria);

        Assert.assertTrue(matches);
    }
}
