package leetcode;

import java.security.cert.CertificateNotYetValidException;
import java.util.ArrayList;
import java.util.List;

/**
 * You are implementing a program to use as your calendar. We can add a new event if adding the
 * event will not cause a double booking.
 *
 * <p>A double booking happens when two events have some non-empty intersection (i.e., some moment
 * is common to both events.).
 *
 * <p>The event can be represented as a pair of integers start and end that represents a booking on
 * the half-open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 * <p>Implement the MyCalendar class:
 *
 * <p>MyCalendar() Initializes the calendar object. boolean book(int start, int end) Returns true if
 * the event can be added to the calendar successfully without causing a double booking. Otherwise,
 * return false and do not add the event to the calendar.
 *
 * <p>Example 1:
 *
 * <p>Input ["MyCalendar", "book", "book", "book"] [[], [10, 20], [15, 25], [20, 30]] Output [null,
 * true, false, true]
 *
 * <p>Explanation MyCalendar myCalendar = new MyCalendar(); myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked
 * by another event. myCalendar.book(20, 30); // return True, The event can be booked, as the first
 * event takes every time less than 20, but not including 20.
 *
 * <p>Constraints:
 *
 * <p>0 <= start < end <= 10^9 At most 1000 calls will be made to book.
 */
public class MyCalenddarI729 {

  public static void main(String[] args) {
    var calendar = new MyCalendar();
    System.out.println(calendar.book(10,20));
      System.out.println(calendar.book(15,25));
      System.out.println(calendar.book(20,30));
  }
}

class MyCalendar {

    private List<List<Integer>> events;

    public MyCalendar() {
        this.events = new ArrayList<>(1000);
    }

    public boolean book(int start, int end) {

        var optional = events.stream()
                .filter(event -> checkInterval(event.get(0), start, end) || checkInterval(event.get(1), start,end )
                        || checkInterval(start, event.get(0), event.get(1)) || checkInterval(end-1, event.get(0), event.get(1)))
                .findFirst();

        if (!optional.isPresent()) {
            this.events.add(List.of(start, end-1));
        }
        return !optional.isPresent();
    }


    private boolean checkInterval(int num, int start, int end) {
        return start <= num && num < end;
    }
}