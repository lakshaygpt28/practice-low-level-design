package Questions.StackOverflow.service;

import Questions.StackOverflow.model.Answer;
import Questions.StackOverflow.model.Comment;
import Questions.StackOverflow.model.Member;
import Questions.StackOverflow.model.Question;
import Questions.StackOverflow.model.Tag;
import Questions.StackOverflow.model.TextPhotoBasedEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflow {
    private static volatile StackOverflow instance;
    private final Map<Long, Question> questions;
    private final Map<Long, Member> members;
    private final Map<String, List<Question>> taggedQuestions;

    StackOverflow() {
        questions = new ConcurrentHashMap<>();
        members = new ConcurrentHashMap<>();
        taggedQuestions = new ConcurrentHashMap<>();
    }

    public static StackOverflow getInstance() {
        if (instance == null) {
            synchronized (StackOverflow.class) {
                if (instance == null) {
                    instance = new StackOverflow();
                }
            }
        }
        return instance;
    }

    public void registerUser(Member member) {
        members.put(member.getId(), member);
    }

    public void postQuestion(Question question) {
        questions.put(question.getId(), question);
        for (Tag tag: question.getTags()) {
            taggedQuestions.putIfAbsent(tag.getTag(), new ArrayList<>());
            taggedQuestions.get(tag.getTag()).add(question);
        }
    }

    public void postAnswer(Question question, Answer answer) {
        question.addAnswer(answer);
    }

    public void postComment(Comment comment, TextPhotoBasedEntity to) {
        if (to instanceof Answer) {
            ((Answer) to).addComment(comment);
        } else if (to instanceof Question) {
            ((Question) to).addComment(comment);
        }
    }

    public List<Question> searchQuestion(String query) {
        List<Question> result = new ArrayList<>();
        for (Question question: questions.values()) {
            if (question.getTitle().contains(query) || question.getText().contains(query)) {
                result.add(question);
            }
        }
        return result;
    }

    public List<Question> getTaggedQuestions(String tag) {
        return taggedQuestions.getOrDefault(tag, new ArrayList<>());
    }

    public List<Question> getQuestionsByUser(Member member) {
        List<Question> result = new ArrayList<>();
        for (Question question : questions.values()) {
            if (question.getCreator().equals(member)) {
                result.add(question);
            }
        }
        return result;
    }

    public void upVote(TextPhotoBasedEntity entity, Member member) {
        entity.upVote(member.getId());
    }

    public void downVote(TextPhotoBasedEntity entity, Member member) {
        entity.downVote(member.getId());
    }


}
