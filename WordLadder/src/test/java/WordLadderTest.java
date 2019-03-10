import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WordLadderTest {
  @Test
  public void evaluatesExpression() {
    Main main = new Main();
    String check = main.testing("cat", "dog");
    assertEquals("cat->cot->dot->dog", check);
  }
}