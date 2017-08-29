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

package com.fjoglar.android.boilerplate.data.source;

import java.util.Random;

public class Repository implements DataSource {

    private static volatile DataSource INSTANCE;

    private Repository() {
        // private constructor
    }

    public static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    @Override
    public void getWelcomeMessage(GetWelcomeMessageCallback callback) {

        final float ERROR_RATE = 0.15f;
        final String WELCOME_MESSAGE = "Hello World!";
        final String ERROR_MESSAGE = "Oh no! Goodbye World...";

        if (new Random().nextFloat() > ERROR_RATE) {
            callback.onWelcomeMessageLoaded(WELCOME_MESSAGE);
        } else {
            callback.onDataNotAvailable(ERROR_MESSAGE);
        }
    }
}