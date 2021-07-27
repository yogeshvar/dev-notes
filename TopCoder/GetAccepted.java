class GetAcceptedChallenge {
    public String answer(String question) {
        int count = (question.split("not").length) - 1;
        if (count % 2 == 0)
            return "True";
        return "False";
    }
}

public class GetAccepted {
    public static void main(String[] args) {
        GetAcceptedChallenge getAcceptedChallenge = new GetAcceptedChallenge();
        System.out.println(getAcceptedChallenge.answer("Do you want to get accepted?"));
    }
}
