package View.User;

import Controler.LogoutController; // Dodajte potrebne importe

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBarPanelLoggedIn extends ToolBarPanelUser {

    public ToolBarPanelLoggedIn(UserFrame userFrame) {
        super(userFrame);
    }

    @Override
    public void initToolBar() {
        super.initToolBar(); // Pozivamo initToolBar() iz ToolBarPanelUser-a

        // Uklanjamo dugme za login
        JPanel optionsPanel = (JPanel) getComponent(0); // Pretpostavka: optionsPanel je prvi dodat panel

        Component[] components = optionsPanel.getComponents();
        for (Component comp : components) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (button.getText().equals("Login")) {
                    optionsPanel.remove(button);
                    break;
                }
            }
        }

        // Dodajemo dugme za logout
        JButton logout = createStyledButton("Logout");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 11; // Podešavanje položaja dugmeta za logout, na mestu gde je bio login
        logout.addActionListener(e -> {
            // Implementacija odjavljivanja
            new LogoutController(userFrame.getAcountService()).setVisible(true); // Pretpostavljeno
        });
        optionsPanel.add(logout, c);

    }
}
