package io.github.balram02.musify.utils;

import android.content.Context;
import android.content.SharedPreferences;

import io.github.balram02.musify.Models.SongsModel;

public class Preferences {

    private static final String SONGS_DETAILS = "general_preferences";
    private static final String DEFAULT_SETTINGS = "other_preferences";

    private static SharedPreferences sharedPreferences;

    public static class DefaultSettings {

        /**************save operations**************/

        // save when app is launched first time
        synchronized public static void setFirstLaunch(Context context, boolean value) {
            sharedPreferences = context.getSharedPreferences(DEFAULT_SETTINGS, Context.MODE_PRIVATE);
            sharedPreferences.edit().putBoolean("is_first_launch", value).apply();
        }

        /**************retrieving operations**************/

        // check if app is launched first time
        synchronized public static boolean isFirstLaunch(Context context) {
            return context.getSharedPreferences(DEFAULT_SETTINGS, Context.MODE_PRIVATE)
                    .getBoolean("is_first_launch", false);
        }
    }

    public static class SongDetails {

        /**************save operations**************/

        // save last song details
        synchronized public static void setLastSongDetails(Context context, SongsModel model) {
            sharedPreferences = context.getSharedPreferences(SONGS_DETAILS, Context.MODE_PRIVATE);
            sharedPreferences.edit()
                    .putString("last_song_name", model.getTitle())
                    .putString("last_song_artist", model.getArtist())
                    .putLong("last_song_duration", model.getDuration()).apply();
        }

        // save songs' last position
        synchronized public static void setLastSongCurrentPosition(Context context, int position) {
            context.getSharedPreferences(SONGS_DETAILS, Context.MODE_PRIVATE).edit()
                    .putInt("last_song_current_position", position).apply();
        }

        /**************retrieving operations**************/

        // retrieve last song name
        synchronized public static String getLastSongName(Context context) {
            return context.getSharedPreferences(SONGS_DETAILS, Context.MODE_PRIVATE)
                    .getString("last_song_name", null);
        }

        // retrieve last song artist
        synchronized public static String getLastSongArtist(Context context) {
            return context.getSharedPreferences(SONGS_DETAILS, Context.MODE_PRIVATE)
                    .getString("last_song_artist", null);
        }

        // retrieve song's last position
        synchronized public static int getLastSongCurrentPosition(Context context) {
            return context.getSharedPreferences(SONGS_DETAILS, Context.MODE_PRIVATE)
                    .getInt("last_song_current_position", 0);
        }

        // retrieve songs duration
        synchronized public static long getLastSongMaxDuration(Context context) {
            return context.getSharedPreferences(SONGS_DETAILS, Context.MODE_PRIVATE)
                    .getLong("last_song_duration", 0);
        }
    }

}