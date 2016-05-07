package kpi.study.epam;

public class Main {

    public static void main(String[] args) {
        Controller controller=new Controller(new Model(),new View());
        controller.processPlay();
    }
}
