package com.techienerd.quizgame.model;

/**
 * Created by Nayan on 7/18/2017.
 */
public class MScore {
    private int presentScore;
    private int bestScore;
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public int getPresentScore() {
        return presentScore;
    }

    public void setPresentScore(int presentScore) {
        this.presentScore = presentScore;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
}
