import org.junit.*;
import static org.junit.Assert.*;

public class ToDoTest {

  @Test
  public void ToDo_instantiatesCorrectly_true() {
    Task myToDo = new ToDo("Cook Curry");
    assertEquals(true, myToDo instanceof ToDo);
  }

  @Test
  public void ToDo_instantiatesWithDescription_String(){
    ToDo myToDo = new ToDo("Cook Curry");
    assertEquals("Cook Curry", myToDo.getDescription());
  }
}
