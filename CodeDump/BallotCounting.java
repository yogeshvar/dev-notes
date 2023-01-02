class BallotCountingChallenge {
    public int count(String votes) {
        int averageVotesTowin = (int) (votes.length() * (50 / 100.0f));
        char[] ch = votes.toCharArray();
        int AVotes = 0;
        int BVotes = 0;
        for (int i = 0; i < ch.length; i++) {
            if (AVotes > averageVotesTowin) {
                return i;
            } else if (BVotes > averageVotesTowin) {
                return i;
            }
            if (ch[i] == 'A')
                AVotes++;
            if (ch[i] == 'B')
                BVotes++;
        }
        return AVotes + BVotes;
    }
}

public class BallotCounting {
    public static void main(String[] args) {
        BallotCountingChallenge ballotCountingChallenge = new BallotCountingChallenge();
        String votes = "BABABBB";
        int result = ballotCountingChallenge.count(votes);
        System.out.println("Result : " + result);
    }
}
