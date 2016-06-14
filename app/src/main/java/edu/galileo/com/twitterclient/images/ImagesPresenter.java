package edu.galileo.com.twitterclient.images;

import edu.galileo.com.twitterclient.images.events.ImagesEvent;

/**
 * Created by praxis on 14/06/16.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImagesTweet();
    void onEventMainThread(ImagesEvent event);
}
