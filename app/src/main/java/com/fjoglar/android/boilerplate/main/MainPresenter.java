/*
 * Copyright 2017 Felipe Joglar Santos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fjoglar.android.boilerplate.main;

import com.fjoglar.android.boilerplate.UseCase;
import com.fjoglar.android.boilerplate.UseCaseHandler;
import com.fjoglar.android.boilerplate.data.source.Repository;
import com.fjoglar.android.boilerplate.main.domain.GetWelcomeMessage;

public class MainPresenter implements MainContract.Presenter {

    private final UseCaseHandler mUseCaseHandler;
    private MainContract.View mMainView;

    public MainPresenter(MainContract.View mainView) {
        mMainView = mainView;
        mUseCaseHandler = UseCaseHandler.getInstance();

        mMainView.setPresenter(this);
    }

    @Override
    public void getWelcomeMessage() {

        GetWelcomeMessage getWelcomeMessage = new GetWelcomeMessage(Repository.getInstance());

        mUseCaseHandler.execute(getWelcomeMessage, new GetWelcomeMessage.RequestValues(),
                new UseCase.UseCaseCallback<GetWelcomeMessage.ResponseValue>() {
                    @Override
                    public void onSuccess(GetWelcomeMessage.ResponseValue response) {
                        mMainView.showWelcomeMessage(response.getResponseMessage());
                    }

                    @Override
                    public void onError(GetWelcomeMessage.ResponseValue response) {
                        mMainView.showWelcomeMessage(response.getResponseMessage());
                    }
                });
    }

    @Override
    public void start() {
        getWelcomeMessage();
    }
}