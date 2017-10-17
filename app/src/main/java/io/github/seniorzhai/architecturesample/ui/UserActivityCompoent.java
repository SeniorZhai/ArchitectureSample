package io.github.seniorzhai.architecturesample.ui;

import dagger.Component;
import io.github.seniorzhai.architecturesample.di.ActivityScope;

@ActivityScope
@Component(modules = UserModule.class)
public interface UserActivityCompoent {
    void inject(UserActivity activity);
}
