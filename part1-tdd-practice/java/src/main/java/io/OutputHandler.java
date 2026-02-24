package io;

public interface OutputHandler {
    public void gameStartMessage();
    public void gameScoreMessage(int strike, int ball);
    public void gameCompleteMessage();
    public void gameRestartMessage();
}
