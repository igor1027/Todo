package Service.Impl;

import Controller.Menu;
import Entity.TaskValues;
import Repository.DataBase;
import Service.TaskService;

public class TaskServiceImp implements TaskService {
    ScanService scanService = new ScanService();
    CheckService checkService = new CheckService();
//    Menu menu = new Menu();

    @Override
    public void addTask() {
        System.out.println("Введите значения для своей таблицы");
        System.out.println("Введите имя задачи");
        String newName = scanService.checkString();
        System.out.println("Введите описание задачи");
        String newDescription = scanService.checkString();
        String newStatus = chooseNewStatus();
        TaskValues taskValues = new TaskValues(newName,newDescription,newStatus);
        DataBase.addTask(taskValues);
        System.out.println("Задача добавлена");
    }

    @Override
    public void updateTask() {
//        if (checkService.CheckDataBaseIsEmpty()){
//            System.out.println("Список данных пустой");
//            menu.StartApplication();
//        }else{
//            System.out.println("Ведите id задачи, в которой хотите внести изменения");
//            int id = scanService.checkInt();
            System.out.println("Введите новое имя задачи");
            String newName = scanService.checkString();
            System.out.println("Введите новое описание задачи");
            String newDescription = scanService.checkString();
            System.out.println("Ведите id задачи, в которой хотите внести изменения");
             int id = scanService.checkInt();
            DataBase.updateTask(newName, newDescription, id);
            System.out.println("Изменеия выполнены");
//        }
    }

    @Override
    public void updateTaskStatus() {
        System.out.println("Введите id задачи, что хотите изменить");
        int id = scanService.checkInt();
        String newStatus = chooseNewStatus();
        DataBase.UpdateStatus(id,newStatus);
        System.out.println("Статус обновлен");
    }

    @Override
    public void deleteTask() {
        if(checkService.CheckDataBaseIsEmpty()){
            System.out.println("Список пуст");
        }else {
            System.out.println("Введите id задачи");
            int id = scanService.checkInt();
            DataBase.deleteTask(id);
            System.out.println("Задача удалена");
        }

    }

    @Override
    public void infoTask() {
        DataBase.infoTask();
        System.out.println("====================================================================");
    }

    private String chooseNewStatus(){
        System.out.println("Выберете один из предложенных статусов:");
        System.out.println("1. Планируется");
        System.out.println("2. Выполняется");
        System.out.println("3. Завершино");
        int choose;
        do{
            choose = scanService.checkInt();
        }while (choose != 1 && choose !=2 && choose !=3);

        switch (choose){
            case 1: {
                return String.valueOf(Status.PLANNING);
            }
            case 2: {
                return String.valueOf(Status.PROCESSING);
            }
            case 3: {
                return String.valueOf(Status.FINISH);
            }
        }
        return null;
    }
}
