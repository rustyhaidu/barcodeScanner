package cristiapp.sepazxing;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.zxing.Result;

import java.util.ArrayList;

import cristiapp.module.zxing.ZXingScannerView;

/**
 * Created by Claudiu on 7/6/2015.
 */
public class Tab1Fragment extends Fragment implements MessageDialogFragment.MessageDialogListener,
        ZXingScannerView.ResultHandler, FormatSelectorDialogFragment.FormatSelectorDialogListener,
        CameraSelectorDialogFragment.CameraSelectorDialogListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return (LinearLayout) inflater.inflate(R.layout.activity_full_scanner_fragment,container,false);
    }

    @Override
    public void onCameraSelected(int cameraId) {

    }

    @Override
    public void onFormatsSaved(ArrayList<Integer> selectedIndices) {

    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void handleResult(Result rawResult) {

    }
}
