package com.example.tz_demo_8_11;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	private FrameLayout frameLayout;
	private SplashView splashView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		// 帧布局
		frameLayout = new FrameLayout(this);
		// 先添加ContentView
		ContentView contentView=new ContentView(this);
		frameLayout.addView(contentView);
		// 再添加SplashView
		splashView = new SplashView(this);
		frameLayout.addView(splashView);
		setContentView(frameLayout);
		// 开启Splash动画 --- 模拟后台加载数据
		startLoad();
	}

	private Handler handler=new Handler();
	private void startLoad() {
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// 数据加载完毕执行后面的动画 -- 让ContentView显示
				splashView.splashAndDisapper();
			}
		}, 3000);
	}
}
