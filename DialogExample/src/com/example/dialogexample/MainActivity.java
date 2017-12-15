package com.example.dialogexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	//普通对话框
	public void click1(View v){
		//通过builder构建器
		AlertDialog.Builder builder = new Builder(this);//一定要用this
		builder.setTitle("警告");
		builder.setMessage("世界上最遥远的距离是没有网络");
		builder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				System.out.println("点击了确定按钮");
			}
		});
		builder.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				System.out.println("点击了取消按钮");
			}
		});
		
		//~~@!!@!~@~!@~!@!~@~
		builder.show();
	}
	
	//单选对话框
	public void click2(View v){
		//通过builder构建器
		AlertDialog.Builder builder = new Builder(this);//一定要用this
		builder.setTitle("请选择。。。。");
		final String[] a = {"1","2","3"};
		builder.setSingleChoiceItems(a,-1 , new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//取出条目
				String aa = a[which];
				Toast.makeText(getApplicationContext(), aa, 1).show();
				
				dialog.dismiss();//关闭
				
			}
		});//-1表示没有条目被选中
		
		//~~@!!@!~@~!@~!@!~@~
		builder.show();
	}
	
	//多选对话框
	public void click3(View v){
		//通过builder构建器
		AlertDialog.Builder builder = new Builder(this);//一定要用this
		builder.setTitle("请选择。。。。");
		final String[] a = {"1","2","3"};
		boolean[] b = {true,false,false};
		builder.setMultiChoiceItems(a,b, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				
			}
		} );
			
		builder.setPositiveButton("ok", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		
		//~~@!!@!~@~!@~!@!~@~
		builder.show();
	}
	
	//进度条对话框
	public void click4(View v){
		final  ProgressDialog dialog = new ProgressDialog(this);
		dialog.setTitle("玩命加载中......");
		//设置样式
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		
		dialog.show();
		
		new Thread(){public void run() {
			dialog.setMax(100);
			
			for (int i = 0; i < 100; i++) {
				
				dialog.setProgress(i);
				//Thread.sleep(time);
				SystemClock.sleep(50);
			}
			dialog.dismiss();
		};}.start();
	}
}
