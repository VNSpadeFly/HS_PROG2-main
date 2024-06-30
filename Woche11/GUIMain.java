import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MGui {
  // die Referenzen auf die zu erzeugenden Bedienelemente
  JFrame frame;
  JPanel panel;
  JButton endButton;
  JButton backButton;
  JButton calcButton;
  JSlider maxIterations;
  JLabel view;
  
  MGui() {
    // Erstellen des Rahmens
    frame = new JFrame("Mandelbrotmenge");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Erstellen des Panels
    panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);

    // Rahmen sichtbar machen
    frame.setVisible(true);
  }

  private void placeComponents(JPanel panel) {
    panel.setLayout(null);

    // Erstellen des "Rechnen"-Buttons
    calcButton = new JButton("Rechnen");
    calcButton.setBounds(10, 20, 100, 25);
    panel.add(calcButton);
    calcButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Rechnen");
      }
    });

    // Erstellen des "Zurueck"-Buttons
    backButton = new JButton("Zurueck");
    backButton.setBounds(10, 60, 100, 25);
    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Zurueck");
      }
    });

    // Erstellen des "Ende"-Buttons
    endButton = new JButton("Ende");
    endButton.setBounds(10, 100, 100, 25);
    panel.add(endButton);
    endButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Ende");
        System.exit(0);
      }
    });

    // Erstellen des Labels
    view = new JLabel("Platzhalter");
    view.setBounds(150, 20, 300, 25);
    panel.add(view);

    // Erstellen des Sliders
    maxIterations = new JSlider(0, 30);
    maxIterations.setBounds(150, 60, 300, 50);
    panel.add(maxIterations);
    maxIterations.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        System.out.println("Neuer Wert: " + maxIterations.getValue());
      }
    });
  }
}

public class GuiMain {
  public static void main(String[] args) {
    MGui m = new MGui();
  }
}
