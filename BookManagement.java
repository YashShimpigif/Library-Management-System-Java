import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookManagement extends JFrame {

    public BookManagement() {
        setTitle("Book Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JTextField titleField = new JTextField(15);
        final JTextField authorField = new JTextField(15);
        final JTextField qtyField = new JTextField(5);

        JButton addBtn = new JButton("Add Book");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = LibraryDB.connect();
                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO books(title, author, quantity) VALUES (?, ?, ?)");
                    ps.setString(1, titleField.getText());
                    ps.setString(2, authorField.getText());
                    ps.setInt(3, Integer.parseInt(qtyField.getText()));
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Book Added Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Title"));
        panel.add(titleField);
        panel.add(new JLabel("Author"));
        panel.add(authorField);
        panel.add(new JLabel("Quantity"));
        panel.add(qtyField);
        panel.add(addBtn);

        add(panel);
        setVisible(true);
    }
}
