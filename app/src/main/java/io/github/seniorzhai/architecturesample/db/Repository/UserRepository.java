package io.github.seniorzhai.architecturesample.db.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.github.seniorzhai.architecturesample.db.StoryDao;
import io.github.seniorzhai.architecturesample.network.ApiService;

@Singleton
public class UserRepository {
    private final StoryDao storyDao;
    private final ApiService apiService;

    @Inject
    UserRepository(ApiService apiService, StoryDao storyDao) {
        this.storyDao = storyDao;
        this.apiService = apiService;
    }

}
