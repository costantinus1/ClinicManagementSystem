package clinic.ui;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    
    private JTextField staffIdField;
    private JButton loginButton;

    public LoginScreen() {
        setTitle("SafeScan v1.0 - Staff Authorization");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        getContentPane().setBackground(new Color(85, 107, 47)); // Dark Khaki
        setLayout(new GridBagLayout());

        buildLoginUI();
        
        // This is the "Magic Trick" to make hitting ENTER work!
        this.getRootPane().setDefaultButton(loginButton);
        
        setVisible(true);
    }

    private void buildLoginUI() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("STAFF LOGIN", SwingConstants.CENTER);
        title.setForeground(new Color(189, 183, 107)); // Light Khaki
        title.setFont(new Font("Monospaced", Font.BOLD, 22));
        gbc.gridy = 0;
        add(title, gbc);

        JLabel label = new JLabel("Enter Staff ID Number:");
        label.setForeground(Color.WHITE);
        gbc.gridy = 1;
        add(label, gbc);

        staffIdField = new JTextField(15);
        gbc.gridy = 2;
        add(staffIdField, gbc);

        loginButton = new JButton("ACCESS SYSTEM");
        loginButton.setBackground(new Color(189, 183, 107));
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridy = 3;
        
        // This is the logic that opens your MRI Checklist
        loginButton.addActionListener(e -> {
            String enteredID = staffIdField.getText();
            // Let's create a "Master Key" for your demo
            if (enteredID.equals("ADMIN")) {
                new MriSafetyScreener(); 
                dispose();               
                System.out.println("🔓 Access Granted: Staff authorized.");
            } else {
                // This is the "False Pass" handling
                JOptionPane.showMessageDialog(this, 
                    "INVALID STAFF ID: Access Denied.", 
                    "Security Alert", 
                    JOptionPane.ERROR_MESSAGE);
                System.out.println("🔒 Access Denied: Unauthorized attempt.");
            }
        });

        add(loginButton, gbc);
    }

    public static void main(String[] args) {
        // ALWAYS run the project from here!
        SwingUtilities.invokeLater(() -> new LoginScreen());
    }
}