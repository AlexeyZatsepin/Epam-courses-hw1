package kpi.study.epam;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created 4/25/16.
 * @author Alex
 */
public class Model {
    private List<Integer> attempts;
    private int randomValue;
    private int minValue;
    private int maxValue;

    Model(){
        randomValue=0;
        minValue=0;
        maxValue=0;
        attempts = new LinkedList<>();
    }
    //function that gives us pseudo-random value
    public int rand() {
        return randomValue = new Random().nextInt(maxValue+1 - minValue)+minValue;//pseudo-random value between [min,max]
    }
    /**
     * the setters and getters block bellow
     * */
    public void setBarriers(int minValue,int maxValue){
        this.minValue=minValue;
        this.maxValue=maxValue;
    }
    public List<Integer> getAttempts() {
        return attempts;
    }
    public int getLastAttempt(){
        return attempts.get(attempts.size()-1);
    }

    public void addAttempt(Integer query) {
        attempts.add(query);
    }

    public int getRandomValue() {
        return randomValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
