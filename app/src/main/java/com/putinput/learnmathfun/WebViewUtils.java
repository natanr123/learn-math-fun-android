package com.putinput.learnmathfun;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Random;
import java.io.IOException;

public class WebViewUtils {
    static public void loadSite(String url, WebView webView, FullscreenActivity activity) throws IOException
    {
        System.out.println("loadSiteloadSiteloadSiteloadSiteloadSiteloadSiteloadSite111");
        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setDomStorageEnabled(true);
        String summary = "<html><body>You scored <b>192</b> points.</body></html>";
        //String indexHtml = "file:///android_asset/index.html";

        //webView.loadUrl(indexHtml);




        class JsObject {
            private FullscreenActivity fullscreenActivity;
            JsObject(FullscreenActivity fullscreenActivity)
            {
                super();
                this.fullscreenActivity = fullscreenActivity;
            }
            @JavascriptInterface
            public String exit()
            {
                this.fullscreenActivity.finish();
                System.out.println("JAVASCRIPT ASK: exit");
                return "injectedObject";
            }
        }
        JsObject jsObject = new JsObject(activity);
        webView.addJavascriptInterface(jsObject, "injectedObject");



        webView.loadUrl(url);
    }
}
