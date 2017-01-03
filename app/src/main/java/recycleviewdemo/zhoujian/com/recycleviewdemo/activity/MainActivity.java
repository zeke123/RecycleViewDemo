package recycleviewdemo.zhoujian.com.recycleviewdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import recycleviewdemo.zhoujian.com.recycleviewdemo.R;
import recycleviewdemo.zhoujian.com.recycleviewdemo.adapter.MainAdapter;
import recycleviewdemo.zhoujian.com.recycleviewdemo.adapter.MainAdapter.OnItemClickLitener;
import recycleviewdemo.zhoujian.com.recycleviewdemo.bean.Person;
import recycleviewdemo.zhoujian.com.recycleviewdemo.view.DividerGridItemDecoration;
import recycleviewdemo.zhoujian.com.recycleviewdemo.view.DividerItemDecoration;

public class MainActivity extends Activity
{

	private RecyclerView mRecyclerView;
	private ArrayList<Person> personList;
	private MainAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		//initListView();
		initGridView();
		initEvent();

	}

	private void initGridView()
	{

		mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
		mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
		// 设置item动画
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.setAdapter(mAdapter);

	}

	private void initListView()
	{
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
		// 设置item动画
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.setAdapter(mAdapter);


	}

	private void initView() {


		TextView tv_start= (TextView) findViewById(R.id.tv_start);

		tv_start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this,WaterFallActivity.class));
			}
		});

		mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
		mAdapter = new MainAdapter(this, personList);


	}

	private void initEvent()
	{
		mAdapter.setOnItemClickLitener(new OnItemClickLitener()
		{
			@Override
			public void onItemClick(View view, int position)
			{
				Toast.makeText(MainActivity.this, personList.get(position).getName(),Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onItemLongClick(View view, int position)
			{
				Toast.makeText(MainActivity.this, personList.get(position).getName(),Toast.LENGTH_SHORT).show();
			}
		});
	}

	protected void initData()
	{
		personList = new ArrayList<Person>();
		Person mPerson0= new Person("宋江");
		personList.add(mPerson0);
		Person mPerson1= new Person("卢俊义");
		personList.add(mPerson1);
		Person mPerson2= new Person("吴用");
		personList.add(mPerson2);
		Person mPerson3= new Person("公孙胜");
		personList.add(mPerson3);
		Person mPerson4= new Person("关胜");
		personList.add(mPerson4);
		Person mPerson5= new Person("林冲");
		personList.add(mPerson5);
		Person mPerson6= new Person("秦明");
		personList.add(mPerson6);
		Person mPerson7= new Person("呼延灼");
		personList.add(mPerson7);
		Person mPerson8= new Person("花荣");
		personList.add(mPerson8);
		Person mPerson9= new Person("柴进");
		personList.add(mPerson9);
		Person mPerson10= new Person("李应");
		personList.add(mPerson10);
		Person mPerson11= new Person("鲁智深");
		personList.add(mPerson11);
	}
}
