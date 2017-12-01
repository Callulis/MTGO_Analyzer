import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EV_Calc_Interface {
    private JSlider slider1;
    private JPanel main_panel;
    private JLabel Win_Rate_Label;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel two_man_EV;
    private JLabel comp_draft_ev;
    private JLabel inter_draft_ev;
    private JLabel friendly_draft_ev;
    private JLabel constructed_league_ev;
    private JLabel pptq_limited_ev;
    private JLabel pptq_constructed_ev;

    public EV_Calc_Interface(){

        JFrame guiFrame = new JFrame();

        guiFrame.setTitle("Cards Probability Calculator");

        guiFrame.add(main_panel);
        guiFrame.setLocationByPlatform(true);
        guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        guiFrame.pack();
        guiFrame.setVisible(true);

        Win_Rate_Label.setText(String.valueOf(slider1.getValue()));

        slider1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                Win_Rate_Label.setText(String.valueOf(slider1.getValue()));
            }
        });
        slider1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Win_Rate_Label.setText(String.valueOf(slider1.getValue()));
            }
        });
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Win_Rate_Label.setText(String.valueOf(slider1.getValue()));
            }
        });
    }

    public static void main(String[] args) {
        EV_Calc_Interface a = new EV_Calc_Interface();

    }
}
