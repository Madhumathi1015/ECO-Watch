package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;
import java.util.concurrent.TimeUnit;

public class HomeFragment extends Fragment {

    private Handler handler = new Handler(); // Handler for countdown
    private Runnable runnable;

    // Initial countdown time in milliseconds (adjust as necessary)
    long initialTimeMillis = ((4L * 365 + 265L) * 24 * 60 * 60 + 10L * 60 * 60 + 10L * 60 + 39L) * 1000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Find TextView and WebViews by their IDs
        TextView countdownTimer = root.findViewById(R.id.countdownTimer);
        WebView webView = root.findViewById(R.id.webView);
        WebView youtubeWebView = root.findViewById(R.id.youtubeWebView);

        // Start the countdown timer
        startCountdown(countdownTimer);

        // Load the CO2 tracker in WebView
        setupWebView(webView, "https://www.theworldcounts.com/embeds/counters/23?background_color=white&color=black&font_family=%22Helvetica+Neue%22%2C+Arial%2C+sans-serif&font_size=14");

        // Configure the WebView to load YouTube video
        setupWebView(youtubeWebView, "https://www.youtube.com/embed/q_XE3bVggJk");

        return root;
    }

    private void setupWebView(WebView webView, String url) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    private void startCountdown(TextView countdownTimer) {
        runnable = new Runnable() {
            @Override
            public void run() {
                if (initialTimeMillis > 0) {
                    long days = TimeUnit.MILLISECONDS.toDays(initialTimeMillis);
                    long hours = TimeUnit.MILLISECONDS.toHours(initialTimeMillis) - TimeUnit.DAYS.toHours(days);
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(initialTimeMillis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(initialTimeMillis));
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(initialTimeMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(initialTimeMillis));

                    countdownTimer.setText(String.format("%d days, %02d hours, %02d minutes, %02d seconds", days, hours, minutes, seconds));

                    initialTimeMillis -= 1000; // Decrease the time by 1 second

                    handler.postDelayed(this, 1000); // Schedule the next update
                } else {
                    countdownTimer.setText("Time's up!");
                }
            }
        };

        handler.post(runnable); // Start the countdown
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Cleanup to avoid memory leaks
        handler.removeCallbacks(runnable);
    }
}
