package edu.galileo.com.twitterclient.images;

import edu.galileo.com.twitterclient.images.events.ImagesEvent;
import edu.galileo.com.twitterclient.images.ui.ImagesView;
import edu.galileo.com.twitterclient.lib.base.EventBus;

/**
 * Created by Roberto Hdez. on 16/06/16.
 * <roberto.htamayo@gmail.com>
 */

public class ImagesPresenterImpl implements ImagesPresenter {
    private ImagesView view;
    private EventBus eventBus;
    private ImagesInteractor interactor;

    public ImagesPresenterImpl(ImagesView view, EventBus eventBus, ImagesInteractor interactor) {
        this.view = view;
        this.eventBus = eventBus;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getImagesTweet() {
        if(view != null){
            view.hideImages();
            view.showProgress();
        }
        interactor.execute();
    }

    @Override
    public void onEventMainThread(ImagesEvent event) {
        String error = event.getError();
        if(view != null){
            view.showImages();
            view.hideProgress();

            if(error != null){
                view.onError(error);
            }else {
                view.setContent(event.getImages());
            }
        }
    }
}
