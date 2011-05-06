class Player {
    private int score;
    private int lives;
    public Player() {
        lives=10;
        score=0;
    }
    public void addScore(int plus) {
        score+=plus;
    }
    public void looseLife() {
        lives--;
    }
    public int getScore() {
        return score;
    }
    public int getLives() {
        return lives;
    }
}
