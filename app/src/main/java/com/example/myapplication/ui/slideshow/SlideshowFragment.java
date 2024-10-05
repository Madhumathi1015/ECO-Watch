package com.example.myapplication.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.myapplication.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the fragment layout
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize WebView
        WebView webView = binding.webView;
        webView.setWebViewClient(new WebViewClient()); // Ensures links open in the WebView, not the browser
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript

        // Load the URL
        webView.loadUrl("https://worldview.earthdata.nasa.gov/?v=66.401340625,5.680839062500002,90.413059375,16.350760937500002&i=1&l=Reference_Labels_15m,Reference_Features_15m,Coastlines_15m(hidden),MLS_N2O_46hPa_Day,MLS_N2O_46hPa_Night,MERRA2_Dust_Surface_Mass_Concentration_PM25_Monthly,VIIRS_NOAA20_Thermal_Anomalies_375m_All,AIRS_L3_Carbon_Monoxide_500hPa_Volume_Mixing_Ratio_Monthly_Night,AIRS_L3_Methane_400hPa_Volume_Mixing_Ratio_Monthly_Day,AIRS_L3_Carbon_Monoxide_500hPa_Volume_Mixing_Ratio_Monthly_Day,OCO-3_Carbon_Dioxide_Total_Column_Average,AIRS_L3_Carbon_Dioxide_AIRS_AMSU_Monthly,IMERG_Precipitation_Rate,VIIRS_NOAA20_DayNightBand_At_Sensor_Radiance(hidden),VIIRS_NOAA20_DayNightBand_AtSensor_M15(hidden),VIIRS_SNPP_DayNightBand_At_Sensor_Radiance(hidden),VIIRS_SNPP_DayNightBand_AtSensor_M15(hidden),BlueMarble_NextGeneration(hidden),VIIRS_NOAA21_CorrectedReflectance_TrueColor,VIIRS_NOAA20_CorrectedReflectance_TrueColor(hidden),VIIRS_SNPP_CorrectedReflectance_TrueColor(hidden),MODIS_Aqua_CorrectedReflectance_TrueColor(hidden),MODIS_Terra_CorrectedReflectance_TrueColor&lg=false&l1=Reference_Labels_15m,Reference_Features_15m,Coastlines_15m(hidden),MLS_N2O_46hPa_Day,MLS_N2O_46hPa_Night,MERRA2_Dust_Surface_Mass_Concentration_PM25_Monthly,VIIRS_NOAA20_Thermal_Anomalies_375m_All,AIRS_L3_Carbon_Monoxide_500hPa_Volume_Mixing_Ratio_Monthly_Night,AIRS_L3_Methane_400hPa_Volume_Mixing_Ratio_Monthly_Day,AIRS_L3_Carbon_Monoxide_500hPa_Volume_Mixing_Ratio_Monthly_Day,OCO-3_Carbon_Dioxide_Total_Column_Average,AIRS_L3_Carbon_Dioxide_AIRS_AMSU_Monthly,IMERG_Precipitation_Rate,VIIRS_NOAA20_DayNightBand_At_Sensor_Radiance(hidden),VIIRS_NOAA20_DayNightBand_AtSensor_M15(hidden),VIIRS_SNPP_DayNightBand_At_Sensor_Radiance(hidden),VIIRS_SNPP_DayNightBand_AtSensor_M15(hidden),BlueMarble_NextGeneration(hidden),VIIRS_NOAA21_CorrectedReflectance_TrueColor,VIIRS_NOAA20_CorrectedReflectance_TrueColor(hidden),VIIRS_SNPP_CorrectedReflectance_TrueColor(hidden),MODIS_Aqua_CorrectedReflectance_TrueColor(hidden),MODIS_Terra_CorrectedReflectance_TrueColor&lg1=false&ca=true&cv=36&s=79.4433,23.3794%2B78.4072,11.0158&t=2024-10-03-T00%3A00%3A00Z&t1=2024-09-26-T00%3A00%3A00Z");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
