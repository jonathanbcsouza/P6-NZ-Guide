/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.tour.guide;

public class Categories {

    private int itemTitle;
    private int itemDescription;
    private int itemImage;


    public Categories(int vTitle, int vResource, int imageResourceId) {
        itemTitle = vTitle;
        itemDescription = vResource;
        itemImage = imageResourceId;
    }

    public int getItemTitle() {
        return itemTitle;
    }

    public int getItemDescription() {
        return itemDescription;
    }

    public int getItemImage() {
        return itemImage;
    }


}
