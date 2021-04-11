package com.typicode.jsonplaceholder.url;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JSONPlaceholderUrl {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static final String POSTS = "posts";
}
