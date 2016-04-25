package kpi.study.epam;

import java.util.List;

/**
 * Created by Alex on 4/25/16.
 */
public class View {
    //Necessary constants
    public static final String START_GAME = "Let's play! I wonna play with u";
    public static final String RANGE_TITLE="Now range is:";
    public static final String USER_INPUT = "Enter your prediction (INT value): ";
    public static final String WRONG_INPUT_DATA = "Wrong input value! Repeat please! ";
    public static final String WRONG_RANGE = "Invalid input value! Enter INT value from range! ";
    public static final String MORE_THAN_RANDOM = "So close,but more that my value, try again.";
    public static final String LESS_THAN_RANDOM = "So close,but less that my value, try again.";
    public static final String CORRECT_ANSWER = "Congratulations! You won the game";
    public static final String ATTEMPTS = "Your attempts : ";
    public static final String USER_ATTEMPTS = "Your previous answers: ";
    public static final String RIGHT_NUMBER="Random value was:";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndAttempts(String message, List<Integer> attempts) {
        System.out.println(message + attempts);
    }

    public void printMessageValidRange(String message, int min, int max){
        System.out.println(message + "[" + min + ";" + max + "]");
    }
}
