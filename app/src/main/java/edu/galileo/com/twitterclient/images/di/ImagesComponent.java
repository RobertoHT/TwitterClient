package edu.galileo.com.twitterclient.images.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.com.twitterclient.images.ImagesPresenter;
import edu.galileo.com.twitterclient.images.ui.ImagesFragment;
import edu.galileo.com.twitterclient.lib.di.LibsModule;

/**
 * Created by Roberto Hdez. on 16/06/16.
 * <roberto.htamayo@gmail.com>
 */

@Singleton @Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();
}
