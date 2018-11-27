package JSliders;

import java.awt.Color;
import PR_TimeLifeApp.TimeLifeApp;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.plaf.metal.MetalSliderUI;

public class LinhaDoTempo extends JSlider{
		
	public LinhaDoTempo() {
				
		new JSlider();
		setValue(0);
		setUI(new MetalSliderUI() {
			protected void scrollDueToClickInTrack(int direction) {
				int value = getValue();
				if (getOrientation() == JSlider.HORIZONTAL) {
					value = this.valueForXPosition(getMousePosition().x);
				} else if (getOrientation() == JSlider.VERTICAL) {
					value = this.valueForYPosition(getMousePosition().y);
				}
				setValue(value);
			}
		});
		
		setBackground(new Color(27,27,27));
		
		addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				if (Math.abs(getValue() - TimeLifeApp._playercontrol.tempo) > 10) {
					try {
						TimeLifeApp._playercontrol.Play(getValue());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
	}
}
