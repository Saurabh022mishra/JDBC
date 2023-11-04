import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyClockFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel1;
    JLabel dayLabel1;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyClockFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        timeLabel1= new JLabel();
        timeLabel1.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel1.setForeground(new Color(0x00FF00));
        timeLabel1.setBackground(Color.black);
        timeLabel1.setOpaque(true);

        dateLabel = new JLabel();
        dayLabel1.setFont(new Font("Ink Free",Font.PLAIN,25));

        this.add(timeLabel1);
        this.add(dayLabel1);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel1.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel1.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try{
                Thread.sleep(1000);
            }catch (Exception e){
                //TODO Auto.generated catch block
                e.printStackTrace();
            }
        }
    }
}
