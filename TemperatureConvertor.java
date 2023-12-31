import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * this class is the child of Convertor and converts temperatures
 * 
 * @version 1.0.0
 * @since 1.0.0
 * @see Convertor
 * 
 * @autor JuanObandoDev
 */
public class TemperatureConvertor extends Convertor {
    private String destinyTemperature;
    private static final Map<String, Double> TEMPERATURES = new HashMap<String, Double>();

    /**
     * This constructor set the temperature units and calls the method
     * setDestinyTemperature()
     * 
     * @see #setDestinyTemperature()
     */
    public TemperatureConvertor() {
        super();
        TEMPERATURES.put("Fahrenheit", 0.0);
        TEMPERATURES.put("Kelvin", 0.0);
        this.destinyTemperature = setDestinyTemperature();
    }

    /**
     * This method sets the destiny temperature unit
     * 
     * @return separateSelection(selected)
     * @see #separateSelection(String selected)
     */
    public String setDestinyTemperature() {
        String[] options = generateTemperatureOptions();
        String selected = (String) JOptionPane.showInputDialog(
                null,
                "Select a temperature",
                "Temperature converter",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                "None");
        return super.separateSelection(selected);
    }

    /**
     * This method generates the options for the temperature convertor
     * 
     * @return options
     */
    public String[] generateTemperatureOptions() {
        String[] options = new String[TEMPERATURES.size() * 2];
        int j = 0;
        for (int i = 0; i < options.length; i++) {
            if (i < 2) {
                options[i] = "Celsius to " + TEMPERATURES.keySet().toArray()[i];
            } else {
                options[i] = TEMPERATURES.keySet().toArray()[j] + " to Celsius";
                j++;
            }
        }
        return options;
    }

    /**
     * This method shows the result of the convertion
     * 
     * @see Convertor#getValueToConvert()
     */
    public void showResult() {
        String result = "";
        switch (super.getOrigin()) {
            case "Celsius":
                if (this.destinyTemperature.equals("Fahrenheit")) {
                    result = super.getValueToConvert() + "C° = "
                            + String.format("%.2f", (super.getValueToConvert() * 1.8) + 32) + "F°";
                } else {
                    result = super.getValueToConvert() + "C° = "
                            + String.format("%.2f", (super.getValueToConvert() + 273.15)) + "K°";
                }
                break;
            case "Fahrenheit":
                result = super.getValueToConvert() + "F° = "
                        + String.format("%.2f", ((super.getValueToConvert() - 32) / 1.8)) + "C°";
                break;
            case "Kelvin":
                result = super.getValueToConvert() + "K° = "
                        + String.format("%.2f", (super.getValueToConvert() - 273.15)) + "C°";
                break;
        }
        JOptionPane.showMessageDialog(
                null,
                result);
    }
}
