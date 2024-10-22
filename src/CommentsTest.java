import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommentsTest {

    public static void main(String[] args) {
        CommentsTest commentsTest = new CommentsTest();

        List<Comments> allComments = getComments();

        List<Comments> sortedCommentsDesc = commentsTest.getAllComments(allComments, Boolean.TRUE);
        sortedCommentsDesc.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        List<Comments> sortedCommentsAsc = commentsTest.getAllComments(allComments, Boolean.FALSE);
        sortedCommentsAsc.forEach(System.out::println);

    }

    private static List<Comments> getComments() {
        Comments comments1 = new Comments(1, "c1", LocalDate.of(2024, 2, 9));
        Comments comments2 = new Comments(1, "c1", LocalDate.of(2024, 4, 30));
        Comments comments3 = new Comments(1, "c1", LocalDate.of(2024, 6, 14));
        Comments comments4 = new Comments(1, "c1", LocalDate.of(2024, 1, 23));
        Comments comments5 = new Comments(1, "c1", LocalDate.of(2024, 3, 21));
        Comments comments6 = new Comments(1, "c1", LocalDate.of(2024, 11, 6));

        return Arrays.asList(comments1, comments2, comments3, comments4, comments5, comments6);
    }

    private List<Comments> getAllComments(List<Comments> allComments, Boolean isDescending) {
        List<Comments> allCommentsSorted = sortByDescending(allComments);
        if(!isDescending) {
            Collections.reverse(allCommentsSorted);
        }
        return allCommentsSorted;
    }

    List<Comments> sortByDescending(List<Comments> allComments) {
        Comparator<Comments> commentsComparator = Comparator.comparing(Comments::getDate).thenComparing(Comments::getId);
        allComments.sort(commentsComparator);
//        Collections.sort(allComments, commentsComparator); // same as above
        return allComments;
    }
}
