package cz.majlos.test1;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;
import android.view.ContextMenu;


@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity implements OnClickListener, OnMenuItemClickListener {
	private EditText mEditTextTitle;
	private EditText mEditTextNote;
	private AlertDialog.Builder dBuilder;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_poznamka_relative);
        setContentView(R.layout.activity_poznamka);
		mEditTextTitle = (EditText) findViewById(R.id.editTitle);
		//mEditTextNote = (EditText) findViewById(R.id.editNote);
		dBuilder = new AlertDialog.Builder(this);
				
		findViewById(R.id.buttonSave).setOnClickListener(this);
		findViewById(R.id.buttonDelete).setOnClickListener(this);
		findViewById(R.id.buttonMenu).setOnClickListener(this);
		
		//this.registerForContextMenu(findViewById(R.id.buttonMenu));
		
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //menu.findItem(R.id.action_test3).setOnMenuItemClickListener(this);
		//menu.findItem(R.id.action_test4).setOnMenuItemClickListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
        	case R.id.action_test1:
	        	Toast.makeText(getApplicationContext(), getString(R.string.action_test1), Toast.LENGTH_SHORT).show();
	            return true;
        	case R.id.action_test2:
	        	Toast.makeText(getApplicationContext(), getString(R.string.action_test2), Toast.LENGTH_SHORT).show();
	            return true;
        	case R.id.action_test3:
	        	Toast.makeText(getApplicationContext(), getString(R.string.action_test3), Toast.LENGTH_SHORT).show();
	            return true;
        	case R.id.action_test4:
	        	Toast.makeText(getApplicationContext(), getString(R.string.action_test4), Toast.LENGTH_SHORT).show();
	            return true;
	        default:
	        	return super.onOptionsItemSelected(item);
        }
    }
    
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
        	case R.id.action_test3:
	        	Toast.makeText(getApplicationContext(), getString(R.string.action_test3), Toast.LENGTH_SHORT).show();
	            return true;
        	case R.id.action_test4:
	        	Toast.makeText(getApplicationContext(), getString(R.string.action_test4), Toast.LENGTH_SHORT).show();
	            return true;
	        default:
	        	return true;
        }
    }
    
    /**
     * @param item
     * @return
     */
    public boolean onMenuItemClick(MenuItem item) {
    	switch (item.getItemId()) {
	    	case R.id.action_test3:
	        	Toast.makeText(getApplicationContext(), getString(R.string.action_test3_click), Toast.LENGTH_SHORT).show();
	            return true;
	    	case R.id.action_test4:
	        	Toast.makeText(getApplicationContext(), getString(R.string.action_test4_click), Toast.LENGTH_SHORT).show();
	            return true;
	        default:
	        	return false;
    	}
    }
    
    /**
     * FUNGUJE TOTO VUBEC?
     */
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    	super.onCreateContextMenu(menu, v, menuInfo);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.popup_menu, menu);
    }

    
@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.buttonSave:
				String toastText = mEditTextTitle.getText().toString() + ": " + mEditTextNote.getText().toString();
				Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
				break;
			case R.id.buttonDelete:
				dBuilder.setTitle(R.string.dlg_delete_title);
				dBuilder.setMessage(R.string.dlg_delete_message);
				dBuilder.setPositiveButton(R.string.dlg_btn_yes, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mEditTextTitle.setText("");
						mEditTextNote.setText("");
						Toast.makeText(getApplicationContext(), getString(R.string.toast_delete), Toast.LENGTH_LONG).show();
					}

				}).setNegativeButton(R.string.dlg_btn_no, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}

				});
				AlertDialog deleteDialog = dBuilder.create();
				deleteDialog.show();
				break;
			case R.id.buttonMenu:
				PopupMenu popup = new PopupMenu(MainActivity.this, v);
				MenuInflater inflater = popup.getMenuInflater();
				inflater.inflate(R.menu.popup_menu, popup.getMenu());
				popup.setOnMenuItemClickListener(MainActivity.this);
				popup.show();
				break;
		}
	}		
	
	
}
