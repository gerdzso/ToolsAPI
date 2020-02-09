package woody_tool_gripper;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.robot.toolsapi.ToolsAPI;

public class Woody_Tool_Gripper  implements ToolsAPI{

	private JPanel mainPanel;
	private JSlider slider;
	
	public Woody_Tool_Gripper() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		mainPanel.add(new JLabel("close"));
		slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
		mainPanel.add(slider);
		mainPanel.add(new JLabel("open"));
	}
	
	@Override
	public int getSignal() {
		return slider.getValue();
	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}

	@Override
	public void setSignal(int signal) {
		slider.setValue(signal);
	}

	@Override
	public int showOptionDialog(int initValue) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(new JLabel("close"));
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
		if (initValue > -1) {
			slider.setValue(initValue);
		}
		panel.add(slider);
		panel.add(new JLabel("open"));
		int result = JOptionPane.showOptionDialog(null, panel, "Set up gripper",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, null, null);
		if (result == JOptionPane.YES_OPTION){
            return slider.getValue();
        }
		
		return -1;
		
	}

}
