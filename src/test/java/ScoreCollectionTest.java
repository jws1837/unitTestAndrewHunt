import org.junit.Assert;
import org.junit.jupiter.api.*;
// JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
// assert,assume, assertThrows
class ScoreCollectionTest {

  @BeforeAll
  static void setup() {}

  @BeforeEach
  void setUp() {}

  //  @AfterAll
  @AfterEach
  void tearDown() {}

  @DisplayName("book 31p")
  @Test
  public void answersArithmeticMeanOfTwoNumbers() {
    // Arrange
    ScoreCollection collection = new ScoreCollection();
    collection.add(() -> 5);
    collection.add(() -> 7);

    // Act
    int actualResult = collection.arithmeticMean();

    // Assert
    Assert.assertEquals(actualResult, 6);
  }
}