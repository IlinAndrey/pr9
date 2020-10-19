package pr9;
import java.util.Scanner;

import static java.lang.System.err;

public class LabClassUI {
    LabClass labClass;

    public LabClassUI() {
        labClass = new LabClass();
        LabClassDriver driver = new LabClassDriver(labClass);
        Scanner in = new Scanner(System.in);
        boolean created = false;
        System.out.println("Хотите ли вы создать новый список?(если нет, он загрузит старый): ");

        String input = (in.nextLine()).toLowerCase();
        if (input.equals("да")) {
            driver.createLabClass();
            created = true;
        }
        else if (input.equals("нет")) {
            driver.fillLabClass();
        }
        else {
            err.print("Неправильный ввод");
            System.out.println('\n');
            driver.fillLabClass();
        }

        if (created) {
            System.out.println("Хотите ли вы сохранить список? ");
            input = (in.next()).toLowerCase();
            if (input.equals("да")) {
                driver.saveLabCLass();
            }
            driver.fillLabClass();
        }
    }

    public void findStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя студента: ");
        String name = null;

        try {
            name = (in.nextLine()).toLowerCase();
            if (name.isEmpty()) {

                throw new EmptyStringException("Вы ввели пустую строку");
            }
        }
        catch (EmptyStringException e) {
            err.println(e.getMessage());
            System.out.println();
            findStudent();
            return;
        }

        try {
            System.out.println(labClass.find(name).toString());
        }
        catch (StudentNotFoundException e) {
            err.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        LabClassUI app = new LabClassUI();
        app.findStudent();
    }
}

