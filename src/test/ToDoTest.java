import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

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

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    ToDo myToDo = new ToDo("Mow the lawn");
    assertEquals(false, myToDo.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today(){
    ToDo myToDo = new ToDo("Mow the Lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myToDo.getCreatedAt().getDayofWeek());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    ToDo firstToDo = new ToDo("Mow the lawn");
    ToDo secondToDo = new ToDo("Buy groceries");
    assertEquals(true, ToDo.all().contains(firstToDo));
    assertEquals(true, ToDo.all().contains(secondToDo));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    ToDo myToDo = new ToDo("Mow the lawn");
    ToDo.clear();
    assertEquals(ToDo.all().size(), 0);
// Does it matter, that zero and methods are in different orders?

  }

  @Test
  public void getId_tasksInstantiateWithAnID_1() {
    ToDo.clear();
    ToDo myToDo = new ToDo("Mow the lawn");
    assertEquals(1, myToDo.getId());
  }

  @Test
  public void find_returnsToDoWithSameId_secondToDo(){
    ToDo firstToDo = new ToDo("Mow the lawn")
    ToDo secondToDo = new ToDo("Buy the groceries");
    assertEquals(Task.find(secondToDo.getId()), secondToDo);
  }
}
