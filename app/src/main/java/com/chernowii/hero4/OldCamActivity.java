package com.chernowii.hero4;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.*;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorListener;
import android.hardware.SensorEventListener;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.media.session.MediaSession;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.format.Formatter;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.location.Location;
import android.location.LocationListener;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.channels.ClosedChannelException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Notification;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.app.NotificationManager;

import android.app.PendingIntent;

import android.content.Intent;
import android.graphics.Outline;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.app.Notification;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.content.Context;
import java.lang.UnsupportedOperationException;
import android.location.LocationManager;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;

public class OldCamActivity extends Activity {
    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile (String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return ret;
    }
    private static final String AUDIO_RECORDER_FILE_EXT_3GP = ".3gp";
    private static final String AUDIO_RECORDER_FILE_EXT_MP4 = ".mp4";
    private static final String AUDIO_RECORDER_FOLDER = "AudioRecorder";
    private static final String PREFS_NAME = "";
    private MediaRecorder recorder = null;
    private int currentFormat = 0;
    private int output_formats[] = { MediaRecorder.OutputFormat.MPEG_4, MediaRecorder.OutputFormat.THREE_GPP };
    private String file_exts[] = { AUDIO_RECORDER_FILE_EXT_MP4, AUDIO_RECORDER_FILE_EXT_3GP };
    GPStracker gps;
    NotificationCompat.WearableExtender wearableExtender =
            new NotificationCompat.WearableExtender()
                    .setHintShowBackgroundOnly(true);

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_old_cam, menu);
        return true;
    }
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            if (KeyEvent.KEYCODE_MEDIA_PLAY == event.getKeyCode()) {
                Toast.makeText(getApplicationContext(),
                        "Test!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                new AlertDialog.Builder(this)
                        .setTitle("About GoProHero")
                        .setMessage("Developed by Konrad Iturbe\nGOPRO, HERO, the GOPRO logo, and the GoPro Be a Hero logo are trademarks or registered trademarks of GoPro, Inc\nHow to use it:\nHeroControl: creates a notification with three main controls that can be accessed from the lock screen, car stereo UI, android wear and more.\nThe live preview may lag a bit, this is normal :)\nIf you own a HERO2/HERO3/HERO3+ go to the 3 dot menu and tap on Configure H2/H3/H3+, its necessary to input the GoPro password.")
                        .setPositiveButton(R.string.webpage, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/KonradIT/goprohero/blob/master/README.md"));
                                startActivity(browserIntent);
                            }
                        })
                        .setNeutralButton(R.string.reddit, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.reddit.com/r/Android/comments/2zxv84/devalpha_goprohero_unofficial_gopro_app/"));
                                startActivity(browserIntent);
                            }
                        })

                        .setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(R.drawable.ic_launcher)
                        .show();

                return true;
            // case R.id.action_config:
            //    Intent intentTwo = new Intent(this, ConfigScreen.class);
            //  startActivity(intentTwo);
            //   return true;
            case R.id.action_calc:
                Intent intentThree = new Intent(this, Calculator.class);
                startActivity(intentThree);
                return true;
            case R.id.action_h4cam:
                Intent intentFour = new Intent(this, MainActivity.class);
                startActivity(intentFour);
                return true;
            case R.id.action_setup:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);

                alert.setTitle("Camera Password");
                alert.setMessage("Type your GoPro Password (default is goprohero)");

