package utilerias;

import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.JPanel;

/**
 * a
 *
 * @hidden
 */
public class DateTimePickerPanel extends JPanel {

    private DateTimePicker dateTimePicker;

    public DateTimePickerPanel() {
        dateTimePicker = new DateTimePicker();
        this.add(dateTimePicker);
    }

    public DateTimePicker getDateTimePicker() {
        return dateTimePicker;
    }
}
