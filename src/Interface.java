import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton OKButton;
    private JLabel exact;
    private JLabel at_least;
    private JPanel main_panel;
    private JLabel N;
    private JLabel K;
    private JLabel n;
    private JLabel k;
    private JLabel exact_label;
    private JLabel at_least_label;
    private JPanel warning;

    public Interface() {
        JFrame guiFrame = new JFrame();

        guiFrame.setTitle("Cards Probability Calculator");

        guiFrame.add(main_panel);
        guiFrame.setLocationByPlatform(true);
        guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        guiFrame.pack();
        guiFrame.setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int N_val = 0;
                int K_val = 0;
                int n_val = 0;
                int k_val = 0;
                try {
                     N_val = Integer.parseInt(textField1.getText());
                     K_val = Integer.parseInt(textField2.getText());
                     n_val = Integer.parseInt(textField3.getText());
                     k_val = Integer.parseInt(textField4.getText());

                    exact_label.setText("Chances of drawing exactly " + k_val);
                    at_least_label.setText("Chances of drawing at least " + k_val);

                    exact.setText(String.valueOf(Probability_Distributions.hypergeometric_dist(N_val, K_val, n_val, k_val)));
                    at_least.setText(String.valueOf(Probability_Distributions.hypergeometric_dist_at_least(N_val, K_val, n_val, k_val)));
                }
                catch(NumberFormatException a){
                    JOptionPane.showMessageDialog(warning, "Please enter valid integers!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }

    public static void main(String[] args) {
        Interface a = new Interface();
    }
}
