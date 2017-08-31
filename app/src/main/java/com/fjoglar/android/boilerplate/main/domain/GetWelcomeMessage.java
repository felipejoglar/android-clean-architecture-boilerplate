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

package com.fjoglar.android.boilerplate.main.domain;

import com.fjoglar.android.boilerplate.UseCase;
import com.fjoglar.android.boilerplate.data.source.DataSource;

public class GetWelcomeMessage extends UseCase<GetWelcomeMessage.RequestValues, GetWelcomeMessage.ResponseValue> {

    private final DataSource mDataSource;

    public GetWelcomeMessage(DataSource dataSource) {
        this.mDataSource = dataSource;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        mDataSource.getWelcomeMessage(
                new DataSource.GetWelcomeMessageCallback() {
                    @Override
                    public void onWelcomeMessageLoaded(String welcomeMessage) {
                        ResponseValue responseValue = new ResponseValue(welcomeMessage);
                        getUseCaseCallback().onSuccess(responseValue);
                    }

                    @Override
                    public void onDataNotAvailable(String errorMessage) {
                        Error dataNotAvailableError = new Error(errorMessage);
                        getUseCaseCallback().onError(dataNotAvailableError);
                    }
                });
    }

    public static final class RequestValues implements UseCase.RequestValues {
    }

    public static final class ResponseValue implements UseCase.ResponseValue {

        private String mResponseMessage;

        public ResponseValue(String responseMessage) {
            mResponseMessage = responseMessage;
        }

        public String getResponseMessage() {
            return mResponseMessage;
        }
    }
}