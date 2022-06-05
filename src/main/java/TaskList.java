import java.util.ArrayList;

public class TaskList {
    ArrayList<String> toDo = new ArrayList();

   public void addTask(String task){
       toDo.add(task);
   }

   public void removeTask(int index){
       toDo.remove(index-1);
   }
   public void printList(){
       int index=1;
       System.out.println();
       for (String task:toDo
            ) {
            System.out.println(index+". "+task);
            index++;
       }
   }

   public int listSize(){
       return toDo.size();
   }
}
