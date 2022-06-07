import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
//assert,assume, assertThrows
class ScoreCollectionTest {

  @BeforeAll
  static void setup() {}

  @BeforeEach
  void setUp() {}

//  @AfterAll
  @AfterEach
  void tearDown() {}

  @Disabled("Not implemented yet")
  @Test
  void test() {
    fail("Not yet implemented");
  }

  @Disabled("Not implemented yet")
  @Test
  void add() {}

  @DisplayName("Single test successful")
  @Test
  void arithmeticMean() {}
}
