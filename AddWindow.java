package L5_GUI.view;

import L5_GUI.data.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;

public class AddWindow extends JFrame {
    private JPanel panelKindOfEdition;
    private JComboBox comboBox;
    private JLabel kindOfEdition;
    private JPanel jPanel;
    private JTextField textFieldTitle;
    private JTextField textFieldAuthor;
    private JTextField textFieldYear;
    private JTextField textFieldNum;
    private JTextField textFieldGenreOrIssueNum;
    private JTextField textFieldStudyArea;

    private JLabel labelTitle;
    private JLabel labelAuthor;
    private JLabel labelYear;
    private JLabel labelNum;
    private JLabel labelGenreOrIssueNum;
    private JLabel labelStudyArea;

    private JPanel panelButtons;
    private JButton addButton;
    private JButton cancelButton;

    private Book book;
    private Textbook textBook;
    private Magazine magazine;

    public AddWindow(PublishingHouse publishingHouse){
        setTitle("Добавление");

        initComponents();
        addAndSetComponents();

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedIndex() == 0){
                    labelGenreOrIssueNum.setText("Жанр");

                }
                if (comboBox.getSelectedIndex() == 1){
                    labelGenreOrIssueNum.setText("Жанр");
                    textFieldGenreOrIssueNum.setText("Учебная литература");
                    textFieldGenreOrIssueNum.setEditable(false);
                    labelStudyArea.setVisible(true);
                    textFieldStudyArea.setVisible(true);
                    textFieldStudyArea.setEditable(true);
                    jPanel.repaint();
                }
                if (comboBox.getSelectedIndex() == 2) {
                    labelGenreOrIssueNum.setText("Номер выпуска");
                }
                if (comboBox.getSelectedIndex() != 1){
                    textFieldGenreOrIssueNum.setText("");
                    textFieldGenreOrIssueNum.setEditable(true);
                    labelStudyArea.setVisible(false);
                    textFieldStudyArea.setVisible(false);
                    textFieldStudyArea.setEditable(false);
                    jPanel.repaint();
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFromTextFieldTitle = textFieldTitle.getText();
                String textFromTextFieldAuthor = textFieldAuthor.getText();
                String textFromTextFieldYear = textFieldYear.getText();
                String textFromTextFieldNumOfPages = textFieldNum.getText();
                String textFromTextFieldDop = textFieldGenreOrIssueNum.getText();


                try {
                    String kindEdition = (String)comboBox.getSelectedItem();

                    if ("Книга".equals(kindEdition)) {
                        book = new Book(textFromTextFieldTitle, textFromTextFieldAuthor, Integer.parseInt(textFromTextFieldYear), Integer.parseInt(textFromTextFieldNumOfPages), textFromTextFieldDop);
                        publishingHouse.addEdition(book);
                    }
                    if ("Учебник".equals(kindEdition)) {
                        textBook = new Textbook(textFromTextFieldTitle, textFromTextFieldAuthor, Integer.parseInt(textFromTextFieldYear), Integer.parseInt(textFromTextFieldNumOfPages), textFromTextFieldDop);
                        publishingHouse.addEdition(textBook);
                    }
                    if ("Журнал".equals(kindEdition)) {
                        magazine = new Magazine(textFromTextFieldTitle, textFromTextFieldAuthor, Integer.parseInt(textFromTextFieldYear), Integer.parseInt(textFromTextFieldNumOfPages), Integer.parseInt(textFromTextFieldDop));
                        publishingHouse.addEdition(magazine);
                    }
                    JOptionPane.showMessageDialog(null, "Элемент успешно добавлен", "Добавление", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                catch (NumberFormatException ex){
                    JDialog dialog = new JDialog(AddWindow.this, "Добавление", true);
                    dialog.add(new JLabel("   Введите данные в правильном формате"));
                    dialog.setSize(200, 100);
                    dialog.setVisible(true);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


//        this.setAlwaysOnTop(true);
        this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addAndSetComponents() {
        add(panelKindOfEdition, BorderLayout.NORTH);
        panelKindOfEdition.setLayout(new BoxLayout(panelKindOfEdition, BoxLayout.Y_AXIS));
        panelKindOfEdition.setBorder(BorderFactory.createCompoundBorder());

        panelKindOfEdition.add(kindOfEdition);
        panelKindOfEdition.add(comboBox);

        add(jPanel, BorderLayout.CENTER);
        jPanel.setLayout(new GridLayout(7, 2));

        add(panelButtons, BorderLayout.SOUTH);
        panelButtons.add(addButton);
        panelButtons.add(cancelButton);
        jPanel.add(labelTitle);
        jPanel.add(textFieldTitle);
        jPanel.add(labelAuthor);
        jPanel.add(textFieldAuthor);
        jPanel.add(labelYear);
        jPanel.add(textFieldYear);
        jPanel.add(labelNum);
        jPanel.add(textFieldNum);
        jPanel.add(labelGenreOrIssueNum);
        jPanel.add(textFieldGenreOrIssueNum);
        jPanel.add(labelStudyArea);
        jPanel.add(textFieldStudyArea);
        labelStudyArea.setVisible(false);
        textFieldStudyArea.setVisible(false);
        textFieldStudyArea.setEditable(false);
    }

    private void initComponents() {
        panelKindOfEdition = new JPanel();

        kindOfEdition = new JLabel();
        kindOfEdition.setText("Вид издания: ");
        String[] kinds = {
                "Книга",
                "Учебник",
                "Журнал"
        };
        comboBox = new JComboBox(kinds);

        jPanel = new JPanel();

        textFieldTitle = new JTextField();
        textFieldAuthor = new JTextField();
        textFieldYear = new JTextField();
        textFieldNum = new JTextField();
        textFieldGenreOrIssueNum = new JTextField();
        textFieldStudyArea = new JTextField();

        labelTitle = new JLabel("Название");
        labelAuthor = new JLabel("Автор");
        labelYear = new JLabel("Год издания");
        labelNum = new JLabel("Количество страниц");
        labelGenreOrIssueNum = new JLabel("Жанр");
        labelStudyArea = new JLabel("Учебная область");

        panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1, 2));
        addButton = new JButton("Добавить");
        cancelButton = new JButton("Отмена");
    }
}
