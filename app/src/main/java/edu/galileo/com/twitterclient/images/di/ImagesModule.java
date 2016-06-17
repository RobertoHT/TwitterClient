package edu.galileo.com.twitterclient.images.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.com.twitterclient.api.CustomTwitterApiClient;
import edu.galileo.com.twitterclient.entities.Image;
import edu.galileo.com.twitterclient.images.ImagesInteractor;
import edu.galileo.com.twitterclient.images.ImagesInteractorImpl;
import edu.galileo.com.twitterclient.images.ImagesPresenter;
import edu.galileo.com.twitterclient.images.ImagesPresenterImpl;
import edu.galileo.com.twitterclient.images.ImagesRepository;
import edu.galileo.com.twitterclient.images.ImagesRepositoryImpl;
import edu.galileo.com.twitterclient.images.ui.ImagesView;
import edu.galileo.com.twitterclient.images.ui.adapters.ImagesAdapter;
import edu.galileo.com.twitterclient.images.ui.adapters.OnItemClickListener;
import edu.galileo.com.twitterclient.lib.base.EventBus;
import edu.galileo.com.twitterclient.lib.base.ImageLoader;

/**
 * Created by Roberto Hdez. on 16/06/16.
 * <roberto.htamayo@gmail.com>
 */

@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemList(){
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    ImagesPresenter providesImagesPresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor){
        return new ImagesPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImageView(){
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(org.greenrobot.eventbus.EventBus eventBus, CustomTwitterApiClient client){
        return new ImagesRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session){
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitter(){
        return Twitter.getSessionManager().getActiveSession();
    }
}
