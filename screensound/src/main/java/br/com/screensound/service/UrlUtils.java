package br.com.screensound.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlUtils {

    public UrlUtils() {}

    public static String formatarArtista(String nomeArtista) {
        return URLEncoder.encode(nomeArtista.trim(), StandardCharsets.UTF_8);
    }
}
