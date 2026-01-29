import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Library Management System");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton bookBtn = new JButton("Book Management");
        JButton issueBtn = new JButton("Issue / Return");

        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookManagement();
            }
        });

        issueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IssueReturn();
            }
        });

        JPanel panel = new JPanel();
        panel.add(bookBtn);
        panel.add(issueBtn);

        add(panel);
        setVisible(true);
    }
}
