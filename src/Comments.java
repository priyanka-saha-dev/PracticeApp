import java.time.LocalDate;
import java.util.Comparator;

public class Comments {
//        implements Comparable<Comments>{

    private Integer id;
    private String comment;
    private LocalDate date;

    public Comments(Integer id, String comment, LocalDate date) {
        this.id = id;
        this.comment = comment;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }

//    @Override
//    public int compareTo(Comments o) {
//
//        int idComp = this.id.compareTo(o.getId());
//        if(idComp != 0) {
//            return idComp;
//        } else {
//            return this.comment.compareTo(o.getComment());
//        }
//
//    }
}
