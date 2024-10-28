import java.util.ArrayList;
import java.util.Scanner;

public class Methods_InClassProject {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("***WELCOME TO YOUR DAILY TO DO LIS***");
        // the full tasks list
        ArrayList<String> listOfTasks = new ArrayList<>();
        // the completed tasks list
        ArrayList<String> theCompletedTasks = new ArrayList<>();

        // adding tasks to the full list
        String task;
        do{
            System.out.println("Please Enter Your Tasks For The Day (and 'done' to end the list): ");
            task = input.nextLine();
            // added this condition because I had logic error where "done" was added to the list
            if(!task.equalsIgnoreCase("done")){
              addTask(listOfTasks, task);
            }
        }while(!task.equalsIgnoreCase("done"));

        System.out.println("The is the full list: " + listOfTasks);

       // checking off tasks
        String checkOffTask;
        do{
            System.out.println("Now Please CheckOff Your Completed Tasks (and 'done' to end the list): ");
            checkOffTask = input.nextLine();
            checkTask(listOfTasks, theCompletedTasks, checkOffTask);
        }while(!checkOffTask.equalsIgnoreCase("done"));

        // show the full to do list
        showToDoList(theCompletedTasks, listOfTasks);

    }

    public static ArrayList<String> addTask(ArrayList<String> tasksList, String task){
        tasksList.add(task);
        return tasksList;
    }

    public static void checkTask(ArrayList<String> theFullList, ArrayList<String> theCompletedList, String task){
        if(theFullList.contains(task)){
            theCompletedList.add(task);
            theFullList.remove(task);
        }
    }
    public static void showToDoList(ArrayList<String> completedTasksList, ArrayList<String> remainingTasksList){
        for(String task : completedTasksList){
            System.out.print(task + " IS DONE \n");
        }
        System.out.println("************************");
        for(String task : remainingTasksList){
            System.out.print(task + " IS NOT DONE \n");
        }
    }

}
