import java.util.ArrayList;
import java.time.LocalDate;

/**
 * This class stores information about a post in a social network news feed.
 * The main part of the post consists of a photo and a caption.
 * Other data, such as author and time, are also stored.
 * 
 * @author Sara Rydell
 */

public class EventPost extends Post
{
    // Additional fields for EventPost
    private String title;       // event title
    private String location;    // location of event
    private LocalDate date;     // date of event

    /**
     * Constructor for objects of class EventPost. taken from PhotoPost code
     * 
     * @param author    The username of the author of this post.
     * @param title     The title of the event of this post.
     * @param location  The location of the eventof this post.
     * @param date      The date of the event of this post.
     */
    public EventPost(String author, String title, String location, LocalDate date)
    {
        super(author);
        this.title = title;
        this.location = location;
        this.date = date;
    }

    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
        System.out.println("  " + title);
        System.out.println("  " + location + "  " + date);
        System.out.println("*********************");
        //super.display();
    }
}
