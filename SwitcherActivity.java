package com.example.testscrorientation;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class SwitcherActivity extends Activity {
	private Button btnAdd, btnSub;
	private ImageSwitcher imageSwitcher;
	private int index = 0;
	private List<Drawable> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_image_switch);
		putData();
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		btnAdd = (Button) findViewById(R.id.btnadd);
		btnSub = (Button) findViewById(R.id.btnSub);
		btnAdd.setOnClickListener(myClick);
		btnSub.setOnClickListener(myClick);
		
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(SwitcherActivity.this, android.R.anim.slide_in_left));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(SwitcherActivity.this, android.R.anim.slide_out_right));
		imageSwitcher.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {
				return new ImageView(SwitcherActivity.this);
			}
		});
		imageSwitcher.setImageDrawable(list.get(0));
	}
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private View.OnClickListener myClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnadd:
				index--;
				if(index<0)
				{
					index=list.size()-1;
				}
				imageSwitcher.setImageDrawable(list.get(index));
				break;

			case R.id.btnSub:
				index++;
				if(index>=list.size()){
					index=0;
				}
				imageSwitcher.setImageDrawable(list.get(index));
				break;
			}
		}
	};

	private void putData() {
		list = new ArrayList<Drawable>();
		list.add(getResources().getDrawable(R.drawable.land_0));
		list.add(getResources().getDrawable(R.drawable.land_1));
        list.add(getResources().getDrawable(R.drawable.land_2));
        
        list.add(getResources().getDrawable(R.drawable.potrait_0));
        list.add(getResources().getDrawable(R.drawable.potrait_1));
        list.add(getResources().getDrawable(R.drawable.potrait_2));
	}
}
