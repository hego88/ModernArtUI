package com.coursera.hricigor.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ModernArtDialog extends DialogFragment implements
		DialogInterface.OnClickListener {

	private static Intent mIntent;
	private static Intent mChoser;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.dialog_text)
				.setPositiveButton(R.string.dialog_visit, this)
				.setNegativeButton(R.string.dialog_not_now, null);

		return builder.create();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
		mChoser = Intent.createChooser(mIntent, getResources().getString(R.string.open_with));
		startActivity(mChoser);

	}
}
