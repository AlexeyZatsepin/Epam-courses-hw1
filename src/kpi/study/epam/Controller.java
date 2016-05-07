package kpi.study.epam;

import java.util.Scanner;

public class Controller{
    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void processPlay(){
        Scanner scanner= new Scanner(System.in);
        view.printMessage(View.START_GAME);
        model.setBarriers(GlobalValues.MIN_BARRIER,GlobalValues.MAX_BARRIER);
        model.rand();

        model.addAttempt(attempt(scanner));
        while (model.getRandomValue()!= model.getLastAttempt()){
            if (model.getLastAttempt() < model.getRandomValue()) {
                view.printMessage(View.LESS_THAN_RANDOM);
                model.setMinValue(model.getLastAttempt());
            }
            else if (model.getLastAttempt() > model.getRandomValue()) {
                view.printMessage(View.MORE_THAN_RANDOM);
                model.setMaxValue(model.getLastAttempt());
            }
            view.printMessageAndAttempts(View.USER_ATTEMPTS,model.getAttempts());
            model.addAttempt(attempt(scanner));
        }
        view.printMessage(View.CORRECT_ANSWER);
        view.printMessageAndAttempts(View.ATTEMPTS,model.getAttempts());
        view.printMessage(new StringBuilder().append(View.RIGHT_NUMBER).append(model.getRandomValue()).toString());
    }

    public int attempt(Scanner sc) {
        int attemptValue = inputIntValueWithScanner(sc);
        while (attemptValue < model.getMinValue() || attemptValue > model.getMaxValue()) {
            view.printMessage(View.WRONG_RANGE);
            attemptValue = inputIntValueWithScanner(sc);
        }
        return attemptValue;
    }

    // inspection of input
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessageValidRange(View.RANGE_TITLE, model.getMinValue(), model.getMaxValue());
        view.printMessage(View.USER_INPUT);

        while( !sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_DATA);
            sc.next();
        }

        return sc.nextInt();
    }
}
