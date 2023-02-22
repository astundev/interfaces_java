package net.astundev.android.actionbartabs;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Obtenemos una referencia a la actionbar
		ActionBar abar = getActionBar();
		
		//Establecemos el modo de navegaci�n por pesta�as
	    abar.setNavigationMode(
	    		ActionBar.NAVIGATION_MODE_TABS);
	    
	    //Ocultamos el t�tulo de la actividad
	    //abar.setDisplayShowTitleEnabled(false);
	    
	    //Creamos las pesta�as
	    ActionBar.Tab tab1 = 
	    		abar.newTab().setText("Tab 1");
	    
        ActionBar.Tab tab2 = 
        		abar.newTab().setText("Tab 2");
        
        //Creamos los fragments de cada pesta�a
        Fragment tab1frag = new Tab1Fragment();
        Fragment tab2frag = new Tab2Fragment();
        
        //Asociamos los listener a las pesta�as
        tab1.setTabListener(new MiTabListener(tab1frag));
        tab2.setTabListener(new MiTabListener(tab2frag));
        
        //A�adimos las pesta�as a la action bar
        abar.addTab(tab1);
        abar.addTab(tab2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.menu_new:
	            Log.i("ActionBar", "Nuevo!");
	            return true;
	        case R.id.menu_save:
	            Log.i("ActionBar", "Guardar!");;
	            return true;
	        case R.id.menu_settings:
	            Log.i("ActionBar", "Settings!");;
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
}
