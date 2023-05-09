import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administratorview extends JPanel implements ActionListener {
  private StudentTrackerController controller;
  private JTextField moduleField;
  private JTextField skillsField;
  private JTextField scoreField;
  private JTextField achievementField;
  private JTextField responsibilityField;
  private JButton addButton;
  private JButton exportButton;
  private JButton exitButton;

  public Administratorview(StudentTrackerController controller) {
      this.controller = controller;
      setBorder(new EmptyBorder(8, 8, 8, 8));
      setLayout(new GridLayout(13, 1, 5, 5));

      add(new JLabel("model"));
      moduleField = new JTextField();
      add(moduleField);

      add(new JLabel("skill"));
      skillsField = new JTextField();
      add(skillsField);

      add(new JLabel("score"));
      scoreField = new JTextField();
      add(scoreField);

      add(new JLabel("achievement"));
      achievementField = new JTextField();
      add(achievementField);

      add(new JLabel("responsiblity"));
      responsibilityField = new JTextField();
      add(responsibilityField);

      addButton = new JButton("add");
      addButton.setIcon(new ImageIcon("resources/add.png"));
      add(addButton);
      addButton.addActionListener(this);

      exportButton = new JButton("export");
      exportButton.setIcon(new ImageIcon("resources/export.png"));
      add(exportButton);
      exportButton.addActionListener(this);

      exitButton = new JButton("Log out");
      //exitButton.setIcon(new ImageIcon("resources/exit.png"));
      add(exitButton);
      exitButton.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == addButton) {
          controller.addData(
                  moduleField.getText().trim(),
                  skillsField.getText().trim(),
                  scoreField.getText().trim(),
                  achievementField.getText().trim(),
                  responsibilityField.getText().trim()
          );
          moduleField.setText("");
          skillsField.setText("");
          scoreField.setText("");
          achievementField.setText("");
          responsibilityField.setText("");
      } else if (e.getSource() == exportButton) {
          controller.exportData();
      } else if (e.getSource() == exitButton) {
          denglu a=new denglu();
          a.denglu();
          setVisible(false);
          System.exit(0);
      }
  }
}