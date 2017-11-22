package com.example.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity implements OnItemClickListener{

	private GridView gridView;
	private List<Map<String,Object>> datalist;
	private int[] icon = {R.drawable.youtube,R.drawable.weather,R.drawable.world,
			R.drawable.address_book,R.drawable.calendar,
			R.drawable.camera,R.drawable.clock,R.drawable.messenger,
			R.drawable.ringtone,R.drawable.settings,
			R.drawable.speech_balloon,R.drawable.games_control};
	private String [] iconName = {"视频","天气","浏览器","通讯录","日历","照相机","闹钟","短信","铃声","设置","语音","游戏"};
    private SimpleAdapter adapter;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gridView);
        //准备数据源
        //新建适配器
        //GridView 加载适配器
        //GridV配置事件监听器
        datalist= new ArrayList<Map<String,Object>>();
        
        adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"image","text"}, new int[]{R.id.imge,R.id.text});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }
	private List<Map<String,Object>> getData() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<icon.length;i++){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("image", icon[i]);
		map.put("text", iconName[i]);
		datalist.add(map);
		}
		Log.i("Main", "size="+datalist.size());
		return datalist;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "我是"+iconName[position], Toast.LENGTH_SHORT).show();
		
		
	}

}
