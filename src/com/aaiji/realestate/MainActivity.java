package com.aaiji.realestate;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aaiji.adapter.MenuListAdapter;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {

	ActionBar bar;
	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
	MenuListAdapter mMenuAdapter;
	String[] title;
	String[] subtitle;
	int[] icon;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();		
		initDrawer();
		initTabBar();
	}

	private void initDrawer() {
		// TODO Auto-generated method stub
		mTitle = mDrawerTitle = getTitle();
		//
		// // Generate title
		title = new String[] { "name" };
		//
		// // Generate subtitle
		subtitle = new String[] { "" };
		//
		// // Generate icon
		icon = new int[] { R.drawable.ic_launcher };
		//
		// // Locate DrawerLayout in drawer_main.xml
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		//
		// // Locate ListView in drawer_main.xml
		mDrawerList = (ListView) findViewById(R.id.listview_drawer);
		//
		// // Set a custom shadow that overlays the main content when the drawer
		// // opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		//
		// // Pass string arrays to MenuListAdapter
		mMenuAdapter = new MenuListAdapter(MainActivity.this, title, subtitle,
				icon);

		// Set the MenuListAdapter to the ListView
		mDrawerList.setAdapter(mMenuAdapter);

		// Capture listview menu item click
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(view);
			}

			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				// Set the title on the action when drawer open
				getSupportActionBar().setTitle(mDrawerTitle);
				super.onDrawerOpened(drawerView);
			}
		};
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		// Locate Position
		switch (position) {

		// case 0:
		// ft.replace(R.id.content_frame, userProfile);
		// break;

		// case 2:
		// ft.replace(R.id.content_frame, societyUtil);
		// break;
		// case 3:
		// ft.replace(R.id.content_frame, fragmentNeighbour);
		// break;

		}
		ft.commit();
		mDrawerList.setItemChecked(position, true);
		// Get the title followed by the position
		setTitle(title[position]);
		// Close drawer
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	private void initTabBar() {
		// TODO Auto-generated method stub
		bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab tabGroup = bar.newTab();
		tabGroup.setText("A");
		tabGroup.setTabListener(new MyTabsListener(new FeedFragment()));
		bar.addTab(tabGroup);

//		Tab tabMessage = bar.newTab();
//		tabMessage.setText("B");
//		// tabMessage.setTabListener(new MyTabsListener(messageFragment));
//		bar.addTab(tabMessage);
//
//		Tab tabUsers = bar.newTab();
//		tabUsers.setText("C");
//		// tabUsers.setTabListener(new MyTabsListener(userFragment));
//		bar.addTab(tabUsers);

	}

	protected class MyTabsListener implements ActionBar.TabListener {
		private Fragment fragment;

		public MyTabsListener(Fragment fragment) {
			this.fragment = fragment;
		}

		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			ft.add(R.id.content_frame, fragment, null);
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			ft.remove(fragment);
		}
	}

}
