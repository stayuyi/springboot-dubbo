package com.yy.provider1;

import org.mockito.ArgumentMatcher;

import java.util.List;

class IsRightParams implements ArgumentMatcher<List> {
    @Override
    public boolean matches(List list) {
        return ((List) list).size() == 2;
    }
}