// Set an EditText view to get user input
                final EditText input = new EditText(this);
                alert.setView(input);

                alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        String value = String.valueOf(input.getText());
                        String filename = "camconfig.txt";
                        FileOutputStream outputStream;

                        try {
                            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                            outputStream.write(value.getBytes());
                            outputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                        v.vibrate(600);
                        Toast.makeText(getApplicationContext(),
                                "All set! Restart the app please :)", Toast.LENGTH_LONG).show();

                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();

                return true;
         /*   case R.id.action_profilesettings:
                Intent intentFour = new Intent(this, ProfileConfig.class);
                startActivity(intentFour);
                return true;
                */
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private NotificationManager mNotificationManager;
    private int notificationID = 100;
    private int numMessages = 0;

    Spinner spnr;
    String[] vidreslist = {
            "Select",
            "4K",
            "2.7K",
            "1440p",
            "1080p",
            "720p",
            "WVGA"
    };
    public static String getFileContents(final File file) throws IOException {
        final InputStream inputStream = new FileInputStream(file);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        final StringBuilder stringBuilder = new StringBuilder();

        boolean done = false;

        while (!done) {
            final String line = reader.readLine();
            done = (line == null);

            if (line != null) {
                stringBuilder.append(line);
            }
        }

        reader.close();
        inputStream.close();

        return stringBuilder.toString();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_cam);
        if (savedInstanceState == null) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_old_cam);

            String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

            File yourFile = new File( yourFilePath );
            try {
                String testPassword = getFileContents(yourFile);
                Toast.makeText(getApplicationContext(),
                        testPassword, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        setTitle("GoProHero");
        getActionBar().setIcon(R.drawable.icono);
        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        final TextView mTextView = (TextView) findViewById(R.id.connectedcam);
        Log.d("wifiInfo", wifiInfo.toString());
        String wifiSSID = wifiInfo.getSSID();
        int ip = wifiInfo.getIpAddress();
        String ipAddress = Formatter.formatIpAddress(ip);
        String goprotwo = "10.5.5.109";
        mTextView.setText(wifiSSID);
        if (ipAddress.equals(goprotwo)){
            mTextView.setTextColor(Color.parseColor("#00FF00"));
        }
        else{
            mTextView.setTextColor(Color.parseColor("#FF0000"));
            new AlertDialog.Builder(this)
                    .setTitle("Camera not connected")
                    .setMessage("1. Make sure your GoPro has wifi turned on by checking in the LCD screen/back screen. If not, turn it on by going to the settings and scrolling until Wifi, then set GoPro app.\n2. Tap on Open Wifi settings below and connect to the GoPro camera. \n3. Restart the app.")
                    .setPositiveButton(R.string.wifi, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent browserIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                            startActivity(browserIntent);
                        }
                    })

                    .setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(R.drawable.ic_launcher)
                    .show();
        }
    }
    public void startGPAudioRec(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Trigger + Audio!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
        new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=" + password + "&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(output_formats[currentFormat]);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
        //get current date time with Date()
        Date date = new Date();
        String thedate = dateFormat.format(date);
        recorder.setOutputFile("sdcard/GoProRecording " + thedate + ".mp3");
        try {
            recorder.prepare();
            recorder.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final TextView mTextView = (TextView) findViewById(R.id.recstatus);
        mTextView.setText("Status: recording");

    }

    public void startJSONDiscovery(View view){

    }
    public void stopGPAudioRec(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Stopped + Audio!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
        new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=" + password + "&p=%00");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null != recorder) {
            recorder.stop();
            recorder.reset();
            recorder.release();
            recorder = null;
        }
        final TextView mTextView = (TextView) findViewById(R.id.recstatus);
        mTextView.setText("Status: ready");
    }
    public void startGPSLog(View view){
        gps = new GPStracker(OldCamActivity.this);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
        //get current date time with Date()
        Date date = new Date();
        String thedate = dateFormat.format(date);
        DateFormat dateFormatTwo = new SimpleDateFormat("dd-MM-yyyy");
        //get current date time with Date()
        Date dateTwo = new Date();
        String theotherdate = dateFormatTwo.format(dateTwo);
        String thisfiledate = dateFormatTwo.format(dateTwo);
        // check if GPS enabled
        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "GPS Tracking started", Toast.LENGTH_LONG).show();
            try {
                File myFile = new File("/sdcard/GoProGPSTrack" + theotherdate + ".txt");
                myFile.createNewFile();
                FileOutputStream fOut = new FileOutputStream(myFile);
                OutputStreamWriter myOutWriter =
                        new OutputStreamWriter(fOut);
                myOutWriter.append("<gpx>");
                myOutWriter.append("<trk>");
                myOutWriter.append("<name>GoPro Track</name>");
                myOutWriter.append("<trkseg>");
                myOutWriter.append("<latitude>" + latitude + "</latitude>");
                myOutWriter.append("<longitude>" + longitude + "</longitude>");
                myOutWriter.append("<time>" + date + "</time>");
                myOutWriter.append("</trkseg>");
                myOutWriter.close();
                fOut.close();
            } catch (Exception e) {
                Toast.makeText(getBaseContext(), e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

    }



    public void goProControlNotification(View view) {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, OCTrigger.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intentTwo = new Intent(this, OCTurnOff.class);
        PendingIntent pIntentTwo = PendingIntent.getActivity(this, 0, intentTwo, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentSeven = new Intent(this, OCTurnOn.class);
        PendingIntent pIntentSeven = PendingIntent.getActivity(this, 0, intentSeven, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentThree = new Intent(this, OCStop.class);
        PendingIntent pIntentThree = PendingIntent.getActivity(this, 0, intentThree, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentFour = new Intent(this, OCVideo.class);
        PendingIntent pIntentFour = PendingIntent.getActivity(this, 0, intentFour, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentFive = new Intent(this, OCPhoto.class);
        PendingIntent pIntentFive = PendingIntent.getActivity(this, 0, intentFive, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentSix = new Intent(this, OCBurst.class);
        PendingIntent pIntentSix = PendingIntent.getActivity(this, 0, intentSix, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentEight = new Intent(this, OCTimelapse.class);
        PendingIntent pIntentEight = PendingIntent.getActivity(this, 0, intentEight, PendingIntent.FLAG_UPDATE_CURRENT);
        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Control your GoPro camera!")

                .setContentText("Right from lockscreen, car, wear watch and more!").setSmallIcon(R.drawable.icono)
                        //   .setContentIntent(pIntent)
                .setPriority(0)
                .addAction(R.drawable.ic_trigger, "Trigger", pIntent)
                .addAction(R.drawable.ic_power, "Turn Off", pIntentTwo)
                .addAction(R.drawable.ic_power, "Turn On", pIntentSeven)
                .addAction(R.drawable.ic_stop, "Stop", pIntentThree)
                .addAction(R.drawable.ig_video, "Video mode", pIntentFour)
                .addAction(R.drawable.ic_photo, "Photo mode", pIntentFive)
                .addAction(R.drawable.ic_ms, "Burst mode", pIntentSix)
                .addAction(R.drawable.ic_action_stat_reply, "TimeLapse", pIntentEight).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }


    private Camera camera;
    Camera.Parameters params;
    public void sendFlash(View view) {
        camera = Camera.open();
        params = camera.getParameters();
        params = camera.getParameters();
        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();
    }


    public void sendTriggerWear() {
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
    }
    public static void sendStopWear() {
    }
    public static void sendTagWear() {

    }

    public void sendDisplayAdvancedProtune(View view) {
        Intent intent = new Intent(this, OCProtuneControls.class);
        startActivity(intent);
        // MainActivity.setContentView(R.layout.activity_protune_controls);
    }
    public void sendDisplayLiveView(View view) {
        Intent intentTwo = new Intent(this, LiveStuff.class);
        startActivity(intentTwo);
    }
    public void sendHDR(View view) {
        Intent intentTwo = new Intent(this, HDR.class);
        startActivity(intentTwo);
    }
    public void sendMediaBrowser(View view) {
        Intent intentTwo = new Intent(this, MediaBrowser.class);
        startActivity(intentTwo);
    }
    public void sendOldCamSet(View view) {
        Intent intentTwo = new Intent(this, WelcomeScreen.class);
        startActivity(intentTwo);
    }
    public void sendTriggerTest2() {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Trigger!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
    }


    /**
     * A placeholder fragment containing a simple view.
     */

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);
            return rootView;
        }
    }
    //START OF VOLUME ROCKER ayy lmao!

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)){
            //Do something:
            Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
            v.vibrate(200);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.vibrate(300);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.vibrate(300);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.vibrate(300);
            Toast.makeText(getApplicationContext(),
                    "Stopped!", Toast.LENGTH_SHORT).show();
            String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

            File yourFile = new File( yourFilePath );
            try {
                String password = getFileContents(yourFile);

            new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=" + password + "&p=%00");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)){
            //Do something:
            Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
            v.vibrate(600);
            Toast.makeText(getApplicationContext(),
                    "Trigger!", Toast.LENGTH_SHORT).show();
            String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

            File yourFile = new File( yourFilePath );
            try {
                String password = getFileContents(yourFile);

                new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=" + password + "&p=%01");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    // END OF VOLUME ROCKER ROFLMAO!!
    //SOME GOOD NOTIFICATION LMAOs


    //START OF THE WIFI HERO4 COMMANDS:

    public void sendTrigger(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Trigger!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);


            new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=" + password + "&p=%01");
        // new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=20161962&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendTurnOn(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Turned On!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);


            new HttpAsyncTask().execute("http://10.5.5.9/bacpac/PW?t=" + password + "&p=%01");
            // new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=20161962&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendTurnOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Turned Off!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);


            new HttpAsyncTask().execute("http://10.5.5.9/bacpac/PW?t=" + password + "&p=%00");
            // new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=20161962&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendTriggerGPS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Trigger!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
    }
    public void sendAbout(View view) {
        new AlertDialog.Builder(this)
                .setTitle("About GoProHero")
                .setMessage("Developed by Konrad Iturbe\nGOPRO, HERO, the GOPRO logo, and the GoPro Be a Hero logo are trademarks or registered trademarks of GoPro, Inc")
                .setPositiveButton(R.string.webpage, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/KonradIT/goprohero/blob/master/README.md"));
                        startActivity(browserIntent);
                    }
                })
                .setNeutralButton(R.string.reddit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.reddit.com/r/Android/comments/2zxv84/devalpha_goprohero_unofficial_gopro_app/"));
                        startActivity(browserIntent);
                    }
                })

                .setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(R.drawable.icono)
                .show();
    }


    public void sendStop(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(200);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.vibrate(300);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.vibrate(300);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.vibrate(300);
        Toast.makeText(getApplicationContext(),
                "Stopped!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);

            new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=" + password + "&p=%00");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendVideo(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Set to Video mode!", Toast.LENGTH_SHORT).show();

        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
        new HttpAsyncTask().execute("http://10.5.5.9/camera/CM?t=" + password + "&p=%00");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendPhoto(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Set to Photo mode!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
        new HttpAsyncTask().execute("http://10.5.5.9/camera/CM?t=" + password + "&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendBurst(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Set to Burst mode!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
        new HttpAsyncTask().execute("http://10.5.5.9/camera/CM?t=" + password + "&p=%02");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendTimelapse(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Set to Timelapse mode!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
        new HttpAsyncTask().execute("http://10.5.5.9/camera/CM?t=" + password + "&p=%03");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //RISKY ZONE:


    //RESOLUTION FOR VIDEO
    public void sendVR4K(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "4K!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/VV?t=" + password + "&p=%06");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendVR27K(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "2.7K!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/VV?t=" + password + "&p=%05");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendVR1440P(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "1440P!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/VV?t=" + password + "&p=%04");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendVR1080PS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "1080P SuperView!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/VV?t=" + password + "&p=%09");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendVR1080P(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "1080p!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/VV?t=" + password + "&p=%03");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendVR960P(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "960p!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/VV?t=" + password + "&p=%02");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendVR720PS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "720p SuperView!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/VV?t=" + password + "&p=%0a");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendVR720P(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "720p!", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/VV?t=" + password + "&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//FOVs

    public void sendNarrowFOV(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "Narrow", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/FV?t=" + password + "&p=%02");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMediumFOV(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "Medium", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/FV?t=" + password + "&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendWideFOV(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "Wide", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/FV?t=" + password + "&p=%00");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send12MPW(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "12MP W", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/PR?t=" + password + "&p=%05");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send7MPW(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "7MP W", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/PR?t=" + password + "&p=%04");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send7MPM(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "12MP W", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/PR?t=" + password + "&p=%06");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send5MPW(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "12MP W", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/PR?t=" + password + "&p=%0r");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void send120FPS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "120FPS", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/FV?t=" + password + "&p=%09");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send60FPS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);
        Toast.makeText(getApplicationContext(),
                "60FPS", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/FV?t=" + password + "&p=%07");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send30FPS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(200);
        Toast.makeText(getApplicationContext(),
                "30FPS", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/FV?t=" + password + "&p=%04");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send05TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 0.5 seconds", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/TI?t=" + password + "&p=%00");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send1TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 1 second", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/TI?t=" + password + "&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send2TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 2 seconds", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/TI?t=" + password + "&p=%02");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send5TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 5 seconds", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/TI?t=" + password + "&p=%05");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send10TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 10 seconds", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/TI?t=" + password + "&p=%0a");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send30TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 30 seconds", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/FV?t=" + password + "&p=%1e");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send60TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 60 seconds", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/FV?t=" + password + "&p=%3c");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendLEDOff(View view) {
        Toast.makeText(getApplicationContext(),
                "LEDs OFF", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/bacpac/LB?t=" + password + "&p=%00");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendLED2(View view) {
        Toast.makeText(getApplicationContext(),
                "LEDs 2", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/bacpac/LB?t=" + password + "&p=%01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendLED4(View view) {
        Toast.makeText(getApplicationContext(),
                "LEDs 4", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/LB?t=" + password + "&p=%02");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendBuzzerOff(View view) {
        Toast.makeText(getApplicationContext(),
                "spot Off", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/EX?t=" + password + "&p=%00");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendBuzzer100(View view) {
        Toast.makeText(getApplicationContext(),
                "spot on", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/camera/EX?t=" + password + "&p=%00");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendActionProfile(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/3/5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendCinemaProfile(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(300);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/2/4");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/3/10");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/10/1");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/11/4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendGPS(View view) {

    }

    public void sendIndoorProfile(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/3/8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String password = getFileContents(yourFile);
            new HttpAsyncTask ().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendProfileOne(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);

        String videoResolutionOne = "";
        String frameRateOne = "";
        String fovOne = "";
        String protuneOne = "";
        String wbOne = "";
        String colorOne = "";
        String isoOne = "";
        String sharpnessOne = "";
        String evOne = "";
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/" + videoResolutionOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/" + frameRateOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/" + fovOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/" + protuneOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/11/" + wbOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/12/" + colorOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/13/" + isoOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/14/" + sharpnessOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/" + evOne);
    }
    public void sendProfileTwo(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/8");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
    }
    public void sendProfileThree(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/8");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
    }

    public void sendWiFiOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Wifi Off", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/63/0");
    }
    public void sendCamOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Turned off", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/system/sleep");
    }
    public void sendFullOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "WiFi+Camera OFF", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/system/sleep");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/63/0");
    }
    public void sendDeleteAll(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Camera media empty", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
        new HttpAsyncTask().execute("http://10.5.5.9/camera/DL?t=" + password );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendDeleteLast(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Deleted last file", Toast.LENGTH_SHORT).show();
        String yourFilePath = this.getFilesDir() + "/" + "camconfig.txt";

        File yourFile = new File( yourFilePath );
        try {
            String password = getFileContents(yourFile);
        new HttpAsyncTask().execute("http://10.5.5.9/camera/DL?t=" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendLCDOn(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD ON", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/72/1");
    }
    public void sendLCDOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD OFF", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/72/0");
    }
    public void sendLCDHigh(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD High", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/49/0");
    }
    public void sendLCDMedium(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Medium", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/49/1");
    }
    public void sendLCDLow(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Low", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/49/2");
    }
    public void sendLCDLock(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Locked", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/50/1");
    }
    public void sendLCDUnlock(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Unlocked", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/50/0");
    }
    public void sendLCDNever(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Sleep never", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/51/0");
    }
    public void sendLCD1Min(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Sleep 1 min", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/51/1");
    }
    public void sendLCD2Min(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Sleep 2 Min", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/51/2");
    }
    public void sendLCD3Min(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Sleep 3 Min", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/51/3");
    }
    // END OF RISKY ZONE; CARRY ON.


    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Done!", Toast.LENGTH_SHORT).show();
            ;
        }
    }
}

