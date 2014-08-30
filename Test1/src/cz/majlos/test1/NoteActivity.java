package cz.majlos.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends Activity implements OnClickListener {

	private EditText mEditTextTitle;
	private EditText mEditTextNote;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poznamka);
		
		mEditTextTitle = (EditText) findViewById(R.id.editTitle);
		mEditTextNote = (EditText) findViewById(R.id.editNote);
		
		findViewById(R.id.buttonSave).setOnClickListener(this);
		findViewById(R.id.buttonDelete).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.buttonSave:
				String toastText = mEditTextTitle.getText().toString() + ": " + mEditTextNote.getText().toString();
				Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
				break;
			case R.id.buttonDelete:
				mEditTextTitle.setText("");
				mEditTextNote.setText("");
				Toast.makeText(getApplicationContext(), getString(R.string.toast_delete), Toast.LENGTH_LONG).show();
				break;
		}
	}

}
