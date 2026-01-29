import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class IssueReturn extends JFrame {

    public IssueReturn() {
        setTitle("Issue / Return Book");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JTextField bookId = new JTextField(5);
        final JTextField userId = new JTextField(5);

        JButton issueBtn = new JButton("Issue Book");
        JButton returnBtn = new JButton("Return Book");

        issueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = LibraryDB.connect();
                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO issues(book_id, user_id, issue_date) VALUES (?, ?, ?)");
                    ps.setInt(1, Integer.parseInt(bookId.getText()));
                    ps.setInt(2, Integer.parseInt(userId.getText()));
                    ps.setString(3, new Date().toString());
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Book Issued Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dummy dates for demo
                Date issueDate = new Date(System.currentTimeMillis() - 10L * 24 * 60 * 60 * 1000);
                Date returnDate = new Date();

                int fine = FineCalculator.calculateFine(issueDate, returnDate);
                JOptionPane.showMessageDialog(null, "Book Returned\nFine: ?" + fine);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Book ID"));
        panel.add(bookId);
        panel.add(new JLabel("User ID"));
        panel.add(userId);
        panel.add(issueBtn);
        panel.add(returnBtn);

        add(panel);
        setVisible(true);
    }
}
