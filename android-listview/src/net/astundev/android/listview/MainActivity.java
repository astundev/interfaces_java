package net.astundev.android.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView lblEtiqueta;
	private ListView lstOpciones;
	
	private Titular[] datos = 
	    	new Titular[]{
	    		new Titular("T�tulo 1", "Subt�tulo largo 1"),
	    		new Titular("T�tulo 2", "Subt�tulo largo 2"),
	    		new Titular("T�tulo 3", "Subt�tulo largo 3"),
	    		new Titular("T�tulo 4", "Subt�tulo largo 4"),
	    		new Titular("T�tulo 5", "Subt�tulo largo 5")};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AdaptadorTitulares adaptador = 
            	new AdaptadorTitulares(this);
            
        lblEtiqueta = (TextView)findViewById(R.id.LblEtiqueta);
        lstOpciones = (ListView)findViewById(R.id.LstOpciones);
            
        lstOpciones.setAdapter(adaptador);
        
        lstOpciones.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
            	
            	//Alternativa 1:
            	String opcionSeleccionada = 
            			((Titular)a.getAdapter().getItem(position)).getTitulo();
            	
            	//Alternativa 2:
            	//String opcionSeleccionada = 
            	//		((TextView)v.findViewById(R.id.LblTitulo))
            	//			.getText().toString();
            	
            	lblEtiqueta.setText("Opci�n seleccionada: " + opcionSeleccionada);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    class AdaptadorTitulares extends ArrayAdapter<Titular> {
    	
    	Activity context;
    	
    	AdaptadorTitulares(Activity context) {
    		super(context, R.layout.listitem_titular, datos);
    		this.context = context;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.listitem_titular, null);
			
			TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
			lblTitulo.setText(datos[position].getTitulo());
			
			TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
			lblSubtitulo.setText(datos[position].getSubtitulo());
			
			return(item);
		}
    }
}
