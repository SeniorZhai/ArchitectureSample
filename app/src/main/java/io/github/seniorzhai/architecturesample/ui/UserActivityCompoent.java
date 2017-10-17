package io.github.seniorzhai.architecturesample.ui;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserModule.class)
public interface UserActivityCompoent {
    void inject(UserActivity activity);
}
