package com.creativedroids.link;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.creativedroids.link.utils.DataHandler;
import com.creativedroids.link.utils.PrefClass;

import java.util.Random;

public class MoreScreen extends Activity implements OnClickListener {

	private final Context context = this;
	private final Random rand = new Random();
	private final int[] draw = new int[]{R.drawable.pressed_roundrect_five, R.drawable.pressed_roundrect_six, R.drawable.pressed_roundrect_seven,
			R.drawable.pressed_roundrect_eight, R.drawable.pressed_roundrect_nine, R.drawable.pressed_roundrect_ten, R.drawable.pressed_roundrect_eleven,
			R.drawable.pressed_roundrect_twelve, R.drawable.pressed_roundrect_thirteen, R.drawable.pressed_roundrect_fourteen};
	private Button bhelp, bsound, btags;
	private LinearLayout llmoretitile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.morescreen);

		PrefClass p1 = new PrefClass(context);

		bhelp = findViewById(R.id.bhelp);
		bsound = findViewById(R.id.bsound);
		btags = findViewById(R.id.btags);

		llmoretitile = findViewById(R.id.llmoretitle);

		bhelp.setTypeface(DataHandler.getTypeface(context));
		bsound.setTypeface(DataHandler.getTypeface(context));
		btags.setTypeface(DataHandler.getTypeface(context));

		bhelp.setOnClickListener(this);
		bsound.setOnClickListener(this);
		btags.setOnClickListener(this);

		setSound();
		((TextView) findViewById(R.id.tvheading)).setTypeface(DataHandler.getTypeface(context));

		llmoretitile.setBackgroundResource(draw[rand.nextInt(10)]);

	}

	private void setSound() {
		if (PrefClass.getSound())
			bsound.setText(getResources().getString(R.string.sound) + " " + getResources().getString(R.string.on));
		else
			bsound.setText(getResources().getString(R.string.sound) + " " + getResources().getString(R.string.off));
	}

	private void toggleSound() {
		PrefClass.setSound(!PrefClass.getSound());
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
			case R.id.bsound:
				toggleSound();
				setSound();
				break;
			case R.id.bhelp:
				startActivity(new Intent(context, HelpActivity.class));
				break;
			case R.id.btags:
				startActivity(new Intent(context, TagsScreen.class));
				break;
		}
	}

}
