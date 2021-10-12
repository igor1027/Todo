package Controller;

import Entity.TaskValues;
import Repository.DataBase;
import Service.Impl.ScanService;
import Service.Impl.TaskServiceImp;

public class Menu {
    ScanService scanService = new ScanService();
    DataBase dataBase = new DataBase();
    TaskServiceImp taskServiceImp = new TaskServiceImp();
    TaskValues taskValues = new TaskValues();

    public void StartApplication(){
        System.out.println("Выберете одно из предложеных действий");
        System.out.println("1 - Добавить задачу");
        System.out.println("2 - Обновить задачу");
        System.out.println("3 - Обновить статус задачи");
        System.out.println("4 - Удалить задачу");
        System.out.println("5 - Просмотр задач");
        System.out.println("6 - Выход");
        ChoiceMenuAction();
    }

    private void ChoiceMenuAction(){
        int i = scanService.checkInt();

        switch (i){
            case 1: {
                taskServiceImp.addTask();
                StartApplication();
            }
            case 2: {
                taskServiceImp.updateTask();
                StartApplication();
            }
            case 3: {
                taskServiceImp.updateTaskStatus();
                StartApplication();
            }
            case 4: {
                taskServiceImp.deleteTask();
                StartApplication();
            }
            case 5: {
                taskServiceImp.infoTask();
                StartApplication();
            }
            case 6: {
                System.out.println("До новых встреч");
                System.exit(0);
            }

            default: {
                System.out.println("Введенного вами пункта нет в меню");
                StartApplication();
            }
        }
    }
}
