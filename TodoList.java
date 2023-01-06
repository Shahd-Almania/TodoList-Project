
//Create a todo list application where users can add, delete and update they todos

package TodoListProject;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    public static ArrayList<String> Todo = new ArrayList<String>();
    public static void main(String[] args) {

        int Item = -1;
        while (Item != 0) {
            Item = option();
            switch (Item) {

                case 1: addTask();
                    break;
                case 2: deleteTask();
                    break;
                case 3: Update();
                    break;
                case 4: showTask();
                    System.out.println(Todo);
                    break;
                case -1:
                    System.out.println("Value is -1 now terminating your program");
                    System.exit(0); //Enter -1 --> exit program
            }
        }
    }
    public static int option() {
        System.out.println("\n ==== Todo List ====");
        System.out.println("Enter Your choice or choose -1 to exit ");
        System.out.println(" Task number of you want:");
        System.out.println("1. To add to the todo list.");
        System.out.println("2. To delete from the todo list.");
        System.out.println("3. To update from the todo list.");
        System.out.println("4. To print all the todos.");
        System.out.println("----------------------");

        try{
            System.out.print("Enter task number: ");
            Scanner scanner=new Scanner(System.in);
            int choice = scanner.nextInt(); //To enter the todo number.
            return choice;
        }catch (Exception exception){
            throw new RuntimeException("Error when enter a value other than a number.."); //Enter only number.
        }
    }
    public static void showTask() {
        int number = 0;
        for (String item : Todo) {  // used "for-each" loop.
            System.out.println(++number + " " + item);

        }

        System.out.println("----------------------");
    }
    public static void addTask() {
        System.out.println("Enter your todo name: ");

            Scanner scanner = new Scanner(System.in);
            String item = scanner.nextLine();
            System.out.println("Your todo saved .. choose another choice ");
            Todo.add(item);
            showTask();
    }
    public static void deleteTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you want to delete? note:Enter number todo: ");
        try{
            int index = scanner.nextInt();
            if((index-1)<0 || index>Todo.size()) {
                System.out.println("Wrong index number! Please enter "+Todo.size());
            }else {
                Todo.remove(index-1);
                System.out.println("Your todo saved .. choose another choice ");
            }
            showTask();
        }catch (Exception e){
            throw new RuntimeException("Error when entering a value other than a number.."); //Enter only number.
        }
    }
    public static void Update()  { // Update --> It deletes the item, then adds another item, and then prints it.
        deleteTask();
        addTask();
        showTask();
    }
}
