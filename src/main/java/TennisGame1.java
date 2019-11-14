public class TennisGame1 implements TennisGame {

    public static final String ZERO = "Love";
    public static final String ONE = "Fifteen";
    public static final String TWO = "Thirty";
    public static final String THREE = "Forty";
    private int m_score1 = 0;
    private int m_score2 = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1wonPoint();
        } else {
            player2wonPoint();
        }
    }

    private void player2wonPoint() {
        m_score2 += 1;
    }

    private void player1wonPoint() {
        m_score1 += 1;
    }

    public String getScore() {
        if (scoreEqual()) {
            return getScoreWhenEqual();
        }
        if (decisiveGamePoint()) {
            return getScoreWhenDecisive();
        }
        return getScoreWhenDifferentAndLowerThan4();
    }

    private boolean decisiveGamePoint() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private boolean scoreEqual() {
        return m_score1 == m_score2;
    }

    private String getScoreWhenDecisive() {
        StringBuilder score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score.toString();
    }

    private String getScoreWhenEqual() {
        StringBuilder score;
        switch (m_score1) {
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

    private String getScoreWhenDifferentAndLowerThan4() {
        StringBuilder score = new StringBuilder();

        getScoreForPoints(score, m_score1);
        score.append("-");
        getScoreForPoints(score, m_score2);
        return score.toString();
    }

    private void getScoreForPoints(StringBuilder score, int tempScore) {
        switch (tempScore) {
            case 0:
                score.append(ZERO);
                break;
            case 1:
                score.append(ONE);
                break;
            case 2:
                score.append(TWO);
                break;
            case 3:
                score.append(THREE);
                break;
        }
    }
}
