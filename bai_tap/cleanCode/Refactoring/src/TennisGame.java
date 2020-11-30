public class TennisGame {
    public static final char SUBTRACTION = '-';
    public static final int SCORE_LOVE = 0;
    public static final int SCORE_15 = 1;
    public static final int SCORE_30 = 2;
    public static final int SCORE_40 = 3;

    public static String getScore(String player1Name, String player2Name, int scoreOne, int scoreTwo) {
        String score = "";
        int tempScore = 0;
        if (scoreOne == scoreTwo) {
            switch (scoreOne) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;
            }
        } else if (scoreOne >= 4 || scoreTwo >= 4) {
            int minusResult = scoreOne - scoreTwo;
            return (minusResult == 1)
                    ? "Advantage player1"
                    : (minusResult == -1)
                    ? "Advantage player2"
                    : (minusResult >= 2)
                    ? "Win for player1"
                    : "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scoreOne;
                else {
                    score += SUBTRACTION;
                    tempScore = scoreTwo;
                }
                switch (tempScore) {
                    case SCORE_LOVE:
                        return "love";

                    case SCORE_15:
                        return "Fifteen";

                    case SCORE_30:
                        return "Thirty";

                    case SCORE_40:
                        return "Forty";
                }
            }
        }
        return score;
    }
}