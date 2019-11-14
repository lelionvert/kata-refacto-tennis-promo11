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
        if (player1getsAdvantage()) return "Advantage player1";
        if (player2getsAdvantage()) return "Advantage player2";
        if (player1win()) return "Win for player1";
        if (player2win()) return "Win for player2";

        return getScoreRegularPlay();
    }

    private boolean player2win() {
        return (scorePlayer1 >= 4 || scorePlayer2 >= 4) && scorePlayer1 - scorePlayer2 < 1;
    }

    private boolean player1win() {
        return (scorePlayer1 >= 4 || scorePlayer2 >= 4) && scorePlayer1 - scorePlayer2 > 1;
    }

    private boolean player2getsAdvantage() {
        int minusResult = scorePlayer1 - scorePlayer2;
        return (scorePlayer1 >= 4 || scorePlayer2 >= 4) && minusResult == -1;
    }

    private boolean player1getsAdvantage() {
        int minusResult = scorePlayer1 - scorePlayer2;
        return (scorePlayer1 >= 4 || scorePlayer2 >= 4) && minusResult == 1;
    }

    private boolean scoreEqual() {
        return scorePlayer1 == scorePlayer2;
    }

    private String getScoreWhenEqual() {
        switch (scorePlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
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
