import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class SearchFieldController extends FocusAdapter {
    private JTextField searchField;
    private String placeholderText;
    private Color placeholderColor;
    private Color activeColor;
    
    public SearchFieldController(JTextField searchField, String placeholderText, 
                                 Color placeholderColor, Color activeColor) {
        this.searchField = searchField;
        this.placeholderText = placeholderText;
        this.placeholderColor = placeholderColor;
        this.activeColor = activeColor;
        
        // Initialiser le champ avec le texte d'espace réservé
        this.searchField.setText(placeholderText);
        this.searchField.setForeground(placeholderColor);
    }
    
    public void focusGained(FocusEvent e) {
        if (searchField.getText().equals(placeholderText)) {
            searchField.setText("");
            searchField.setForeground(activeColor);
        }
    }
 
    public void focusLost(FocusEvent e) {
        if (searchField.getText().isEmpty()) {
            searchField.setText(placeholderText);
            searchField.setForeground(placeholderColor);
        }
    }
}