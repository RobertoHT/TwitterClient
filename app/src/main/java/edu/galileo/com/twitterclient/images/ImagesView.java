package edu.galileo.com.twitterclient.images;

import java.util.List;

import edu.galileo.com.twitterclient.entities.Image;

/**
 * Created by praxis on 14/06/16.
 */
public interface ImagesView {
    void showElements();
    void hideElements();
    void showProgress();
    void hideProgress();

    void onError(String e);
    void setContent(List<Image> items);
}
