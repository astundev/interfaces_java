package net.astundev.android.logging;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private static final String LOGTAG = "LogsAndroid"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.e(LOGTAG, "Mensaje de error");
        Log.w(LOGTAG, "Mensaje de warning");
        Log.i(LOGTAG, "Mensaje de informaci�n");
        Log.d(LOGTAG, "Mensaje de depuraci�n");
        Log.v(LOGTAG, "Mensaje de verbose");
        
        try 
        {
        	int a = 1/0;
        }
        catch(Exception ex) 
        {
        	Log.e(LOGTAG, "Divisi�n por cero!", ex);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
