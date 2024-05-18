package devoss.hdstep.desktop.gui.menu.listeners.help;

import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutHelpMenuItemActionListener implements ActionListener {
    private final HDStepFrame frame;

    public AboutHelpMenuItemActionListener(HDStepFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JWindow window = new JWindow(this.frame);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.blue));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JTextArea textArea = new JTextArea();
        textArea.append("Programm zum Ertellen von elektonischen Schaltungen");
        textArea.setEnabled(false);
        textArea.setLineWrap(true);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(textArea);
        JLabel label = new JLabel("E-Mail: vt7970170@gmail.com");
        panel.add(label);


        window.setSize(new Dimension(400, 200));
        Button button = new Button("OK");
        button.setSize(new Dimension(100, 100));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
            }
        });
        panel.add(button);
        window.add(panel);
        window.setLocation(100, 100);
        window.setVisible(true);
    }
}
