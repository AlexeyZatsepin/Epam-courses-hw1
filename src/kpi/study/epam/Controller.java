package kpi.study.epam;

import java.util.Scanner;

/**
 * Created by Alex on 4/25/16.
 */
public class Controller{
    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void proccessPlay(){
        view.printMessage(View.START_GAME);
        model.rand(0,100);

        Scanner scanner= new Scanner(System.in);
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
        view.printMessage(View.RIGHT_NUMBER + model.getRandomValue());
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
