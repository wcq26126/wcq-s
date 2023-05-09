import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Administratormodel {
    private ArrayList<String> modules;
    private ArrayList<String> skills;
    private ArrayList<Double> scores;
    private ArrayList<String> achievements;
    private ArrayList<String> responsibilities;

    public void Student() {
        modules = new ArrayList<>();
        skills = new ArrayList<>();
        scores = new ArrayList<>();
        achievements = new ArrayList<>();
        responsibilities = new ArrayList<>();
    }

    public void addModule(String module) {
        if (!module.isEmpty()) {
            modules.add(module);
        }
    }

    public void addSkill(String skill) {
        if (!skill.isEmpty()) {
            skills.add(skill);
        }
    }

    public void addScore(String scoreText) {
        if (!scoreText.isEmpty()) {
            try {
                double score = Double.parseDouble(scoreText);
                scores.add(score);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Score input is invalid, please enter a number.");
            }
        }
    }

    public void addAchievement(String achievement) {
        if (!achievement.isEmpty()) {
            achievements.add(achievement);
        }
    }

    public void addResponsibility(String responsibility) {
        if (!responsibility.isEmpty()) {
            responsibilities.add(responsibility);
        }
    }

    public String getModules() {
        StringBuilder sb = new StringBuilder();
        sb.append("model:\n");
        for (String module : modules) {
            sb.append(module).append("\t");
        }
        return sb.toString();
    }

    public String getSkills() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nskill:\n");
        for (String skill : skills) {
            sb.append(skill).append("\t");
        }
        return sb.toString();
    }

    public String getScores() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nscore:\n");
        double sum = 0;
        for (Double score : scores) {
            sb.append(score).append("\t");
            sum += score;
        }
        if (!scores.isEmpty()) {
            sb.append("\n\n\nGPA\n").append(sum / scores.size());
        }
        return sb.toString();
    }

    public String getAchievements() {
      StringBuilder sb = new StringBuilder();
      sb.append("\n\n\nachievement:\n");
      for (String achievement : achievements) {
          sb.append(achievement).append("\t");
      }
      return sb.toString();
  }

  public String getResponsibilities() {
      StringBuilder sb = new StringBuilder();
      sb.append("\n\nresponsibility\n");
      for (String responsibility : responsibilities) {
          sb.append(responsibility).append("\t");
      }
      return sb.toString();
  }

  public void exportData() {
      try {
          Files.write(Paths.get("modules.txt"), modules, StandardCharsets.UTF_8);
          Files.write(Paths.get("skills.txt"), skills, StandardCharsets.UTF_8);
          Files.write(Paths.get("scores.txt"), scores.stream().map(String::valueOf).collect(Collectors.toList()), StandardCharsets.UTF_8);
          Files.write(Paths.get("achievements.txt"), achievements, StandardCharsets.UTF_8);
          Files.write(Paths.get("responsibilities.txt"), responsibilities, StandardCharsets.UTF_8);
                  JOptionPane.showMessageDialog(null, "Data exported");
      } catch (IOException e) {
          JOptionPane.showMessageDialog(null, "An error occurred while exporting data");
      }
  }

  public void importData() {
      try {
          modules = new ArrayList<>(Files.readAllLines(Paths.get("modules.txt"), StandardCharsets.UTF_8));
          skills = new ArrayList<>(Files.readAllLines(Paths.get("skills.txt"), StandardCharsets.UTF_8));
          scores = Files.readAllLines(Paths.get("scores.txt"), StandardCharsets.UTF_8).stream().map(Double::valueOf).collect(Collectors.toCollection(ArrayList::new));
          achievements = new ArrayList<>(Files.readAllLines(Paths.get("achievements.txt"), StandardCharsets.UTF_8));
          responsibilities = new ArrayList<>(Files.readAllLines(Paths.get("responsibilities.txt"), StandardCharsets.UTF_8));

          JOptionPane.showMessageDialog(null, "Data has been imported");
      } catch (IOException e) {
          JOptionPane.showMessageDialog(null, "An error occurred importing data");
      }
  }
}