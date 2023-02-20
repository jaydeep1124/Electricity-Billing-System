package electricity.billing.system;

import javax.swing.ImageIcon;
import  javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.*;;

public class MainFrame extends JFrame implements Runnable {
Thread t;
    public void init(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 550, 0);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setTitle("UGVCL");
        setVisible(true);

        int x = 1;
        for(int i=2; i<600;i+=4,x+=1){
            setLocation(x+350,x);
            setSize(700-(x/2), (i));
            try {
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        t= new Thread(this);
        t.start();
            
        
    
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }    

    public void run() {
        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}