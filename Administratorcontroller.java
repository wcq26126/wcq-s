import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Administratorcontroller {

  private Administratormodel student;
  private JTextArea displayArea;

  public Administratorcontroller(Administratormodel student) {
      this.student = student;
  }

  public void setDisplayArea(JTextArea displayArea) {
      this.displayArea = displayArea;
  }
  public void addData(String module, String skill, String scoreText, String achievement, String responsibility) {
	    student.addModule(module);
	    student.addSkill(skill);
	    student.addScore(scoreText);
	    student.addAchievement(achievement);
	    student.addResponsibility(responsibility);
	    updateDisplay();
	}

	private void updateDisplay() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(student.getModules());
	    sb.append(student.getSkills());
	    sb.append(student.getScores());
	    sb.append(student.getAchievements());
	    sb.append(student.getResponsibilities());
	    displayArea.setText(sb.toString());
	}

	public void exportData() {
	    student.exportData();
	}

	public void importData() {
	    student.importData();
	    updateDisplay();
	}
	}