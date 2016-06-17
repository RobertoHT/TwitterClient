package edu.galileo.com.twitterclient.images;

/**
 * Created by Roberto Hdez. on 16/06/16.
 * <roberto.htamayo@gmail.com>
 */

public class ImagesInteractorImpl implements ImagesInteractor {
    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
