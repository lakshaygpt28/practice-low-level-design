package Questions.StackOverflow;

import Questions.StackOverflow.model.Bounty;
import Questions.StackOverflow.model.Member;
import Questions.StackOverflow.model.Question;
import Questions.StackOverflow.model.Tag;
import Questions.StackOverflow.service.StackOverflow;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StackOverflowDemo {
    public static void run() {
        StackOverflow stackOverflow = StackOverflow.getInstance();

        Member member1 = new Member(1);
        Member member2 = new Member(2);
        stackOverflow.registerUser(member1);
        stackOverflow.registerUser(member2);

        // Post a question
        Question question1 = new Question(1L, member1, "What is Java?", "Please explain Java.", null,
                Arrays.asList(new Tag("java"), new Tag("programming")), new Bounty(100, Instant.now().plus(7, ChronoUnit.DAYS).toEpochMilli()));
        stackOverflow.postQuestion(question1);

        stackOverflow.upVote(question1, member2);

        // Search for questions
        List<Question> searchResults = stackOverflow.searchQuestion("Java");
        System.out.println("Search Results:");
        for (Question question : searchResults) {
            System.out.println(question.getTitle());
        }

        // Get questions by tag
        List<Question> taggedQuestions = stackOverflow.getTaggedQuestions("java");
        System.out.println("Questions tagged with 'java':");
        for (Question question : taggedQuestions) {
            System.out.println(question.getTitle());
        }

        // Get questions by user
        List<Question> userQuestions = stackOverflow.getQuestionsByUser(member1);
        System.out.println("Questions posted by user1:");
        for (Question question : userQuestions) {
            System.out.println(question.getTitle());
        }

    }

    public static void main(String[] args) {
        run();
    }
}
