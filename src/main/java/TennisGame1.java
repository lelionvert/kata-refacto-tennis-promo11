public class TennisGame1 implements TennisGame {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1wonPoint();
        } else {
            player2wonPoint();
        }
    }

    private void player2wonPoint() {
        scorePlayer2 += 1;
    }

    private void player1wonPoint() {
        scorePlayer1 += 1;
    }

    public String getScore() {
        if (scoreEqual()) {
            return getScoreWhenEqual();
        }
        if (decisiveGamePoint()) {
            return getScoreWhenDecisive();
        }
        return getScoreRegularPlay();
    }

    private boolean decisiveGamePoint() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private boolean scoreEqual() {
        return scorePlayer1 == scorePlayer2;
    }

    private String getScoreWhenDecisive() {
        StringBuilder score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score.toString();
    }

    private String getScoreWhenEqual() {
        StringBuilder score;
        switch (scorePlayer1) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score.toString();
    }

    private String getScoreRegularPlay() {
        StringBuilder score = new StringBuilder();

        getScoreForPoints(score, scorePlayer1);
        score.append("-");
        getScoreForPoints(score, scorePlayer2);
        return score.toString();
    }

    private void getScoreForPoints(StringBuilder score, int tempScore) {
        switch (tempScore) {
            case 0:
                score.append(LOVE);
                break;
            case 1:
                score.append(FIFTEEN);
                break;
            case 2:
                score.append(THIRTY);
                break;
            case 3:
                score.append(FORTY);
                break;
        }
    }
}
