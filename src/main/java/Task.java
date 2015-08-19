import java.time.LocalDateTime;
import java.util.ArrayList;


public class Task { //class Task

  private static ArrayList<Task> instances = new ArrayList<Task>();

  private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private int mId;


  public Task(String description) {
    mDescription = description;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size(); //total size of the array( 5 tasks = size 5) not indiv. objects
  }// constructor has all the instructions for making a new instance of the class task
  //constructors are named after the class, they are actually methods

  public String getDescription(){
    return mDescription;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Task> all() {
    return instances;
  }

  public static Task find (int id){
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }
  
  public static void clear() {
    instances.clear();
  }
} //class Task
