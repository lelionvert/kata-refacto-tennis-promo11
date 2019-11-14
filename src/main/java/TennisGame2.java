public class TennisGame2 implements TennisGame {
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    private String player1result = "";
    private String player2result = "";

    public String getScore() {
        String score = "";
        if (isScoreEqualAndNotDeuce()) {
            if (scorePlayer1 == 0)
                score = "Love";
            if (scorePlayer1 == 1)
                score = "Fifteen";
            if (scorePlayer1 == 2)
                score = "Thirty";
            score += "-All";
        }
        if (isScoreEqualAndDeuce())
            score = "Deuce";

        if (secondPlayerScoreIsZero()) {
            if (scorePlayer1 == 1)
                player1result = "Fifteen";
            if (scorePlayer1 == 2)
                player1result = "Thirty";
            if (scorePlayer1 == 3)
                player1result = "Forty";

            player2result = "Love";
            score = player1result + "-" + player2result;
        }
        if (scorePlayer2 > 0 && scorePlayer1 == 0) {
            if (scorePlayer2 == 1)
                player2result = "Fifteen";
            if (scorePlayer2 == 2)
                player2result = "Thirty";
            if (scorePlayer2 == 3)
                player2result = "Forty";

            player1result = "Love";
            score = player1result + "-" + player2result;
        }

        if (scorePlayer1 > scorePlayer2 && scorePlayer1 < 4) {
            if (scorePlayer1 == 2)
                player1result = "Thirty";
            if (scorePlayer1 == 3)
                player1result = "Forty";
            if (scorePlayer2 == 1)
                player2result = "Fifteen";
            if (scorePlayer2 == 2)
                player2result = "Thirty";
            score = player1result + "-" + player2result;
        }
        if (scorePlayer2 > scorePlayer1 && scorePlayer2 < 4) {
            if (scorePlayer2 == 2)
                player2result = "Thirty";
            if (scorePlayer2 == 3)
                player2result = "Forty";
            if (scorePlayer1 == 1)
                player1result = "Fifteen";
            if (scorePlayer1 == 2)
                player1result = "Thirty";
            score = player1result + "-" + player2result;
        }

        if (scorePlayer1 > scorePlayer2 && scorePlayer2 >= 3) {
            score = "Advantage player1";
        }

        if (scorePlayer2 > scorePlayer1 && scorePlayer1 >= 3) {
            score = "Advantage player2";
        }

        if (scorePlayer1 >= 4 && scorePlayer2 >= 0 && (scorePlayer1 - scorePlayer2) >= 2) {
            score = "Win for player1";
        }
        if (scorePlayer2 >= 4 && scorePlayer1 >= 0 && (scorePlayer2 - scorePlayer1) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean secondPlayerScoreIsZero() {
        return scorePlayer1 > 0 && scorePlayer2 == 0;
    }

    private boolean isScoreEqualAndDeuce() {
        return scorePlayer1 == scorePlayer2 && scorePlayer1 >= 3;
    }

    private boolean isScoreEqualAndNotDeuce() {
        return scorePlayer1 == scorePlayer2 && scorePlayer1 < 4;
    }

    private void P1Score() {
        scorePlayer1++;
    }

    private void P2Score() {
        scorePlayer2++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }
}