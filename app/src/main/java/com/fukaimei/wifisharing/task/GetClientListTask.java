package com.fukaimei.wifisharing.task;

import java.util.ArrayList;

//import com.example.mixture.bean.ClientScanResult;
//import com.example.mixture.util.WifiUtil;

import android.os.AsyncTask;

import com.fukaimei.wifisharing.bean.ClientScanResult;
import com.fukaimei.wifisharing.util.WifiUtil;

public class GetClientListTask extends AsyncTask<Void, Void, ArrayList<ClientScanResult>> {

    @Override
    protected ArrayList<ClientScanResult> doInBackground(Void... params) {
        return WifiUtil.getClientList(true);
    }

    @Override
    protected void onPostExecute(ArrayList<ClientScanResult> clientList) {
        mListener.onGetClient(clientList);
    }

    private GetClientListener mListener;

    public void setGetClientListener(GetClientListener listener) {
        mListener = listener;
    }

    public static interface GetClientListener {
        public abstract void onGetClient(ArrayList<ClientScanResult> clientList);
    }

}
