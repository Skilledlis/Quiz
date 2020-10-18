package com.example.quiz;

public class Question {

    private int mTextResId;
    private int mImgResId;
    private char mAnswerTrue;

    public Question(int textResId, int imgRestId, char answerTrue) {
        mTextResId = textResId;
        mImgResId = imgRestId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTexResId(int textResId) {
        mImgResId = textResId;
    }

    public int getImgResId() {
        return mImgResId;
    }

    public void setImgResId(int imgResId) {
        mImgResId = imgResId;
    }

    public char isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(char answerTrue) {
        mAnswerTrue = answerTrue;
    }


}
