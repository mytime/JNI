package com.hello.javapassc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	public JNI jni;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		jni = new JNI();

	}

	// 传递数字
	public void click(View v) {
		Toast.makeText(getApplicationContext(), jni.add(3, 4) + "", 0).show();
	}

	// 传递字符创
	public void passstring(View v) {
		Toast.makeText(getApplicationContext(), jni.sayHelloC("abcd"), 0)
				.show();
	}

	// 传递数组
	public void passsIntArray(View v) {
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		jni.arrElementsIncrease(array);
		for (int i : array) {
			Log.d("i", i+"");
		}

	}

}
